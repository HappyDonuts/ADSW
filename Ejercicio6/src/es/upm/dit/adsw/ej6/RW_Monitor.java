package es.upm.dit.adsw.ej6;

public class RW_Monitor {

	// Utilizo una política laxa. En caso de que el ejercicio esté bien,
	// intentaré implementar una más sofisticada
	private int nReaders = 0;
	private int nWriters = 0;

	public RW_Monitor() {
	}

	public synchronized void openReading() {
		while (nWriters > 0) {
			waiting();
		}
		nReaders++;
	}

	public synchronized void closeReading() {
		nReaders--;
		notifyAll();
	}

	public synchronized void openWriting() {
		while (nReaders > 0 || nWriters > 0) {
			waiting();
		}
		nWriters++;
	}

	public synchronized void closeWriting() {
		nWriters--;
		notifyAll();
	}

	public synchronized int getNReadersIn() {
		return nReaders;
	}

	public synchronized int getNWritersIn() {
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
