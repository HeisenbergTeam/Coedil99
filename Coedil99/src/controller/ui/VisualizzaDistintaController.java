package controller.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.persistence.metamodel.ListAttribute;

import modello_di_dominio.Commessa;
import modello_di_dominio.Distinta;
import modello_di_dominio.Ordine;
import modello_di_dominio.RigaDistinta;
import servizi.GestoreOrdine;
import servizi.GestoreServizi;
import servizi.impl.GestoreOrdineDAO;
import servizi.impl.GestoreServiziPrototipo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class VisualizzaDistintaController implements Initializable {
    @FXML private ListView<String> listPezziDistinta;
    @FXML private Label lbl_modulo;
    @FXML private Label lbl_revisione;
    @FXML private Label lbl_data;
    @FXML private Label lbl_cliente;
    @FXML private Label lbl_destinazione;
    @FXML private Label lbl_elemstrutturale;
    @FXML private Label lbl_cartellino;

    final ObservableList<String> listaPezzi = FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		GestoreServizi gsp = GestoreServiziPrototipo.getGestoreServizi();
		GestoreOrdine gestoreOrdine = (GestoreOrdine) gsp.getServizio("GestoreOrdineDAO");
		
		Ordine ordine = gestoreOrdine.getOrdine(1);
		
		System.out.println(ordine.getID()+"");
		
		//TODO: modifica a getCommessaID(id)
		Commessa[] commesse = ordine.commesse.toArray();
		
		for (int i=0; i < commesse.length; i++) {
			System.out.println(commesse[i].getID()+" "+commesse[i].getDistinta());
		}
		
		Distinta distinta = commesse[0].getDistinta();
		
		RigaDistinta[] righeDistinta = distinta.righeDistinta.toArray();
		
		for (int i=0; righeDistinta.length>i; i++) {
			listaPezzi.add(righeDistinta[i].getID()+"");
		}
		
		listPezziDistinta.setItems(listaPezzi);
		
	    lbl_modulo.setText("PROSSIMA ITERAZIONE");
	    lbl_revisione.setText("REV: "+distinta.getRevisione());
	    lbl_data.setText(distinta.getDataInizio().toGMTString());
	    lbl_cliente.setText("PROSSIMA ITERAZIONE");
	    lbl_destinazione.setText(ordine.getDestinazione().getVia());
	    lbl_elemstrutturale.setText(distinta.getElementoStrutturale());
	    lbl_cartellino.setText("PROSSIMA ITERAZIONE");
		
		
		
		
		
	}
    
    
    

}