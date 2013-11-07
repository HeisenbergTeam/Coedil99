package ui;

import java.io.IOException;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * MainApplication
 * @author mw
 *
 */
/**
 * MainApplication
 * @author mw
 *
 */
public class MainApplication extends Application {
/**
 * main
 * @param args
 */
	private LinkedList<Scene> history = new LinkedList<Scene>();
	
	private Stage mainStage;
	
	private static MainApplication instance;
	
	public static MainApplication getInstance(){
		return instance;
	}
	
	public static void main(String args[]){
		MainApplication.launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		
		this.mainStage = stage;
		MainApplication.instance = this;
		
		this.loadPage("login");
		
		
	}
	
	public void goBack() {
		
		this.mainStage.setScene(this.history.pop());
		this.mainStage.show();
		
	}
	
	public void loadPage(String name){
		
		Parent root;
		try {
			
			root = FXMLLoader.load(getClass().getResource("fxml/"+name+".fxml"));
			Scene scene = new Scene(root, 800, 600);
			
			//Save history
			this.history.push(this.mainStage.getScene());
			
			this.mainStage.setTitle("Coedil99");
			this.mainStage.setScene(scene);
			this.mainStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
		

	}
	
	
	

}
