package Main;

import Klasses.*;

public class Main {

	public static void main(String[] args) {
		FighterClass Knight1 = new Knight("Knight1");
		FighterClass Wizard1 = new Wizard("Wizard1");
		FighterClass Knight2 = new Knight("Knight2");
		
		
		Knight1.PrintInfo();
		Wizard1.PrintInfo();
		
		((Knight) Knight1).attack(Wizard1);
		((Wizard) Wizard1).attack(Knight1);
		
		((Knight) Knight1).Magic_guard();
		((Wizard) Wizard1).Wonder_guard();
		
		((Knight) Knight1).attack(Wizard1);
		((Wizard) Wizard1).attack(Knight1);
	}
	
	
	
}
