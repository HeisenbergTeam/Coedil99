package com.coedil99.controller.ui;

import com.coedil99.modello_di_dominio.LavorazionePezzo;
import com.coedil99.modello_di_dominio.Pezzo;
import com.coedil99.modello_di_dominio.RigaDistinta;
import com.coedil99.ui.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * PannelloControlloController
 * @author mw
 *
 */
public class PannelloControlloController {

	public void setAction(int action) {

	}

	@FXML protected BorderPane container;
	
	@FXML protected void visualizzaOrdini(ActionEvent action)
    {
		MainApplication.getInstance().loadPage("visualizza_ordini", "com.coedil99.controller.ui.VisualizzaOrdiniController", DefineControllerUi.MODIFICA_ORDINI);
	}

	@FXML protected void creaOrdine(ActionEvent action)
    {
		MainApplication.getInstance().loadPage("visualizza_ordini", "com.coedil99.controller.ui.VisualizzaOrdiniController", DefineControllerUi.NUOVO_ORDINE);
	}

    @FXML protected void gestisciRDA(ActionEvent action)
    {
		//fx:controller="com.coedil99.controller.ui.VisualizzaRdaController"
		MainApplication.getInstance().loadPage("visualizza_rda", "com.coedil99.controller.ui.VisualizzaRdaController", 0);
    }

	
}
