package es.upm.dit.adsw.ej60;

public class RW_Monitor {
	private int nReaders;
	private int nWriters;

	public RW_Monitor(){
		
	}
	
	public synchronized int getNReadersIn(){
		return nReaders;
	}
	
	public synchronized int getNWriters(){
		return nWriters;
	}
	
	public synchronized void closeReading(){
		return;
	}
	
	public synchronized void closeWriting(){
		return;
	}
}
