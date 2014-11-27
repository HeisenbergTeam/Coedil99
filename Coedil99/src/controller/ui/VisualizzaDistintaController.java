package controller.ui;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import modello_di_dominio.Commessa;
import modello_di_dominio.Distinta;
import modello_di_dominio.LavorazionePezzo;
import modello_di_dominio.Ordine;
import modello_di_dominio.Pezzo;
import modello_di_dominio.RigaDistinta;
import servizi.GestoreCommessa;
import servizi.GestoreDistinta;
import servizi.GestoreOrdine;
import servizi.GestorePezzi;
import servizi.GestoreRigaDistinta;
import servizi.GestoreServizi;
import servizi.Log;
import servizi.Sessione;
import servizi.impl.GestoreServiziPrototipo;

public class VisualizzaDistintaController implements Initializable {
	
    @FXML private ListView<RigaDistinta> listPezziDistinta;
    @FXML private Label lbl_modulo;
    @FXML private Label lbl_revisione;
    @FXML private Label lbl_data;
    @FXML private Label lbl_cliente;
    @FXML private Label lbl_destinazione;
    @FXML private Label lbl_elemstrutturale;
    @FXML private Label lbl_cartellino;
    
    @FXML private Label lbl_indicazione;
    @FXML private Label lbl_n_pezzi;
    @FXML private Label lbl_n_pezzi_magazzino;
    @FXML private Label lbl_data_arrivo;
    @FXML private Label lbl_diametro;
    @FXML private Label lbl_peso_originale;
    @FXML private Label lbl_peso_lavorato;
    @FXML private Label lbl_lavorazione;
    @FXML private Label lbl_misura_taglio;
    @FXML private Label lbl_codice_pezzo;
    @FXML private Label lbl_fornitore;

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

    private Map<String,Label> distintaLabels;
    private Map<String,TextField> distintaTextFields;
    private Map<String,Object> rigaDistintaNodes;
    private Map<String,Object> rigaDistintaTextFields;
    
    private RigaDistinta rigaSelezionata;
    
    private GestoreDistinta gestoreDistinta;
    private GestoreRigaDistinta gestoreRigaDistinta;
    private GestoreOrdine gestoreOrdine;
    private GestoreCommessa gestoreCommessa;
    private GestorePezzi gestorePezzi;
    private Log log;
    private Sessione session;
    
    Ordine ordine;
    Commessa[] commesse;
    Distinta distinta;
    RigaDistinta[] righeDistinta;
    
    private Boolean modificandoDistinta = false;
    private Boolean modificandoRigaDistinta = false;

    private int oldIndex = -1;
    
    final ObservableList<RigaDistinta> listaPezzi = FXCollections.observableArrayList();
    
    public void printSelectedItem(ListView listView) {
        ObservableList<Integer> list = listView.getSelectionModel().getSelectedIndices();
        System.out.println("The selectedIndices property contains: " + list.size() + " element(s):");
        for(int i=0; i<list.size(); i++) { System.out.println(i + ")" + list.get(i)); }
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		salvaDistButton.setDisable(true);
		modificaPezzoButton.setDisable(true);
		rimuoviPezzoButton.setDisable(true);
        btn_aggiungi_sagoma.setDisable(true);
        btn_modifica_sagoma.setDisable(true);
        btn_rimuovi_sagoma.setDisable(true);

		//Caricamento servizi
		GestoreServizi gsp = GestoreServiziPrototipo.getGestoreServizi();
		gestoreOrdine = (GestoreOrdine) gsp.getServizio("GestoreOrdineDAO");
		gestoreCommessa = (GestoreCommessa) gsp.getServizio("GestoreCommessaDAO");
		gestoreDistinta = (GestoreDistinta) gsp.getServizio("GestoreDistintaDAO");
		gestoreRigaDistinta = (GestoreRigaDistinta) gsp.getServizio("GestoreRigaDistintaDAO");
		gestorePezzi = (GestorePezzi) gsp.getServizio("GestorePezziDAO");
		log = (Log) gsp.getServizio("LogStdout");
		session = (Sessione) gsp.getServizio("SessionePrototipo");
		
		refreshList();
		
		refreshDistinta();
	    
	    //distinta labels
	    
	    distintaLabels = new HashMap<String,Label>();
	    //distintaLabels.put("modulo",lbl_modulo);
	    distintaLabels.put("revisione",lbl_revisione);
	    //distintaLabels.put("data",lbl_data);
	    //distintaLabels.put("cliente",lbl_cliente);
	    distintaLabels.put("destinazione",lbl_destinazione);
	    distintaLabels.put("elemstrutturale",lbl_elemstrutturale);
	    //distintaLabels.put("cartellino",lbl_cartellino);
	    
	    //rigaDistinta nodes
	    
	    rigaDistintaNodes = new HashMap<String,Object>();
	    rigaDistintaNodes.put("codice", lbl_codice_pezzo);
	    rigaDistintaNodes.put("n_pezzi", lbl_n_pezzi);
	    rigaDistintaNodes.put("diametro", lbl_diametro);
	    rigaDistintaNodes.put("peso", lbl_peso_originale);
	    rigaDistintaNodes.put("peso_lavorato", lbl_peso_lavorato);
	    rigaDistintaNodes.put("lavorazione", lbl_lavorazione);
	    rigaDistintaNodes.put("misura_taglio", lbl_misura_taglio);
	    rigaDistintaNodes.put("fornitore", lbl_fornitore);
	    rigaDistintaNodes.put("indicazione", lbl_indicazione);
	    
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
			salvaDatiDistinta();
			return;
		}
		
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

		String current_date = lbl_data.getText();
		Parent datePickParent = lbl_data.getParent();
		
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
		tps.getChildren().remove(lbl_data);
		tps.getChildren().add(datePicker);
        datePicker.setMaxWidth(Double.MAX_VALUE);

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

            String current_date = lbl_data_arrivo.getText();
            Parent datePickParent = lbl_data_arrivo.getParent();

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
            tps.getChildren().remove(lbl_data_arrivo);
            tps.getChildren().add(dateConsegnaPicker);
            dateConsegnaPicker.setMaxWidth(Double.MAX_VALUE);

            aggiungiPezzoButton.setDisable(true);
			modificaPezzoButton.setText("Annulla");
			rimuoviPezzoButton.setText("Salva");
            listPezziDistinta.setDisable(true);
            btn_aggiungi_sagoma.setDisable(false);
            btn_modifica_sagoma.setDisable(false);
            btn_rimuovi_sagoma.setDisable(false);


			modificandoRigaDistinta = true;
			
		}else{
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
            tps.getChildren().add(lbl_data_arrivo);

            Calendar cal = Calendar.getInstance();
            cal.set(ld.getYear(), ld.getMonthValue()-1, ld.getDayOfMonth()); //year is as expected, month is zero based, date is as expected
            Date dt = cal.getTime();

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
            gestoreRigaDistinta.cancellaRigaDistinta(riga);
        } else {

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
            tps.getChildren().add(lbl_data_arrivo);

            Calendar cal = Calendar.getInstance();
            cal.set(ld.getYear(), ld.getMonthValue()-1, ld.getDayOfMonth()); //year is as expected, month is zero based, date is as expected
            Date dt = cal.getTime();

            gestoreRigaDistinta.modificaLavorazionePezzoByRigaDistinta(rigaSelezionata, lbl_lavorazione.getText(), utilita.Parsers.getFloat(lbl_misura_taglio.getText()), utilita.Parsers.getFloat(lbl_peso_lavorato.getText()), rigaSelezionata.getLavorazionePezzo().getSagoma());
            gestoreRigaDistinta.modificaRigaDistintaBYID(rigaSelezionata.getID(), rigaSelezionata.getPezzo(), distinta, rigaSelezionata.getLavorazionePezzo(), lbl_indicazione.getText());
            gestoreRigaDistinta.modificaSagomaByRigaDistinta(rigaSelezionata,pathSagoma);
            gestorePezzi.modificaDescrizionePezzo(rigaSelezionata.getPezzo().getDescrizionePezzo(),lbl_codice_pezzo.getText(),utilita.Parsers.getFloat(lbl_peso_originale.getText()),utilita.Parsers.getFloat(lbl_diametro.getText()),lbl_fornitore.getText());
            gestorePezzi.modificaPezzo(rigaSelezionata.getPezzo(),rigaSelezionata.getPezzo().getDescrizionePezzo(),dt,Integer.parseInt(lbl_n_pezzi.getText()));

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

        listPezziDistinta.getSelectionModel().getSelectedItem();
						
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
		tps.getChildren().add(lbl_data);

		Calendar cal = Calendar.getInstance();
		cal.set(ld.getYear(), ld.getMonthValue()-1, ld.getDayOfMonth()); //year is as expected, month is zero based, date is as expected
		Date dt = cal.getTime();

        if(modificandoDistinta != true){
			refreshDistinta();
			return;
		}
		
		gestoreDistinta.modificaDistintaByID(distinta.getID(), dt, distinta.getCommessa(), utilita.Parsers.getNumbers(lbl_revisione.getText()), distinta.getModello(), lbl_elemstrutturale.getText());
		gestoreOrdine.modificaDestinazione(ordine, lbl_destinazione.getText());

        refreshDistinta();

		modificandoDistinta = false;
        modificaDistButton.setText("Modifica");
        modificaDistButton.setDisable(false);

		
	}
	
	private void refreshCommonDataDistinta() {
		
		ordine = gestoreOrdine.getOrdine(1);
		
		log.i(String.valueOf(ordine.getID()));
			
		//TODO: modifica a getCommessaID(id)
		commesse = ordine.commesse.toArray();
				
		for (int i=0; i < commesse.length; i++) {
			log.i(commesse[i].getID()+" "+commesse[i].getDistinta());
		}
		
		distinta = commesse[0].getDistinta();
		
	}
	
	private void refreshDistinta() {
		
		refreshCommonDataDistinta();
		
		lbl_modulo.setText("PROSSIME ITERAZIONI");
	    lbl_revisione.setText(distinta.getRevisione()+"");
	    lbl_data.setText(utilita.Parsers.printItalianDate(distinta.getDataInizio()));
	    lbl_cliente.setText("PROSSIME ITERAZIONI");
	    lbl_destinazione.setText(ordine.getDestinazione().getVia());
	    lbl_elemstrutturale.setText(distinta.getElementoStrutturale());
	    lbl_cartellino.setText("PROSSIME ITERAZIONI");
	    
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
	                @Override 
	                public ListCell<RigaDistinta> call(ListView<RigaDistinta> list) {
	                    return new RigaDistCell();
	                }
	            }
	        );
	    
	    //Listener
	    listPezziDistinta.setOnMouseClicked(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {
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
            lbl_indicazione.setText(rigaSelezionata.getIndicazione());
            lbl_codice_pezzo.setText(rigaSelezionata.getPezzo().getDescrizionePezzo().getNome());
            lbl_fornitore.setText(rigaSelezionata.getPezzo().getDescrizionePezzo().getFornitore());
            lbl_data_arrivo.setText(utilita.Parsers.printItalianDate(rigaSelezionata.getPezzo().getDataArrivo()));
            lbl_n_pezzi.setText(rigaSelezionata.getPezzo().getQuantita()+"");
            lbl_diametro.setText(rigaSelezionata.getPezzo().getDescrizionePezzo().getDiametro()+"");
            lbl_misura_taglio.setText(rigaSelezionata.getLavorazionePezzo().getMisuraDiTaglio()+"");
            lbl_peso_originale.setText(rigaSelezionata.getPezzo().getDescrizionePezzo().getPeso()+"");
            lbl_peso_lavorato.setText(rigaSelezionata.getLavorazionePezzo().getPeso()+"");
            lbl_lavorazione.setText(rigaSelezionata.getLavorazionePezzo().getDescrizione());
            try {
                rigaSelezionata.getLavorazionePezzo().getSagoma().getImg();
                File file = new File(rigaSelezionata.getLavorazionePezzo().getSagoma().getImg());
                img_sagoma.setImage(new Image("file:///"+file.getCanonicalPath()));
            } catch (Exception e) {
                System.out.println("no image");
                //e.printStackTrace();
            }

            modificaPezzoButton.setDisable(false);
            rimuoviPezzoButton.setDisable(false);
            
            printSelectedItem(listPezziDistinta);
    	}
	}


/**
 *  aggiungiPezzo
 */
	@FXML 
	protected void aggiungiPezzo(){
		
		log.i("Aggiungi pezzo");
		
		
		Stage popupStage = new Stage();
		popupStage.initModality(Modality.APPLICATION_MODAL);
		
		//popupStage.setScene(new Scene(new Group(new Text(10,10, "my second window"))));
		
		
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("../../ui/fxml/aggiungi_pezzo.fxml"));
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
        if (pezzoSelezionato!=null && pezzoSelezionato!=null && indicazione!=null) {
            RigaDistinta riga = gestoreRigaDistinta.creaRigaDistinta(pezzoSelezionato, distinta, lavorazionePezzo, indicazione);
            listaPezzi.add(riga);
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

            File newfile = new File(".\\Coedil99\\blobs\\sagoma\\" + file.getName());

            //try {
            //    Files.copy(file.toPath(), newfile.toPath());
            //} catch (IOException e) {
            //    e.printStackTrace();
            //}
            try {
                utilita.FilesOp.copyFileUsingStream(file, newfile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //FileUtils.copyFile(source, dest);

            int start = (newfile.getAbsolutePath().indexOf("Coedil99\\blobs\\sagoma\\"));

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

            final FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File(".\\Coedil99\\blobs\\sagoma\\"));
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                int start = (file.getAbsolutePath().indexOf("Coedil99\\blobs\\sagoma\\"));

                int end = (file.getAbsolutePath().length());

                pathSagoma = ( file.getAbsolutePath().substring(start,end) );

                File file2 = new File(pathSagoma);
                try {
                    System.out.println(file2.getCanonicalPath());
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






}
