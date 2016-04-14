package es.upm.dit.adsw.ej60;

import java.util.ArrayList;
import java.util.List;

public class TsList {
	private LogViewer viewer=LogViewer.getInstance();
	List<CV> lista = new ArrayList<CV>();
	int id;

	public synchronized void put(String clave, String valor) {
		viewer.dump(this, 0, 1);
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
		viewer.dump(this, 0, 0);

	}

	public String get(String clave) {
		viewer.dump(this, 1, 0);

		for (CV cv : lista) {
			if (cv.getClave().compareTo(clave) == 0) {
				viewer.dump(this, 0, 0);

				return cv.getValor();
			}
		}
		return null;
	}

	public synchronized String remove(String clave) {
		viewer.dump(this, 0, 1);
		for (CV cv : lista) {
			if (cv.getClave().equals(clave)) {
				String valorBorrado = cv.getValor();
				lista.remove(cv);
				viewer.dump(this, 0, 0);

				return valorBorrado;
			}
		}

		return null;
		
	}

	public synchronized void clear() {
		lista.clear();
	}
}
