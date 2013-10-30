package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import modello_di_dominio.Commessa;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Commessa;
import modello_di_dominio.Ordine;

import org.orm.PersistentException;

public class VisualizzaOrdiniController implements Initializable{
	
	
	@FXML private TableView<Ordine> tableOrdini;
	@FXML private TableColumn<Ordine,String> tableOrdiniId;
	@FXML private TableColumn<Ordine,String> tableOrdiniData;
	
	@FXML private TableView<Commessa> tableCommesse;
	@FXML private TableColumn<Commessa,String> tableCommesseId;
	@FXML private TableColumn<Commessa,String> tableCommesseStato;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		/**************************************************
		 *            TABELLA ORDINI
		 *************************************************/
		
		
		// TODO Auto-generated method stub
		 tableOrdiniId.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ordine,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Ordine, String> arg0) {
				// TODO Auto-generated method stub
				SimpleStringProperty s = new SimpleStringProperty();
				s.set(((Integer)arg0.getValue().getID()).toString());
				return s;
			}
		});
		 
		 tableOrdiniData.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ordine,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(
					CellDataFeatures<Ordine, String> arg0) {
				// TODO Auto-generated method stub
				SimpleStringProperty s = new SimpleStringProperty();
				//s.set(arg0.getValue().getDataCreazione().toString());
				
				//s.set(arg0.getValue().getClass().toString());
				if(arg0.getValue() == null){
					System.out.println("null");
					s.set("ciao");
				}else{
					s.set(arg0.getValue().getDataCreazione().toString());
				}
				return s;
			}
		});
		 
		ArrayList<Ordine> ordini = new ArrayList<Ordine>();
		Ordine ao = new Ordine();
		try {
			Ordine o = DAOFactory.getDAOFactory().getOrdineDAO().getOrdineByORMID(1);
			ordini.add(o);
			ordini.add(o);
			ordini.add(o);
			ao = o;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableOrdini.setItems(FXCollections.observableList(ordini));
		
		tableOrdini.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> arg0,
					Object arg1, Object arg2) {
				// TODO Auto-generated method stub
				System.out.println(arg1);
				
			}
		});
		
		/**************************************************
		 *            TABELLA DISTINTE
		 *************************************************/
		
		tableCommesseId.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Commessa,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(
					CellDataFeatures<Commessa, String> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		tableCommesseStato.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Commessa,String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(
							CellDataFeatures<Commessa, String> arg0) {
						// TODO Auto-generated method stub
						return null;
					}
		});;
		
		ArrayList<Commessa> commesse = new ArrayList<Commessa>();
		Commessa[] comm = ao.getCommesse().toArray();
		
		for(Commessa c : comm){
			commesse.add(c);
		}
		
		tableCommesse.setItems(FXCollections.observableList(commesse));
		
	}
	
	protected void loadCommessaTable(List<Commessa> distinte){
		
		
		
		
		
	}
	
	
}
