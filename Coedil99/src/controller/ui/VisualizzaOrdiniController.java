package controller.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPaneBuilder;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import modello_di_dominio.Commessa;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Ordine;

import org.orm.PersistentException;

import servizi.GestoreServizi;
import servizi.Log;
import servizi.impl.GestoreOrdineDAO;
import servizi.impl.GestoreServiziPrototipo;
import ui.MainApplication;
import edu.emory.mathcs.backport.java.util.Arrays;

public class VisualizzaOrdiniController implements Initializable{
	
	
	@FXML private TableView<Ordine> tableOrdini;
	@FXML private TableColumn<Ordine,String> tableOrdiniId;
	@FXML private TableColumn<Ordine,String> tableOrdiniData;
	
	@FXML private TabPane commesseTabPane;
	
	protected Log log;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		GestoreServizi gsp = GestoreServiziPrototipo.getGestoreServizi();
		GestoreOrdineDAO gestoreOrdineDAO = (GestoreOrdineDAO) gsp.getServizio("GestoreOrdineDAO");
		log = (Log) gsp.getServizio("LogStdout");
		
		/**************************************************
		 *            TABELLA ORDINI
		 *************************************************/
		ArrayList<Ordine> ordini = new ArrayList<Ordine>(gestoreOrdineDAO.getOrdini());
		
		this.loadOrdiniTable(ordini);
		
		//ListenerOrdini
		
		tableOrdini.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> arg0,
					Object arg1, Object arg2) {
				
				Ordine ao;
				try {
					ao = DAOFactory.getDAOFactory().getOrdineDAO().getOrdineByORMID(1);
					//VisualizzaOrdiniController.this.loadCommessaTable(Arrays.asList(ao.commesse.toArray()));
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				
				
			}
		});
		
		//Listener commesse
		/*
		tableCommesse.setOnMouseClicked((new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent mouseEvent) {
		        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
		            if(mouseEvent.getClickCount() == 2){
		                System.out.println("Double clicked");
		            }
		        }
				
			}
		}));
		*/
	}
	
	protected void initOrdinitTable(){
		
	}
	
	/**
	 * 
	 * @param ordini
	 */
	protected void loadOrdiniTable(List<Ordine> ordini){
		
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
				
				if(arg0.getValue() == null){
					s.set("ciao");
				}else{
					s.set(arg0.getValue().getDataCreazione().toString());
				}
				return s;
			}
		});
		
		ObservableList<Ordine> list = FXCollections.observableList(ordini);
		tableOrdini.setItems(list);
		
	}
/**
 *  goBack Action
 */
	@FXML protected void goBack(){
		MainApplication.getInstance().goBack();
	}
	
	@FXML protected void onNewCommessa(){
		log.i("nuova commessa");
		
		TabPaneBuilder<TabPaneBuilder<B>>.create()
		
	}
	
	@FXML protected void onEditCommessa(){
		log.i("modifica commessa");
		
		
	}
	
	@FXML protected void onDeleteCommessa(){
		log.i("delete commessa");
		
		
	}
}
