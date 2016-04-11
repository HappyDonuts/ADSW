package es.upm.dit.adsw.ej5;

public class TsRouter {

	int max = 0;
	Packet[] queue = new Packet[max];
	int nDatos = 0;

	TsRouter(int max) {
		this.max = max;
	}

	public synchronized Packet get() {
		for (int i = 0; i < max; i++) {
			if (queue[i].getPriority() == Priority.ALTA) {
				Packet paqueteFuera = queue[i];
				queue[i] = null;
				System.arraycopy(queue, i, queue, i + 1, nDatos - i);
				nDatos--;
				return paqueteFuera;
			}
		}
		for (int i = 0; i < max; i++) {
			if (queue[i].getPriority() == Priority.MEDIA) {
				Packet paqueteFuera = queue[i];
				queue[i] = null;
				System.arraycopy(queue, i, queue, i + 1, nDatos - i);
				nDatos--;
				return paqueteFuera;
			}
		}
		for (int i = 0; i < max; i++) {
			if (queue[i].getPriority() == Priority.BAJA) {
				Packet paqueteFuera = queue[i];
				queue[i] = null;
				System.arraycopy(queue, i, queue, i + 1, nDatos - i);
				nDatos--;
				return paqueteFuera;
			}
		} 

		return null;
	}

	public synchronized void send(Packet newPaquete) {
		if (nDatos == max) {
			Packet paqueteless = queue[0];
			int posicion = 0;
			for (int i = 0; i < max; i++) {
				if (queue[i].getPriority().compareTo(paqueteless.getPriority()) < 0) {
					paqueteless = queue[i];
					posicion = i;

				}
			}
			if (paqueteless.getPriority().compareTo(newPaquete.getPriority()) < 0) {
				queue[posicion] = null;
				System.arraycopy(queue, posicion, queue, posicion + 1, nDatos - posicion);
				queue[nDatos - 1] = newPaquete;
				return;
			}
		}
		queue[nDatos - 1] = newPaquete;
		nDatos++;
	}
}
