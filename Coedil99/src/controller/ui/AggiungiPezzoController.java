package controller.ui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import modello_di_dominio.LavorazionePezzo;
import modello_di_dominio.Pezzo;
import modello_di_dominio.RigaDistinta;
import modello_di_dominio.Sagoma;
import servizi.*;
import servizi.impl.GestoreServiziPrototipo;

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
    private GestoreRigaDistinta gestoreRigaDistinta;

    private String pathSagoma="";
    private String descrizione="";
    private String indicazione="";
    private float peso=0;
    private float taglio=0;
/**
 * 
 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		aggiungiPezzo.setDisable(true);

        GestoreServizi gsp = GestoreServiziPrototipo.getGestoreServizi();
        GestorePezzi gestorePezzi = (GestorePezzi) GestoreServizi.getGestoreServizi().getServizio("GestorePezziDAO");
		log = (Log) GestoreServizi.getGestoreServizi().getServizio("LogStdout");
		sessione = (Sessione) GestoreServizi.getGestoreServizi().getServizio("SessionePrototipo");
        gestoreRigaDistinta = (GestoreRigaDistinta) gsp.getServizio("GestoreRigaDistintaDAO");

        List<Pezzo> pezzi = gestorePezzi.getPezzi();
		ObservableList<Pezzo> obsPezzi = FXCollections.observableArrayList(pezzi);
		
		
		listPezzi.setItems(obsPezzi);
		
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
    public void onBtnAggiungiSagoma(){

        log.i("pezzo aggiunto");

        //Pezzo scelto
        Pezzo scelto = listPezzi.getSelectionModel().getSelectedItem();
        sessione.set("pezzo_aggiunto",scelto);

        //Chiudo la finestra
        ((Stage) cercaPezzo.getScene().getWindow()).close();

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

        log.i("pezzo aggiunto");

        //Pezzo scelto
        Pezzo scelto = listPezzi.getSelectionModel().getSelectedItem();
        sessione.set("pezzo_aggiunto",scelto);

        //Chiudo la finestra
        ((Stage) cercaPezzo.getScene().getWindow()).close();

    }
/**
 * 
 */
	@FXML
	public void onAggiungiPezzo(){
		
		log.i("pezzo aggiunto");
		
		//Pezzo scelto
		Pezzo pezzoScelto = listPezzi.getSelectionModel().getSelectedItem();

		Sagoma sagoma = gestoreRigaDistinta.creaSagoma(pathSagoma);

        descrizione = descrizioneTipoLavorazione.getText();
        indicazione = indicazioneRigaDistinta.getText();
        taglio = Float.parseFloat(misuraTaglio.getText());
        peso = Float.parseFloat(pesoTxt.getText());

        LavorazionePezzo lavorazionePezzo = gestoreRigaDistinta.creaLavorazionePezzo(descrizione, taglio, peso, sagoma);

        //RigaDistinta rigaDistinta = gestoreRigaDistinta.creaRigaDistinta(scelto, distinta, lavorazionePezzo, indicazione);


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


            //@FXML private TextField indicazioneRigaDistinta;
            //@FXML private TextField descrizioneTipoLavorazione;
            //@FXML private TextField misuraTaglio;
            //@FXML private TextField pesoTxt;

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
