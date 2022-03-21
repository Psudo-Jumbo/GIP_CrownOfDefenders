package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Klasses.*;
import Skills.*;

public class General {
	
	ArrayList<FighterClass> classes = new ArrayList<FighterClass>();
	HashMap<String, FighterClass> players = new HashMap<String, FighterClass>();
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		General X = new General();
		
		X.filloutclasses();
	}
	
	public void filloutclasses () {
		FighterClass Fighter1 = new Fighter("Figter1");
		classes.add(Fighter1);
		FighterClass Knight1 = new Knight("Knight1");
		classes.add(Knight1);
		FighterClass Wizard1 = new Wizard("Wizard1");
		classes.add(Wizard1);
		FighterClass HeavySwordsman1 = new HeavySwordsman("HeavySwordsman1");
		classes.add(HeavySwordsman1);
		FighterClass Rogue1 = new Rogue("Rogue1");
		classes.add(Rogue1);
		
		combat("Alpha", "Beta");
	}
	
	public void combat(String player1, String player2) {
		
		System.out.println("Combat Start");
		
		System.out.println("---");
		
		System.out.println("Player: " + player1 + " VS " + "Player: " + player2);
		
		System.out.println("---");
		
		System.out.println(player1 + " choose class"); //player 1 choosing their class
		for (FighterClass x: classes) {
			System.out.println(x.getclassname());
		}
		String p1class_choice = scan.nextLine();
		chooseClass(p1class_choice, player1); 
		
		System.out.println("---");
		
		System.out.println(player2 + " choose class"); //player 2 choosing their class
		for (FighterClass x: classes) {
				System.out.println(x.getclassname());
			}
		
		System.out.println("---");
		
		String p2class_choice = scan.nextLine();
		chooseClass(p2class_choice, player2); 
		
		System.out.println("---");
		
		 //printing player information
		System.out.println("Player: " + player1);
		players.get(player1).PrintAll();
		System.out.println("---");
		
		 //printing player information
		System.out.println("Player: " + player2);
		players.get(player2).PrintAll();
		System.out.println("---");
		
		combatstart(player1, player2);
		
	}
	
	public void combatstart (String player1, String player2) {
		boolean onefirst;
		System.out.println("Deciding Fastest");
		if(players.get(player1).GetSpeed()>players.get(player2).GetSpeed()) {
			onefirst = true;
			System.out.println(player1 + " goes first");
		} else if((players.get(player1).GetSpeed() == players.get(player2).GetSpeed())) {
			onefirst = false;
			System.out.println(player2 + " goes first");
		} else {
			double randomized = (Math.random()*2);
			if(randomized > 1) {
				onefirst = true;
				System.out.println(player1 + " goes first");
			}
			else {
				onefirst = false;
				System.out.println(player2 + " goes first");
			}
		}
		
		if (onefirst == true) {
			combatround(player1, player2);
		} else {
			combatround(player2, player1);
		}
		
	}
	
	public void combatround (String first, String second) {
		
		boolean turnorder = false;
		
		while(players.get(first).hp_current > 0 && players.get(second).hp_current > 0) {
			if(turnorder == false) {
				System.out.println(first + "'s turn");
				attackround(first, second);
			}
			else if (turnorder == true) {
				System.out.println(second + "'s turn");
				attackround(second, first);
			}
			
			if (turnorder == true) {
				turnorder = false;
			} else if (turnorder == false) {
				turnorder = true;
			}
		}
		System.out.println("---");
		if(players.get(first).hp_current > 0) {
			System.out.println(first + " has defeated " + second);
			players.get(first).PrintAll();
		} else if(players.get(second).hp_current > 0) {
			System.out.println(second + " has defeated " + first);
			players.get(second).PrintAll();
		}
		}
	
	public void attackround(String attacker, String target) {
		System.out.println(attacker + " What would you like to do?");  //first attacks
		System.out.println("---");
		for(Attack X: players.get(attacker).getAttacks()) {
			System.out.println(X.getName());
		}
		String chosenattackp1 = scan.nextLine();
		players.get(attacker).checkattack(chosenattackp1, players.get(target));
	}
	
	public void chooseClass(String chosenclassname, String choosingplayer) {
		
		chosenclassname = chosenclassname.toLowerCase();
		
		if (chosenclassname.contains("knight")) {
			FighterClass knight = new Knight(choosingplayer);
			players.put(choosingplayer, knight);
		}
		else if (chosenclassname.contains("wizard")) {
			FighterClass wizard = new Wizard(choosingplayer);
			players.put(choosingplayer, wizard);
		}
		else if (chosenclassname.contains("fighter")) {
			FighterClass fighter = new Fighter(choosingplayer);
			players.put(choosingplayer, fighter);
		}
		else if (chosenclassname.contains("heavy swordsman") || chosenclassname.contains("heavyswordsman")) {
			FighterClass HeavySwordsman = new HeavySwordsman(choosingplayer);
			players.put(choosingplayer, HeavySwordsman);
		}
		else if (chosenclassname.contains("rogue")) {
			FighterClass rogue = new Rogue(choosingplayer);
			players.put(choosingplayer, rogue);
		}
		else {
			System.out.println("Class not found");
			System.out.println("defaulting to Fighter");
			FighterClass fighter = new Fighter(choosingplayer);
			players.put(choosingplayer, fighter);
		}
	}
}
