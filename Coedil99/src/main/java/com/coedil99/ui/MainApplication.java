package com.coedil99.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;
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
/**
 * mainStage
 */
	private Stage mainStage;
/**
 * instance
 */
	private static MainApplication instance;
/**
 *  startpage
 *  
 *  This page is 
 */
	private final static String startpage = "login";
/**
 * getInstance	
 * @return
 */
	public static MainApplication getInstance(){
		return instance;
	}
/**
 * main	
 * @param args
 */
	public static void main(String args[]){
		MainApplication.launch(args);
	}
/**
 * 
 */
	@Override
	public void start(Stage stage) {
		
		this.mainStage = stage;
		this.mainStage.setMinWidth(800);
		this.mainStage.setMinHeight(600);
		MainApplication.instance = this;
		
		this.loadPage(startpage);
		
	}
/**
 * goBack
 */
	public void goBack() {
		
		this.mainStage.setScene(this.history.pop());
		this.mainStage.show();
		
	}
/**
 * loadPage
 * @param name page to be loaded
 */
	public void loadPage(String name){
		
		Parent root;
		try {

            String pageUrl = getClass().getResource("./fxml/"+name+".fxml").toString();

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
