package es.upm.dit.adsw.ej5;

public class TsRouterSmokeTest {

	public static void main(String[] args) {

		TsRouter router = new TsRouter(5);

		(new Thread(new Sender(1, router))).start();
		(new Thread(new Sender(2, router))).start();
		(new Thread(new Sender(3, router))).start();
		(new Thread(new Sender(4, router))).start();
		(new Thread(new Sender(5, router))).start();
		(new Thread(new Sender(6, router))).start();
		(new Thread(new Sender(7, router))).start();

		(new Thread(new Receiver(1, router))).start();
		(new Thread(new Receiver(2, router))).start();
		(new Thread(new Receiver(3, router))).start();
		(new Thread(new Receiver(4, router))).start();
		(new Thread(new Receiver(5, router))).start();
		(new Thread(new Receiver(6, router))).start();
		(new Thread(new Receiver(7, router))).start();
	}
}
