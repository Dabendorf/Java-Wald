package wald;

/**
 * Diese Klasse repraesentiert einen Nadelbaum.<br>
 * Als Eigenschaften enthaelt sie die (x,y)-Koordinaten des Punktes unten in der Mitte, ausserdem die Kronen- und Stammhoehe und -Breite.<br>
 * Ausserdem existieren zwei Arrays mit Zahlen, die zusammen die Koordinaten aller Baumecken bilden, damit diese einfach durchiteriert werden koennen beim Zeichen.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class Nadelbaum {
	
	private int x, y;
	private int sth;
	private int stb;
	private int kronh;
	private int kronb;
	private int xpoints[];
	private int ypoints[];
	
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
	
	public int getKronh() {
		return kronh;
	}
	
	public void setKronh(int kronh) {
		this.kronh = kronh;
	}
	
	public int getKronb() {
		return kronb;
	}
	
	public void setKronb(int kronb) {
		this.kronb = kronb;
	}

	public int[] getXpoints() {
		return xpoints;
	}

	public void setXpoints(int[] xpoints) {
		this.xpoints = xpoints;
	}

	public int[] getYpoints() {
		return ypoints;
	}

	public void setYpoints(int[] ypoints) {
		this.ypoints = ypoints;
	}
}