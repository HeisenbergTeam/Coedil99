package com.coedil99.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
		this.mainStage.setMinWidth(1024);
		this.mainStage.setMinHeight(768);
		MainApplication.instance = this;
		
		this.loadPage(startpage, "com.coedil99.controller.ui.LoginController", 0);
		
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
	public void loadPage(String name, String strControllerName, int intAction){

		Parent root;
		try {

            String pageUrl = getClass().getResource("./fxml/"+name+".fxml").toString();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/"+name+".fxml"));

			try {
				Class classController = Class.forName(strControllerName);
				Class reflectionParameters[] = new Class[1];
				reflectionParameters[0] = Integer.TYPE;
				Object istanceController = classController.newInstance();
				Method meth = classController.getMethod(
						"setAction", reflectionParameters);
				meth.invoke(istanceController, intAction);
				loader.setController(istanceController);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			root = loader.load();
			//root = FXMLLoader.load(getClass().getResource("fxml/"+name+".fxml"));

			Scene scene = new Scene(root, 1024, 768);

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
