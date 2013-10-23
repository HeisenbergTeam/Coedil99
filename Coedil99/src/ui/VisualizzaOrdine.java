package ui;

 
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class VisualizzaOrdine extends Application {
    public static void start(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("layout_pagina.fxml"));
			Scene scene = new Scene(root, 300, 275);
			 stage.setTitle("FXML Welcome");
			 stage.setScene(scene);
			 stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	

    }
}