package es.upm.dit.adsw.ej3;

import java.util.ArrayList;
import java.util.List;

public class HashListas implements Diccionario {
	private final List<CV>[] slots;
	private int nDatos = 0;

	/**
	 * constructor.
	 * 
	 * @param nSlots
	 *            numero de ranuras (slots).
	 */
	public HashListas(int nSlots) {

		slots = new List[nSlots];

		for (int i = 0; i < nSlots; i++) {
			slots[i] = new ArrayList<CV>();
			nDatos = 0;
		}
	}

	@Override
	public void put(String clave, String valor) {

		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}

		int idx = Math.abs(clave.hashCode()) % slots.length;
		List<CV> lista = slots[idx];
		for (CV cv : lista) {
			if (cv.getClave().equals(clave)) {
				cv.setValor(valor);
				return;
			}
		}

		slots[idx].add(new CV(clave, valor));
		nDatos++;

	}

	@Override
	public String get(String clave) {

		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}

		int idx = Math.abs(clave.hashCode()) % slots.length;
		List<CV> lista = slots[idx];
		for (CV cv : lista) {
			if (cv.getClave().equals(clave))
				return cv.getValor();
		}
		return null;
	}

	@Override
	public String remove(String clave) {
		
		return null;
	}

	@Override
	public int size() {

		return nDatos;
	}

	@Override
	public void clear() {
		for (int i = 0; i < slots.length; i++) {
			slots[i].clear();
		}

	}

	public void print() {
		for (int j = 0; j < slots.length; j++) {
			for (int i = 0; i < slots[j].size(); i++) {

				System.out.println(j + " " + slots[j].get(i).getClave() + " "
						+ slots[j].get(i).getValor());
			}
			System.out.println("");
		}
	}
}
