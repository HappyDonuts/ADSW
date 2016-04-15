package es.upm.dit.adsw.ej60;

public class TsCacheSmokeTest {

	public static void main(String[] args) {
		
		int nSlots=10;
		int nAgents=50;
		TsCache cache = new TsCache(nSlots);
		
		for(int i=0;i<nAgents;i++){
			(new Thread(new TestAgent(i, cache))).start();
		}
	}

}
