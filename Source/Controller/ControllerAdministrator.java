package Controller;

import java.util.ArrayList;

import Model.Game;
import Model.Menu;
import Model.Player;

public class ControllerAdministrator {
	
	public static ArrayList<Player> tabJoueurs;
	public static Menu menu;
	public static ArrayList<Xbox360Controller> xbox_controllers ;

	public ControllerAdministrator(Menu me, ArrayList<Player> tabJ) {
		menu = me;
		tabJoueurs = tabJ;
		xbox_controllers = Xbox360Controller
				.initControllers();
		new GraphicalController();
	}
	
	public static void resetGame() {
		Game.resetGame();
	}
}
