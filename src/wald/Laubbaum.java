package wald;

/**
 * Diese Klasse repraesentiert einen Laubbaum.<br>
 * Als Eigenschaften enthaelt sie die (x,y)-Koordinaten eines Punktes, ausserdem die Stammhoehe und -Breite und den Radius der Krone.<br>
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class Laubbaum {

	private int x, y;
	private int sth;
	private int stb;
	private int rad;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSth() {
		return sth;
	}

	public void setSth(int sth) {
		this.sth = sth;
	}

	public int getStb() {
		return stb;
	}

	public void setStb(int stb) {
		this.stb = stb;
	}

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}
}