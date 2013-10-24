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
 
public class VisualizzaOrdine extends Application {
    public static void start(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
    	Parent root;
		try {
			root = (BorderPane) FXMLLoader.load(getClass().getResource("layout_pagina.fxml"));
			
			Scene scene = new Scene(root, 300, 275);
			
			TreeView<String> treeViewOrdini = (TreeView<String>) root.lookup("#treeview_ordini");
			System.out.println(treeViewOrdini.getClass().toString());
			
			
			stage.setTitle("FXML Welcome");
			stage.setScene(scene);
			stage.show();
			
			if(scene.lookup("#treeview_ordini") == null){
				System.out.println("i");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	

    }
}