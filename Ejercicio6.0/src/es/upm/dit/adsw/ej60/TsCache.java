package es.upm.dit.adsw.ej60;

public class TsCache {

	TsList[] slots;
	int nSlots;

	public TsCache(int nSlots) {
		this.nSlots = nSlots;
		slots = new TsList[nSlots];
		for (int i = 0; i < nSlots; i++) {
			slots[i] = new TsList();
		}
	}

	public void put(String clave, String valor) {
		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}

		int idx = Math.abs(clave.hashCode()) % slots.length;
		slots[idx].put(clave, valor);
	}

	public String get(String clave) {
		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}

		int idx = Math.abs(clave.hashCode()) % slots.length;
		return slots[idx].get(clave);
	}

	public String remove(String clave) {
		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}

		int idx = Math.abs(clave.hashCode()) % slots.length;
		return slots[idx].remove(clave);

	}

	public void clear() {
		for (int i = 0; i < nSlots; i++) {
			slots[i].clear();
		}
	}
}
