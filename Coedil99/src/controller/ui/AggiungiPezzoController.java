package controller.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;
import modello_di_dominio.Pezzo;
import servizi.GestorePezzi;
import servizi.GestoreServizi;
import servizi.Log;

public class AggiungiPezzoController implements Initializable {

	@FXML private ListView listPezzi;
	@FXML private TextField cercaPezzo;
	
	private Log log;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		GestorePezzi gestorePezzi = (GestorePezzi) GestoreServizi.getGestoreServizi().getServizio("GestorePezziDAO");
		
		List<Pezzo> pezzi = gestorePezzi.getPezzi();
		ObservableList<Pezzo> obsPezzi = FXCollections.observableArrayList(pezzi);
		
		
		
		listPezzi.setItems(obsPezzi);
		
		 listPezzi.setCellFactory(new Callback<ListView<Pezzo>, 
		            ListCell<Pezzo>>() {
		                @Override 
		                public ListCell<Pezzo> call(ListView<Pezzo> list) {
		                    return new ColorRectCell();
		                }
		            }
		        );
		
		
		
	}
	
	@FXML
	public void onAggiungiPezzo(){
		
		log.i("pezzo aggiunto");
		
	}
	
	static class ColorRectCell extends ListCell<Pezzo> {
        @Override
        public void updateItem(Pezzo item, boolean empty) {
            super.updateItem(item, empty);
            Rectangle rect = new Rectangle(100, 20);
            if (item != null) {
                rect.setFill(Color.web("000"));
                setGraphic(rect);
            }
        }
    }

}
