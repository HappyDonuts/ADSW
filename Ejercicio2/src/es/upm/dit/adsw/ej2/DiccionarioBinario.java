package es.upm.dit.adsw.ej2;

public class DiccionarioBinario implements Diccionario {

	private final CV[] datos;
	private int nDatos = 0;

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
		int buscaClave = busca(clave);
		if ((datos[buscaClave] != null)
				&& (datos[buscaClave].getClave() == clave)) {
			datos[buscaClave].setValor(valor);
			return;
		}
		// Si el nmero de datos es igual o superior al tamaño del array, no cabe
		// la clave
		if (nDatos >= datos.length) {
			throw new RuntimeException();
		}

		// Si la clave no está presente y hay sitio, introduce la clave-valor, y
		// luego ordena el array
		CV objetoCV = new CV(clave, valor);
		
		
		
		System.arraycopy(datos, buscaClave , datos,
				buscaClave+1, nDatos  - buscaClave);
		datos[buscaClave] = objetoCV;
		nDatos++;

	}

	/**
	 * Busca la posición del array en la cual está la clave
	 *
	 * @param clave
	 * @return la posicion en la cual está o debería
	 * @throws IllegalArgumentException
	 *             Si clave es null.
	 * @throws IllegalArgumentException
	 *             Si clave es la cadena vacia.
	 */
	private int busca(String clave) {

		if ((clave == null) || (clave.isEmpty() == true)) {
			throw new IllegalArgumentException();
		}

		int a = 0;
		int z = nDatos - 1;
		while (a < z) {
			int m = (a + z) / 2;
//			int cmp = clave.compareTo(datos[m].getClave());
			int cmp = OpMeter.compareTo(clave,datos[m].getClave());
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
		int buscaClave= busca(clave);
		if ((datos[buscaClave] != null)
				&& (datos[buscaClave].getClave() == clave)) {
			return datos[buscaClave].getValor();
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
		int buscaClave = busca(clave);
		if ((datos[buscaClave] != null)
				&& (datos[buscaClave].getClave() == clave)) {
			String valorBorrado = datos[buscaClave].getValor();
			datos[buscaClave] = null;
			
				System.arraycopy(datos, buscaClave+1 , datos,
						buscaClave, nDatos -1 - buscaClave);
				nDatos--;
				datos[nDatos]=null;
				
				check();
				return valorBorrado;
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
			datos[i] = null;
		}
	}

	/**
	 * Imprime el array, sirve para depurar y poder ver las claves del array
	 */
	public void print() {

		for (int i = 0; i < datos.length; i++) {
			if (datos[i] != null) {
				System.out.println(datos[i].getClave());
			}
			if(datos[i]==null){
				System.out.println("NULL");
			}
		}
		System.out.println();
	}
	
	private void check() {
		int pos = 0;
		while (pos < datos.length && datos[pos] != null) {
		if (pos + 1 < datos.length && datos[pos + 1] != null) {
		String k1 = datos[pos].getClave();
		String k2 = datos[pos + 1].getClave();
		if (k1.compareTo(k2) > 0)
		System.err.println("ERROR: datos desordenados");
		if (k1.equals(k2))
		System.err.println("ERROR: datos duplicados");
		}
		pos++;
		}
		if (pos != nDatos)
		System.err.println("ERROR: datos mal contados");
		while (pos < datos.length) {
		if (datos[pos] != null)
		System.err.println("ERROR: datos en la zona vacia");
		pos++;
		}
		}
}
