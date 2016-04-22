package es.upm.dit.adsw.ej6;

import java.util.ArrayList;
import java.util.List;

public class TsList {

	List<CV> lista;
	RW_Monitor monitor;
	private LogViewer viewer = LogViewer.getInstance();

	public TsList() {
		lista = new ArrayList<CV>();
	}

	public String get(String clave) {
		monitor.openReading();
		viewer.dump(this, monitor.getNReaders(), monitor.getNWriters());
		try {
			for (CV cv : lista) {
				if (cv.getClave().equals(clave)) {
					return cv.getValor();
				}
			}
			return null;
		} finally {
			monitor.closeReading();
		}
	}

	public void put(String clave, String valor) {
		monitor.openWriting();
		viewer.dump(this, monitor.getNReaders(), monitor.getNWriters());

		try {
			for (CV cv : lista) {
				if (cv.getClave().equals(clave)) {
					cv.setValor(valor);
					return;
				}
			}
			lista.add(new CV(clave, valor));
		} finally {
			monitor.closeWriting();
		}
	}

	public String remove(String clave) {
		monitor.openWriting();
		viewer.dump(this, monitor.getNReaders(), monitor.getNWriters());

		try {
			for (CV cv : lista) {
				if (cv.getClave().equals(clave)) {
					String valorBorrado = cv.getValor();
					lista.remove(cv);
					return valorBorrado;
				}
			}
			return null;
		} finally {
			monitor.closeWriting();
		}
	}

	public void clear() {
		monitor.openWriting();

		try {
			lista.clear();
		} finally {
			monitor.closeWriting();
		}
	}

}
