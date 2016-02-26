package es.upm.dit.adsw.ej2;

import java.util.Arrays;
import java.util.Comparator;

public class DiccionarioBinario implements Diccionario {

	private final CV[] datos;
	private int nDatos = 0;
	CV cvnull = new CV(null, null);

	public DiccionarioBinario(int max) {
		datos = new CV[max];

	}

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
	 * @throws RuntimeException
	 *             Si no cabe la clave.
	 */
	@Override
	public void put(String clave, String valor) throws RuntimeException {

		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}

		// Comprueba que la clave se encuentra en el array, y sobreescribe el
		// valor.

		if ((datos[busca(clave)] != null) && (datos[busca(clave)].getClave() == clave)) {
			datos[busca(clave)].setValor(valor);
			return;
		}
		//
		if (nDatos >= datos.length) {
			throw new RuntimeException();
		}

		CV objetoCV = new CV(clave, valor);
		datos[nDatos] = objetoCV;
		nDatos++;

		Arrays.sort(datos, 0, nDatos, new Comparator<CV>() {
			public int compare(CV o1, CV o2) {
				return o1.getClave().compareTo(o2.getClave());

			}
		});

	}

	/**
	 * Busca la posición del array en la cual está la clave
	 *
	 * @param clave
	 * @return 0 si no está la clave.
	 * @throws IllegalArgumentException
	 *             Si clave es null.
	 * @throws IllegalArgumentException
	 *             Si clave es la cadena vacia.
	 */
	private int busca(String clave) {
		int a = 0;
		int z = nDatos - 1;
		while (a < z) {
			int m = (a + z) / 2;
			int cmp = clave.compareTo(datos[m].getClave());
			if (cmp == 0) {

				return m;
			} else if (cmp < 0)
				z = m;
			else
				a = m + 1;
		}

		return a;
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

		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}
		// Busca la clave en el array, y si está devuelve el valor
		if ((datos[busca(clave)] != null) && (datos[busca(clave)].getClave() == clave)) {
			return datos[busca(clave)].getValor();
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

		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}

		if ((datos[busca(clave)] != null) && (datos[busca(clave)].getClave() == clave)) {
			int posiClaveBorrada=busca(clave);
			String valorBorrado = datos[posiClaveBorrada].getValor();
			datos[busca(clave)] = null;
			if (posiClaveBorrada!=nDatos-1){
			System.arraycopy(datos, posiClaveBorrada + 1, datos, posiClaveBorrada, nDatos-1-posiClaveBorrada);

			Arrays.sort(datos, 0, nDatos, new Comparator<CV>() {
				public int compare(CV o1, CV o2) {
					return o1.getClave().compareTo(o2.getClave());

				}
			});
			nDatos--;
			return valorBorrado;
			}
		}

		// int i;
		// for (i = 0; i < datos.length; i++) {
		// if (clave.equals(datos[i].getClave()) == true) {
		// String valorBorrado = datos[i].getValor();
		// datos[i] = cvnull;
		// nDatos--;
		// return valorBorrado;
		// }
		// }
		return null;
	}

	/**
	 * @return nÃºmero de elementos almacenados.
	 */
	@Override
	public int size() {

		return nDatos;
	}

	/**
	 * Elimina todas las claves.
	 */
	@Override
	public void clear() {

		int i;
		nDatos = 0;
		for (i = 0; i < datos.length; i++) {
			datos[i] = null;
		}
	}

	public void print() {

		for (int i = 0; i < nDatos; i++) {
			System.out.println(datos[i].getClave());
		}
		System.out.println();
	}
}
