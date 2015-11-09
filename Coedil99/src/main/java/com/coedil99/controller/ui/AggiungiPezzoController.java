package com.coedil99.controller.ui;

import com.coedil99.modello_di_dominio.DAOFactory;
import com.coedil99.modello_di_dominio.LavorazionePezzo;
import com.coedil99.modello_di_dominio.Pezzo;
import com.coedil99.modello_di_dominio.RigaDistinta;
import com.coedil99.modello_di_dominio.dao.PezzoDAO;
import com.coedil99.modello_di_dominio.dao.RigaDistintaDAO;
import com.coedil99.servizi.GestoreServizi;
import com.coedil99.servizi.Log;
import com.coedil99.servizi.Sessione;
import com.coedil99.servizi.impl.GestoreServiziPrototipo;
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
import org.orm.PersistentException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AggiungiPezzoController implements Initializable {
/**
 * 
 */
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
    private GestoreServizi gsp;
    private PezzoDAO pezzoDAO;

    private String pathSagoma="";
    private String descrizione="";
    private String indicazione="";
    private float peso=0;
    private float taglio=0;

    private String oldString = null;

    private Pezzo[] pezzi;
    private ObservableList<Pezzo> obsPezzi;
/**
 * 
 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		aggiungiPezzo.setDisable(true);

        gsp = GestoreServiziPrototipo.getGestoreServizi();
        pezzoDAO = DAOFactory.getDAOFactory().getPezzoDAO();
		log = (Log) GestoreServizi.getGestoreServizi().getServizio("LogStdout");
		sessione = (Sessione) GestoreServizi.getGestoreServizi().getServizio("SessionePrototipo");
        rigaDistintaDAO = DAOFactory.getDAOFactory().getRigaDistintaDAO();

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
                //System.out.println(entry.getDescrizionePezzo().getNome());
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

    private void refreshListaPezzi(){
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

        //listPezzi.setItems(obsPezzi);

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

    /**
     *
     */
    @FXML
    private void instaSearch() {
        //System.out.println("aaa");
        handleSearchByKey(oldString,cercaPezzo.getText());
        oldString=cercaPezzo.getText();
    }

    /**
     *
     */
    @FXML
    public void onBtnAggiungiSagoma(){

        log.i("aggiunta_sagoma");

        final FileChooser fileChooser = new FileChooser();
        //fileChooser.setInitialDirectory(new File(".\\Coedil99\\blobs\\sagoma\\"));
        File file = fileChooser.showOpenDialog(((Stage) cercaPezzo.getScene().getWindow()));
        if (file != null) {

            File newfile = new File(".\\Coedil99\\blobs\\sagoma\\"+file.getName());

            //try {
            //    Files.copy(file.toPath(), newfile.toPath());
            //} catch (IOException e) {
            //    e.printStackTrace();
            //}
            try {
                FilesOp.copyFileUsingStream(file, newfile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //FileUtils.copyFile(source, dest);

            int start = (newfile.getAbsolutePath().indexOf("Coedil99\\blobs\\sagoma\\"));

            int end = (newfile.getAbsolutePath().length());

            pathSagoma = ( newfile.getAbsolutePath().substring(start,end) );

            File file2 = new File(pathSagoma);
            try {
                System.out.println(file2.getCanonicalPath());
                imgSagoma.setImage(new Image("file:///"+file2.getCanonicalPath()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     *
     */
    @FXML
    public void onBtnModificaSagoma(){

        log.i("selezione_sagoma");

        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(".\\Coedil99\\blobs\\sagoma\\"));
        File file = fileChooser.showOpenDialog(((Stage) cercaPezzo.getScene().getWindow()));
        if (file != null) {
            int start = (file.getAbsolutePath().indexOf("Coedil99\\blobs\\sagoma\\"));

            int end = (file.getAbsolutePath().length());

            pathSagoma = ( file.getAbsolutePath().substring(start,end) );

            File file2 = new File(pathSagoma);
            try {
                System.out.println(file2.getCanonicalPath());
                imgSagoma.setImage(new Image("file:///"+file2.getCanonicalPath()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    /**
     *
     */
    @FXML
    public void onBtnRimuoviSagoma(){

        log.i("rimuovi_sagoma");

        imgSagoma.setImage(null);
        pathSagoma="";


    }
/**
 * 
 */
	@FXML
	public void onAggiungiPezzo(){
		
		log.i("pezzo aggiunto");
		
		//Pezzo scelto
		Pezzo pezzoScelto = listPezzi.getSelectionModel().getSelectedItem();

		//Sagoma sagoma = rigaDistintaDAO.creaSagoma(pathSagoma);

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


        //LavorazionePezzo lavorazionePezzo = rigaDistintaDAO.creaLavorazionePezzo(descrizione, taglio, peso, sagoma);
        LavorazionePezzo lavorazionePezzo = null;

        //RigaDistinta rigaDistinta = rigaDistintaDAO.creaRigaDistinta(scelto, distinta, lavorazionePezzo, indicazione);


        sessione.set("pezzo_selezionato",pezzoScelto);
        sessione.set("lavorazionePezzo_selezionato", lavorazionePezzo);

        boolean blocca = false;

        if (indicazioneRigaDistinta.getText().matches("") || indicazioneRigaDistinta.getText() == null) {
            blocca = true;
            indicazioneRigaDistinta.setStyle("-fx-border-color: red");
            indicazioneRigaDistinta.setPromptText("Riempi questo campo");
        } else {
            blocca = false;
            sessione.set("indicazione_rigaDistinta", indicazione);

            //Chiudo la finestra
            ((Stage) cercaPezzo.getScene().getWindow()).close();
        }
	}
/**
 * 
 * @author mw
 *
 */
	static class PezzoCell extends ListCell<Pezzo> {
        @Override
        public void updateItem(Pezzo item, boolean empty) {
            super.updateItem(item, empty);
            if(item != null){
            	setText(item.getDescrizionePezzo().getNome());
            }
        }
    }

}
