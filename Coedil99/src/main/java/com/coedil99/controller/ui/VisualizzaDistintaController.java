package com.coedil99.controller.ui;

import com.coedil99.controller.builder.Builder;
import com.coedil99.controller.builder.Editor;
import com.coedil99.modello_di_dominio.*;
import com.coedil99.modello_di_dominio.dao.DistintaDAO;
import com.coedil99.modello_di_dominio.dao.OrdineDAO;
import com.coedil99.modello_di_dominio.dao.RigaDistintaDAO;
import com.coedil99.utilita.UtilitaManager;
import com.coedil99.utilita.Log;
import com.coedil99.utilita.Sessione;
import com.coedil99.utilita.impl.UtilitaManagerPrototipo;
import com.coedil99.ui.MainApplication;
import com.coedil99.utilita.FilesOp;
import com.coedil99.utilita.Parsers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.orm.PersistentException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class VisualizzaDistintaController implements Initializable {
	
    @FXML private ListView<RigaDistinta> listPezziDistinta;
    @FXML private TextField txt_modulo;
    @FXML private TextField txt_revisione;
    @FXML private TextField txt_data;
    @FXML private TextField txt_cliente;
    @FXML private TextField txt_destinazione;
    @FXML private TextField txt_elemstrutturale;
    @FXML private TextField txt_cartellino;
    
    @FXML private TextField txt_indicazione;
    @FXML private TextField txt_n_pezzi;
    @FXML private TextField txt_n_pezzi_magazzino;
    @FXML private TextField txt_data_arrivo;
    @FXML private TextField txt_diametro;
    @FXML private TextField txt_peso_originale;
    @FXML private TextField txt_peso_lavorato;
    @FXML private TextField txt_lavorazione;
    @FXML private TextField txt_misura_taglio;
    @FXML private TextField txt_codice_pezzo;
    @FXML private TextField txt_fornitore;

    @FXML private ImageView img_sagoma;

    @FXML private Button modificaDistButton;
    @FXML private Button salvaDistButton;
    @FXML private Button aggiungiPezzoButton;
    @FXML private Button modificaPezzoButton;
    @FXML private Button rimuoviPezzoButton;
    @FXML private Button btn_aggiungi_sagoma;
    @FXML private Button btn_modifica_sagoma;
    @FXML private Button btn_rimuovi_sagoma;
    
    @FXML private TitledPane righe_distinta;
    @FXML private TitledPane informazioni_distinta;
    
    @FXML private DatePicker datePicker = new DatePicker();
    @FXML private DatePicker dateConsegnaPicker = new DatePicker();

    private String pathSagoma="";

    //private Map<String,Label> distintaLabels;
    //private Map<String,TextField> distintaTextFields;
    //private Map<String,Object> rigaDistintaNodes;
    //private Map<String,Object> rigaDistintaTextFields;
    
    private RigaDistinta rigaSelezionata;
    
    private DistintaDAO distintaDAO;
    private RigaDistintaDAO rigaDistintaDAO;
    private OrdineDAO ordineDao;

    private Log log;
    private Sessione session;
    
    Ordine ordine;
    Commessa[] commesse;
    Distinta distinta;
    RigaDistinta[] righeDistinta;
    
    private Boolean modificandoDistinta = false;
    private Boolean modificandoRigaDistinta = false;

    public int currentDistintaId = 0;

    private int oldIndex = -1;
    
    final ObservableList<RigaDistinta> listaPezzi = FXCollections.observableArrayList();

    static public final String DISTINTA_CORRENTE = "distinta_corrente";

    public void setAction(int action) {
        currentDistintaId = action;
    }

    public void setTextEdit(TextField txtField, Boolean enabled){
        System.out.println(txtField.toString());
        if(enabled) {
            txtField.setStyle("-fx-background-color: #FFFFFF;");
            txtField.setAlignment(Pos.CENTER);
            txtField.setEditable(true);
        }else{
            txtField.setStyle("-fx-background-color: #EEEEEE;");
            txtField.setAlignment(Pos.CENTER);
            txtField.setEditable(false);
        }
    }

	public void initialize(URL arg0, ResourceBundle arg1) {
		
		salvaDistButton.setDisable(true);
		modificaPezzoButton.setDisable(true);
		rimuoviPezzoButton.setDisable(true);
        btn_aggiungi_sagoma.setDisable(true);
        btn_modifica_sagoma.setDisable(true);
        btn_rimuovi_sagoma.setDisable(true);


		UtilitaManager gsp = UtilitaManagerPrototipo.getGestoreServizi();
		ordineDao = DAOFactory.getDAOFactory().getOrdineDAO();

		distintaDAO = DAOFactory.getDAOFactory().getDistintaDAO();
		rigaDistintaDAO = DAOFactory.getDAOFactory().getRigaDistintaDAO();

		log = (Log) gsp.getServizio("LogStdout");
		session = (Sessione) gsp.getServizio("SessionePrototipo");
		
		refreshList();
		refreshDistinta();

        setTextEdit(txt_modulo,false);
        setTextEdit(txt_revisione,false);
        setTextEdit(txt_data,false);
        setTextEdit(txt_cliente,false);
        setTextEdit(txt_destinazione,false);
        setTextEdit(txt_elemstrutturale,false);
        setTextEdit(txt_cartellino,false);
        setTextEdit(txt_indicazione,false);
        setTextEdit(txt_n_pezzi,false);
        //setTextEdit(txt_n_pezzi_magazzino,false);
        setTextEdit(txt_data_arrivo,false);
        setTextEdit(txt_diametro,false);
        setTextEdit(txt_peso_originale,false);
        setTextEdit(txt_peso_lavorato,false);
        setTextEdit(txt_lavorazione,false);
        setTextEdit(txt_misura_taglio,false);
        setTextEdit(txt_codice_pezzo,false);
        setTextEdit(txt_fornitore,false);

	    /*
	    distintaLabels = new HashMap<String,Label>();
	    //distintaLabels.put("modulo",txt_modulo);
	    distintaLabels.put("revisione",txt_revisione);
	    //distintaLabels.put("data",txt_data);
	    //distintaLabels.put("cliente",txt_cliente);
	    distintaLabels.put("destinazione",txt_destinazione);
	    distintaLabels.put("elemstrutturale",txt_elemstrutturale);
	    //distintaLabels.put("cartellino",txt_cartellino);
	    
	    //rigaDistinta nodes
	    
	    rigaDistintaNodes = new HashMap<String,Object>();
	    rigaDistintaNodes.put("codice", txt_codice_pezzo);
	    rigaDistintaNodes.put("n_pezzi", txt_n_pezzi);
	    rigaDistintaNodes.put("diametro", txt_diametro);
	    rigaDistintaNodes.put("peso", txt_peso_originale);
	    rigaDistintaNodes.put("peso_lavorato", txt_peso_lavorato);
	    rigaDistintaNodes.put("lavorazione", txt_lavorazione);
	    rigaDistintaNodes.put("misura_taglio", txt_misura_taglio);
	    rigaDistintaNodes.put("fornitore", txt_fornitore);
	    rigaDistintaNodes.put("indicazione", txt_indicazione);
	    */
	}
	
/**
 * modificaDatiDistinta
 */
	@FXML
	protected void modificaDatiDistinta(){
		
		log.i("Modifica dei dati della distinta");
		
		//Check
		if(modificandoDistinta != false){
			modificandoDistinta = false;
			modificaDistButton.setText("Modifica");
            setTextEdit(txt_revisione,false);
            setTextEdit(txt_data,false);
            setTextEdit(txt_elemstrutturale,false);
			salvaDatiDistinta();
			return;
		}

        setTextEdit(txt_revisione,true);
        setTextEdit(txt_data,true);
        setTextEdit(txt_elemstrutturale,true);
		/*
		Set<Map.Entry<String, Label>> insieme = distintaLabels.entrySet(); 
		Iterator<Map.Entry<String, Label>> iterator = insieme.iterator();
		
		distintaTextFields = new HashMap<String, TextField>();
		
		while(iterator.hasNext() != false){
			
			Map.Entry<String, Label> entry = iterator.next();
			
			Parent p = entry.getValue().getParent();
			TextField tf = new TextField();
			tf.setText(entry.getValue().getText());
			Pane tps = (Pane) p;
			tps.getChildren().remove(entry.getValue());
			tps.getChildren().add(tf);
			
			distintaTextFields.put(entry.getKey(), tf);
		}

		String current_date = txt_data.getText();
		Parent datePickParent = txt_data.getParent();
		
		final String pattern = "dd-MM-yyyy";

		datePicker.setPromptText(pattern.toLowerCase());

		datePicker.setConverter(new StringConverter<LocalDate>() {
		     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

		     @Override 
		     public String toString(LocalDate date) {
		         if (date != null) {
		             return dateFormatter.format(date);
		         } else {
		             return "";
		         }
		     }

		     @Override 
		     public LocalDate fromString(String string) {
		         if (string != null && !string.isEmpty()) {
		             return LocalDate.parse(string, dateFormatter);
		         } else {
		             return null;
		         }
		     }
		 });
		String[] split = current_date.split("-");
		LocalDate ld = LocalDate.of(Integer.parseInt(split[2]),Integer.parseInt(split[1]),Integer.parseInt(split[0]));
			//	new LocalDate(getNumber(split[0]),getNumber(split[1]),getNumber(split[2]))
		datePicker.setValue(ld);
		
		Pane tps = (Pane) datePickParent;
		tps.getChildren().remove(txt_data);
		tps.getChildren().add(datePicker);
        datePicker.setMaxWidth(Double.MAX_VALUE);
*/
        //Flag
		modificandoDistinta = true;
		//Disabilito le modifiche
		//modificaDistButton.setDisable(true);
		
		//Abilito tasto annulla
		modificaDistButton.setText("Annulla");
		
		//Abilito il salvataggio
		salvaDistButton.setDisable(false);
	}
/**
 * 
 */
	@FXML
	protected void modificaRigaDistinta(){
		
		log.i("Modifica della riga distinta");
		
		if(modificandoRigaDistinta != true){
		/*
			Set<Map.Entry<String, Object>> insieme = rigaDistintaNodes.entrySet();
			Iterator<Map.Entry<String, Object>> iterator = insieme.iterator();
			
			rigaDistintaTextFields = new HashMap<String,Object>();
			
			while(iterator.hasNext()){
				
				Map.Entry<String, Object> entry = iterator.next();
				
				Parent p = ((Node) entry.getValue()).getParent();
				TextField tf = new TextField();
				tf.setText(((Label) entry.getValue()).getText());
				Pane tps = (Pane) p;
				System.out.println(entry.getKey());
				tps.getChildren().remove(entry.getValue());
				tps.getChildren().add(tf);
				
				rigaDistintaTextFields.put(entry.getKey(), tf);
                System.out.println(entry.getKey());
			}

            String current_date = txt_data_arrivo.getText();
            Parent datePickParent = txt_data_arrivo.getParent();

            final String pattern = "dd-MM-yyyy";

            dateConsegnaPicker.setPromptText(pattern.toLowerCase());

            dateConsegnaPicker.setConverter(new StringConverter<LocalDate>() {
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

                @Override
                public String toString(LocalDate date) {
                    if (date != null) {
                        return dateFormatter.format(date);
                    } else {
                        return "";
                    }
                }

                @Override
                public LocalDate fromString(String string) {
                    if (string != null && !string.isEmpty()) {
                        return LocalDate.parse(string, dateFormatter);
                    } else {
                        return null;
                    }
                }
            });
            String[] split = current_date.split("-");
            LocalDate ld = LocalDate.of(Integer.parseInt(split[2]),Integer.parseInt(split[1]),Integer.parseInt(split[0]));
            //	new LocalDate(getNumber(split[0]),getNumber(split[1]),getNumber(split[2]))
            dateConsegnaPicker.setValue(ld);

            Pane tps = (Pane) datePickParent;
            tps.getChildren().remove(txt_data_arrivo);
            tps.getChildren().add(dateConsegnaPicker);
            dateConsegnaPicker.setMaxWidth(Double.MAX_VALUE);
*/
            aggiungiPezzoButton.setDisable(true);
			modificaPezzoButton.setText("Annulla");
			rimuoviPezzoButton.setText("Salva");
            listPezziDistinta.setDisable(true);
            btn_aggiungi_sagoma.setDisable(false);
            btn_modifica_sagoma.setDisable(false);
            btn_rimuovi_sagoma.setDisable(false);


			modificandoRigaDistinta = true;
			
		}else{
            /*
            Set<Map.Entry<String, Object>> insieme = rigaDistintaTextFields.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = insieme.iterator();

            while(iterator.hasNext()){

                Map.Entry<String, Object> entry = iterator.next();
                Parent p = ((Node) entry.getValue()).getParent();

                Pane tps = (Pane) p;
                System.out.println(entry.getKey());
                tps.getChildren().remove(entry.getValue());
                tps.getChildren().add((Node) rigaDistintaNodes.get(entry.getKey()));

            }

            Parent datePickParent = dateConsegnaPicker.getParent();
            LocalDate ld = dateConsegnaPicker.getValue();

            Pane tps = (Pane) datePickParent;
            tps.getChildren().remove(dateConsegnaPicker);
            tps.getChildren().add(txt_data_arrivo);

            Calendar cal = Calendar.getInstance();
            cal.set(ld.getYear(), ld.getMonthValue()-1, ld.getDayOfMonth()); //year is as expected, month is zero based, date is as expected
            Date dt = cal.getTime();
*/
            aggiornaCampiRigaDistinta();

            aggiungiPezzoButton.setDisable(false);
            modificaPezzoButton.setText("Modifica");
            rimuoviPezzoButton.setText("Rimuovi");
            listPezziDistinta.setDisable(false);
            btn_aggiungi_sagoma.setDisable(true);
            btn_modifica_sagoma.setDisable(true);
            btn_rimuovi_sagoma.setDisable(true);
            modificandoRigaDistinta=false;
            return;
		}
		
	}

    @FXML
    protected void rimuoviPezzo(){

        if(modificandoRigaDistinta != true){
            log.i("Rimuovi pezzo");

            RigaDistinta riga = listPezziDistinta.getSelectionModel().getSelectedItem();
            listaPezzi.remove(riga);
            riga.getDistinta().righeDistinta.remove(riga);
            distinta.righeDistinta.remove(riga);
            righeDistinta = distinta.righeDistinta.toArray();
            listaPezzi.removeAll();
            listaPezzi.clear();
            listaPezzi.addAll(righeDistinta);
            listPezziDistinta.setItems(listaPezzi);
            refreshList();
            //gestoreRigaDistinta.cancellaSagomaByRigaDistinta(riga);
            try {

                rigaDistintaDAO.delete(riga);
            } catch (PersistentException e) {
                e.printStackTrace();
            }
        } else {
/*
            Set<Map.Entry<String, Object>> insieme = rigaDistintaTextFields.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = insieme.iterator();

            while(iterator.hasNext()){

                Map.Entry<String, Object> entry = iterator.next();
                Parent p = ((Node) entry.getValue()).getParent();

                Pane tps = (Pane) p;
                tps.getChildren().remove(entry.getValue());

                ((Label) rigaDistintaNodes.get(entry.getKey())).setText(((TextField) entry.getValue()).getText());

                tps.getChildren().add((Node) rigaDistintaNodes.get(entry.getKey()));

            }

            Parent datePickParent = dateConsegnaPicker.getParent();
            LocalDate ld = dateConsegnaPicker.getValue();

            Pane tps = (Pane) datePickParent;
            tps.getChildren().remove(dateConsegnaPicker);
            tps.getChildren().add(txt_data_arrivo);

            Calendar cal = Calendar.getInstance();
            cal.set(ld.getYear(), ld.getMonthValue()-1, ld.getDayOfMonth()); //year is as expected, month is zero based, date is as expected
            Date dt = cal.getTime();
*/
            //TODO: Reimpostare
            //gestoreRigaDistinta.modificaLavorazionePezzoByRigaDistinta(rigaSelezionata, txt_lavorazione.getText(), Parsers.getFloat(txt_misura_taglio.getText()), Parsers.getFloat(txt_peso_lavorato.getText()), rigaSelezionata.getLavorazionePezzo().getSagoma());
            //gestoreRigaDistinta.modificaRigaDistintaBYID(rigaSelezionata.getID(), rigaSelezionata.getPezzo(), distinta, rigaSelezionata.getLavorazionePezzo(), txt_indicazione.getText());
            //gestoreRigaDistinta.modificaSagomaByRigaDistinta(rigaSelezionata,pathSagoma);
            //TODO: Aggiornare la descrizione del pezzo
            //pezzoDao.modificaDescrizionePezzo(rigaSelezionata.getPezzo().getDescrizionePezzo(), txt_codice_pezzo.getText(), Parsers.getFloat(txt_peso_originale.getText()), Parsers.getFloat(txt_diametro.getText()), txt_fornitore.getText());
            //TODO: Aggiornare il pezzo
            //pezzoDao.modificaPezzo(rigaSelezionata.getPezzo(), rigaSelezionata.getPezzo().getDescrizionePezzo(), dt, Integer.parseInt(txt_n_pezzi.getText()));

            refreshList();

            aggiungiPezzoButton.setDisable(false);
            modificaPezzoButton.setText("Modifica");
            rimuoviPezzoButton.setText("Rimuovi");
            listPezziDistinta.setDisable(false);
            rimuoviPezzoButton.setDisable(false);
            btn_aggiungi_sagoma.setDisable(true);
            btn_modifica_sagoma.setDisable(true);
            btn_rimuovi_sagoma.setDisable(true);
            modificandoRigaDistinta = false;

        }

    }
/**
 * 
 */
	@FXML 
	protected void salvaDatiDistinta(){
		
		log.i("Salvataggio dati distinta");

        salvaDistButton.setDisable(true);
					/*
		Set<Map.Entry<String, TextField>> insieme = distintaTextFields.entrySet(); 
		Iterator<Map.Entry<String, TextField>> iterator = insieme.iterator();
		
		while(iterator.hasNext()){
			
			Map.Entry<String, TextField> entry = iterator.next();
			Parent p = entry.getValue().getParent();
			
			Pane tps = (Pane) p;
            System.out.println(entry.toString());
			tps.getChildren().remove(entry.getValue());
			distintaLabels.get(entry.getKey()).setText(entry.getValue().getText());
			
			tps.getChildren().add(distintaLabels.get(entry.getKey()));
			
		}
		
		Parent datePickParent = datePicker.getParent();
		LocalDate ld = datePicker.getValue();
		
		Pane tps = (Pane) datePickParent;
		tps.getChildren().remove(datePicker);
		tps.getChildren().add(txt_data);

		Calendar cal = Calendar.getInstance();
		cal.set(ld.getYear(), ld.getMonthValue()-1, ld.getDayOfMonth()); //year is as expected, month is zero based, date is as expected
		Date dt = cal.getTime();
*/
        if(modificandoDistinta != true){
			refreshDistinta();
			return;
		}
        Distinta distinta = null;
        try {
            distinta = distintaDAO.getDistintaByORMID(currentDistintaId);
            new Editor().modificaDistinta(distinta,Parsers.italianDateStringToDate(txt_data.getText()), null, null,Integer.parseInt(txt_revisione.getText()),txt_elemstrutturale.getText());
        } catch (PersistentException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        setTextEdit(txt_revisione,false);
        setTextEdit(txt_data,false);
        setTextEdit(txt_elemstrutturale,false);

        //TODO:modifica distinta
		//distintaDAO.modificaDistintaByID(distinta.getID(), dt, distinta.getCommessa(), Parsers.getNumbers(txt_revisione.getText()), distinta.getModello(), txt_elemstrutturale.getText());
		//TODO:Modifica destinazione ordine
        //ordine.setDestinazione();
		//ordineDao.modificaDestinazione(ordine, txt_destinazione.getText());

        refreshDistinta();

		modificandoDistinta = false;
        modificaDistButton.setText("Modifica");
        modificaDistButton.setDisable(false);

		
	}
	
	private void refreshCommonDataDistinta() {


        try {
            distinta = distintaDAO.getDistintaByORMID(currentDistintaId);
            Commessa commessa = distinta.getCommessa();
            ordine = commessa.getOrdine();
        } catch (PersistentException e) {
            e.printStackTrace();
        }


			/*
		//TODO: modifica a getCommessaID(id)
		commesse = ordine.commesse.toArray();
				
		for (int i=0; i < commesse.length; i++) {
			log.i(commesse[i].getID()+" "+commesse[i].getDistinta());
		}
		
		distinta = commesse[0].getDistinta();
		*/
	}
	
	private void refreshDistinta() {
		
		refreshCommonDataDistinta();
		
		txt_modulo.setText("PROSSIME ITERAZIONI");
	    txt_revisione.setText(distinta.getRevisione()+"");
	    txt_data.setText(Parsers.printItalianDate(distinta.getDataInizio()));
	    txt_cliente.setText("PROSSIME ITERAZIONI");
	    txt_destinazione.setText(ordine.getDestinazione().getVia());
	    txt_elemstrutturale.setText(distinta.getElementoStrutturale());
	    txt_cartellino.setText("PROSSIME ITERAZIONI");
	    
	}
	
	private void refreshList() {

		if (listPezziDistinta.getSelectionModel().getSelectedIndex() != -1) {
			oldIndex = listPezziDistinta.getSelectionModel().getSelectedIndex();
		}
		
		refreshCommonDataDistinta();
		
		righeDistinta = distinta.righeDistinta.toArray();
		listaPezzi.removeAll();
		listaPezzi.clear();
		listaPezzi.addAll(righeDistinta);
		
		
		Parent listPezziDistintaParent = listPezziDistinta.getParent();
		
		Pane tps = (Pane) listPezziDistintaParent;
		tps.getChildren().remove(listPezziDistinta);
		
		listPezziDistinta.setItems(listaPezzi);
		
		tps.getChildren().add(listPezziDistinta);
		
		listPezziDistinta.getSelectionModel().select(oldIndex);
		
		aggiornaCampiRigaDistinta();
		
		//CellFactory
	    listPezziDistinta.setCellFactory(new Callback<ListView<RigaDistinta>, 
	            ListCell<RigaDistinta>>() {
	                public ListCell<RigaDistinta> call(ListView<RigaDistinta> list) {
	                    return new RigaDistCell();
	                }
	            }
	        );
	    
	    //Listener
	    listPezziDistinta.setOnMouseClicked(new EventHandler<MouseEvent>() {

	        public void handle(MouseEvent event) {

                if(oldIndex == -1)
                {
                    modificaPezzoButton.setDisable(false);
                    rimuoviPezzoButton.setDisable(false);
                }

	        	oldIndex=listPezziDistinta.getSelectionModel().getSelectedIndex();

	        	aggiornaCampiRigaDistinta();
	        }
	    });
		
	}

	protected void aggiornaCampiRigaDistinta() {
		if (listPezziDistinta.getSelectionModel().getSelectedItem()!=null) {
            System.out.println("clicked on " + listPezziDistinta.getSelectionModel().getSelectedItem());
            
            rigaSelezionata = listPezziDistinta.getSelectionModel().getSelectedItem();
            
            //Aggiorno campi
            txt_indicazione.setText(rigaSelezionata.getIndicazione());
            txt_codice_pezzo.setText(rigaSelezionata.getPezzo().getDescrizionePezzo().getNome());
            txt_fornitore.setText(rigaSelezionata.getPezzo().getDescrizionePezzo().getFornitore().getNome());
            txt_data_arrivo.setText(Parsers.printItalianDate(rigaSelezionata.getPezzo().getRigaRDA().getRda().getDataArrivoEffettiva()));
            txt_n_pezzi.setText(rigaSelezionata.getQuantitaRigaDistinta()+"");
            txt_diametro.setText(rigaSelezionata.getPezzo().getDescrizionePezzo().getDiametro()+"");
            txt_misura_taglio.setText(rigaSelezionata.getLavorazionePezzo().getMisuraDiTaglio()+"");
            txt_peso_originale.setText(rigaSelezionata.getPezzo().getDescrizionePezzo().getPeso()+"");
            txt_peso_lavorato.setText(rigaSelezionata.getLavorazionePezzo().getPeso()+"");
            txt_lavorazione.setText(rigaSelezionata.getLavorazionePezzo().getDescrizione());
            try {
                rigaSelezionata.getLavorazionePezzo().getSagoma().getImg();
                File file = new File(rigaSelezionata.getLavorazionePezzo().getSagoma().getImg());
                img_sagoma.setImage(new Image("file:///"+file.getCanonicalPath()));
            } catch (Exception e) {
                log.i("No image");
                //e.printStackTrace();
            }

            btn_modifica_sagoma.setDisable(false);
            btn_rimuovi_sagoma.setDisable(false);
    	}
	}


/**
 *  aggiungiPezzo
 */
	@FXML 
	protected void aggiungiPezzo() throws PersistentException {
		
		log.i("Aggiungi pezzo");

		Stage popupStage = new Stage();
		popupStage.initModality(Modality.APPLICATION_MODAL);
		
		Parent root = null;
		try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("fxml/aggiungi_pezzo.fxml"));

            //"com.coedil99.controller.ui.AggiungiPezzoController"
            AggiungiPezzoController controller = new AggiungiPezzoController();

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

		Pezzo pezzoSelezionato = (Pezzo) session.get("pezzo_selezionato");
        LavorazionePezzo lavorazionePezzo = (LavorazionePezzo) session.get("lavorazionePezzo_selezionato");
        String indicazione = (String) session.get("indicazione_rigaDistinta");

        if (pezzoSelezionato!=null && indicazione!=null) {

            RigaDistinta riga = rigaDistintaDAO.createRigaDistinta();
            riga.setPezzo(pezzoSelezionato);
            riga.setIndicazione(indicazione);
            riga.setLavorazionePezzo(lavorazionePezzo);
            riga.setDistinta(distinta);
            //riga.
            listaPezzi.add(riga);

            rigaDistintaDAO.save(riga);

            session.set("pezzo_selezionato",false);


        }
	}
	
	static class RigaDistCell extends ListCell<RigaDistinta> {
		@Override
		public void updateItem(RigaDistinta item, boolean empty) {
            super.updateItem(item, empty);
            if(item != null){
            	Label l = new Label(item.getIndicazione());
            	setGraphic(l);
            }
        }
    }

    /**
     *
     */
    @FXML
    public void onBtnAggiungiSagoma() {

        log.i("aggiunta_sagoma");

        final FileChooser fileChooser = new FileChooser();
        //fileChooser.setInitialDirectory(new File(".\\Coedil99\\blobs\\sagoma\\"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {

            File newfile = new File(".\\Coedil99\\src\\main\\resources\\blobs\\sagoma\\" + file.getName());

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

            int start = (newfile.getAbsolutePath().indexOf("Coedil99\\src\\main\\resources\\blobs\\sagoma\\"));

            int end = (newfile.getAbsolutePath().length());

            pathSagoma = (newfile.getAbsolutePath().substring(start, end));

            File file2 = new File(pathSagoma);
            try {
                System.out.println(file2.getCanonicalPath());
                img_sagoma.setImage(new Image("file:///" + file2.getCanonicalPath()));
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
            //Parent root =
            final FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File(".\\Coedil99\\src\\main\\resources\\blobs\\sagoma\\"));
            Stage stage = (Stage) img_sagoma.getScene().getWindow();
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                int start = (file.getAbsolutePath().indexOf("Coedil99\\src\\main\\resources\\blobs\\sagoma\\"));

                int end = (file.getAbsolutePath().length());

                pathSagoma = ( file.getAbsolutePath().substring(start,end) );

                File file2 = new File(pathSagoma);
                try {

                    img_sagoma.setImage(new Image("file:///"+file2.getCanonicalPath()));
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

            img_sagoma.setImage(null);
            pathSagoma="";


        }

        @FXML
        public void goBack()
        {
            MainApplication.getInstance().goBack();
        }




}
