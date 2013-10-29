
public class Attaque {
	
	String name;
	int width, height, power;
	/* 	effectiveCooldown est le temps de recharge effectif de l'attaque pour un joueur.
		InfoCooldown n'est qu'une information,
		et est utilisee notamment pour la mise a jour d 'effectiveCooldown. */
	long time, infoCooldown, effectiveCooldown;
	
	/**
	 * Constructeur pour creer une attaque
	 * @param n nom de l'attaque
	 * @param width largeur de l'attaque
	 * @param height hauteur de l'attaque
	 * @param power puissance de l'attaque
	 * @param time temps d'affichage de l'attaque
	 * @param infoCooldown temps de recharge de l'attaque (a titre d'information, jamais modifie en jeu)
	 */
	public Attaque(String n, int width, int height, int power, long time, long infoCooldown) {
		this.name = n;
		this.width = width;
		this.height = height;
		this.power = power;
		this.time = time;
		this.infoCooldown = infoCooldown;
		this.effectiveCooldown = 0;
	}
	
	public String getName() {
		return name;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	/**
	 * Methode utilisee pour connaitre la puissance de l'attaque
	 * @return la puissance de l'attaque
	 */
	public int getPower() {
		return power;
	}
	
	/**
	 * Methode utilisee pour connaitre la duree d'affichage de l'attaque
	 * @return le temps d'affichage en millisecondes de l'attaque
	 */
	public long getTime() {
		return time;
	}
	
	/**
	 * Methode utilisee pour connaitre le temps de recharge d'une attaque a titre d'information (infoCooldown n'est jamais modifiee en jeu)
	 * @return le temps de recharge de l'attaque
	 */
	public long getInfoCooldown() {
		return infoCooldown;
	}
	
	/**
	 * Methode utiliee pour connaitre le temps de recharge effectif de l'attaque pour un joueur
	 * @return le temps de recharge effectif de l'attaque pour un joueur
	 */
	public long getEffectiveCooldown() {
		return effectiveCooldown;
	}
	
	/**
	 * Methode utiliee pour mettre a jour le temps de recharge effectif de l'attaque pour un joueur
	 */
	public void setEffectiveCooldown(long cooldown) {
		effectiveCooldown = cooldown;
	}
	
	/**
	 * Methode utilisee pour calculer la position de l'attaque (son affichage) par rapport a un joueur
	 * @param j le joueur qui lance l'attaque
	 * @return un tableau de int de taille 4.
	 * En 0 on a : l'abscisse de l'attaque,
	 * en 1 on a : l'ordonnee de l'attaque,
	 * en 2 on a : la largeur de l'attaque,
	 * en 3 on a : la hauteur de l'attaque.
	 */
	public int[] getAttackPosition(Joueur j) {
		int x = 0;
		int y = 0;
		if (j.getTurned() == Joueur.TURNED_RIGHT)
		{
			x = j.getX() + (j.getW() + getWidth());
			y = j.getY() + (j.getH() / 2);
		} else if (j.getTurned() == Joueur.TURNED_LEFT) {
			x = j.getX() - (getWidth() * 2); 
			y = j.getY() + (j.getH() / 2);
		}
		int tab[] = {x, y, getWidth(), getHeight()};
		return tab;
	}
	
}