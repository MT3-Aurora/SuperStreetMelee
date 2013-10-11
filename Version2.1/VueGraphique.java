import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;


public class VueGraphique extends JPanel implements Observer {

	Joueur j;
	ArrayList<Decor> d;
	
	public VueGraphique(Joueur p, ArrayList<Decor> de) {
		j = p;
		this.setPreferredSize(new Dimension(1000,700));
		j.addObserver(this);
		d = de;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		//Affichage du joueur
		g.setColor(Color.DARK_GRAY);
		g.fillRect(j.getX(), j.getY(), j.getW(), j.getH());
		
		//Affichage du sol
		g.setColor(Color.gray);
		for (int i = 0; i< d.size();i++) {
			g.fillRect(d.get(i).getX(), d.get(i).getY(), d.get(i).getW(), d.get(i).getH());
		}
		
		//Trace des traits autour du joueur, pour le debugging
		g.setColor(Color.RED);
		g.drawLine(0, j.getY(), 1000, j.getY());
		g.drawLine(0, j.getY()+j.getH(), 1000, j.getY()+j.getH());
		g.drawLine(j.getX(), 0, j.getX(), 900);
		g.drawLine(j.getX()+j.getW(), 0, j.getX()+j.getW(), 900);
		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
	}
	
}
