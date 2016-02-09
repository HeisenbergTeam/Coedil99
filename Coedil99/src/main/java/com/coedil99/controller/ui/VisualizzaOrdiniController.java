package com.coedil99.controller.ui;

import com.coedil99.dominio.builder.Builder;
import com.coedil99.modello_di_dominio.*;
import com.coedil99.modello_di_dominio.dao.OrdineDAO;
import com.coedil99.utilita.Parsers;
import com.coedil99.utilita.UtilitaManager;
import com.coedil99.utilita.Log;
import com.coedil99.utilita.Sessione;
import com.coedil99.utilita.impl.UtilitaManagerPrototipo;
import com.coedil99.ui.MainApplication;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.util.Callback;
import org.orm.PersistentException;

import java.text.ParseException;
import java.util.Date;

import java.net.URL;
import java.util.*;

public class VisualizzaOrdiniController implements Initializable {

	@FXML
	private TableView<Ordine> tableOrdini;
	@FXML
	private TableColumn<Ordine, String> tableOrdiniId;
	@FXML
	private TableColumn<Ordine, String> tableOrdiniData;
	@FXML
	private TableColumn<Ordine, String> tableOrdiniDestinazione;
	@FXML
	private TableColumn<Ordine, String> tableOrdiniCliente;

	@FXML
	private TabPane commesseTabPane;

	@FXML
	public Button btnNewOrdine;
	//public Button btnEditOrdine;
	public Button btnDeleteOrdine;
	public Button btnNewCommessa;
	public Button btnEditCommessa;
	public Button btnEditDistinta;
	public Button btnDeleteCommessa;


	protected Log log;
    protected Sessione sessione;
	protected Ordine ordineCorrente = null;

	private boolean newOrdine = false;

	public void setAction(int action) {
		if (action == DefineControllerUi.MODIFICA_ORDINI) {

		}
		if (action == DefineControllerUi.NUOVO_ORDINE) {
			newOrdine = true;
		}
	}

	public ArrayList<Ordine> getOrdini() {
		OrdineDAO ordineDAO = DAOFactory.getDAOFactory().getOrdineDAO();
		ArrayList<Ordine> ordini = new ArrayList<Ordine>();
		try {
			ordini = new
					ArrayList<Ordine>(Arrays.asList(ordineDAO.listOrdineByQuery(null, null)));
		} catch (PersistentException e) {}
		return ordini;
	}


	final private ChangeListener changeListener = new ChangeListener<Object>() {


		public void changed(ObservableValue<? extends Object> arg0,
				Object arg1, Object arg2) {

			Integer index = (Integer)arg2;
			if (index >= 0 ) {
				btnNewCommessa.setDisable(false);
				//btnEditOrdine.setDisable(false);
				btnDeleteOrdine.setDisable(false);
				Ordine ao = getOrdini().get(index);
				//System.out.print(ao.getID());
				VisualizzaOrdiniController.this.ordineCorrente = ao;
				VisualizzaOrdiniController.this.loadTablePane(ao);
			}
		}
	};

	private void refreshListaOrdini() {

		//final ArrayList<Ordine> ordiniEmpty = new ArrayList<Ordine>();
		//this.loadOrdiniTable(ordiniEmpty);
		//tableOrdini.setItems(ordini);

		UtilitaManager gsp = UtilitaManagerPrototipo.getGestoreServizi();
		log = (Log) gsp.getServizio("LogStdout");
		sessione = (Sessione) gsp.getServizio("SessionePrototipo");

		tableOrdini.getSelectionModel().selectedIndexProperty()
				.removeListener(changeListener);

			this.loadOrdiniTable(getOrdini());
			// ListenerOrdini

			tableOrdini.getSelectionModel().selectedIndexProperty()
					.addListener(changeListener);

	}

	private void nuovoOrdine() {
		Date now = new Date();
		Destinazione destinazione = new Builder.DestinazioneBuilder().setVia("Nuova destinazione").build();
		Ordine ordine = new Builder.OrdineBuilder().setDataCreazione(now).setDestinazione(destinazione).build();
		//tableOrdini.getSelectionModel().clearSelection();
		refreshListaOrdini();
		tableOrdini.getSelectionModel().selectLast();
		tableOrdini.scrollTo(ordine);
		//tableOrdini.requestFocus();
		//System.out.print(tableOrdini.getSelectionModel().getTableView().refresh();//.getSelectedItem(ordine));
		//tableOrdini.getSelectionModel().getTableView().refresh();
		//tableOrdini.refresh();
		//tableOrdini.getSelectionModel().clearSelection();
		//tableOrdini.getSelectionModel().selectLast();
		//tableOrdini.getSelectionModel().select( tableOrdini.getSelectionModel().getSelectedIndices().size()-1);
		//tableOrdini.getFocusModel().fo.focus(0);
		btnNewOrdine.setDisable(false);
		//btnEditOrdine.setDisable(false);
		btnDeleteOrdine.setDisable(false);
		btnNewCommessa.setDisable(false);
		btnEditCommessa.setDisable(true);
		btnEditDistinta.setDisable(true);
		btnDeleteCommessa.setDisable(true);
	}

	public void initialize(URL arg0, ResourceBundle arg1) {

		tableOrdini.setEditable(true);
		refreshListaOrdini();

		commesseTabPane.getTabs().clear();

		btnNewOrdine.setDisable(false);
		btnDeleteOrdine.setDisable(true);
		btnNewCommessa.setDisable(true);
		btnEditCommessa.setDisable(true);
		btnEditDistinta.setDisable(true);
		btnDeleteCommessa.setDisable(true);

		if (newOrdine) {
			nuovoOrdine();
		}

	}

	protected void loadOrdiniTable(List<Ordine> ordini) {


		tableOrdiniId
				.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ordine, String>, ObservableValue<String>>() {


					public ObservableValue<String> call(
							CellDataFeatures<Ordine, String> arg0) {

						SimpleStringProperty s = new SimpleStringProperty();
						s.set(((Integer) arg0.getValue().getID()).toString());
						return s;
					}
				});

		tableOrdiniData
				.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ordine, String>, ObservableValue<String>>() {


					public ObservableValue<String> call(
							CellDataFeatures<Ordine, String> arg0) {

						SimpleStringProperty s = new SimpleStringProperty();

						if (arg0.getValue() == null) {
							s.set("?");
						} else {
							s.set(Parsers.printItalianDate(arg0.getValue().getDataCreazione()));
						}
						return s;
					}
				});

		tableOrdiniData.setCellFactory(TextFieldTableCell.<Ordine>forTableColumn());
		tableOrdiniData.setOnEditCommit(
				new EventHandler<TableColumn.CellEditEvent<Ordine, String>>() {


					public void handle(TableColumn.CellEditEvent<Ordine, String> t) {
						System.out.print(t.getNewValue());

						Ordine ordineCorrenet = ((Ordine) t.getTableView().getItems().get(
								t.getTablePosition().getRow())
						);

						try {
							ordineCorrenet.setDataCreazione(Parsers.italianDateStringToDate(t.getNewValue()));
						} catch (ParseException e) {
							e.printStackTrace();
						}

						try {

							DAOFactory.getDAOFactory().getOrdineDAO().save(ordineCorrenet);
						} catch (PersistentException e) {
							e.printStackTrace();
						} finally {
							refreshListaOrdini();
						}

					}
				}
		);
		tableOrdiniData.setEditable(true);

		tableOrdiniDestinazione
				.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ordine, String>, ObservableValue<String>>() {

					public ObservableValue<String> call(
							CellDataFeatures<Ordine, String> arg0) {
						// TODO Auto-generated method stub
						SimpleStringProperty s = new SimpleStringProperty();

						if (arg0.getValue() == null) {
							s.set("ciao");
						} else {
							s.set(arg0.getValue().getDestinazione().getVia());
						}
						return s;
					}
				});

		tableOrdiniDestinazione.setCellFactory(TextFieldTableCell.<Ordine>forTableColumn());
		tableOrdiniDestinazione.setOnEditCommit(
				new EventHandler<TableColumn.CellEditEvent<Ordine, String>>() {


					public void handle(TableColumn.CellEditEvent<Ordine, String> t) {
						System.out.print(t.getNewValue());

						Ordine ordineCorrenet = ((Ordine) t.getTableView().getItems().get(
								t.getTablePosition().getRow())
						);

						Destinazione oldDest = ordineCorrenet.getDestinazione();
						Destinazione dest = new Builder.DestinazioneBuilder().setVia(t.getNewValue()).build();
						ordineCorrenet.setDestinazione(dest);

						try {

							DAOFactory.getDAOFactory().getOrdineDAO().save(ordineCorrenet);
							DAOFactory.getDAOFactory().getDestinazioneDAO().deleteAndDissociate(oldDest);
						} catch (PersistentException e) {
							e.printStackTrace();
						} finally {
							refreshListaOrdini();
						}


					}
				}
		);
		tableOrdiniDestinazione.setEditable(true);

		tableOrdiniCliente.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ordine, String>, ObservableValue<String>>() {


					public ObservableValue<String> call(
							CellDataFeatures<Ordine, String> arg0) {
						SimpleStringProperty s = new SimpleStringProperty();
						s.set("PROSSIMA ITERAZIONE");
						return s;
					}
				});

		tableOrdiniCliente.setOnEditCommit(
				new EventHandler<TableColumn.CellEditEvent<Ordine, String>>() {

					public void handle(TableColumn.CellEditEvent<Ordine, String> t) {
						log.i(t.getNewValue());
					}
				}
		);
		tableOrdiniCliente.setEditable(true);

		ObservableList<Ordine> list = FXCollections.observableList(ordini);
		tableOrdini.setItems(list);

	}

	/**
	 * goBack Action
	 */
	@FXML
	protected void goBack() {
		MainApplication.getInstance().goBack();
	}

	protected int currentCommessaId = 0;

	/**
	 * onNewCommessaAction
	 */
	@FXML
	protected void onNewCommessa() {

        log.i("nuova commessa");
		Date now = new Date();
		Ordine ordine = tableOrdini.getSelectionModel().getSelectedItem();
		Commessa commessa = new Builder.CommessaBuilder().setDataCreazione(now).setOrdine(ordine).setPriorita(0).build();
		Distinta distinta = new Builder.DistintaBuilder().setCommessa(commessa).setDataInizio(now).setElementoStrutturale("Nuovo elemento strutturale").setModello("Nuovo modello").setRevisione(0).build();
		loadTablePane(ordine);
	}

	public Map txtDataMap = new Hashtable();
	public Map txtPrioritaMap = new Hashtable();

	public boolean modificaOn = false;
	/**
	 * onEditCommessa action
	 */
	@FXML
	protected void onEditCommessa() {
		log.i("modifica commessa");


		for(Object commessaId: txtDataMap.keySet()) {

			if (currentCommessaId == (Integer) commessaId) {
				log.i("found "+txtDataMap.get(commessaId) + ""+"\n");
				log.i("found "+txtPrioritaMap.get(commessaId) + ""+"\n");
				log.i("found "+currentCommessaId+ ""+"\n");

				TextField currentPriorita = (TextField)txtPrioritaMap.get(commessaId);
				TextField currentData = (TextField)txtDataMap.get(commessaId);

				if(modificaOn) {
					try {
						Commessa commessa = DAOFactory.getDAOFactory().getCommessaDAO().getCommessaByORMID(currentCommessaId);
						commessa.setDataCreazione(Parsers.italianDateStringToDate(currentData.getText()));
						commessa.setPriorita(Integer.parseInt(currentPriorita.getText()));
						DAOFactory.getDAOFactory().getCommessaDAO().save(commessa);
					} catch (PersistentException e) {
						e.printStackTrace();
					} catch (ParseException e) {
						e.printStackTrace();
					}


					currentPriorita.setEditable(false);
					currentPriorita.setStyle("-fx-background-color: #EEEEEE;");
					currentData.setEditable(false);
					currentData.setStyle("-fx-background-color: #EEEEEE;");

					modificaOn = false;
					btnNewOrdine.setDisable(false);

					btnDeleteOrdine.setDisable(false);
					btnNewCommessa.setDisable(false);
					btnEditCommessa.setDisable(false);
					btnEditCommessa.setText("Modifica commessa");
					btnEditDistinta.setDisable(false);
					btnDeleteCommessa.setDisable(false);
				} else {

					currentPriorita.setEditable(true);
					currentPriorita.setStyle("-fx-background-color: #FFFFFF;");

					currentData.setEditable(true);
					currentData.setStyle("-fx-background-color: #FFFFFF;");


					modificaOn = true;
					btnNewOrdine.setDisable(true);
					//btnEditOrdine.setDisable(false);
					btnDeleteOrdine.setDisable(true);
					btnNewCommessa.setDisable(true);
					btnEditCommessa.setDisable(false);
					btnEditCommessa.setText("Salva commessa");
					btnEditDistinta.setDisable(true);
					btnDeleteCommessa.setDisable(true);
				}
			}
		}

	}

	/**
	 * onEditCommessaDistinta action
	 */
	@FXML
	protected void onEditCommessaDistinta() {
		log.i("modifica distinta");

		sessione.set(VisualizzaDistintaController.DISTINTA_CORRENTE,null);

		try {

			Distinta[] arrayDistinta = DAOFactory.getDAOFactory().getDistintaDAO().listDistintaByQuery("CommessaID = "+currentCommessaId,null);
			for (int i = 0; i < arrayDistinta.length; i++) {
				System.out.print(currentCommessaId+" "+arrayDistinta[i].getCommessa().getID()+"\n");
				if (arrayDistinta[i].getCommessa().getID() == currentCommessaId) {
					MainApplication.getInstance().loadPage("visualizza_distinta", "com.coedil99.controller.ui.VisualizzaDistintaController", (arrayDistinta[i].getID()));
				}
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}



	}

	/**
	 * onDeleteCommessa action
	 */
	@FXML
	protected void onDeleteCommessa() {
		log.i("delete commessa");

		Ordine ordine = tableOrdini.getSelectionModel().getSelectedItem();
		try {
			Commessa commessa = DAOFactory.getDAOFactory().getCommessaDAO().getCommessaByORMID(currentCommessaId);
			System.out.print(currentCommessaId);

			Distinta[] arrayDistinta = DAOFactory.getDAOFactory().getDistintaDAO().listDistintaByQuery("CommessaID = "+currentCommessaId,null);
			System.out.print(arrayDistinta.length);
			for (int i = 0; i < arrayDistinta.length; i++) {
				if (arrayDistinta[i].getCommessa().getID() == currentCommessaId) {
					System.out.print("deleting distinta " + arrayDistinta[i].getID());
					DAOFactory.getDAOFactory().getDistintaDAO().deleteAndDissociate(arrayDistinta[i]);
				}
			}
			DAOFactory.getDAOFactory().getCommessaDAO().deleteAndDissociate(commessa);
		} catch (PersistentException e) {
			e.printStackTrace();
		} finally {
			loadTablePane(ordine);
		}

	}

	/**
	 * onDeleteCommessa action
	 */
	@FXML
	protected void onNewOrdine() {
		log.i("new ordine");
		nuovoOrdine();
	}

	/**
	 * onDeleteCommessa action
	 */
	@FXML
	protected void onEditOrdine() {
		log.i("edit ordine");
	}

	/**
	 * onDeleteCommessa action
	 */
	@FXML
	protected void onDeleteOrdine() {
		log.i("delete ordine");

		Ordine ordine = tableOrdini.getSelectionModel().getSelectedItem();
		try {

			DAOFactory.getDAOFactory().getOrdineDAO().deleteAndDissociate(ordine);
		} catch (PersistentException e) {
			e.printStackTrace();
		} finally {
			refreshListaOrdini();
		}

	}

	protected Map currentTab = new Hashtable();

	ChangeListener<Number> tabListener = new ChangeListener<Number>() {

		public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
			for(Object commessaId: currentTab.keySet()) {

				if (newValue == commessaId) {

					currentCommessaId = (Integer) currentTab.get(commessaId);
					log.i("found "+currentCommessaId+ ""+"\n");

				}
			}
		}
	};

	protected void loadTablePane(Ordine ordine) {
		Commessa[] commesse = ordine.commesse.toArray();

		commesseTabPane.getTabs().clear();

		txtDataMap.clear();
		txtPrioritaMap.clear();

		commesseTabPane.getSelectionModel().selectedIndexProperty().addListener(tabListener);

		btnDeleteCommessa.setDisable(true);
		btnEditCommessa.setDisable(true);
		btnEditDistinta.setDisable(true);

		currentTab.clear();

		Integer tabId = 0;
		for (Commessa c : commesse) {

			if (tabId == 0)
				currentCommessaId = c.getID();

			commesseTabPane.getTabs().add(createCommessaTab(c));

			currentTab.put(tabId, c.getID());

			tabId += 1;

			btnDeleteCommessa.setDisable(false);
			btnEditCommessa.setDisable(false);
			btnEditDistinta.setDisable(false);
		}
	}

	/**
	 * createCommessaTab
	 * 
	 * @param commessa
	 * @return
	 */
	private Tab createCommessaTab(Commessa commessa) {
		Tab tab = new Tab();
		tab.setText(" "+String.valueOf(commessa.getID())+" ");

		TitledPane titledPane = new TitledPane();
		titledPane.setAlignment(Pos.TOP_LEFT);
		titledPane.setAnimated(false);
		titledPane.setPrefHeight(94);
		titledPane.setPrefWidth(724);
		titledPane.setStyle("");

		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_LEFT);
		gridPane.setMaxHeight(200);
		gridPane.setPrefHeight(45);
		gridPane.setPrefWidth(685);

		ColumnConstraints column1 = new ColumnConstraints();
		column1.setHgrow(Priority.SOMETIMES);
		column1.setMinWidth(10);
		column1.setPrefWidth(100);

		ColumnConstraints column2 = new ColumnConstraints();
		column2.setHgrow(Priority.SOMETIMES);
		column2.setMinWidth(10);
		column2.setPrefWidth(100);

		RowConstraints row = new RowConstraints();
		row.setVgrow(Priority.SOMETIMES);
		row.setMinHeight(10);
		row.setPrefHeight(30);

		gridPane.getColumnConstraints().addAll(column1, column2);


		TextField data = new TextField();
		data.setMinHeight(25);
		data.setStyle("-fx-background-color: #EEEEEE;");
		data.setText(Parsers.printItalianDate(commessa.getDataCreazione()));
		data.setAlignment(Pos.CENTER);
		data.setEditable(false);
		data.setId("txtData_"+commessa.getID());

		TitledPane titledPaneData = new TitledPane();
		titledPaneData.setAnimated(false);
		titledPaneData.setText("Data di creazione della commessa");
		titledPaneData.setContent(data);

		TextField priorita = new TextField();
		priorita.setMinHeight(25);
		priorita.setStyle("-fx-background-color: #EEEEEE;");
		priorita.setText(commessa.getPriorita()+"");
		priorita.setAlignment(Pos.CENTER);
		priorita.setEditable(false);
		priorita.setId("txtPriorita_"+commessa.getID());

		txtDataMap.put(commessa.getID(),data);
		txtPrioritaMap.put(commessa.getID(),priorita);

		TitledPane titledPanePriorita = new TitledPane();
		titledPanePriorita.setAnimated(false);
		titledPanePriorita.setText("Priorità della commessa");
		titledPanePriorita.setContent(priorita);

		gridPane.add(titledPaneData, 0, 0);
		gridPane.add(titledPanePriorita, 1, 0);

		gridPane.setPadding(new Insets(10, 10, 10, 10));

		titledPane.setContent(gridPane);
		tab.setContent(titledPane);

		return tab;

	}
}

