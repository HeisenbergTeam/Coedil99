package com.coedil99.ui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ElaboraRDA extends Application {
    public static void start(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
    	Parent root;
		try {
			root = (BorderPane) FXMLLoader.load(getClass().getResource("/com/coedil99/ui/fxml/elabora_rda.fxml"));
			
			
			Scene scene = new Scene(root, 1024, 730);
			stage.setMinWidth(1024);
			stage.setMinHeight(730);
			stage.setTitle("Richiesta d'acquisto");
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	

    }
}