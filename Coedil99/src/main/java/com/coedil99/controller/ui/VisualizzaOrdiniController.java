package com.coedil99.controller.ui;

import com.coedil99.controller.builder.Builder;
import com.coedil99.modello_di_dominio.*;
import com.coedil99.modello_di_dominio.dao.OrdineDAO;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.util.Callback;
import org.orm.PersistentException;
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

		@Override
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
		Destinazione destinazione = new Builder.DestinazioneBuilder().setVia("").build();
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		tableOrdini.setEditable(true);//.setCellFactory(TextFieldTableCell.forTableColumn());
		//tableOrdiniCliente.setCellFactory(TextFieldTableCell.forTableColumn());
		//tableOrdiniCliente.setEditable(true);
		refreshListaOrdini();

		commesseTabPane.getTabs().clear();

		btnNewOrdine.setDisable(false);
		//btnEditOrdine.setDisable(true);
		btnDeleteOrdine.setDisable(true);
		btnNewCommessa.setDisable(true);
		btnEditCommessa.setDisable(true);
		btnEditDistinta.setDisable(true);
		btnDeleteCommessa.setDisable(true);

		if (newOrdine) {
			nuovoOrdine();
		}

	}

	/**
	 * loadOrdiniTable
	 * 
	 * @param ordini
	 */
	protected void loadOrdiniTable(List<Ordine> ordini) {

		// TODO Auto-generated method stub
		tableOrdiniId
				.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ordine, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(
							CellDataFeatures<Ordine, String> arg0) {
						// TODO Auto-generated method stub
						SimpleStringProperty s = new SimpleStringProperty();
						s.set(((Integer) arg0.getValue().getID()).toString());
						return s;
					}
				});

		tableOrdiniData
				.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ordine, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(
							CellDataFeatures<Ordine, String> arg0) {
						// TODO Auto-generated method stub
						SimpleStringProperty s = new SimpleStringProperty();

						if (arg0.getValue() == null) {
							s.set("?");
						} else {
							s.set(arg0.getValue().getDataCreazione().toString());
						}
						return s;
					}
				});

		tableOrdiniData.setCellFactory(TextFieldTableCell.forTableColumn());
		tableOrdiniData.setOnEditCommit(
				new EventHandler<TableColumn.CellEditEvent<Ordine, String>>() {

					@Override
					public void handle(TableColumn.CellEditEvent<Ordine, String> t) {
						System.out.print(t.getNewValue());

						Ordine ordineCorrenet = ((Ordine) t.getTableView().getItems().get(
								t.getTablePosition().getRow())
						);

						ordineCorrenet.setDataCreazione(new Date());

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

					@Override
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

		tableOrdiniDestinazione.setCellFactory(TextFieldTableCell.forTableColumn());
		tableOrdiniDestinazione.setOnEditCommit(
				new EventHandler<TableColumn.CellEditEvent<Ordine, String>>() {

					@Override
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
						} catch (PersistentException e) {
							e.printStackTrace();
						} finally {
							refreshListaOrdini();
						}

						try {

							DAOFactory.getDAOFactory().getDestinazioneDAO().deleteAndDissociate(oldDest);
						} catch (PersistentException e) {
							e.printStackTrace();
						}

					}
				}
		);
		tableOrdiniDestinazione.setEditable(true);


/*
		Callback<TableColumn<Ordine,String>, TableCell<Ordine,String>> cellFactory =
				new Callback<TableColumn<Ordine,String>, TableCell<Ordine,String>>() {
					public TableCell call(TableColumn p) {
						return new EditingCell();
					}
				};
*/
		tableOrdiniCliente.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ordine, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(
							CellDataFeatures<Ordine, String> arg0) {
						// TODO Auto-generated method stub
						SimpleStringProperty s = new SimpleStringProperty();

						if (arg0.getValue() == null) {
							s.set("PROSSIMA ITERAZIONE");
						} else {
							s.set("PROSSIMA ITERAZIONE");
						}
						return s;
					}
				});

		tableOrdiniCliente.setCellFactory(TextFieldTableCell.forTableColumn());
		tableOrdiniCliente.setOnEditCommit(
				new EventHandler<TableColumn.CellEditEvent<Ordine, String>>() {

					@Override
					public void handle(TableColumn.CellEditEvent<Ordine, String> t) {
						System.out.print(t.getNewValue());
						/*
						((Ordine) t.getTableView().getItems().get(
								t.getTablePosition().getRow())
						).setDestinazione(t.getNewValue());
						*/
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

	/**
	 * onNewCommessaAction
	 */
	@FXML
	protected void onNewCommessa() {

        log.i("nuova commessa");

	}

	/**
	 * onEditCommessa action
	 */
	@FXML
	protected void onEditCommessa() {
		log.i("modifica commessa");

        //sessione.set(VisualizzaDistintaController.DISTINTA_CORRENTE,null);

		 //MainApplication.getInstance().loadPage("visualizza_distinta", "com.coedil99.controller.ui.VisualizzaDistintaController", 0);

	}

	/**
	 * onEditCommessaDistinta action
	 */
	@FXML
	protected void onEditCommessaDistinta() {
		log.i("modifica distinta");

		sessione.set(VisualizzaDistintaController.DISTINTA_CORRENTE,null);

		MainApplication.getInstance().loadPage("visualizza_distinta", "com.coedil99.controller.ui.VisualizzaDistintaController", 0);

	}

	/**
	 * onDeleteCommessa action
	 */
	@FXML
	protected void onDeleteCommessa() {
		log.i("delete commessa");

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
		tableOrdiniDestinazione.setCellFactory(TextFieldTableCell.forTableColumn());
		//setCellFactory(TextFieldTableCell.<StateData>forTableColumn());
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

	/**
	 * loadTablePane
	 * 
	 * @param ordine
	 */
	protected void loadTablePane(Ordine ordine) {
		Commessa[] commesse = ordine.commesse.toArray();

		commesseTabPane.getTabs().clear();

		btnDeleteCommessa.setDisable(true);
		btnEditCommessa.setDisable(true);
		btnEditDistinta.setDisable(true);

		for (Commessa c : commesse) {

			commesseTabPane.getTabs().add(createCommessaTab(c));

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

		Label data = new Label();
		data.setMinHeight(25);
		data.setText(commessa.getDataCreazione().toString());

		TitledPane titledPaneData = new TitledPane();
		titledPaneData.setAnimated(false);
		titledPaneData.setText("Data di creazione della commessa");
		titledPaneData.setContent(data);

		Label priorita = new Label();
		priorita.setMinHeight(25);
		priorita.setText(commessa.getPriorita()+"");

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
/*
class EditingCell extends TableCell<Ordine, String> {

	private TextField textField;

	public EditingCell() {
	}

	@Override
	public void startEdit() {
		if (!isEmpty()) {
			super.startEdit();
			createTextField();
			setText(null);
			setGraphic(textField);
			textField.selectAll();
		}
	}

	@Override
	public void cancelEdit() {
		super.cancelEdit();

		setText((String) getItem());
		setGraphic(null);
	}

	@Override
	public void updateItem(String item, boolean empty) {
		super.updateItem(item, empty);

		if (empty) {
			setText(null);
			setGraphic(null);
		} else {
			if (isEditing()) {
				if (textField != null) {
					textField.setText(getString());
				}
				setText(null);
				setGraphic(textField);
			} else {
				setText(getString());
				setGraphic(null);
			}
		}
	}

	private void createTextField() {
		textField = new TextField(getString());
		textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
		textField.focusedProperty().addListener(new ChangeListener<Boolean>(){
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0,
								Boolean arg1, Boolean arg2) {
				if (!arg2) {
					commitEdit(textField.getText());
				}
			}
		});
	}

	private String getString() {
		return getItem() == null ? "" : getItem().toString();
	}
}
*/
