package es.upm.dit.adsw.ej5;

public class Sender implements Runnable {
	
	int id;
	TsRouter router;
	
	Sender(int id, TsRouter router){
		this.id=id;
		this.router=router;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Packet paquete = new Packet(Priority.random(), 0);
		router.send(paquete);
		Nap.sleep(1000);	
	}	
}
