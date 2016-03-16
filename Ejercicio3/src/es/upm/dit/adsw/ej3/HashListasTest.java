package es.upm.dit.adsw.ej3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Bateria de pruebas sobre DiccionarioLineal y DiccionarioHashMap.
 */
public class HashListasTest {
	HashListas datosHashListas = new HashListas(3);

	/**
	 * Falla si no consigue meter un elemento
	 */
	@Test
	public void testPutLineal1() {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		assertEquals(datosHashListas.get("uno"), "num1");
	}

	/**
	 * Falla si no pone 4 elementos y luego los devuelve
	 */
	@Test
	public void testPutLineal2() {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		datosHashListas.put("dos", "num2");
		datosHashListas.put("tres", "num3");
		datosHashListas.put("cuatro", "num4");

		datosHashListas.print();

		assertEquals(datosHashListas.get("uno"), "num1");
		assertEquals(datosHashListas.get("dos"), "num2");
		assertEquals(datosHashListas.get("tres"), "num3");
		assertEquals(datosHashListas.get("cuatro"), "num4");
	}

	/**
	 * Falla si no devuelve el valor actualizado
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
	 * Falla si no devuelve el valor segun se actualiza
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
	 * Falla si no devuelve los distintos valores actualziados
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
	 * Falla si no devuelve el valor original despues de haberlo actualizado
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
	 * Falla si no devuelve el valor original despues de volver a introducirlo
	 */
	@Test
	public void testPutLineal7() {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		assertEquals(datosHashListas.get("uno"), "num1");

		datosHashListas.put("uno", "num1");
		assertEquals(datosHashListas.get("uno"), "num1");
	}

	/**
	 * Falla si no deveulve los valores actualziados
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
	 * Falla si al introducir una clave nula no devuelve la excepción
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPutLineal10() throws Exception {
		datosHashListas.clear();
		datosHashListas.put(null, "aloha");
	}

	/**
	 * Falla si al introducir una clave vacia no devuelve excepcion
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPutLineal11() throws Exception {
		datosHashListas.clear();
		datosHashListas.put("", "aloha");
	}

	/**
	 * Falla si el tamaño de un diccionario vacio difiere de cero
	 */
	@Test
	public void testSizeLineal1() {
		datosHashListas.clear();
		assertEquals(datosHashListas.size(), 0);
	}

	/**
	 * Falla si al meter un elemento no devuelve el tamaño adecuado
	 */
	@Test
	public void testSizeLineal2() {
		datosHashListas.clear();
		datosHashListas.put("zanahoria", "cosa naranja");
		assertEquals(datosHashListas.size(), 1);
	}

	/**
	 * Falla si no devuelve el tamaño adecuado con cinco elementos
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
	 * Falla si al quitar un elemento el tamaño no se actualiza
	 */
	@Test
	public void testRemoveLineal1() {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		assertEquals(datosHashListas.get("uno"), "num1");
		assertEquals(datosHashListas.size(), 1);
		datosHashListas.remove("uno");
		assertEquals(datosHashListas.size(), 0);

		assertNull(datosHashListas.get("uno"));
	}

	/**
	 * Falla si al meter 5 y quitar 3 elementos no devuelve el tamaño correcto
	 */
	@Test
	public void testRemoveLineal2() {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		datosHashListas.put("dos", "num2");
		datosHashListas.put("tres", "num3");
		datosHashListas.put("cuatro", "num4");
		datosHashListas.put("cinco", "num5");
		assertEquals(datosHashListas.size(), 5);

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
	 * Falla si al quitar una clave nula no devuelve excepcion
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveLineal3() throws Exception {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		datosHashListas.remove(null);
	}

	/**
	 * Falla si al quitar una clave vacia no devuelve excepcion
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveLineal4() throws Exception {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		datosHashListas.remove("");
	}

	/**
	 * Falla si al pedir una clave nula no devuelve excepcion
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetLineal1() throws Exception {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		datosHashListas.get(null);
	}

	/**
	 * Falla si al pedir una clave vacia no devuelve excepcion
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetLineal2() throws Exception {
		datosHashListas.clear();
		datosHashListas.put("uno", "num1");
		datosHashListas.get("");
	}

	/**
	 * Falla si al pedir una clave que no está no devuelve null
	 */
	@Test
	public void testGetLineal3() {
		datosHashListas.clear();
		assertNull(datosHashListas.get("uno"));
	}

	/**
	 * Falla si al limpiar un diccionaria el tamaño no es 0
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
	 * Falla si al limpiar un diccionario vacio el tamaño no es 0
	 */
	@Test
	public void testClearLineal2() {
		datosHashListas.clear();
		assertEquals(datosHashListas.size(), 0);
	}

	/**
	 * Falla si al limpiar un diccionario y luego introducir un elemnto no
	 * devuelve el tamaño correcto
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
