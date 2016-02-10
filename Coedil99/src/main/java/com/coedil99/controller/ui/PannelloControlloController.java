package com.coedil99.controller.ui;

import com.coedil99.dominio.builder.Builder;
import com.coedil99.modello_di_dominio.*;
import com.coedil99.ui.MainApplication;
import com.coedil99.utilita.Sessione;
import com.coedil99.utilita.UtilitaManager;
import com.coedil99.utilita.impl.UtilitaManagerPrototipo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Date;


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

		MainApplication.getInstance().loadPage("visualizza_rda", "com.coedil99.controller.ui.VisualizzaRdaController", 0);
    }

	@FXML protected void nuovaRDA(ActionEvent action)
	{

		UtilitaManager gsp = UtilitaManagerPrototipo.getGestoreServizi();
		Sessione session = (Sessione) gsp.getServizio("SessionePrototipo");

		Stage popupStage = new Stage();
		popupStage.initModality(Modality.APPLICATION_MODAL);

		Parent root = null;
		try {
			FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("fxml/aggiungi_rda.fxml"));

			//"com.coedil99.controller.ui.AggiungiPezzoController"
			AggiungiRDAController controller = new AggiungiRDAController();

			// Set it in the FXMLLoader
			loader.setController(controller);

			root = loader.load();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		Scene scene = new Scene(root);
		popupStage.setScene(scene);

		//blocking
		popupStage.showAndWait();

		Fornitore fornitoreSelezionato = (Fornitore) session.get("fornitore_selezionato");
		Date dateP = (Date) session.get("data_prevista");
		Date dateE = (Date) session.get("data_effettiva");
		Date dateR = (Date) session.get("data_richiesta");

		if (fornitoreSelezionato != null && dateP != null && dateE != null && dateR != null) {
			RDA nuovaRda = new Builder.RDABuilder().setDataArrivoEffettiva(dateE).setDataArrivoPrevista(dateP).setDataCreazione(dateR).setDescrizione("").setFornitore(fornitoreSelezionato).build();
			MainApplication.getInstance().loadPage("elabora_rda", "com.coedil99.controller.ui.ElaboraRDAController", nuovaRda.getID());
		}
		//fx:controller="com.coedil99.controller.ui.VisualizzaRdaController"
		//MainApplication.getInstance().loadPage("visualizza_rda", "com.coedil99.controller.ui.VisualizzaRdaController", 0);
	}

	@FXML protected void gestisciFornitori(ActionEvent action)
	{
		//fx:controller="com.coedil99.controller.ui.VisualizzaRdaController"
		MainApplication.getInstance().loadPage("fornitore", "com.coedil99.controller.ui.FornitoreController", 0);
	}
	
}
