package es.upm.dit.adsw.ej60;

import java.util.ArrayList;
import java.util.List;

public class TsList {
	List<CV> lista = new ArrayList<CV>();
	int id;

	public synchronized void put(String clave, String valor) {

		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}

		for (CV cv : lista) {
			if (cv.getClave().equals(clave)) {
				cv.setValor(valor);
				return;
			}
		}
		lista.add(new CV(clave, valor));
	}

	public synchronized String get(String clave) {

		for (CV cv : lista) {
			if (cv.getClave().compareTo(clave) == 0) {
				return cv.getValor();
			}
		}
		return null;
	}

	public synchronized String remove(String clave) {

		for (CV cv : lista) {
			if (cv.getClave().equals(clave)) {
				String valorBorrado = cv.getValor();
				lista.remove(cv);
				return valorBorrado;
			}
		}

		return null;
	}

	public synchronized void clear() {
		lista.clear();
	}
}
