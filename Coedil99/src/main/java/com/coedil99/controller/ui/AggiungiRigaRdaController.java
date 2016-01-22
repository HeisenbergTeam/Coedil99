package com.coedil99.controller.ui;

import com.coedil99.modello_di_dominio.DAOFactory;
import com.coedil99.modello_di_dominio.Pezzo;
import com.coedil99.modello_di_dominio.dao.LavorazionePezzoDAO;
import com.coedil99.modello_di_dominio.dao.PezzoDAO;
import com.coedil99.modello_di_dominio.dao.RigaDistintaDAO;
import com.coedil99.utilita.UtilitaManager;
import com.coedil99.utilita.Log;
import com.coedil99.utilita.Sessione;
import com.coedil99.utilita.impl.UtilitaManagerPrototipo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.orm.PersistentException;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Igor on 09/11/2015.
 */
public class AggiungiRigaRdaController implements Initializable {

    static final public String PEZZO_RIGA_RDA = "pezzo_riga_rda";
    static final public String INDICAZIONE_RIGA_RDA = "indicazione_riga_rda";
    static final public String QUANTITA_RIGA_RDA = "quantita_riga_rda";

    @FXML private ListView<Pezzo> listPezzi;
    @FXML private Button aggiungiPezzo;
    @FXML private TextField txt_indicazione_rda;
    @FXML private TextField txt_quantita;

    private PezzoDAO pezzoDAO;
    private Pezzo[] pezzi;
    private ObservableList<Pezzo> obsPezzi;

    private UtilitaManager gsp;
    private Log log;
    private Sessione sessione;
    private RigaDistintaDAO rigaDistintaDAO;
    private LavorazionePezzoDAO lavorazionePezzoDAO;
    @FXML private TextField cercaPezzo;

    private String oldString;

    public void setAction(int action) {

    }

    private void refreshListaPezzi()
    {
        try
        {
            pezzi = pezzoDAO.listPezzoByQuery(null,null);
        }catch(PersistentException e)
        {
            e.printStackTrace();
        }

        obsPezzi = FXCollections.observableArrayList(pezzi);



        Parent listPezziParent = listPezzi.getParent();

        Pane tps = (Pane) listPezziParent;
        tps.getChildren().remove(listPezzi);

        listPezzi.setItems(obsPezzi);

        tps.getChildren().add(listPezzi);

        listPezzi.setCellFactory(new Callback<ListView<Pezzo>,
                                                 ListCell<Pezzo>>() {
                                     @Override
                                     public ListCell<Pezzo> call(ListView<Pezzo> list) {
                                         return new PezzoCell();
                                     }
                                 }
        );

        listPezzi.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pezzo>() {

            @Override
            public void changed(ObservableValue<? extends Pezzo> arg0,
                                Pezzo arg1, Pezzo arg2) {

                aggiungiPezzo.setDisable(false);

            }
        });
    }

    @FXML
    public void onAggiungiPezzo()
    {
        log.i("pezzo aggiunto");

        //Pezzo scelto
        Pezzo pezzoScelto = listPezzi.getSelectionModel().getSelectedItem();

        if (txt_indicazione_rda.getText().matches("") || txt_indicazione_rda.getText() == null) {

            txt_indicazione_rda.setStyle("-fx-border-color: red");
            txt_indicazione_rda.setPromptText("Riempi questo campo");
            return;
        }
        float quantita = -1;
        try {
             quantita = Float.valueOf(txt_quantita.getText());
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }

        if(quantita < 0)
        {
            txt_indicazione_rda.setStyle("-fx-border-color: red");
            txt_indicazione_rda.setPromptText("Riempi questo campo");
            return;
        }

        sessione.set(PEZZO_RIGA_RDA,pezzoScelto);
        sessione.set(INDICAZIONE_RIGA_RDA, txt_indicazione_rda.getText());
        sessione.set(QUANTITA_RIGA_RDA,quantita);

        ((Stage) cercaPezzo.getScene().getWindow()).close();
    }

    @FXML
    public void instaSearch()
    {
        handleSearchByKey(oldString,cercaPezzo.getText());
        oldString=cercaPezzo.getText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        aggiungiPezzo.setDisable(true);

        gsp = UtilitaManagerPrototipo.getGestoreServizi();
        pezzoDAO = DAOFactory.getDAOFactory().getPezzoDAO();
        log = (Log) UtilitaManager.getGestoreServizi().getServizio("LogStdout");
        sessione = (Sessione) UtilitaManager.getGestoreServizi().getServizio("SessionePrototipo");
        rigaDistintaDAO = DAOFactory.getDAOFactory().getRigaDistintaDAO();
        lavorazionePezzoDAO = DAOFactory.getDAOFactory().getLavorazionePezzoDAO();

        refreshListaPezzi();
    }

    static class PezzoCell extends ListCell<Pezzo> {
        @Override
        public void updateItem(Pezzo item, boolean empty) {
            super.updateItem(item, empty);
            if(item != null){
                setText(item.getDescrizionePezzo().getNome());
            }
        }
    }


    public void handleSearchByKey(String oldVal, String newVal) {
        // If the number of characters in the text box is less than last time
        // it must be because the user pressed delete
        if ( oldVal != null && !oldVal.matches("") && (newVal.length() < oldVal.length()) ) {
            // Restore the lists original set of entries
            // and start from the beginning
            refreshListaPezzi();
        }

        // Break out all of the parts of the search text
        // by splitting on white space
        String[] parts = newVal.toUpperCase().split(" ");

        // Filter out the entries that don't contain the entered text
        ObservableList<Pezzo> subentries = FXCollections.observableArrayList();
        for ( Pezzo entry: listPezzi.getItems() ) {
            boolean match = true;
            String entryText = (String)entry.getDescrizionePezzo().getNome();

            for ( String part: parts ) {
                // The entry needs to contain all portions of the
                // search string *but* in any order
                if ( ! entryText.toUpperCase().contains(part) ) {
                    match = false;
                    break;
                }
            }

            if ( match ) {

                subentries.add(entry);

            }
        }

        Parent listPezziParent = listPezzi.getParent();

        Pane tps = (Pane) listPezziParent;
        tps.getChildren().remove(listPezzi);
        listPezzi.setItems(subentries);

        tps.getChildren().add(listPezzi);

        listPezzi.setCellFactory(new Callback<ListView<Pezzo>,
                                         ListCell<Pezzo>>() {
                                     @Override
                                     public ListCell<Pezzo> call(ListView<Pezzo> list) {
                                         return new PezzoCell();
                                     }
                                 }
        );

        listPezzi.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pezzo>() {

            @Override
            public void changed(ObservableValue<? extends Pezzo> arg0,
                                Pezzo arg1, Pezzo arg2) {

                aggiungiPezzo.setDisable(false);

            }
        });

    }




}
