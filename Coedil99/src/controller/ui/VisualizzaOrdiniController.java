package controller.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import modello_di_dominio.Commessa;
import modello_di_dominio.Ordine;
import servizi.GestoreCommessa;
import servizi.GestoreOrdine;
import servizi.GestoreServizi;
import servizi.Log;
import servizi.impl.GestoreOrdineDAO;
import servizi.impl.GestoreServiziPrototipo;
import ui.MainApplication;

public class VisualizzaOrdiniController implements Initializable {

	@FXML
	private TableView<Ordine> tableOrdini;
	@FXML
	private TableColumn<Ordine, String> tableOrdiniId;
	@FXML
	private TableColumn<Ordine, String> tableOrdiniData;

	@FXML
	private TabPane commesseTabPane;

	protected Log log;
	protected Ordine ordineCorrente = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		GestoreServizi gsp = GestoreServiziPrototipo.getGestoreServizi();
		GestoreOrdineDAO gestoreOrdineDAO = (GestoreOrdineDAO) gsp
				.getServizio("GestoreOrdineDAO");
		log = (Log) gsp.getServizio("LogStdout");

		/**************************************************
		 * TABELLA ORDINI
		 *************************************************/
		final ArrayList<Ordine> ordini = new ArrayList<Ordine>(
				gestoreOrdineDAO.getOrdini());

		this.loadOrdiniTable(ordini);

		// ListenerOrdini

		tableOrdini.getSelectionModel().selectedIndexProperty()
				.addListener(new ChangeListener<Object>() {

					@Override
					public void changed(ObservableValue<? extends Object> arg0,
							Object arg1, Object arg2) {

						Ordine ao = ordini.get((Integer) arg2);
						VisualizzaOrdiniController.this.ordineCorrente = ao;
						VisualizzaOrdiniController.this.loadTablePane(ao);

					}
				});

		// Listener commesse
		/*
		 * tableCommesse.setOnMouseClicked((new EventHandler<MouseEvent>() {
		 * 
		 * @Override public void handle(MouseEvent mouseEvent) {
		 * if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
		 * if(mouseEvent.getClickCount() == 2){
		 * System.out.println("Double clicked"); } }
		 * 
		 * } }));
		 */
	}

	protected void initOrdinitTable() {

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
							s.set("ciao");
						} else {
							s.set(arg0.getValue().getDataCreazione().toString());
						}
						return s;
					}
				});

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

		// TODO: Creare una nuova distinta
		GestoreServizi gsp = GestoreServiziPrototipo.getGestoreServizi();
		GestoreOrdine gestoreOrdine = (GestoreOrdine) gsp
				.getServizio("GestoreOrdineDAO");
		Commessa nuovaCommessa = gestoreOrdine.creaCommessa(ordineCorrente, 0,
				new Date());
		GestoreCommessa gestoreCommessa = (GestoreCommessa) gsp
				.getServizio("GestoreCommessaDAO");
		gestoreCommessa.creaDistinta(nuovaCommessa);
		MainApplication.getInstance().loadPage("visualizza_ordini");

	}

	/**
	 * onEditCommessa action
	 */
	@FXML
	protected void onEditCommessa() {
		log.i("modifica commessa");
		// MainApplication.getInstance().loadPage("visualizza_commessa");

	}

	/**
	 * onDeleteCommessa action
	 */
	@FXML
	protected void onDeleteCommessa() {
		log.i("delete commessa");

	}

	/**
	 * loadTablePane
	 * 
	 * @param ordine
	 */
	protected void loadTablePane(Ordine ordine) {
		Commessa[] commesse = ordine.commesse.toArray();

		commesseTabPane.getTabs().clear();

		for (Commessa c : commesse) {

			commesseTabPane.getTabs().add(createCommessaTab(c));

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
		tab.setText(String.valueOf(commessa.getID()));

		GridPane gridPane = new GridPane();

		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(50);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(50);

		gridPane.getColumnConstraints().addAll(column1, column2);

		gridPane.add(new Label("Stato"), 0, 0);
		gridPane.add(new Label("Data creazione"), 0, 1);

		gridPane.add(new Label(commessa.getDataCreazione().toString()), 1, 1);

		gridPane.setPadding(new Insets(10, 10, 10, 10));

		tab.setContent(gridPane);

		return tab;

	}
}
