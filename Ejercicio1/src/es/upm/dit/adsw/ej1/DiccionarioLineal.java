package es.upm.dit.adsw.ej1;

public class DiccionarioLineal implements Diccionario {

	private final CV[] datos;
	private int nDatos = 0;
	CV cvnull = new CV(null, null);

	public DiccionarioLineal(int max) {
		datos = new CV[max];
		for (int i = 0; i < max; i++) {
			datos[i] = cvnull;
		}
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

		int i;
		int j;
		boolean contenido = false;

		// Comprueba que la clave se encuentra en el array, y sobreescribe el
		// valor.
		for (i = 0; i < datos.length; i++) {
			if (clave.equals(datos[i].getClave()) == true){
				datos[i].setValor(valor);
				contenido = true;
				break;
			}

		}
		// En caso de que el objeto no esté presente, Buscamos la primera
		// posición libre y metemos la CV y nDatos +1
		if (contenido == false) {

			for (j = 0; j < datos.length; j++) {
				if (datos[j].getClave() == null) {

					CV objetoCV = new CV(clave, valor);
					datos[j] = objetoCV;

					break;
				}
			}
			nDatos++;
			if (nDatos > datos.length) {
				throw new RuntimeException();
			}
		}

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
		int i;
		for (i = 0; i < datos.length; i++) {
			if (clave.equals(datos[i].getClave()) == true){
				return datos[i].getValor();
			}
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
		int i;
		for (i = 0; i < datos.length; i++) {
			if (clave.equals(datos[i].getClave()) == true){
				String valorBorrado = datos[i].getValor();
				datos[i] = cvnull;
				nDatos--;
				return valorBorrado;
			}
		}
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
			datos[i] = cvnull;
		}
	}
}
