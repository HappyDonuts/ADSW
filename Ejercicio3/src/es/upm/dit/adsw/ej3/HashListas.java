package es.upm.dit.adsw.ej3;

import java.awt.List;
import java.util.ArrayList;

public class HashListas implements Diccionario {

	public HashListas(int nSlots) {

		slots = new List[nSlots];

		for (int i = 0; i < nSlots; i++) {
			slots[i] = new ArrayList<CV>();
		}
	}

	@Override
	public void put(String clave, String valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public String get(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String remove(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
