package wald;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Dies ist die Klasse in der der Wald mitsamt seiner Baeume generiert wird.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class WaldZeichnen {

	private Canvas canvas1 = new Canvas() {
	    public void paint(Graphics stift) {
	    	wald(stift);
	    }
	};
	private JFrame frame1 = new JFrame("Wald");
	private int frameWidth = 800;
	private int frameHeight = 500;
	private int anzahllaub;
	private int anzahlnadel;
	private int anzahlnoel;
	private ArrayList<Laubbaum> laubliste = new ArrayList<Laubbaum>();
	private ArrayList<Nadelbaum> nadelliste = new ArrayList<Nadelbaum>();
	private ArrayList<Weihnachtsbaum> noelliste = new ArrayList<Weihnachtsbaum>();
	
	public WaldZeichnen() {
		frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame1.setSize(frameWidth, frameHeight);
	    frame1.setLocationRelativeTo(null);
	    frame1.setResizable(false);
	    Container cp = frame1.getContentPane();
	    cp.setLayout(null);
	    canvas1.setBounds(0,0,frameWidth,frameWidth);
	    canvas1.setBackground(new Color(0x1B1E24));
	    cp.add(canvas1);
	    frame1.setVisible(false);
	    baumgenerierungdefinition();
	}
	
	/**
	 * Diese Methode generiert alle Baeume vollstaendig.<br>
	 * Bei den Baeumen wird stets darauf geachtet, dass sie sich nicht gegenseitig ueberschneiden.
	 */
	private void baumgenerierungdefinition() {
		Random zufall = new Random();
		anzahllaub = 20;
		anzahlnadel = 20;
		anzahlnoel = 10;
		
		for(int n=0;n<anzahllaub;n++) {
			laubliste.add(new Laubbaum());
		}
		for(int n=0;n<anzahlnadel;n++) {
			nadelliste.add(new Nadelbaum());
		}
		for(int n=0;n<anzahlnoel;n++) {
			noelliste.add(new Weihnachtsbaum());
		}
		
		for(Laubbaum a:laubliste) {
			a.setX(zufall.nextInt(frameWidth));
			a.setY(zufall.nextInt(frameHeight));
			a.setRad(zufall.nextInt(50)+20);
			a.setSth((a.getRad()*2)/3);
			a.setStb(a.getSth()/4);
		}
		for(Nadelbaum b:nadelliste) {
			b.setX(zufall.nextInt(frameWidth));
			b.setY(zufall.nextInt(frameHeight));
			b.setKronh(zufall.nextInt(50)+30);
			b.setKronb(b.getKronh());
			b.setSth((b.getKronh()*2)/3);
			b.setStb(b.getSth()/4);
			int xarr[] = {b.getX()-b.getKronb()/2, b.getX()+b.getKronb()/2, b.getX()};
			int yarr[] = {b.getY(), b.getY(), b.getY()-b.getKronh()};
			b.setXpoints(xarr);
			b.setYpoints(yarr);
		}
		for(Weihnachtsbaum c:noelliste) {
			c.setX(zufall.nextInt(frameWidth));
			c.setY(zufall.nextInt(frameHeight));
			c.setKronh(zufall.nextInt(30)+60);
			c.setKronb((c.getKronh()*2)/3);
			c.setSth(c.getKronh()/5);
			c.setStb(c.getSth()/3);
			
			int xarroben[] = {c.getX()-(c.getKronb()/10)*3, c.getX()+(c.getKronb()/10)*3, c.getX()};
			int yarroben[] = {c.getY()-2*(c.getKronh()/3), c.getY()-2*(c.getKronh()/3), c.getY()-c.getKronh()};
			c.setXpointsoben(xarroben);
			c.setYpointsoben(yarroben);
			int xarrmitte[] = {c.getX()-(c.getKronb()/5)*2, c.getX()+(c.getKronb()/5)*2, c.getX()+(c.getKronb()/36)*5, c.getX()-(c.getKronb()/36)*5};
			int yarrmitte[] = {c.getY()-c.getKronh()/3, c.getY()-c.getKronh()/3, c.getY()-2*(c.getKronh()/3), c.getY()-2*(c.getKronh()/3)};
			c.setXpointsmitte(xarrmitte);
			c.setYpointsmitte(yarrmitte);
			int xarrunten[] = {c.getX()-c.getKronb()/2, c.getX()+c.getKronb()/2, c.getX()+c.getKronb()/6, c.getX()-c.getKronb()/6};
			int yarrunten[] = {c.getY(), c.getY(), c.getY()-c.getKronh()/3, c.getY()-c.getKronh()/3};
			c.setXpointsunten(xarrunten);
			c.setYpointsunten(yarrunten);
		}
		frame1.setVisible(true);
	}
	
	/**
	 * Diese Methode zeichnet den Wald nach den oben definierten Eigenschaften.
	 * @param stift Nimmt das GraphicsElement entgegen.
	 */
	private void wald(Graphics stift) {
		for(Laubbaum a:laubliste) {
			stift.setColor(new Color(0x8B4500));
			stift.fillRect(a.getX()-a.getStb()/2, a.getY()-5, a.getStb(), a.getSth());
			stift.setColor(new Color(0x32CD32));
			stift.fillOval(a.getX()-a.getRad()/2, a.getY()-a.getRad(), a.getRad(), a.getRad());
		}
		for(Nadelbaum b:nadelliste) {
			stift.setColor(new Color(0x8B4500));
			stift.fillRect(b.getX()-b.getStb()/2, b.getY()-5, b.getStb(), b.getSth());
			stift.setColor(new Color(0x32CD32));
			stift.fillPolygon(b.getXpoints(), b.getYpoints(), 3);
		}
		for(Weihnachtsbaum c:noelliste) {
			stift.setColor(new Color(0x8B4500));
			stift.fillRect(c.getX()-c.getStb()/2, c.getY()-5, c.getStb(), c.getSth());
			stift.setColor(new Color(0x32CD32));
			stift.fillPolygon(c.getXpointsunten(),c.getYpointsunten(),4);
			stift.fillPolygon(c.getXpointsmitte(),c.getYpointsmitte(),4);
			stift.fillPolygon(c.getXpointsoben(),c.getYpointsoben(),3);
		}
	}
	
	public static void main(String[] args) {
		new WaldZeichnen();
	}
}