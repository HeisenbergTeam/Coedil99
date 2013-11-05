package servizi.impl;

import java.io.File;
import java.net.URL;
import java.security.Provider.Service;
import java.util.HashMap;

import servizi.GestoreServizi;
import servizi.Servizio;

public class GestoreServiziPrototipo implements GestoreServizi {

	private final static String serviziPackage = "servizi";
	
	private static GestoreServiziPrototipo _instance = new GestoreServiziPrototipo();

	private HashMap<Class, Servizio> Servizi = new HashMap<Class, Servizio>();
	
	public GestoreServiziPrototipo(){
		caricaServizi();
	}
	
	public static GestoreServiziPrototipo getGestoreServiziPrototipo() {
		return _instance;
	}

	public HashMap<Class, Servizio> getServizi() {
		return this.Servizi;
	}

	public Servizio getServizioDaNome(String nome) {
		return this.Servizi.get(nome);
	}

	@Override
	public Servizio getServizio(String classname) {
		Class c;
		try {
			c = Class.forName("servizi."+classname);
			//ClassLoader cl = new URLClassLoader(URL[]{new URL(".")});
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void caricaServizi(){
		URL directoryURL = Thread.currentThread().getContextClassLoader().getResource(serviziPackage);
		
		if(directoryURL == null){
			System.out.println("errore");
			return ;
		}
		
		File directory = new File(directoryURL.getFile());
		
		String[] files = directory.list();
		for (String file : files) {
			if (file.endsWith(".class")) {  
                // Remove the .class extension  
                file = file.substring(0, file.length() - 6);  
                try {  
                    Servizi.put(Class.forName("servizi" + "." + file),null);
                    Class c = Class.forName("servizi" + "." + file);
                    if(Servizio.class.isAssignableFrom(c)){
                    	System.out.println("la implementa");
                    }
                    System.out.println(file);
                } catch (ClassNotFoundException e) {  
                	System.out.println("Asino");
                }
 
			}
			
		}
		
		//URL directoryURL = Thread.currentThread().getContextClassLoader().getResource(serviziPackage);
		
	}

}
