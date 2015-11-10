package com.coedil99.controller.ui;

import com.coedil99.modello_di_dominio.DAOFactory;
import com.coedil99.modello_di_dominio.Ordine;
import com.coedil99.modello_di_dominio.RDA;
import com.coedil99.modello_di_dominio.dao.OrdineDAO;
import com.coedil99.servizi.GestoreServizi;
import com.coedil99.servizi.Log;
import com.coedil99.servizi.impl.GestoreServiziPrototipo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import org.orm.PersistentException;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class VisualizzaRdaController implements Initializable {

    @FXML
    private TableView<Ordine> tableRda;
    @FXML
    private TableColumn<Ordine, String> tableRdaId;
    @FXML
    private TableColumn<Ordine, String> tableRdaData;

    @FXML
    private TabPane rdaTabPane;

    protected Log log;
    protected RDA rdaCorrente = null;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        GestoreServizi gsp = GestoreServiziPrototipo.getGestoreServizi();
        OrdineDAO ordineDAO = DAOFactory.getDAOFactory().getOrdineDAO();
        log = (Log) gsp.getServizio("LogStdout");


        ArrayList<Ordine> rdas = null;
        try {
            rdas = new ArrayList<Ordine>(
                    Arrays.asList(ordineDAO.listOrdineByQuery(null, null)));
            this.loadOrdiniTable(rdas);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
//
//
//
//		// ListenerOrdini
//
//		tableOrdini.getSelectionModel().selectedIndexProperty()
//				.addListener(new ChangeListener<Object>() {
//
//					@Override
//					public void changed(ObservableValue<? extends Object> arg0,
//							Object arg1, Object arg2) {
//
//						Ordine ao = ordini.get((Integer) arg2);
//						VisualizzaOrdiniController.this.ordineCorrente = ao;
//						VisualizzaOrdiniController.this.loadTablePane(ao);
//
//					}
//				});

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

    /**
     * loadOrdiniTable
     *
     * @param ordini
     */
    protected void loadOrdiniTable(List<Ordine> ordini) {


        tableRdaId
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

        tableRdaData
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
        //tableOrdini.setItems(list);

    }
}