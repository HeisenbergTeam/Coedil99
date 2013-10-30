package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class VisualizzaOrdini extends Application{

    public static void start(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Parent root =  FXMLLoader.load(getClass().getResource("visualizza_ordini.fxml"));
		TableView table = (TableView) root.lookup("tabella_ordini");
		//table.setItems();
		
		
		Scene scene = new Scene(root, 640, 480);
		
		stage.setTitle("FXML Welcome");
		stage.setScene(scene);
		stage.show();
		
	}

}
