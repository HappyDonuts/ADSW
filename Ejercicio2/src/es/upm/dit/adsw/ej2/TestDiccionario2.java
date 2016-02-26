package es.upm.dit.adsw.ej2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Bateria de pruebas sobre DiccionarioLineal y DiccionarioHashMap.
 */
public class TestDiccionario2 {
	DiccionarioBinario datosDBinario = new DiccionarioBinario(5);
	// DiccionarioHashMap datosHashMap = new DiccionarioHashMap();

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
		datosDBinario.print();
		datosDBinario.remove("uno");
		datosDBinario.print();
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
}

// /**
// * Ponemos un elemento
// */
// @Test
// public void testPutHashMap1() {
// datosHashMap.put("patata", "tuberculo");
// assertEquals(datosHashMap.get("patata"), "tuberculo");
// }
//
// /**
// * Ponemos 4 elementos
// */
// @Test
// public void testPutHashMap2() {
// datosHashMap.clear();
// datosHashMap.put("uno", "num1");
// datosHashMap.put("dos", "num2");
// datosHashMap.put("tres", "num3");
// datosHashMap.put("cuatro", "num4");
// assertEquals(datosHashMap.get("uno"), "num1");
// assertEquals(datosHashMap.get("dos"), "num2");
// assertEquals(datosHashMap.get("tres"), "num3");
// assertEquals(datosHashMap.get("cuatro"), "num4");
// }
//
// /**
// * Ponemos un elemento y lo sustituimos
// */
// @Test
// public void testPutHashMap3() {
// datosHashMap.clear();
// datosHashMap.put("uno", "num1");
// assertEquals(datosHashMap.get("uno"), "num1");
// datosHashMap.put("uno", "num1sustituto1");
// assertEquals(datosHashMap.get("uno"), "num1sustituto1");
// }
//
// /**
// * Ponemos un elemento y lo sustituimos varias veces
// */
// @Test
// public void testPutHashMap4() {
// datosHashMap.clear();
// datosHashMap.put("uno", "num1");
// assertEquals(datosHashMap.get("uno"), "num1");
// datosHashMap.put("uno", "num1sustituto1");
// assertEquals(datosHashMap.get("uno"), "num1sustituto1");
// datosHashMap.put("uno", "num1sustituto2");
// assertEquals(datosHashMap.get("uno"), "num1sustituto2");
// datosHashMap.put("uno", "num1sustituto3");
// assertEquals(datosHashMap.get("uno"), "num1sustituto3");
// }
//
// /**
// * Sustituimos dos elementos distintos simultaneamente
// */
// @Test
// public void testPutHashMap5() {
// datosHashMap.clear();
// datosHashMap.put("uno", "num1");
// assertEquals(datosHashMap.get("uno"), "num1");
// datosHashMap.put("uno", "num1sustituto");
// assertEquals(datosHashMap.get("uno"), "num1sustituto");
// datosHashMap.put("dos", "num2");
// assertEquals(datosHashMap.get("dos"), "num2");
// datosHashMap.put("dos", "num2sustituto");
// assertEquals(datosHashMap.get("dos"), "num2sustituto");
// }
//
// /**
// * Sustituimos un elemento y lo ponemos com estaba al principio
// */
// @Test
// public void testPutHashMap6() {
// datosHashMap.clear();
// datosHashMap.put("uno", "num1");
// assertEquals(datosHashMap.get("uno"), "num1");
// datosHashMap.put("uno", "num1sustituto1");
// assertEquals(datosHashMap.get("uno"), "num1sustituto1");
// datosHashMap.put("uno", "num1");
// assertEquals(datosHashMap.get("uno"), "num1");
// }
//
// /**
// * Ponemos 5 elementos
// */
// @Test
// public void testPutHashMap7() {
// datosHashMap.clear();
// datosHashMap.put("uno", "num1");
// datosHashMap.put("dos", "num2");
// datosHashMap.put("tres", "num3");
// datosHashMap.put("cuatro", "num4");
// datosHashMap.put("cinco", "num5");
//
// assertEquals(datosHashMap.get("uno"), "num1");
// assertEquals(datosHashMap.get("dos"), "num2");
// assertEquals(datosHashMap.get("tres"), "num3");
// assertEquals(datosHashMap.get("cuatro"), "num4");
// assertEquals(datosHashMap.get("cinco"), "num5");
// }
//
// /**
// * Ponemos 5, y los sustituimos todos de golpe
// */
// @Test
// public void testPutHashMap8() {
// datosHashMap.clear();
// datosHashMap.put("uno", "num1");
// datosHashMap.put("dos", "num2");
// datosHashMap.put("tres", "num3");
// datosHashMap.put("cuatro", "num4");
// datosHashMap.put("cinco", "num5");
//
// datosHashMap.put("uno", "num1sust");
// datosHashMap.put("dos", "num2sust");
// datosHashMap.put("tres", "num3sust");
// datosHashMap.put("cuatro", "num4sust");
// datosHashMap.put("cinco", "num5sust");
//
// assertEquals(datosHashMap.get("uno"), "num1sust");
// assertEquals(datosHashMap.get("dos"), "num2sust");
// assertEquals(datosHashMap.get("tres"), "num3sust");
// assertEquals(datosHashMap.get("cuatro"), "num4sust");
// assertEquals(datosHashMap.get("cinco"), "num5sust");
// }
//
// /**
// * introducimos una clave nula
// */
// @Test(expected = IllegalArgumentException.class)
// public void testPutHashMap10() throws Exception {
// datosHashMap.clear();
// datosHashMap.put(null, "aloha");
// }
//
// /**
// * Una clave vacia
// */
// @Test(expected = IllegalArgumentException.class)
// public void testPutHashMap11() throws Exception {
// datosHashMap.clear();
// datosHashMap.put("", "aloha");
// }
//
// /**
// * Vemos el tama�o de un diccionario vacio
// */
// @Test
// public void testSizeHashMap1() {
// datosHashMap.clear();
// assertEquals(datosHashMap.size(), 0);
// }
//
// /**
// * Vemos el tama�o con un elemento
// */
// @Test
// public void testSizeHashMap2() {
// datosHashMap.clear();
// datosHashMap.put("zanahoria", "cosa naranja");
// assertEquals(datosHashMap.size(), 1);
// }
//
// /**
// * Tama�o 5 elementos
// */
// @Test
// public void testSizeHashMap3() {
// datosHashMap.clear();
// datosHashMap.put("uno", "num1");
// datosHashMap.put("dos", "num2");
// datosHashMap.put("tres", "num3");
// datosHashMap.put("cuatro", "num4");
// datosHashMap.put("cinco", "num5");
// assertEquals(datosHashMap.size(), 5);
// }
//
// /**
// * Ponemos un elemento y lo quitamos
// */
// @Test
// public void testRemoveHashMap1() {
// datosHashMap.clear();
// datosHashMap.put("uno", "num1");
// assertEquals(datosHashMap.get("uno"), "num1");
// datosHashMap.remove("uno");
// assertNull(datosHashMap.get("uno"));
// }
//
// /**
// * ponemos 5 elementos, quitamos 3
// */
// @Test
// public void testRemoveHashMap2() {
// datosHashMap.clear();
// datosHashMap.put("uno", "num1");
// datosHashMap.put("dos", "num2");
// datosHashMap.put("tres", "num3");
// datosHashMap.put("cuatro", "num4");
// datosHashMap.put("cinco", "num5");
//
// datosHashMap.remove("uno");
// datosHashMap.remove("dos");
// datosHashMap.remove("tres");
//
// assertNull(datosHashMap.get("uno"));
// assertNull(datosHashMap.get("dos"));
// assertNull(datosHashMap.get("tres"));
// assertEquals(datosHashMap.get("cuatro"), "num4");
// assertEquals(datosHashMap.get("cinco"), "num5");
// }
//
// /**
// * Quitamos una clave nula
// */
// @Test(expected = IllegalArgumentException.class)
// public void testRemoveHashMap3() throws Exception {
// datosHashMap.clear();
// datosHashMap.put("uno", "num1");
// datosHashMap.remove(null);
// }
//
// /**
// * Quitamos una clave vacia
// */
// @Test(expected = IllegalArgumentException.class)
// public void testRemoveHashMap4() throws Exception {
// datosHashMap.clear();
// datosHashMap.put("uno", "num1");
// datosHashMap.remove("");
// }
//
// /**
// * buscamos una clave nula
// */
// @Test(expected = IllegalArgumentException.class)
// public void testGetHashMap1() throws Exception {
// datosHashMap.clear();
// datosHashMap.put("uno", "num1");
// datosHashMap.get(null);
// }
//
// /**
// * Buscamos una clave vacia
// */
// @Test(expected = IllegalArgumentException.class)
// public void testGetHashMap2() throws Exception {
// datosHashMap.clear();
// datosHashMap.put("uno", "num1");
// datosHashMap.get("");
// }
//
// /**
// * Buscamos una clave que no esta en el diccionario
// */
// @Test
// public void testGetHashMap3() {
// datosHashMap.clear();
// assertNull(datosHashMap.get("uno"));
// }
//
// /**
// * Metemos tres elementos, y limpiamos el diccionario
// */
// @Test
// public void testClearHashMap1() {
// datosHashMap.put("uno", "num1");
// datosHashMap.put("dos", "num2");
// datosHashMap.put("tres", "num3");
// assertEquals(datosHashMap.size(), 3);
// datosHashMap.clear();
// assertEquals(datosHashMap.size(), 0);
// }
//
// /**
// * Limpiamos un diccionario
// */
// @Test
// public void testClearHashMap2() {
// datosHashMap.clear();
// assertEquals(datosHashMap.size(), 0);
// }
//
// /**
// * Limpiamos un diccionario, y luego introducimos un elemento
// */
// @Test
// public void testClearHashMap3() {
// datosHashMap.clear();
// datosHashMap.put("uno", "num1");
// assertEquals(datosHashMap.size(), 1);
// datosHashMap.clear();
// assertEquals(datosHashMap.size(), 0);
// datosHashMap.put("uno", "num1");
// assertEquals(datosHashMap.size(), 1);
// }
// }
