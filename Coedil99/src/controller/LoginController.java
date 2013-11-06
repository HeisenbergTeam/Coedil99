package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import servizi.Autenticazione;
import servizi.GestoreServizi;

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
			Stage stage = (Stage) username.getScene().getWindow();
			stage.close();
			
			Parent root = null;
			try {
				root = FXMLLoader.load(getClass().getResource("../ui/fxml/pannello_di_controllo.fxml"));
				Scene scene = new Scene(root, 640, 480);
				
				Stage s = new Stage();
				s.setTitle("FXML Welcome");
				s.setScene(scene);
				s.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
