package es.upm.dit.adsw.ej5;

public class Sender implements Runnable {

	int id;
	TsRouter router;

	Sender(int id, TsRouter router) {
		this.id = id;
		this.router = router;
	}

	@Override
	public void run() {
		while (true) {
			try {

				Packet paquete = new Packet(Priority.random(), 1);
				router.send(paquete);
				Log.sending(id);
				Nap.random(5, 10);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}