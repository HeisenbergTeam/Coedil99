package com.coedil99.controller.ui;

import com.coedil99.servizi.Autenticazione;
import com.coedil99.servizi.GestoreServizi;
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
		
		GestoreServizi gs = GestoreServizi.getGestoreServizi();
		Autenticazione autenticazione = (Autenticazione) gs.getServizio("AutenticazionePrototipo");
		
		if(autenticazione.login(username.getText(),password.getText())){
			
			MainApplication.getInstance().loadPage("pannello_di_controllo");
			
		}
	}
}
