package controller.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import modello_di_dominio.Commessa;
import modello_di_dominio.Distinta;
import modello_di_dominio.Ordine;
import modello_di_dominio.RigaDistinta;
import servizi.GestoreDistinta;
import servizi.GestoreOrdine;
import servizi.GestorePezzi;
import servizi.GestoreServizi;
import servizi.Log;
import servizi.impl.GestoreServiziPrototipo;

public class VisualizzaDistintaController implements Initializable {
	
    @FXML private ListView listPezziDistinta;
    @FXML private Label lbl_modulo;
    @FXML private Label lbl_revisione;
    @FXML private Label lbl_data;
    @FXML private Label lbl_cliente;
    @FXML private Label lbl_destinazione;
    @FXML private Label lbl_elemstrutturale;
    @FXML private Label lbl_cartellino;
    
    @FXML private Label lbl_n_pezzi;
    @FXML private Label lbl_diametro;
    @FXML private Label lbl_peso;
    @FXML private Label lbl_misura_taglio;
    @FXML private Label lbl_codice_pezzo;
    @FXML private Label lbl_fornitore;
    
    @FXML private Button modificaDistButton;
    @FXML private Button salvaDistButton;
    @FXML private Button modificaPezzoButton;
    @FXML private Button rimuoviPezzoButton;
    
    @FXML private TitledPane righe_distinta;
    @FXML private TitledPane informazioni_distinta;
    
    
    
    private Map<String,Label> distintaLabels;
    private Map<String,TextField> distintaTextFields;
    private Map<String,Object> rigaDistintaNodes;
    
    private GestoreDistinta gestoreDistinta;
    private Log log;
    
    private Boolean modificandoDistinta = false;

    final ObservableList<String> listaPezzi = FXCollections.observableArrayList();
    
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
		
		//Caricamento servizi
		GestoreServizi gsp = GestoreServiziPrototipo.getGestoreServizi();
		GestoreOrdine gestoreOrdine = (GestoreOrdine) gsp.getServizio("GestoreOrdineDAO");
		log = (Log) gsp.getServizio("LogStdout");
		GestorePezzi gestorePezzi = (GestorePezzi) gsp.getServizio("GestorePezziDAO");
		
		Ordine ordine = gestoreOrdine.getOrdine(1);
		
		log.i(ordine.getID()+"");
		
		
		//TODO: modifica a getCommessaID(id)
		Commessa[] commesse = ordine.commesse.toArray();
		
		for (int i=0; i < commesse.length; i++) {
			log.i(commesse[i].getID()+" "+commesse[i].getDistinta());
		}
		
		Distinta distinta = commesse[0].getDistinta();
		
		final RigaDistinta[] righeDistinta = distinta.righeDistinta.toArray();
		
		for (int i=0; righeDistinta.length>i; i++) {
			listaPezzi.add(righeDistinta[i].getIndicazione());
		}
		
		listPezziDistinta.setItems(listaPezzi);
		
	    lbl_modulo.setText("PROSSIMA ITERAZIONE");
	    lbl_revisione.setText("REV: "+distinta.getRevisione());
	    lbl_data.setText(distinta.getDataInizio().toGMTString());
	    lbl_cliente.setText("PROSSIMA ITERAZIONE");
	    lbl_destinazione.setText(ordine.getDestinazione().getVia());
	    lbl_elemstrutturale.setText(distinta.getElementoStrutturale());
	    lbl_cartellino.setText("PROSSIMA ITERAZIONE");
	    
	    //distinta labels
	    
	    distintaLabels = new HashMap<String,Label>();
	    distintaLabels.put("modulo",lbl_modulo);
	    distintaLabels.put("revisione",lbl_revisione);
	    distintaLabels.put("data",lbl_data);
	    distintaLabels.put("cliente",lbl_cliente);
	    distintaLabels.put("destinazione",lbl_destinazione);
	    distintaLabels.put("elemstrutturale",lbl_elemstrutturale);
	    distintaLabels.put("cartellino",lbl_cartellino);
	    
	    //rigaDistinta nodes
	    
	    rigaDistintaNodes = new HashMap<String,Object>();
	    rigaDistintaNodes.put("n_pezzi", lbl_n_pezzi);
	    rigaDistintaNodes.put("diametro", lbl_diametro);
	    rigaDistintaNodes.put("peso", lbl_peso);
	    rigaDistintaNodes.put("misura_taglio", lbl_misura_taglio);
	    rigaDistintaNodes.put("fornitore", lbl_n_pezzi);
		
	    listPezziDistinta.setOnMouseClicked(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {
	        	
	        	
	        	
	        	if (listPezziDistinta.getSelectionModel().getSelectedItem()!=null) {
		            System.out.println("clicked on " + listPezziDistinta.getSelectionModel().getSelectedItem());
		            
		            int selected = (int) listPezziDistinta.getSelectionModel().getSelectedIndices().get(0);
		            
		            //Aggiorno campi
		            lbl_codice_pezzo.setText(righeDistinta[selected].getPezzo().getDescrizionePezzo().getNome());
		            lbl_fornitore.setText(righeDistinta[selected].getPezzo().getDescrizionePezzo().getFornitore());
		            lbl_n_pezzi.setText(righeDistinta[selected].getPezzo().getQuantita()+"");
		            lbl_diametro.setText(righeDistinta[selected].getPezzo().getDescrizionePezzo().getDiametro()+"");
		            lbl_misura_taglio.setText("PROSSIMA ITERAZIONE");
		            lbl_peso.setText("PROSSIMA ITERAZIONE");
		            
		            printSelectedItem(listPezziDistinta);
	        	}
	        	
	        }
	    });
		
		
		
		
	}
/**
 * modificaDatiDistinta
 */
	@FXML
	protected void modificaDatiDistinta(){
		
		log.i("Modifica dei dati della distinta");
		
		//Check
		if(modificandoDistinta != false){
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
		
		//Flag
		modificandoDistinta = true;
		//Disabilito le modifiche
		modificaDistButton.setDisable(true);
		//Abilito il salvataggio
		salvaDistButton.setDisable(false);
	}
/**
 * 
 */
	@FXML
	protected void modificaRigaDistinta(){
		
		log.i("Modifica della riga distinta");
		
	}
	
	@FXML 
	protected void salvaDatiDistinta(){
		
		log.i("Salvataggio dati distinta");
		
		
		if(modificandoDistinta != true){
			return;
		}
		
		Set<Map.Entry<String, TextField>> insieme = distintaTextFields.entrySet(); 
		Iterator<Map.Entry<String, TextField>> iterator = insieme.iterator();
		
		while(iterator.hasNext()){
			
			Map.Entry<String, TextField> entry = iterator.next();
			Parent p = entry.getValue().getParent();
			
			Pane tps = (Pane) p;
			tps.getChildren().remove(entry.getValue());
			distintaLabels.get(entry.getKey()).setText(entry.getValue().getText());
			
			
			tps.getChildren().add(distintaLabels.get(entry.getKey()));
			
			
		}
		
		modificandoDistinta = false;
		modificaDistButton.setDisable(false);
		salvaDistButton.setDisable(true);
		
		
	}
/**
 *  aggiungiPezzo
 */
	@FXML 
	protected void aggiungiPezzo(){
		
		log.i("Aggiungi pezzo");


		final Popup popup = new Popup();
		popup.setAutoFix(false);
		popup.setHideOnEscape(true);
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../../ui/fxml/aggiungi_pezzo.fxml"));
			popup.getContent().addAll(root);
			popup.show(((Node) distintaLabels.values().toArray()[0]).getScene().getWindow());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    

}