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
			slots[i] = new ArrayList<CV>(0);
			nDatos=0;
		}
	}

	@Override
	public void put(String clave, String valor) {
		
		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}
		
		int idx = Math.abs(clave.hashCode()) % slots.length;
		List<CV>lista = slots[idx];
		for (CV cv:lista){
			if (cv.getClave().equals(clave))
				cv.setValor(valor);
			return;
		}
		lista.add(new CV(clave,valor));
		nDatos++;

	}

	@Override
	public String get(String clave) {
		
		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}
		
		int idx = Math.abs(clave.hashCode()) % slots.length;
		List<CV>lista=slots[idx];
		for(CV cv:lista){
			if (cv.getClave().equals(clave))
				return cv.getValor();			
		}
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
	public void print(){
		
		for(int i=0;i<slots.length;i++){
			System.out.println(slots[i]);
		}
	}
}
