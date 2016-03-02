package es.upm.dit.adsw.ej2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Bateria de pruebas sobre DiccionarioLineal y DiccionarioHashMap.
 */
public class TestDiccionario2 {
	DiccionarioBinario datosDBinario = new DiccionarioBinario(5);
	BST datosBST = new BST();

	/**
	 * Ponemos un elemento
	 */
	@Test
	public void testPutLineal1() {
		datosDBinario.clear();
		datosDBinario.put("uno", "num1");
		assertEquals(datosDBinario.get("uno"), "num1");
	}

	/**
	 * Ponemos 4 elementos
	 */
	@Test
	public void testPutLineal2() {
		datosDBinario.clear();
		datosDBinario.put("uno", "num1");
		datosDBinario.put("dos", "num2");
		datosDBinario.put("tres", "num3");
		datosDBinario.put("cuatro", "num4");

		assertEquals(datosDBinario.get("uno"), "num1");
		assertEquals(datosDBinario.get("dos"), "num2");
		assertEquals(datosDBinario.get("tres"), "num3");
		assertEquals(datosDBinario.get("cuatro"), "num4");
	}

	/**
	 * Ponemos un elemento y lo sustituimos
	 */
	@Test
	public void testPutLineal3() {
		datosDBinario.clear();
		datosDBinario.put("uno", "num1");
		assertEquals(datosDBinario.get("uno"), "num1");
		datosDBinario.put("uno", "num1sustituto1");
		assertEquals(datosDBinario.get("uno"), "num1sustituto1");
	}

	/**
	 * Ponemos un elemento y lo sustituimos varias veces
	 */
	@Test
	public void testPutLineal4() {
		datosDBinario.clear();
		datosDBinario.put("uno", "num1");
		assertEquals(datosDBinario.get("uno"), "num1");
		datosDBinario.put("uno", "num1sustituto1");
		assertEquals(datosDBinario.get("uno"), "num1sustituto1");
		datosDBinario.put("uno", "num1sustituto2");
		assertEquals(datosDBinario.get("uno"), "num1sustituto2");
		datosDBinario.put("uno", "num1sustituto3");
		assertEquals(datosDBinario.get("uno"), "num1sustituto3");
	}

	/**
	 * Sustituimos dos elementos distintos simultaneamente
	 */
	@Test
	public void testPutLineal5() {
		datosDBinario.clear();
		datosDBinario.put("uno", "num1");
		assertEquals(datosDBinario.get("uno"), "num1");
		datosDBinario.put("uno", "num1sustituto");
		assertEquals(datosDBinario.get("uno"), "num1sustituto");
		datosDBinario.put("dos", "num2");
		assertEquals(datosDBinario.get("dos"), "num2");
		datosDBinario.put("dos", "num2sustituto");
		assertEquals(datosDBinario.get("dos"), "num2sustituto");
	}

	/**
	 * Sustituimos un elemento y lo ponemos com estaba al principio
	 */
	@Test
	public void testPutLineal6() {
		datosDBinario.clear();
		datosDBinario.put("uno", "num1");
		assertEquals(datosDBinario.get("uno"), "num1");
		datosDBinario.put("uno", "num1sustituto1");
		assertEquals(datosDBinario.get("uno"), "num1sustituto1");
		datosDBinario.put("uno", "num1");
		assertEquals(datosDBinario.get("uno"), "num1");
	}

	/**
	 * Ponemos el numero maximo de elentos, 5 en este caso
	 */
	@Test
	public void testPutLineal7() {
		datosDBinario.clear();
		datosDBinario.put("uno", "num1");
		datosDBinario.put("dos", "num2");
		datosDBinario.put("tres", "num3");
		datosDBinario.put("cuatro", "num4");
		datosDBinario.put("cinco", "num5");

		assertEquals(datosDBinario.get("uno"), "num1");
		assertEquals(datosDBinario.get("dos"), "num2");
		assertEquals(datosDBinario.get("tres"), "num3");
		assertEquals(datosDBinario.get("cuatro"), "num4");
		assertEquals(datosDBinario.get("cinco"), "num5");
	}

	/**
	 * Ponemos el numero maximo de elementos, y los sustituimos todos de golpe
	 */
	@Test
	public void testPutLineal8() {
		datosDBinario.clear();
		datosDBinario.put("uno", "num1");
		datosDBinario.put("dos", "num2");
		datosDBinario.put("tres", "num3");
		datosDBinario.put("cuatro", "num4");
		datosDBinario.put("cinco", "num5");

		datosDBinario.put("uno", "num1sust");
		datosDBinario.put("dos", "num2sust");
		datosDBinario.put("tres", "num3sust");
		datosDBinario.put("cuatro", "num4sust");
		datosDBinario.put("cinco", "num5sust");

		assertEquals(datosDBinario.get("uno"), "num1sust");
		assertEquals(datosDBinario.get("dos"), "num2sust");
		assertEquals(datosDBinario.get("tres"), "num3sust");
		assertEquals(datosDBinario.get("cuatro"), "num4sust");
		assertEquals(datosDBinario.get("cinco"), "num5sust");
	}

	/**
	 * Intentamos poner un elemento a un diccionario lleno, vemos que no cabe el
	 * elemento
	 */
	@Test(expected = RuntimeException.class)
	public void testPutLineal9() throws Exception {
		datosDBinario.put("uno", "num1");
		datosDBinario.put("dos", "num2");
		datosDBinario.put("tres", "num3");
		datosDBinario.put("cuatro", "num4");
		datosDBinario.put("cinco", "num5");
		datosDBinario.put("seis", "num6");
	}

	/**
	 * introducimos una clave nula
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPutLineal10() throws Exception {
		datosDBinario.clear();
		datosDBinario.put(null, "aloha");
	}

	/**
	 * Una clave vacia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPutLineal11() throws Exception {
		datosDBinario.clear();
		datosDBinario.put("", "aloha");
	}

	/**
	 * Vemos el tama�o de un diccionario vacio
	 */
	@Test
	public void testSizeLineal1() {
		datosDBinario.clear();
		assertEquals(datosDBinario.size(), 0);
	}

	/**
	 * Vemos el tama�o con un elemento
	 */
	@Test
	public void testSizeLineal2() {
		datosDBinario.clear();
		datosDBinario.put("zanahoria", "cosa naranja");
		assertEquals(datosDBinario.size(), 1);
	}

	/**
	 * Tama�o con el numero m�ximo de elementos
	 */
	@Test
	public void testSizeLineal3() {
		datosDBinario.clear();
		datosDBinario.put("uno", "num1");
		datosDBinario.put("dos", "num2");
		datosDBinario.put("tres", "num3");
		datosDBinario.put("cuatro", "num4");
		datosDBinario.put("cinco", "num5");
		assertEquals(datosDBinario.size(), 5);
	}

	/**
	 * Ponemos un elemento y lo quitamos
	 */
	@Test
	public void testRemoveLineal1() {
		datosDBinario.clear();
		datosDBinario.put("uno", "num1");
		assertEquals(datosDBinario.get("uno"), "num1");
		assertEquals(datosDBinario.size(),1);
		datosDBinario.remove("uno");
		assertEquals(datosDBinario.size(),0);
		
		assertNull(datosDBinario.get("uno"));
	}

	/**
	 * ponemos 5 elementos, quitamos 3
	 */
	@Test
	public void testRemoveLineal2() {
		datosDBinario.clear();
		datosDBinario.put("uno", "num1");
		datosDBinario.put("dos", "num2");
		datosDBinario.put("tres", "num3");
		datosDBinario.put("cuatro", "num4");
		datosDBinario.put("cinco", "num5");
		assertEquals(datosDBinario.size(),5);
		datosDBinario.print();
		
		datosDBinario.remove("uno");
		datosDBinario.print();
		datosDBinario.remove("dos");
		datosDBinario.print();
		datosDBinario.remove("tres");
		datosDBinario.print();

		assertNull(datosDBinario.get("uno"));
		assertNull(datosDBinario.get("dos"));
		assertNull(datosDBinario.get("tres"));
		assertEquals(datosDBinario.get("cuatro"), "num4");
		assertEquals(datosDBinario.get("cinco"), "num5");
	}

	/**
	 * Quitamos una clave nula
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveLineal3() throws Exception {
		datosDBinario.clear();
		datosDBinario.put("uno", "num1");
		datosDBinario.remove(null);
	}

	/**
	 * Quitamos una clave vacia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveLineal4() throws Exception {
		datosDBinario.clear();
		datosDBinario.put("uno", "num1");
		datosDBinario.remove("");
	}

	/**
	 * buscamos una clave nula
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetLineal1() throws Exception {
		datosDBinario.clear();
		datosDBinario.put("uno", "num1");
		datosDBinario.get(null);
	}

	/**
	 * Buscamos una clave vacia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetLineal2() throws Exception {
		datosDBinario.clear();
		datosDBinario.put("uno", "num1");
		datosDBinario.get("");
	}

	/**
	 * Buscamos una clave que no esta en el diccionario
	 */
	@Test
	public void testGetLineal3() {
		datosDBinario.clear();
		assertNull(datosDBinario.get("uno"));
	}

	/**
	 * Metemos tres elementos, y limpiamos el diccionario
	 */
	@Test
	public void testClearLineal1() {
		datosDBinario.put("uno", "num1");
		datosDBinario.put("dos", "num2");
		datosDBinario.put("tres", "num3");
		assertEquals(datosDBinario.size(), 3);
		datosDBinario.clear();
		assertEquals(datosDBinario.size(), 0);
	}

	/**
	 * Limpiamos un diccionario
	 */
	@Test
	public void testClearLineal2() {
		datosDBinario.clear();
		assertEquals(datosDBinario.size(), 0);
	}

	/**
	 * Limpiamos un diccionario, y luego introducimos un elemento
	 */
	@Test
	public void testClearLineal3() {
		datosDBinario.clear();
		// datosLineal.put("uno", "num1");
		// assertEquals(datosLineal.size(), 1);
		// datosLineal.clear();
		// assertEquals(datosLineal.size(), 0);
		// datosLineal.put("uno", "num1");
		// assertEquals(datosLineal.size(), 1);
	}


 /**
 * Ponemos un elemento
 */
 @Test
 public void testPutHashMap1() {
 datosBST.put("patata", "tuberculo");
 assertEquals(datosBST.get("patata"), "tuberculo");
 }

 /**
 * Ponemos 4 elementos
 */
 @Test
 public void testPutHashMap2() {
 datosBST.clear();
 datosBST.put("uno", "num1");
 datosBST.put("dos", "num2");
 datosBST.put("tres", "num3");
 datosBST.put("cuatro", "num4");
 assertEquals(datosBST.get("uno"), "num1");
 assertEquals(datosBST.get("dos"), "num2");
 assertEquals(datosBST.get("tres"), "num3");
 assertEquals(datosBST.get("cuatro"), "num4");
 }

 /**
 * Ponemos un elemento y lo sustituimos
 */
 @Test
 public void testPutHashMap3() {
 datosBST.clear();
 datosBST.put("uno", "num1");
 assertEquals(datosBST.get("uno"), "num1");
 datosBST.put("uno", "num1sustituto1");
 assertEquals(datosBST.get("uno"), "num1sustituto1");
 }

 /**
 * Ponemos un elemento y lo sustituimos varias veces
 */
 @Test
 public void testPutHashMap4() {
 datosBST.clear();
 datosBST.put("uno", "num1");
 assertEquals(datosBST.get("uno"), "num1");
 datosBST.put("uno", "num1sustituto1");
 assertEquals(datosBST.get("uno"), "num1sustituto1");
 datosBST.put("uno", "num1sustituto2");
 assertEquals(datosBST.get("uno"), "num1sustituto2");
 datosBST.put("uno", "num1sustituto3");
 assertEquals(datosBST.get("uno"), "num1sustituto3");
 }

 /**
 * Sustituimos dos elementos distintos simultaneamente
 */
 @Test
 public void testPutHashMap5() {
 datosBST.clear();
 datosBST.put("uno", "num1");
 assertEquals(datosBST.get("uno"), "num1");
 datosBST.put("uno", "num1sustituto");
 assertEquals(datosBST.get("uno"), "num1sustituto");
 datosBST.put("dos", "num2");
 assertEquals(datosBST.get("dos"), "num2");
 datosBST.put("dos", "num2sustituto");
 assertEquals(datosBST.get("dos"), "num2sustituto");
 }

 /**
 * Sustituimos un elemento y lo ponemos com estaba al principio
 */
 @Test
 public void testPutHashMap6() {
 datosBST.clear();
 datosBST.put("uno", "num1");
 assertEquals(datosBST.get("uno"), "num1");
 datosBST.put("uno", "num1sustituto1");
 assertEquals(datosBST.get("uno"), "num1sustituto1");
 datosBST.put("uno", "num1");
 assertEquals(datosBST.get("uno"), "num1");
 }

 /**
 * Ponemos 5 elementos
 */
 @Test
 public void testPutHashMap7() {
 datosBST.clear();
 datosBST.put("uno", "num1");
 datosBST.put("dos", "num2");
 datosBST.put("tres", "num3");
 datosBST.put("cuatro", "num4");
 datosBST.put("cinco", "num5");

 assertEquals(datosBST.get("uno"), "num1");
 assertEquals(datosBST.get("dos"), "num2");
 assertEquals(datosBST.get("tres"), "num3");
 assertEquals(datosBST.get("cuatro"), "num4");
 assertEquals(datosBST.get("cinco"), "num5");
 }

 /**
 * Ponemos 5, y los sustituimos todos de golpe
 */
 @Test
 public void testPutHashMap8() {
 datosBST.clear();
 datosBST.put("uno", "num1");
 datosBST.put("dos", "num2");
 datosBST.put("tres", "num3");
 datosBST.put("cuatro", "num4");
 datosBST.put("cinco", "num5");

 datosBST.put("uno", "num1sust");
 datosBST.put("dos", "num2sust");
 datosBST.put("tres", "num3sust");
 datosBST.put("cuatro", "num4sust");
 datosBST.put("cinco", "num5sust");

 assertEquals(datosBST.get("uno"), "num1sust");
 assertEquals(datosBST.get("dos"), "num2sust");
 assertEquals(datosBST.get("tres"), "num3sust");
 assertEquals(datosBST.get("cuatro"), "num4sust");
 assertEquals(datosBST.get("cinco"), "num5sust");
 }

 /**
 * introducimos una clave nula
 */
 @Test(expected = IllegalArgumentException.class)
 public void testPutHashMap10() throws Exception {
 datosBST.clear();
 datosBST.put(null, "aloha");
 }

 /**
 * Una clave vacia
 */
 @Test(expected = IllegalArgumentException.class)
 public void testPutHashMap11() throws Exception {
 datosBST.clear();
 datosBST.put("", "aloha");
 }

 /**
 * Vemos el tama�o de un diccionario vacio
 */
 @Test
 public void testSizeHashMap1() {
 datosBST.clear();
 assertEquals(datosBST.size(), 0);
 }

 /**
 * Vemos el tama�o con un elemento
 */
 @Test
 public void testSizeHashMap2() {
 datosBST.clear();
 datosBST.put("zanahoria", "cosa naranja");
 assertEquals(datosBST.size(), 1);
 }

 /**
 * Tama�o 5 elementos
 */
 @Test
 public void testSizeHashMap3() {
 datosBST.clear();
 datosBST.put("uno", "num1");
 datosBST.put("dos", "num2");
 datosBST.put("tres", "num3");
 datosBST.put("cuatro", "num4");
 datosBST.put("cinco", "num5");
 assertEquals(datosBST.size(), 5);
 }

 /**
 * Ponemos un elemento y lo quitamos
 */
 @Test
 public void testRemoveHashMap1() {
 datosBST.clear();
 datosBST.put("uno", "num1");
 assertEquals(datosBST.get("uno"), "num1");
 datosBST.remove("uno");
 assertNull(datosBST.get("uno"));
 }

 /**
 * ponemos 5 elementos, quitamos 3
 */
 @Test
 public void testRemoveHashMap2() {
 datosBST.clear();
 datosBST.put("uno", "num1");
 datosBST.put("dos", "num2");
 datosBST.put("tres", "num3");
 datosBST.put("cuatro", "num4");
 datosBST.put("cinco", "num5");

 datosBST.remove("uno");
 datosBST.remove("dos");
 datosBST.remove("tres");

 assertNull(datosBST.get("uno"));
 assertNull(datosBST.get("dos"));
 assertNull(datosBST.get("tres"));
 assertEquals(datosBST.get("cuatro"), "num4");
 assertEquals(datosBST.get("cinco"), "num5");
 }

 /**
 * Quitamos una clave nula
 */
 @Test(expected = IllegalArgumentException.class)
 public void testRemoveHashMap3() throws Exception {
 datosBST.clear();
 datosBST.put("uno", "num1");
 datosBST.remove(null);
 }

 /**
 * Quitamos una clave vacia
 */
 @Test(expected = IllegalArgumentException.class)
 public void testRemoveHashMap4() throws Exception {
 datosBST.clear();
 datosBST.put("uno", "num1");
 datosBST.remove("");
 }

 /**
 * buscamos una clave nula
 */
 @Test(expected = IllegalArgumentException.class)
 public void testGetHashMap1() throws Exception {
 datosBST.clear();
 datosBST.put("uno", "num1");
 datosBST.get(null);
 }

 /**
 * Buscamos una clave vacia
 */
 @Test(expected = IllegalArgumentException.class)
 public void testGetHashMap2() throws Exception {
 datosBST.clear();
 datosBST.put("uno", "num1");
 datosBST.get("");
 }

 /**
 * Buscamos una clave que no esta en el diccionario
 */
 @Test
 public void testGetHashMap3() {
 datosBST.clear();
 assertNull(datosBST.get("uno"));
 }

 /**
 * Metemos tres elementos, y limpiamos el diccionario
 */
 @Test
 public void testClearHashMap1() {
 datosBST.put("uno", "num1");
 datosBST.put("dos", "num2");
 datosBST.put("tres", "num3");
 assertEquals(datosBST.size(), 3);
 datosBST.clear();
 assertEquals(datosBST.size(), 0);
 }

 /**
 * Limpiamos un diccionario
 */
 @Test
 public void testClearHashMap2() {
 datosBST.clear();
 assertEquals(datosBST.size(), 0);
 }

 /**
 * Limpiamos un diccionario, y luego introducimos un elemento
 */
 @Test
 public void testClearHashMap3() {
 datosBST.clear();
 datosBST.put("uno", "num1");
 assertEquals(datosBST.size(), 1);
 datosBST.clear();
 assertEquals(datosBST.size(), 0);
 datosBST.put("uno", "num1");
 assertEquals(datosBST.size(), 1);
 }
 }
