package config;

public class SpielkonfigQuadratisch implements ISpielkonfig {
	Integer kantenlaengeX;

	public SpielkonfigQuadratisch(int breiteSpielfeld) {
		this.kantenlaengeX = breiteSpielfeld;
	}

	@Override
	public Integer kantenlaengeX() {
		return kantenlaengeX;
	}

	@Override
	public Integer kantenlaengeY() {
		return kantenlaengeX;
	}
}
