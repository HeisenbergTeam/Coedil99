package controller.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
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
    
    @FXML private TitledPane righe_distinta;
    @FXML private TitledPane informazioni_distinta;
    
    private ArrayList<Label> distintaLabels;
    private ArrayList<TextField> distintaTextFields;
    private ArrayList<Node> rigaDistintaNodes;
    private Log log;

    final ObservableList<String> listaPezzi = FXCollections.observableArrayList();
    
    public void printSelectedItem(ListView listView) {
        ObservableList<Integer> list = listView.getSelectionModel().getSelectedIndices();
        System.out.println("The selectedIndices property contains: " + list.size() + " element(s):");
        for(int i=0; i<list.size(); i++) { System.out.println(i + ")" + list.get(i)); }
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
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
	    
	    //lbl_modulo
	    
	    distintaLabels = new ArrayList<Label>();
	    distintaLabels.add(lbl_modulo);
	    distintaLabels.add(lbl_revisione);
	    distintaLabels.add(lbl_data);
	    distintaLabels.add(lbl_cliente);
	    distintaLabels.add(lbl_destinazione);
	    distintaLabels.add(lbl_elemstrutturale);
	    distintaLabels.add(lbl_cartellino);
	    
	    for(final Label l : distintaLabels){
	    	
	    	l.setOnMouseClicked(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
					//Se non e' un doppio click esco
					if(arg0.getClickCount() != 2){
						return;
					}
					
					Parent p = l.getParent();
					TextField tf = new TextField();
					tf.setText(l.getText());
					Pane tps = (Pane) p;
					tps.getChildren().remove(l);
					tps.getChildren().add(tf);
					//log.i(p.getClass().toString());
					
				}
	    		
	    	
	    });
		
	    listPezziDistinta.setOnMouseClicked(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {
	        	
	        	//listPezziDistinta.g
	        	
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
	}
	
	@FXML
	protected void modificaDatiDistinta(){
		
		log.i("Modifica dei dati della distinta");
		
		for(Label l : distintaLabels){
			
			Parent p = l.getParent();
			TextField tf = new TextField();
			tf.setText(l.getText());
			Pane tps = (Pane) p;
			tps.getChildren().remove(l);
			tps.getChildren().add(tf);
		}
	}
	    
	@FXML
	protected void modificaRigaDistinta(){
		
		log.i("Modifica della riga distinta");
		
	}
	
	@FXML 
	protected void salvaDatiDistinta(){
		
	}
	
	@FXML 
	protected void aggiungiPezzo(){
		
		log.i("Aggiungi pezzo");


		final Popup popup = new Popup();
		popup.setAutoFix(false);
		popup.setHideOnEscape(true);
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../../ui/fxml/aggiungi_pezzo.fxml"));
			popup.getContent().addAll(root);
			popup.show(distintaLabels.get(0).getScene().getWindow());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
	/*
	protected List<Node> searchNodes(Parent parent,Class instance){
		
		if(parent instanceof TitledPane){
			TitledPane titledPane = (TitledPane) parent;
			Node content = titledPane.getContent();
			
			if(content instanceof Parent){
				return searchNodes(content,selector);
			}
			
		}else{
			
			
			
		}
		
		
		return null;
		
		
	}
    */

}