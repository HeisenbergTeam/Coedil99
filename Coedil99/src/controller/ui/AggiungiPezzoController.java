package controller.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import modello_di_dominio.Pezzo;
import servizi.GestorePezzi;
import servizi.GestoreServizi;

public class AggiungiPezzoController implements Initializable {

	@FXML private ListView listPezzi;
	@FXML private TextField cercaPezzo;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		GestorePezzi gestorePezzi = (GestorePezzi) GestoreServizi.getGestoreServizi().getServizio("GestorePezziDAO");
		
		List<Pezzo> pezzi = gestorePezzi.getPezzi();
		ObservableList<Pezzo> obsPezzi = FXCollections.observableArrayList(pezzi);
		
		listPezzi.setItems(obsPezzi);
		
		
	}

}
