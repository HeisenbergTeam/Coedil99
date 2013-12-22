package controller.ui;

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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;
import modello_di_dominio.Pezzo;
import servizi.GestorePezzi;
import servizi.GestoreServizi;
import servizi.Log;
import servizi.Sessione;

public class AggiungiPezzoController implements Initializable {
/**
 * 
 */
	@FXML private ListView<Pezzo> listPezzi;
	@FXML private TextField cercaPezzo;
	@FXML private Button aggiungiPezzo;
	
	private Log log;
	private Sessione sessione;
/**
 * 
 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		aggiungiPezzo.setDisable(true);
		
		GestorePezzi gestorePezzi = (GestorePezzi) GestoreServizi.getGestoreServizi().getServizio("GestorePezziDAO");
		log = (Log) GestoreServizi.getGestoreServizi().getServizio("LogStdout");
		sessione = (Sessione) GestoreServizi.getGestoreServizi().getServizio("SessionePrototipo");
		
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
	public void onAggiungiPezzo(){
		
		log.i("pezzo aggiunto");
		
		//Pezzo scelto
		Pezzo scelto = listPezzi.getSelectionModel().getSelectedItem();
		sessione.set("pezzo_aggiunto",scelto);
		
		//Chiudo la finestra
		((Stage) cercaPezzo.getScene().getWindow()).close();
		
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
            	setText("Pezzo");
            }
        }
    }

}
