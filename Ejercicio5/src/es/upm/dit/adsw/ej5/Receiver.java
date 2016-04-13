package es.upm.dit.adsw.ej5;

public class Receiver implements Runnable {

	int id;
	TsRouter router;

	Receiver(int id, TsRouter router) {
		this.id = id;
		this.router = router;
	}

	@Override
	public void run() {
		try {
			while (true) {
				router.get();
				Log.receiving(id);
				Nap.random(5, 10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
