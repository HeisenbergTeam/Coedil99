package com.coedil99.controller.ui;

import com.coedil99.modello_di_dominio.DAOFactory;
import com.coedil99.modello_di_dominio.RDA;
import com.coedil99.modello_di_dominio.dao.RDADAO;
import com.coedil99.utilita.UtilitaManager;
import com.coedil99.utilita.Log;
import com.coedil99.utilita.impl.UtilitaManagerPrototipo;
import com.coedil99.ui.MainApplication;
import com.coedil99.controller.ui.DefineControllerUi;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    private TableView<RDA> tableRda;
    @FXML
    private TableColumn<RDA, String> tableRdaId;
    @FXML
    private TableColumn<RDA, String> tableRdaData;

    @FXML
    private TabPane rdaTabPane;

    protected Log log;
    protected RDA rdaCorrente = null;

    public void setAction(int action) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        UtilitaManager gsp = UtilitaManagerPrototipo.getGestoreServizi();
        RDADAO rdaDAO = DAOFactory.getDAOFactory().getRDADAO();
        log = (Log) gsp.getServizio("LogStdout");


        ArrayList<RDA> rdas = null;
        try {
            rdas = new ArrayList<RDA>(
                    Arrays.asList(rdaDAO.listRDAByQuery(null,null)));
            this.loadRdaTable(rdas);
        } catch (PersistentException e) {
            e.printStackTrace();
        }



		// ListenerOrdini

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
    protected void loadRdaTable(List<RDA> ordini) {


        tableRdaId
                .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RDA, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(
                            CellDataFeatures<RDA, String> arg0) {
                        // TODO Auto-generated method stub
                        SimpleStringProperty s = new SimpleStringProperty();
                        s.set(((Integer) arg0.getValue().getID()).toString());
                        return s;
                    }
                });

        tableRdaData
                .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RDA, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(
                            CellDataFeatures<RDA, String> arg0) {
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

        ObservableList<RDA> list = FXCollections.observableList(ordini);
        tableRda.setItems(list);

    }

    @FXML
    public void onNuovaRda(ActionEvent actionEvent) {
        //fx:controller="com.coedil99.controller.ui.ElaboraRDAController"
        MainApplication.getInstance().loadPage("elabora_rda", "com.coedil99.controller.ui.ElaboraRDAController", DefineControllerUi.ELABORA_RDA_NUOVA);
    }

    @FXML
    public void onEditRda(ActionEvent actionEvent) {
        //fx:controller="com.coedil99.controller.ui.ElaboraRDAController"
        MainApplication.getInstance().loadPage("elabora_rda", "com.coedil99.controller.ui.ElaboraRDAController", DefineControllerUi.ELABORA_RDA_LISTA);
    }

    @FXML
    public void onDeleteRda(ActionEvent actionEvent) {

    }

    @FXML
    public void goBack()
    {
        MainApplication.getInstance().goBack();
    }
}