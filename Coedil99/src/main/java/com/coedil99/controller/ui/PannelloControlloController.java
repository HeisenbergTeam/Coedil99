package com.coedil99.controller.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import com.coedil99.ui.MainApplication;
/**
 * PannelloControlloController
 * @author mw
 *
 */
public class PannelloControlloController {
	
	@FXML protected BorderPane container;
	
	@FXML protected void visualizzaOrdini(ActionEvent action){
		
		MainApplication.getInstance().loadPage("visualizza_ordini");
		
	}
	
	@FXML protected void creaOrdine(ActionEvent action){
		
		MainApplication.getInstance().goBack();
		
	}
	
}
