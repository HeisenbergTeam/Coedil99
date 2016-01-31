package com.coedil99.controller.ui;

import com.coedil99.modello_di_dominio.*;
import com.coedil99.modello_di_dominio.dao.OrdineDAO;
import com.coedil99.modello_di_dominio.dao.RDADAO;
import com.coedil99.utilita.UtilitaManager;
import com.coedil99.utilita.Log;
import com.coedil99.utilita.impl.UtilitaManagerPrototipo;
import com.coedil99.ui.MainApplication;
import com.coedil99.controller.ui.DefineControllerUi;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
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
    private TableColumn<RDA, String> tableRdaFornitore;

    @FXML
    private TabPane rdaTabPane;

    @FXML
    public TitledPane commessaPane;

    @FXML
    public TextField dataCreazione;
    @FXML
    public TextField dataPrevista;
    @FXML
    public TextField dataArrivo;

    @FXML
    public Button btnNewRda;
    @FXML
    public Button btnEditRda;
    @FXML
    public Button btnDeleteRda;


    protected Log log;
    protected RDA rdaCorrente = null;

    public void setAction(int action) {

    }

    public ArrayList<RDA> getRDAList() {
        RDADAO rdaDAO = DAOFactory.getDAOFactory().getRDADAO();
        ArrayList<RDA> rdas = null;
        try {
            rdas = new ArrayList<RDA>(
                    Arrays.asList(rdaDAO.listRDAByQuery(null,null)));

        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return rdas;
    }

    final private ChangeListener changeListener = new ChangeListener<Object>() {

        @Override
        public void changed(ObservableValue<? extends Object> arg0,
                            Object arg1, Object arg2) {

            Integer index = (Integer)arg2;
            if (index >= 0 ) {
                commessaPane.setDisable(false);
                RDA rda = getRDAList().get(index);
                dataArrivo.setText(rda.getDataArrivoEffettiva().toString());
                dataCreazione.setText(rda.getDataCreazione().toString());
                dataPrevista.setText(rda.getDataArrivoPrevista().toString());

                btnEditRda.setDisable(false);
                btnDeleteRda.setDisable(false);
            }
        }
    };

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        UtilitaManager gsp = UtilitaManagerPrototipo.getGestoreServizi();
        RDADAO rdaDAO = DAOFactory.getDAOFactory().getRDADAO();
        log = (Log) gsp.getServizio("LogStdout");

        ArrayList<RDA> rdas = getRDAList();

        commessaPane.setDisable(true);

        refreshRdaTable();

        btnNewRda.setDisable(false);
        btnEditRda.setDisable(true);
        btnDeleteRda.setDisable(true);

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

    protected void refreshRdaTable() {
        tableRda.getSelectionModel().selectedIndexProperty()
                .removeListener(changeListener);

        this.loadRdaTable(getRDAList());
        // ListenerOrdini

        tableRda.getSelectionModel().selectedIndexProperty()
                .addListener(changeListener);
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

        tableRdaFornitore
                .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RDA, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(
                            CellDataFeatures<RDA, String> arg0) {
                        // TODO Auto-generated method stub
                        SimpleStringProperty s = new SimpleStringProperty();

                        if (arg0.getValue() == null) {
                            s.set("ciao");
                        } else {
                            s.set(arg0.getValue().getFornitore().getNome());
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
        RDA rda = tableRda.getSelectionModel().getSelectedItem();
        try {

            RigaRDA[] arrayRigaRDA = DAOFactory.getDAOFactory().getRigaRDADAO().listRigaRDAByQuery(null,null);
            for (int i = 0; i < arrayRigaRDA.length; i++) {
                if (arrayRigaRDA[i].getRda().getID() == rda.getID()) {
                    System.out.print("deleting rigarda " + arrayRigaRDA[i].getID());
                    DAOFactory.getDAOFactory().getRigaRDADAO().deleteAndDissociate(arrayRigaRDA[i]);
                }
            }

            DAOFactory.getDAOFactory().getRDADAO().deleteAndDissociate(rda);
        } catch (PersistentException e) {
            e.printStackTrace();
        } finally {
            refreshRdaTable();
        }
    }

    @FXML
    public void goBack()
    {
        MainApplication.getInstance().goBack();
    }
}