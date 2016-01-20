package com.coedil99.utilita.impl;

import com.coedil99.utilita.UtilitaManager;
import com.coedil99.utilita.Servizio;

import java.util.HashMap;

public class UtilitaManagerPrototipo extends UtilitaManager {
/**
 * 
 */
	private final static String serviziPackage = "com.coedil99.utilita.impl.";
/**
 * 
 */
	private HashMap<String, Servizio> servizi = new HashMap<String, Servizio>();

	public UtilitaManagerPrototipo(){
		
	}
	
	@Override
	public Servizio getServizio(String classname) {
		
		String classpath = serviziPackage+classname;
		
		Servizio inst = servizi.get(classpath);
		if(inst!= null){
			return inst;
		}
		
		Class c = null;
		
		
		try {
			
			//TODO: aggiungere un sistema per instanziare un servizio una sola volta
			c = Class.forName(classpath);
			inst = (Servizio) c.newInstance();
			//System.out.println(inst.getClass());
			
			/*
			Field[] fields = c.getDeclaredFields();
			
			for (Field field : fields) {
				
				injected annot = field.getAnnotation(injected.class);
				if(annot != null){
					Servizio s = this.getServizio(annot.serviceImplementation());
					System.out.println(c.toString());
					SessionePrototipo st = new SessionePrototipo();
					field.set(inst, st );
					System.out.println("ciao");
				}
				
				
			}
			*/
			
			servizi.put(classpath, inst);
			
			return inst;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
