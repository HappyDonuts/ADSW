package es.upm.dit.adsw.ej4;

public class Registro {
	private final String clave;
	private int cnt;

	Registro(String clave) {
		this.clave = clave;
		this.cnt = 1;
	}

	public String getClave() {
		return clave;
	}

	public int getCnt() {
		return cnt;
	}

	public void inc() {
		this.cnt++;
	}
}