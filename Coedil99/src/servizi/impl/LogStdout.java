package servizi.impl;

import servizi.Log;

public class LogStdout implements Log {

	@Override
	public void d(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
		
	}

	@Override
	public void e(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

	@Override
	public void i(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

	@Override
	public void w(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

}
