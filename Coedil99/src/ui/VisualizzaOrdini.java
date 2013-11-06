package ui;

import java.util.Date;
import java.util.Iterator;

import modello_di_dominio.Ordine;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class VisualizzaOrdini extends Application{

    public static void start(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Parent root =  FXMLLoader.load(getClass().getResource("visualizza_ordini.fxml"));
		Scene scene = new Scene(root, 640, 480);
		
		stage.setTitle("FXML Welcome");
		stage.setScene(scene);
		stage.show();
		
	}

}
