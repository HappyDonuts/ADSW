package es.upm.dit.adsw.ej1;

import java.util.HashMap;

public class DiccionarioHashMap implements Diccionario {

	private final HashMap<String, String> map = new HashMap<String, String>();

	/**
	 * Mete un valor nuevo. Si ya existe uno con misma clave, reemplaza el
	 * valor.
	 *
	 * @param clave
	 * @param valor
	 * @throws IllegalArgumentException
	 *             Si clave es null.
	 * @throws IllegalArgumentException
	 *             Si clave es la cadena vacia.
	 */
	@Override
	public void put(String clave, String valor) {

		// En principio no hay tama�o m�ximo, as� que siempre deber�a caber la
		// CV
		if ((clave == null) || (clave == "")) {
			throw new IllegalArgumentException();
		}

		map.put(clave, valor);
		// No hay que comprobar si la clave está introducida, ya que el método
		// put la introduce si no está, o la modifica si ya está
	}

	/**
	 * Saca el valor asociado a la clave.
	 *
	 * @param clave
	 * @return null si no estÃ¡ la clave.
	 * @throws IllegalArgumentException
	 *             Si clave es null.
	 * @throws IllegalArgumentException
	 *             Si clave es la cadena vacia.
	 */
	@Override
	public String get(String clave) {

		if ((clave == null) || (clave == "")) {
			throw new IllegalArgumentException();
		}

		if (map.containsKey(clave)) {
			return map.get(clave);
		}

		return null;
	}

	/**
	 * Elimina el objeto asociado a la clave, si estÃ¡.
	 *
	 * @param clave
	 * @return devuelve el valor asociado si estaba la clave; devuelve null si
	 *         no estÃ¡ la clave
	 * @throws IllegalArgumentException
	 *             Si clave es null.
	 * @throws IllegalArgumentException
	 *             Si clave es la cadena vacia.
	 */
	@Override
	public String remove(String clave) {

		if ((clave == null) || (clave == "")) {
			throw new IllegalArgumentException();
		}

		if (map.containsKey(clave)) {
			String valorBorrado = map.get(clave);
			map.remove(clave);
			return valorBorrado;
		}

		return null;
	}

	/**
	 * @return nÃºmero de elementos almacenados.
	 */
	@Override
	public int size() {

		return map.size();
	}

	/**
	 * Elimina todas las claves.
	 */
	@Override
	public void clear() {

		map.clear();

	}

}
