package controller;

import java.io.IOException;

import ui.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PannelloControlloController {
	
	@FXML protected BorderPane container;
	
	@FXML protected void visualizzaOrdini(ActionEvent action){
		
		MainApplication.getInstance().loadPage("visualizza_ordini");
		
	}
	
}
