package es.upm.dit.adsw.ej60;

import java.util.Random;

public class TestAgent implements Runnable {

	int id;
	TsCache cache;
	
	TestAgent(int id, TsCache cache){
		this.id=id;
		this.cache=cache;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				String key = String.valueOf((new Random()).nextInt(1000));
				if (cache.get(key) == null) {
					String val = "{" + key + "}";
					Nap.random(10, 20);
					cache.put(key, val);
				}
				Nap.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
