package es.upm.dit.adsw.ej6;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Bateria de pruebas sobre DiccionarioLineal y DiccionarioHashMap.
 */
public class TsCacheTest {
	TsCache cache = new TsCache(3);

	/**
	 * Falla si no consigue meter un elemento
	 */
	@Test
	public void testPutLineal1() {
		cache.put("uno", "num1");
		assertEquals(cache.get("uno"), "num1");
	}

	/**
	 * Falla si no pone 4 elementos y luego los devuelve
	 */
	@Test
	public void testPutLineal2() {
		cache.put("uno", "num1");
		cache.put("dos", "num2");
		cache.put("tres", "num3");
		cache.put("cuatro", "num4");

		assertEquals(cache.get("uno"), "num1");
		assertEquals(cache.get("dos"), "num2");
		assertEquals(cache.get("tres"), "num3");
		assertEquals(cache.get("cuatro"), "num4");
	}

	/**
	 * Falla si no devuelve el valor actualizado
	 */
	@Test
	public void testPutLineal3() {
		cache.put("uno", "num1");
		assertEquals(cache.get("uno"), "num1");
		cache.put("uno", "num1sustituto1");
		assertEquals(cache.get("uno"), "num1sustituto1");
	}

	/**
	 * Falla si no devuelve el valor segun se actualiza
	 */
	@Test
	public void testPutLineal4() {
		cache.clear();
		cache.put("uno", "num1");
		assertEquals(cache.get("uno"), "num1");
		cache.put("uno", "num1sustituto1");
		assertEquals(cache.get("uno"), "num1sustituto1");
		cache.put("uno", "num1sustituto2");
		assertEquals(cache.get("uno"), "num1sustituto2");
		cache.put("uno", "num1sustituto3");
		assertEquals(cache.get("uno"), "num1sustituto3");
	}

	/**
	 * Falla si no devuelve los distintos valores actualziados
	 */
	@Test
	public void testPutLineal5() {
		cache.clear();
		cache.put("uno", "num1");
		assertEquals(cache.get("uno"), "num1");
		cache.put("uno", "num1sustituto");
		assertEquals(cache.get("uno"), "num1sustituto");
		cache.put("dos", "num2");
		assertEquals(cache.get("dos"), "num2");
		cache.put("dos", "num2sustituto");
		assertEquals(cache.get("dos"), "num2sustituto");
	}

	/**
	 * Falla si no devuelve el valor original despues de haberlo actualizado
	 */
	@Test
	public void testPutLineal6() {
		cache.clear();
		cache.put("uno", "num1");
		assertEquals(cache.get("uno"), "num1");
		cache.put("uno", "num1sustituto1");
		assertEquals(cache.get("uno"), "num1sustituto1");
		cache.put("uno", "num1");
		assertEquals(cache.get("uno"), "num1");
	}

	/**
	 * Falla si no devuelve el valor original despues de volver a introducirlo
	 */
	@Test
	public void testPutLineal7() {
		cache.clear();
		cache.put("uno", "num1");
		assertEquals(cache.get("uno"), "num1");

		cache.put("uno", "num1");
		assertEquals(cache.get("uno"), "num1");
	}

	/**
	 * Falla si no deveulve los valores actualziados
	 */
	@Test
	public void testPutLineal8() {
		cache.clear();
		cache.put("uno", "num1");
		cache.put("dos", "num2");
		cache.put("tres", "num3");
		cache.put("cuatro", "num4");
		cache.put("cinco", "num5");

		cache.put("uno", "num1sust");
		cache.put("dos", "num2sust");
		cache.put("tres", "num3sust");
		cache.put("cuatro", "num4sust");
		cache.put("cinco", "num5sust");

		assertEquals(cache.get("uno"), "num1sust");
		assertEquals(cache.get("dos"), "num2sust");
		assertEquals(cache.get("tres"), "num3sust");
		assertEquals(cache.get("cuatro"), "num4sust");
		assertEquals(cache.get("cinco"), "num5sust");
	}

	/**
	 * Falla si al introducir una clave nula no devuelve la excepci�n
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPutLineal10() throws Exception {
		cache.clear();
		cache.put(null, "aloha");
	}

	/**
	 * Falla si al introducir una clave vacia no devuelve excepcion
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPutLineal11() throws Exception {
		cache.clear();
		cache.put("", "aloha");
	}

	/**
	 * Falla si el tama�o de un diccionario vacio difiere de cero
	 */
	@Test
	public void testSizeLineal1() {
		cache.clear();
		assertEquals(cache.size(), 0);
	}

	/**
	 * Falla si al meter un elemento no devuelve el tama�o adecuado
	 */
	@Test
	public void testSizeLineal2() {
		cache.clear();
		cache.put("zanahoria", "cosa naranja");
	}

	/**
	 * Falla si no devuelve el tama�o adecuado con cinco elementos
	 */
	@Test
	public void testSizeLineal3() {
		cache.clear();
		cache.put("uno", "num1");
		cache.put("dos", "num2");
		cache.put("tres", "num3");
		cache.put("cuatro", "num4");
		cache.put("cinco", "num5");
	}

	/**
	 * Falla si al quitar un elemento el tama�o no se actualiza
	 */
	@Test
	public void testRemoveLineal1() {
		cache.clear();
		cache.put("uno", "num1");
		assertEquals(cache.get("uno"), "num1");
		cache.remove("uno");

		assertNull(cache.get("uno"));
	}

	/**
	 * Falla si al meter 5 y quitar 3 elementos no devuelve el tama�o correcto
	 */
	@Test
	public void testRemoveLineal2() {
		cache.clear();
		cache.put("uno", "num1");
		cache.put("dos", "num2");
		cache.put("tres", "num3");
		cache.put("cuatro", "num4");
		cache.put("cinco", "num5");

		cache.remove("uno");
		cache.remove("dos");
		cache.remove("tres");

		assertNull(cache.get("uno"));
		assertNull(cache.get("dos"));
		assertNull(cache.get("tres"));
		assertEquals(cache.get("cuatro"), "num4");
		assertEquals(cache.get("cinco"), "num5");
	}

	/**
	 * Falla si al quitar una clave nula no devuelve excepcion
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveLineal3() throws Exception {
		cache.clear();
		cache.put("uno", "num1");
		cache.remove(null);
	}

	/**
	 * Falla si al quitar una clave vacia no devuelve excepcion
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveLineal4() throws Exception {
		cache.clear();
		cache.put("uno", "num1");
		cache.remove("");
	}

	/**
	 * Falla si al pedir una clave nula no devuelve excepcion
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetLineal1() throws Exception {
		cache.clear();
		cache.put("uno", "num1");
		cache.get(null);
	}

	/**
	 * Falla si al pedir una clave vacia no devuelve excepcion
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetLineal2() throws Exception {
		cache.clear();
		cache.put("uno", "num1");
		cache.get("");
	}

	/**
	 * Falla si al pedir una clave que no est� no devuelve null
	 */
	@Test
	public void testGetLineal3() {
		cache.clear();
		assertNull(cache.get("uno"));
	}

	/**
	 * Falla si al limpiar un diccionario vacio el tama�o no es 0
	 */
	@Test
	public void testClearLineal2() {
		cache.clear();
		assertEquals(cache.size(), 0);
	}
}