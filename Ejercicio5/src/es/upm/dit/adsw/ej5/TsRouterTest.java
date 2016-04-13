package es.upm.dit.adsw.ej5;

import static org.junit.Assert.*;

import org.junit.Test;

public class TsRouterTest {
	private final Packet packetA1 = new Packet(Priority.ALTA, 1);
	private final Packet packetA2 = new Packet(Priority.ALTA, 2);
	private final Packet packetA3 = new Packet(Priority.ALTA, 3);
	private final Packet packetA4 = new Packet(Priority.ALTA, 4);
	private final Packet packetA5 = new Packet(Priority.ALTA, 5);
	private final Packet packetM1 = new Packet(Priority.MEDIA, 1);
	private final Packet packetM2 = new Packet(Priority.MEDIA, 2);
	private final Packet packetM3 = new Packet(Priority.MEDIA, 3);
	private final Packet packetB1 = new Packet(Priority.BAJA, 1);
	private final Packet packetB2 = new Packet(Priority.BAJA, 2);
	private final Packet packetB3 = new Packet(Priority.BAJA, 3);

	TsRouter router = new TsRouter(4);

	/**
	 * Falla si no recibe los paquetes ordenados segun la prioridad, y despues la antigüedad
	 */
	@Test
	public void ejemplo() {
		Packet[] seq_send = new Packet[] { packetM1, packetB1, packetA1, packetM2, };
		Packet[] seq_rec = new Packet[] { packetA1, packetM1, packetM2, packetB1, };
		for (Packet packet : seq_send)
			router.send(packet);
		for (Packet packet : seq_rec){
			assertSame(packet, router.get());}
		assertNull(router.get());
	}

	/**
	 * Metemos un nuevo paquete con la cola llena
	 * Falla si no quita el paquete de prioridad BAJA, desplaza la cola e introduce el M3 al final
	 */
	@Test
	public void test1() {
		Packet[] seq_send = new Packet[] { packetM1, packetB1, packetA1, packetM2, packetM3};
		Packet[] seq_rec = new Packet[] { packetA1, packetM1, packetM2, packetM3, };
		for (Packet packet : seq_send)
			router.send(packet);
		for (Packet packet : seq_rec)
			assertSame(packet, router.get());
		assertNull(router.get());
	}
	
	/**
	 * Metemos un paquete de prioridad BAJA en la cola llena de prioridades superiores
	 * Falla si introduce el nuevo paquete en la cola llena
	 */
	@Test
	public void test2() {
		Packet[] seq_send = new Packet[] { packetM1, packetA1, packetA2, packetM2, packetB1};
		Packet[] seq_rec = new Packet[] { packetA1, packetA2, packetM1, packetM2, };
		for (Packet packet : seq_send)
			router.send(packet);
		for (Packet packet : seq_rec){
			assertSame(packet, router.get());}
		assertNull(router.get());
	}
	
	/**
	 * Falla si no quita el paquete de prioridad BAJA, desplaza la cola e introduce el M3 al final
	 */
	@Test
	public void test3() {
		Packet[] seq_send = new Packet[] { packetM1, packetM2, packetM3, packetA1, packetA2};
		Packet[] seq_rec = new Packet[] { packetA1, packetA2, packetM2, packetM3, };
		for (Packet packet : seq_send)
			router.send(packet);
		for (Packet packet : seq_rec){
			assertSame(packet, router.get());}
		assertNull(router.get());
	}
	
	/**
	 * Falla si al recibir un paquete de la cola vacia no devuelve null 
	 */
	@Test
	public void test5() {
			assertNull(router.get());
	}
	/**
	 * Falla si al introducir un ALTA en una cola de altas no elimina el más antiguo y añade el nuevo al final
	 */
	@Test
	public void test6() {
		Packet[] seq_send = new Packet[] { packetA1, packetA2, packetA3, packetA4, packetA5};
		Packet[] seq_rec = new Packet[] { packetA2, packetA3, packetA4, packetA5, };
		for (Packet packet : seq_send)
			router.send(packet);
		for (Packet packet : seq_rec){
			assertSame(packet, router.get());}
		assertNull(router.get());
	}
}