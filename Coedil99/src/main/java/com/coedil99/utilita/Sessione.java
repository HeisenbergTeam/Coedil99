package com.coedil99.utilita;


public interface Sessione extends Servizio {
	
	Object get(String objName);
	
	void set(String objName,Object obj);
}
