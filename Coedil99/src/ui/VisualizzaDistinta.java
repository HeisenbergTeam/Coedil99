package ui;

 
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
 
public class VisualizzaDistinta extends Application {
    public static void start(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
    	Parent root;
		try {
			root = (BorderPane) FXMLLoader.load(getClass().getResource("/ui/fxml/visualizza_distinta.fxml"));
			
			
			Scene scene = new Scene(root, 1024, 768);
			stage.setMinWidth(1024);
			stage.setMinHeight(768);
			stage.setTitle("Distinta");
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	

    }
}