package es.upm.dit.adsw.ej5;

import static org.junit.Assert.*;

import org.junit.Test;

public class TsRouterTest {
	private final Packet packetA1 = new Packet(Priority.ALTA, 1);
	private final Packet packetA2 = new Packet(Priority.ALTA, 2);
	private final Packet packetA3 = new Packet(Priority.ALTA, 3);
	private final Packet packetM1 = new Packet(Priority.MEDIA, 1);
	private final Packet packetM2 = new Packet(Priority.MEDIA, 2);
	private final Packet packetM3 = new Packet(Priority.MEDIA, 3);
	private final Packet packetB1 = new Packet(Priority.BAJA, 1);
	private final Packet packetB2 = new Packet(Priority.BAJA, 2);
	private final Packet packetB3 = new Packet(Priority.BAJA, 3);

	@Test
	public void ejemplo() {
		Packet[] seq_send = new Packet[] { packetM1, packetB1, packetA1, packetM2, };
		Packet[] seq_rec = new Packet[] { packetA1, packetM1, packetM2, packetB1, };
		TsRouter router = new TsRouter(5);
		for (Packet packet : seq_send)
			router.send(packet);

		for (Packet packet : seq_rec){
			router.imprimeCola();

			assertSame(packet, router.get());}
		router.imprimeCola();
		assertNull(router.get());

	}
}
