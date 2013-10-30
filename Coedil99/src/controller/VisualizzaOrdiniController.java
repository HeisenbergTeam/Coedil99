package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.orm.PersistentException;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Ordine;

public class VisualizzaOrdiniController implements Initializable{
	
	
	@FXML private TableView<Ordine> tableOrdini;
	@FXML private TableColumn<Ordine,Boolean> tableOrdiniId;
	@FXML private TableColumn<Ordine,String> tableOrdiniData;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		 tableOrdiniId.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ordine,Boolean>, ObservableValue<Boolean>>() {
			
			@Override
			public ObservableValue<Boolean> call(CellDataFeatures<Ordine, Boolean> arg0) {
				// TODO Auto-generated method stub
				SimpleBooleanProperty bool = new SimpleBooleanProperty();
				bool.set(true);
				return bool;
			}
		});
		 
		 tableOrdiniData.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ordine,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(
					CellDataFeatures<Ordine, String> arg0) {
				// TODO Auto-generated method stub
				SimpleStringProperty s = new SimpleStringProperty();
				s.set("ciao");
				return s;
			}
		});
		 
		ArrayList<Ordine> ordini = new ArrayList<Ordine>();
		try {
			Ordine o = DAOFactory.getDAOFactory().getOrdineDAO().getOrdineByORMID(1);
			ordini.add(o);
			ordini.add(o);
			ordini.add(o);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableOrdini.setItems(FXCollections.observableList(ordini));
		
		tableOrdini.getSelectionModel().selectFirst();
	}
	
	
}
