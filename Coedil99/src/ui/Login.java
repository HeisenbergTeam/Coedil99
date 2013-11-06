package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application{

    public static void start(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Parent root =  FXMLLoader.load(getClass().getResource("fxml/login.fxml"));
		Scene scene = new Scene(root, 600, 400);
		
		stage.setTitle("Coedil99 Login");
		stage.setScene(scene);
		stage.show();
		
	}

}
