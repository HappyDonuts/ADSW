package es.upm.dit.adsw.ej6;

import java.util.ArrayList;
import java.util.List;

public class TsList {

	List<CV> lista;
	private RW_Monitor monitor = new RW_Monitor();
	private LogViewer viewer = LogViewer.getInstance();

	public TsList() {
		lista = new ArrayList<CV>();
	}

	public String get(String clave) {
		monitor.openReading();
		My.assertEquals(monitor.getNWritersIn(), 0);
		viewer.dump(this, monitor.getNReadersIn(), monitor.getNWritersIn());

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
		My.assertEquals(monitor.getNWritersIn(), 1);
		My.assertEquals(monitor.getNReadersIn(), 0);
		viewer.dump(this, monitor.getNReadersIn(), monitor.getNWritersIn());

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
		My.assertEquals(monitor.getNWritersIn(), 1);
		My.assertEquals(monitor.getNReadersIn(), 0);
		viewer.dump(this, monitor.getNReadersIn(), monitor.getNWritersIn());

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
		My.assertEquals(monitor.getNWritersIn(), 1);
		My.assertEquals(monitor.getNReadersIn(), 0);

		try {
			lista.clear();
		} finally {
			monitor.closeWriting();
		}
	}

}
