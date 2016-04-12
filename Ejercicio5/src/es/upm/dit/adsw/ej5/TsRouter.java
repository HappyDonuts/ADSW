package es.upm.dit.adsw.ej5;

public class TsRouter {

	private final Packet[] queue;
	private int nDatos = 0;

	TsRouter(int max) {
		queue = new Packet[max];
	}

	public synchronized Packet get() {
		if (nDatos > 0) {
			int posi = 0;
			Packet paquetePrior = queue[0];
			for (int i = 0; i < nDatos; i++) {
				if (queue[i].getPriority().compareTo(paquetePrior.getPriority()) > 0) {
					paquetePrior = queue[i];
					posi = i;
				}
			}
			queue[posi] = null;
			System.arraycopy(queue, posi + 1, queue, posi, nDatos - posi);
			nDatos--;
			return paquetePrior;
		}
		return null;
	}

	public synchronized void send(Packet newPaquete) {
		if (nDatos == queue.length) {
			Packet paqueteless = queue[0];
			int posicion = 0;
			for (int i = 0; i < nDatos; i++) {
				if (queue[i].getPriority().compareTo(paqueteless.getPriority()) < 0) {
					paqueteless = queue[i];
					posicion = i;
				}
			}
			if (paqueteless.getPriority().compareTo(newPaquete.getPriority()) < 0) {
				queue[posicion] = null;
				System.arraycopy(queue, posicion + 1, queue, posicion, nDatos - posicion);
				queue[nDatos - 1] = newPaquete;
				return;
			}
			else {
				return;
			}
		}
		queue[nDatos] = newPaquete;
		nDatos++;
		

	}

	public void imprimeCola() {
		for (int i = 0; i < 5; i++) {
			if (queue[i] == null) {
				System.out.println("null");
				continue;
			}
			System.out.println(queue[i].getPriority());
		}
		System.out.println("");
	}
}
