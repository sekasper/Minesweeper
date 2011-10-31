package config;

public class SpielkonfigRechteckig implements ISpielkonfig {
	Integer kantenlaengeX;
	Integer kantenlaengeY;

	public SpielkonfigRechteckig( int breiteSpielfeld,int hoeheSpielfeld) {
		this.kantenlaengeY = hoeheSpielfeld;
		this.kantenlaengeX = breiteSpielfeld;
	}

	@Override
	public Integer kantenlaengeX() {
		return kantenlaengeX;
	}

	@Override
	public Integer kantenlaengeY() {
		return kantenlaengeY;
	}
}
