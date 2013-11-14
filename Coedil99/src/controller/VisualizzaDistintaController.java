package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.persistence.metamodel.ListAttribute;

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
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class VisualizzaDistintaController implements Initializable {
    @FXML private ListView<String> listPezziDistinta;

    final ObservableList<String> listaPezzi = FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		GestoreServizi gsp = GestoreServiziPrototipo.getGestoreServizi();
		GestoreOrdine gestoreOrdine = (GestoreOrdine) gsp.getServizio("GestoreOrdineDAO");
		
		Ordine ordine = gestoreOrdine.getOrdine(1);
		
		//TODO: modifica a getCommessaID(id)
		RigaDistinta[] righeDistinta = ordine.commesse.toArray()[0].getDistinta().righeDistinta.toArray();
		
		for (int i=0; righeDistinta.length>i; i++) {
			listaPezzi.add(righeDistinta[i].getID()+"");
		}
		
		listPezziDistinta.setItems(listaPezzi);
		
		
	}
    
    
    

}