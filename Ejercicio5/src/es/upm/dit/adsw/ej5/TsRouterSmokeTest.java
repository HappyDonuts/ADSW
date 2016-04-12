package es.upm.dit.adsw.ej5;

public class TsRouterSmokeTest {

	public static void main(String[] args) {

		TsRouter router = new TsRouter(5);

//		Runnable send1 = new Sender(1, router);
//		Thread s1 = new Thread(send1);
//		s1.start();
		(new Thread(new Sender(1, router))).start();
		(new Thread(new Sender(2, router))).start();
		(new Thread(new Sender(3, router))).start();
//		(new Thread(new Sender(4, router))).start();

		(new Thread(new Receiver(1, router))).start();
		(new Thread(new Receiver(2, router))).start();
		(new Thread(new Receiver(3, router))).start();
//		(new Thread(new Receiver(4, router))).start();
				 
	}

}
