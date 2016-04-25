package es.upm.dit.adsw.ej6;

public class TsCache implements Diccionario {

	private final TsList[] slots;

	public TsCache(int nSlots) {

		slots = new TsList[nSlots];

		for (int i = 0; i < nSlots; i++) {
			slots[i] = new TsList();
		}
	}

	@Override
	public void put(String clave, String valor) {

		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}

		int idx = Math.abs(clave.hashCode()) % slots.length;
		slots[idx].put(clave, valor);
	}

	@Override
	public String get(String clave) {

		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}

		int idx = Math.abs(clave.hashCode()) % slots.length;
		return slots[idx].get(clave);
	}

	@Override
	public String remove(String clave) {

		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}

		int idx = Math.abs(clave.hashCode()) % slots.length;
		return slots[idx].remove(clave);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < slots.length; i++) {
			slots[i].clear();
		}

	}

}
