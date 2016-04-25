package es.upm.dit.adsw.ej6;

public class TsCacheSmokeTest {
	public static final int N_SLOTS = 10;

	public static final int N_AGENTS = 50;

	public static void main(String[] args) throws InterruptedException {
		TsCache cache = new TsCache(N_SLOTS);
		for (int id = 0; id < N_AGENTS; id++) {
			TestAgent agent = new TestAgent(id, cache);
			Thread thread = new Thread(agent);
			thread.start();
		}
	}
}
