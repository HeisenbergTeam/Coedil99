package servizi.impl;

import java.util.HashMap;

import servizi.Sessione;
/**
 * 
 * @author mw
 *
 */
public class SessionePrototipo extends HashMap<String,Object> implements Sessione{

	@Override
	public void set(String objName, Object obj) {
		this.put(objName, obj);
		
	}

	@Override
	public Object get(String objName) {
		// TODO Auto-generated method stub
		return super.get(objName);
	}	
	
	
}
