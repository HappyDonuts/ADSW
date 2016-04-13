package es.upm.dit.adsw.ej5;

public class TsRouter {

	private final Packet[] queue;
	private int nDatos = 0;

	TsRouter(int max) {
		queue = new Packet[max + 1];
	}

	/**
	 * De los pendientes de entrega, selecciona el de más prioridad y, dentro de
	 * la misma prioridad, el más antiguo. Lo elimina de la cola y lo devuelve.
	 *
	 * @return el paquete seleccionado.
	 */
	public synchronized Packet get() {
		if (nDatos > 0) {
			int posi = 0;
			Packet highPriority = queue[0];
			for (int i = 0; i < nDatos; i++) {
				if (queue[i].getPriority().compareTo(highPriority.getPriority()) > 0) {
					highPriority = queue[i];
					posi = i;
				}
			}
			System.arraycopy(queue, posi + 1, queue, posi, nDatos - posi);
			queue[nDatos - 1] = null;
			nDatos--;
			return highPriority;
		}
		return null;
	}

	/**
	 * Agrega un paquete a la cola del router. Si la cola está llena, se hace
	 * sitio eliminando el paquete más antiguo de menor prioridad.
	 * 
	 * @throws IllegalArgumentException
	 *             Si el paquete es null.
	 * @param packet
	 *            el paquete a encolar.
	 */
	public synchronized void send(Packet newPaquete) {

		queue[nDatos] = newPaquete;
		nDatos++;
		if (nDatos == queue.length) {
			Packet lowPriority = queue[0];
			int posicion = 0;
			for (int i = 0; i < nDatos; i++) {
				if ((queue[i].getPriority().compareTo(lowPriority.getPriority()) < 0)) {
					lowPriority = queue[i];
					posicion = i;
				}
			}
			System.arraycopy(queue, posicion + 1, queue, posicion, queue.length - posicion - 1);
			queue[queue.length - 1] = null;
			nDatos--;
		}
	}

	/**
	 * Metodo personal para depurar más facilmente Imprime la cola del router
	 * Para cada paquete, imprime su prioridad e id
	 */
	public void printRouter() {
		for (int i = 0; i < queue.length; i++) {
			if (queue[i] == null) {
				System.out.println("null");
				continue;
			}
			System.out.println(queue[i].getPriority() + " " + queue[i].getData());
		}
		System.out.println("");
	}
}
