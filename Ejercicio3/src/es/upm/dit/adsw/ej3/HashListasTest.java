package es.upm.dit.adsw.ej3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Bateria de pruebas sobre DiccionarioLineal y DiccionarioHashMap.
 */
public class HashListasTest {
	HashListas datosHashListas = new HashListas(3);
	
	/**
	 * Ponemos un elemento
	 */
	@Test
	public void testPutLineal1() {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		assertEquals(datosHashListas.get("uno"), "num1");
	}

	/**
	 * Ponemos 4 elementos
	 */
	@Test
	public void testPutLineal2() {
//		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		datosHashListas.put("dos", "num2");
		datosHashListas.put("tres", "num3");
//		datosHashListas.put("cuatro", "num4");
		
//		datosHashListas.print();

		assertEquals(datosHashListas.get("uno"), "num1");
		assertEquals(datosHashListas.get("dos"), "num2");
		assertEquals(datosHashListas.get("tres"), "num3");
//		assertEquals(datosHashListas.get("cuatro"), "num4");
	}

	/**
	 * Ponemos un elemento y lo sustituimos
	 */
	@Test
	public void testPutLineal3() {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		assertEquals(datosHashListas.get("uno"), "num1");
		datosHashListas.put("uno", "num1sustituto1");
		assertEquals(datosHashListas.get("uno"), "num1sustituto1");
	}

	/**
	 * Ponemos un elemento y lo sustituimos varias veces
	 */
	@Test
	public void testPutLineal4() {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		assertEquals(datosHashListas.get("uno"), "num1");
		datosHashListas.put("uno", "num1sustituto1");
		assertEquals(datosHashListas.get("uno"), "num1sustituto1");
		datosHashListas.put("uno", "num1sustituto2");
		assertEquals(datosHashListas.get("uno"), "num1sustituto2");
		datosHashListas.put("uno", "num1sustituto3");
		assertEquals(datosHashListas.get("uno"), "num1sustituto3");
	}

	/**
	 * Sustituimos dos elementos distintos simultaneamente
	 */
	@Test
	public void testPutLineal5() {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		assertEquals(datosHashListas.get("uno"), "num1");
		datosHashListas.put("uno", "num1sustituto");
		assertEquals(datosHashListas.get("uno"), "num1sustituto");
		datosHashListas.put("dos", "num2");
		assertEquals(datosHashListas.get("dos"), "num2");
		datosHashListas.put("dos", "num2sustituto");
		assertEquals(datosHashListas.get("dos"), "num2sustituto");
	}

	/**
	 * Sustituimos un elemento y lo ponemos com estaba al principio
	 */
	@Test
	public void testPutLineal6() {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		assertEquals(datosHashListas.get("uno"), "num1");
		datosHashListas.put("uno", "num1sustituto1");
		assertEquals(datosHashListas.get("uno"), "num1sustituto1");
		datosHashListas.put("uno", "num1");
		assertEquals(datosHashListas.get("uno"), "num1");
	}

	/**
	 * Ponemos el numero maximo de elentos, 5 en este caso
	 */
	@Test
	public void testPutLineal7() {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		datosHashListas.put("dos", "num2");
		datosHashListas.put("tres", "num3");
		datosHashListas.put("cuatro", "num4");
		datosHashListas.put("cinco", "num5");

		assertEquals(datosHashListas.get("uno"), "num1");
		assertEquals(datosHashListas.get("dos"), "num2");
		assertEquals(datosHashListas.get("tres"), "num3");
		assertEquals(datosHashListas.get("cuatro"), "num4");
		assertEquals(datosHashListas.get("cinco"), "num5");
	}

	/**
	 * Ponemos el numero maximo de elementos, y los sustituimos todos de golpe
	 */
	@Test
	public void testPutLineal8() {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		datosHashListas.put("dos", "num2");
		datosHashListas.put("tres", "num3");
		datosHashListas.put("cuatro", "num4");
		datosHashListas.put("cinco", "num5");

		datosHashListas.put("uno", "num1sust");
		datosHashListas.put("dos", "num2sust");
		datosHashListas.put("tres", "num3sust");
		datosHashListas.put("cuatro", "num4sust");
		datosHashListas.put("cinco", "num5sust");

		assertEquals(datosHashListas.get("uno"), "num1sust");
		assertEquals(datosHashListas.get("dos"), "num2sust");
		assertEquals(datosHashListas.get("tres"), "num3sust");
		assertEquals(datosHashListas.get("cuatro"), "num4sust");
		assertEquals(datosHashListas.get("cinco"), "num5sust");
	}

	/**
	 * Intentamos poner un elemento a un diccionario lleno, vemos que no cabe el
	 * elemento
	 */
	@Test(expected = RuntimeException.class)
	public void testPutLineal9() throws Exception {
		datosHashListas.put("uno", "num1");
		datosHashListas.put("dos", "num2");
		datosHashListas.put("tres", "num3");
		datosHashListas.put("cuatro", "num4");
		datosHashListas.put("cinco", "num5");
		datosHashListas.put("seis", "num6");
	}

	/**
	 * introducimos una clave nula
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPutLineal10() throws Exception {
		datosHashListas.clear();
		datosHashListas.put(null, "aloha");
	}

	/**
	 * Una clave vacia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPutLineal11() throws Exception {
		datosHashListas.clear();
		datosHashListas.put("", "aloha");
	}

	/**
	 * Vemos el tama�o de un diccionario vacio
	 */
	@Test
	public void testSizeLineal1() {
		datosHashListas.clear();
		assertEquals(datosHashListas.size(), 0);
	}

	/**
	 * Vemos el tama�o con un elemento
	 */
	@Test
	public void testSizeLineal2() {
		datosHashListas.clear();
		datosHashListas.put("zanahoria", "cosa naranja");
		assertEquals(datosHashListas.size(), 1);
	}

	/**
	 * Tama�o con el numero m�ximo de elementos
	 */
	@Test
	public void testSizeLineal3() {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		datosHashListas.put("dos", "num2");
		datosHashListas.put("tres", "num3");
		datosHashListas.put("cuatro", "num4");
		datosHashListas.put("cinco", "num5");
		assertEquals(datosHashListas.size(), 5);
	}

	/**
	 * Ponemos un elemento y lo quitamos
	 */
	@Test
	public void testRemoveLineal1() {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		assertEquals(datosHashListas.get("uno"), "num1");
		assertEquals(datosHashListas.size(),1);
		datosHashListas.remove("uno");
		assertEquals(datosHashListas.size(),0);
		
		assertNull(datosHashListas.get("uno"));
	}

	/**
	 * ponemos 5 elementos, quitamos 3
	 */
	@Test
	public void testRemoveLineal2() {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		datosHashListas.put("dos", "num2");
		datosHashListas.put("tres", "num3");
		datosHashListas.put("cuatro", "num4");
		datosHashListas.put("cinco", "num5");
		assertEquals(datosHashListas.size(),5);
		
		datosHashListas.remove("uno");
		datosHashListas.remove("dos");
		datosHashListas.remove("tres");

		assertNull(datosHashListas.get("uno"));
		assertNull(datosHashListas.get("dos"));
		assertNull(datosHashListas.get("tres"));
		assertEquals(datosHashListas.get("cuatro"), "num4");
		assertEquals(datosHashListas.get("cinco"), "num5");
	}

	/**
	 * Quitamos una clave nula
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveLineal3() throws Exception {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		datosHashListas.remove(null);
	}

	/**
	 * Quitamos una clave vacia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveLineal4() throws Exception {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		datosHashListas.remove("");
	}

	/**
	 * buscamos una clave nula
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetLineal1() throws Exception {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		datosHashListas.get(null);
	}

	/**
	 * Buscamos una clave vacia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetLineal2() throws Exception {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		datosHashListas.get("");
	}

	/**
	 * Buscamos una clave que no esta en el diccionario
	 */
	@Test
	public void testGetLineal3() {
		datosHashListas.clear();
		assertNull(datosHashListas.get("uno"));
	}

	/**
	 * Metemos tres elementos, y limpiamos el diccionario
	 */
	@Test
	public void testClearLineal1() {
		datosHashListas.put("uno", "num1");
		datosHashListas.put("dos", "num2");
		datosHashListas.put("tres", "num3");
		assertEquals(datosHashListas.size(), 3);
		datosHashListas.clear();
		assertEquals(datosHashListas.size(), 0);
	}

	/**
	 * Limpiamos un diccionario
	 */
	@Test
	public void testClearLineal2() {
		datosHashListas.clear();
		assertEquals(datosHashListas.size(), 0);
	}

	/**
	 * Limpiamos un diccionario, y luego introducimos un elemento
	 */
	@Test
	public void testClearLineal3() {
		datosHashListas.clear();
		 datosHashListas.put("uno", "num1");
		 assertEquals(datosHashListas.size(), 1);
		 datosHashListas.clear();
		 assertEquals(datosHashListas.size(), 0);
		 datosHashListas.put("uno", "num1");
		 assertEquals(datosHashListas.size(), 1);
	}

}
