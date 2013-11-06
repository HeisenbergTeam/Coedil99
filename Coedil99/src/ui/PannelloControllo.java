package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PannelloControllo extends Application {

	@Override
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("visualizza_ordini.fxml"));
			Scene scene = new Scene(root, 640, 480);
			
			stage.setTitle("FXML Welcome");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
