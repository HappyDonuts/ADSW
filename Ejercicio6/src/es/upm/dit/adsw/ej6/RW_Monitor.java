package es.upm.dit.adsw.ej6;

public class RW_Monitor {

	private int nReaders = 0;
	private int nWriters = 0;
	
	public RW_Monitor(){}

	public synchronized void openReading() {
		while (nWriters > 0) {
			waiting();
		}
		nReaders++;
	}
	
	public synchronized void closeReading(){
		nReaders--;
		notifyAll();
	}
	
	public synchronized void openWriting(){
		while (nReaders>0 || nWriters>0){
			waiting();
		}
		nWriters++;
	}
	
	public synchronized void closeWriting(){
		nWriters--;
		notifyAll();
	}
	
	public synchronized int getNReaders(){
		return nReaders;
	}

	public synchronized int getNWriters(){
		return nWriters;
	}
	
	private void waiting() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
