package com.coedil99.utilita.impl;

import com.coedil99.utilita.Sessione;

import java.util.HashMap;

/**
 * 
 * @author mw
 *
 */
public class SessionePrototipo extends HashMap<String,Object> implements Sessione {

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
