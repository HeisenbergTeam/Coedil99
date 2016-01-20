package com.coedil99.controller.ui;

import com.coedil99.utilita.Autenticazione;
import com.coedil99.utilita.UtilitaManager;
import com.coedil99.ui.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
	
	@FXML private TextField username;
	@FXML private PasswordField password;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
	}
	
	@FXML protected void login(ActionEvent event){
		
		UtilitaManager gs = UtilitaManager.getGestoreServizi();
		Autenticazione autenticazione = (Autenticazione) gs.getServizio("AutenticazionePrototipo");
		
		if(autenticazione.login(username.getText(),password.getText()))
        {
			MainApplication.getInstance().loadPage("pannello_di_controllo");
		}
        else
        {
            username.setStyle("-fx-border-color: red");
            username.setPromptText("Username errato!");

            password.setStyle("-fx-border-color: red");
            password.setPromptText("Password errata!");
        }
	}
}
