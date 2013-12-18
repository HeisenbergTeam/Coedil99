package ui;

 
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
 
public class VisualizzaPezzi extends Application {
    public static void start(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
    	Parent root;
		try {
			root = (BorderPane) FXMLLoader.load(getClass().getResource("/ui/fxml/aggiungi_pezzo.fxml"));
			
			
			Scene scene = new Scene(root, 640, 480);
			
			stage.setTitle("Distinta");
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	

    }
}