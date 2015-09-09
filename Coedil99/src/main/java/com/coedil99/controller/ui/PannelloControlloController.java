package com.coedil99.controller.ui;

import com.coedil99.ui.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
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
