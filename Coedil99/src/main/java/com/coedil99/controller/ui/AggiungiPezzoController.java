package com.coedil99.controller.ui;

import com.coedil99.modello_di_dominio.*;
import com.coedil99.modello_di_dominio.dao.LavorazionePezzoDAO;
import com.coedil99.modello_di_dominio.dao.PezzoDAO;
import com.coedil99.modello_di_dominio.dao.RigaDistintaDAO;
import com.coedil99.modello_di_dominio.dao.RigaRDADAO;
import com.coedil99.utilita.UtilitaManager;
import com.coedil99.utilita.Log;
import com.coedil99.utilita.Sessione;
import com.coedil99.utilita.impl.UtilitaManagerPrototipo;
import com.coedil99.utilita.FilesOp;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.hibernate.Query;
import org.orm.PersistentException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AggiungiPezzoController implements Initializable {

	@FXML private ListView<Pezzo> listPezzi;
	@FXML private TextField cercaPezzo;
    @FXML private TextField indicazioneRigaDistinta;
    @FXML private TextField descrizioneTipoLavorazione;
    @FXML private TextField misuraTaglio;
    @FXML private TextField pesoTxt;
	@FXML private Button aggiungiPezzo;
    @FXML private ImageView imgSagoma;
	private Log log;
	private Sessione sessione;
    private RigaDistintaDAO rigaDistintaDAO;
    private UtilitaManager gsp;
    private PezzoDAO pezzoDAO;

    private String pathSagoma="";
    private String descrizione="";
    private String indicazione="";
    private float peso=0;
    private float taglio=0;

    private String oldString = null;

    private Pezzo[] pezzi;
    private ObservableList<Pezzo> obsPezzi;
    private LavorazionePezzoDAO lavorazionePezzoDAO;

    public void setAction(int action) {

    }

	public void initialize(URL arg0, ResourceBundle arg1) {
		
		aggiungiPezzo.setDisable(true);
        gsp = UtilitaManagerPrototipo.getGestoreServizi();
        pezzoDAO = DAOFactory.getDAOFactory().getPezzoDAO();
		log = (Log) UtilitaManager.getGestoreServizi().getServizio("LogStdout");
		sessione = (Sessione) UtilitaManager.getGestoreServizi().getServizio("SessionePrototipo");
        rigaDistintaDAO = DAOFactory.getDAOFactory().getRigaDistintaDAO();
        lavorazionePezzoDAO = DAOFactory.getDAOFactory().getLavorazionePezzoDAO();

        refreshListaPezzi();
		
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

                                     public ListCell<Pezzo> call(ListView<Pezzo> list) {
                                         return new PezzoCell();
                                     }
                                 }
        );

        listPezzi.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pezzo>() {

            public void changed(ObservableValue<? extends Pezzo> arg0,
                                Pezzo arg1, Pezzo arg2) {

                aggiungiPezzo.setDisable(false);

            }
        });

    }

    private void refreshListaPezzi()
    {
        try
        {
            //RigaRDADAO rigaRDADAO = DAOFactory.getDAOFactory().getRigaRDADAO();
            //RigaRDA[] arrayRigheRDA = rigaRDADAO.listRigaRDAByQuery(null,null);
            Query query = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession().createQuery(
                    "FROM RigaRDA R WHERE R.pezzo NOT IN (SELECT F.pezzo FROM RigaDistinta F)"
            );
            List<RigaRDA> righeRDA = query.list();
            if(righeRDA.size() == 0)
            {
                return;
            }

            pezzi = new Pezzo[righeRDA.size()];
            int j = 0;
            for (RigaRDA i :righeRDA) {

                pezzi[j] = i.getPezzo();
                j++;
            }
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
                                     public ListCell<Pezzo> call(ListView<Pezzo> list) {
                                         return new PezzoCell();
                                     }
                                 }
        );

        listPezzi.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pezzo>() {


            public void changed(ObservableValue<? extends Pezzo> arg0,
                                Pezzo arg1, Pezzo arg2) {

                aggiungiPezzo.setDisable(false);

            }
        });
    }


    @FXML
    private void instaSearch()
    {

        handleSearchByKey(oldString,cercaPezzo.getText());
        oldString=cercaPezzo.getText();
    }

    @FXML
    public void onBtnAggiungiSagoma(){

        log.i("aggiunta_sagoma");

        final FileChooser fileChooser = new FileChooser();

        File file = fileChooser.showOpenDialog(cercaPezzo.getScene().getWindow());
        if (file != null) {

            File newfile = new File(".\\Coedil99\\blobs\\sagoma\\"+file.getName());

            try {
                FilesOp.copyFileUsingStream(file, newfile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            int start = (newfile.getAbsolutePath().indexOf("Coedil99\\blobs\\sagoma\\"));

            int end = (newfile.getAbsolutePath().length());

            pathSagoma = ( newfile.getAbsolutePath().substring(start,end) );

            File file2 = new File(pathSagoma);
            try {
                log.i(file2.getCanonicalPath());
                imgSagoma.setImage(new Image("file:///"+file2.getCanonicalPath()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    public void onBtnModificaSagoma(){

        log.i("selezione_sagoma");

        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(".\\Coedil99\\blobs\\sagoma\\"));
        File file = fileChooser.showOpenDialog(cercaPezzo.getScene().getWindow());
        if (file != null) {
            int start = (file.getAbsolutePath().indexOf("Coedil99\\blobs\\sagoma\\"));

            int end = (file.getAbsolutePath().length());

            pathSagoma = ( file.getAbsolutePath().substring(start,end) );

            File file2 = new File(pathSagoma);
            try {
                log.i(file2.getCanonicalPath());
                imgSagoma.setImage(new Image("file:///"+file2.getCanonicalPath()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    public void onBtnRimuoviSagoma(){

        log.i("rimuovi_sagoma");

        imgSagoma.setImage(null);
        pathSagoma="";


    }

	@FXML
	public void onAggiungiPezzo(){
		
		log.i("pezzo aggiunto");
		

		Pezzo pezzoScelto = listPezzi.getSelectionModel().getSelectedItem();

        descrizione = descrizioneTipoLavorazione.getText();
        indicazione = indicazioneRigaDistinta.getText();
        try {
            taglio = Float.parseFloat(misuraTaglio.getText());
        }catch (NumberFormatException e)
        {
            misuraTaglio.setStyle("-fx-border-color: red");
            misuraTaglio.setPromptText("Riempi questo campo");
        }

        try
        {
            peso = Float.parseFloat(pesoTxt.getText());
        }catch(NumberFormatException e)
        {
            pesoTxt.setStyle("-fx-border-color: red");
            pesoTxt.setPromptText("Riempi questo campo");
        }

        LavorazionePezzo lavorazionePezzo = lavorazionePezzoDAO.createLavorazionePezzo();

        sessione.set("pezzo_selezionato",pezzoScelto);
        sessione.set("lavorazionePezzo_selezionato", lavorazionePezzo);

        if (indicazioneRigaDistinta.getText().matches("") || indicazioneRigaDistinta.getText() == null) {
            indicazioneRigaDistinta.setStyle("-fx-border-color: red");
            indicazioneRigaDistinta.setPromptText("Riempi questo campo");
        } else {
            sessione.set("indicazione_rigaDistinta", indicazione);
            ((Stage) cercaPezzo.getScene().getWindow()).close();
        }
	}

	static class PezzoCell extends ListCell<Pezzo> {
        public void updateItem(Pezzo item, boolean empty) {
            super.updateItem(item, empty);
            if(item != null){
            	setText(item.getDescrizionePezzo().getNome());
            }
        }
    }

}
