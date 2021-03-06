package com.coedil99.controller.ui;

import com.coedil99.dominio.builder.Builder;
import com.coedil99.modello_di_dominio.*;
import com.coedil99.modello_di_dominio.dao.RDADAO;
import com.coedil99.utilita.Sessione;
import com.coedil99.utilita.UtilitaManager;
import com.coedil99.utilita.Log;
import com.coedil99.utilita.impl.UtilitaManagerPrototipo;
import com.coedil99.ui.MainApplication;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.orm.PersistentException;

import java.net.URL;
import java.util.*;

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
    protected Sessione session;
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

        public void changed(ObservableValue<? extends Object> arg0,
                            Object arg1, Object arg2) {

            Integer index = (Integer)arg2;
            if (index >= 0 ) {
                commessaPane.setDisable(false);
                RDA rda = getRDAList().get(index);
                rdaCorrente = rda;
                dataArrivo.setText(rda.getDataArrivoEffettiva().toString());
                dataCreazione.setText(rda.getDataCreazione().toString());
                dataPrevista.setText(rda.getDataArrivoPrevista().toString());

                btnEditRda.setDisable(false);
                btnDeleteRda.setDisable(false);
            }
        }
    };

    public void initialize(URL arg0, ResourceBundle arg1) {

        UtilitaManager gsp = UtilitaManagerPrototipo.getGestoreServizi();
        RDADAO rdaDAO = DAOFactory.getDAOFactory().getRDADAO();
        log = (Log) gsp.getServizio("LogStdout");
        session = (Sessione) gsp.getServizio("SessionePrototipo");

        ArrayList<RDA> rdas = getRDAList();

        commessaPane.setDisable(true);

        refreshRdaTable();

        btnNewRda.setDisable(false);
        btnEditRda.setDisable(true);
        btnDeleteRda.setDisable(true);

    }

    protected void refreshRdaTable() {
        tableRda.getSelectionModel().selectedIndexProperty()
                .removeListener(changeListener);

        this.loadRdaTable(getRDAList());

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


                    public ObservableValue<String> call(
                            CellDataFeatures<RDA, String> arg0) {

                        SimpleStringProperty s = new SimpleStringProperty();
                        s.set(""+(arg0.getValue().getID()));
                        return s;
                    }
                });

        tableRdaFornitore
                .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RDA, String>, ObservableValue<String>>() {


                    public ObservableValue<String> call(
                            CellDataFeatures<RDA, String> arg0) {

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

    public void nuovaRDA() {

        log.i("Aggiungi rda");

        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);

        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("fxml/aggiungi_rda.fxml"));

            //"com.coedil99.controller.ui.AggiungiPezzoController"
            AggiungiRDAController controller = new AggiungiRDAController();

            // Set it in the FXMLLoader
            loader.setController(controller);

            root = loader.load();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        popupStage.setScene(scene);

        //blocking
        popupStage.showAndWait();

        Fornitore fornitoreSelezionato = (Fornitore) session.get("fornitore_selezionato");

        Date dateP = (Date) session.get("data_prevista");
        Date dateE = (Date) session.get("data_effettiva");
        Date dateR = (Date) session.get("data_richiesta");

        if (fornitoreSelezionato != null && dateP != null && dateE != null && dateR != null) {
            RDA nuovaRda = new Builder.RDABuilder().setDataArrivoEffettiva(dateE).setDataArrivoPrevista(dateP).setDataCreazione(dateR).setDescrizione("").setFornitore(fornitoreSelezionato).build();
            refreshRdaTable();
            MainApplication.getInstance().loadPage("elabora_rda", "com.coedil99.controller.ui.ElaboraRDAController", nuovaRda.getID());
        }
    }

    @FXML
    public void onNuovaRda(ActionEvent actionEvent) throws PersistentException {

        nuovaRDA();
    }

    @FXML
    public void onEditRda(ActionEvent actionEvent) {

        MainApplication.getInstance().loadPage("elabora_rda", "com.coedil99.controller.ui.ElaboraRDAController", rdaCorrente.getID());
    }

    @FXML
    public void onDeleteRda(ActionEvent actionEvent) {
        RDA rda = tableRda.getSelectionModel().getSelectedItem();
        try {

            RigaRDA[] arrayRigaRDA = DAOFactory.getDAOFactory().getRigaRDADAO().listRigaRDAByQuery(null,null);
            for (int i = 0; i < arrayRigaRDA.length; i++) {
                if (arrayRigaRDA[i].getRda().getID() == rda.getID()) {
                    log.i("deleting rigarda " + arrayRigaRDA[i].getID());
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