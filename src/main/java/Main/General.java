package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.tomcat.jni.File;

import Klasses.*;
import Skills.*;

public class General {
	
	ArrayList<FighterClass> sclasses = new ArrayList<FighterClass>();
	HashMap<String, FighterClass> players = new HashMap<String, FighterClass>();
	Scanner scan = new Scanner(System.in);
	
	String player1;
	String player2;

	
	public ArrayList filloutclasses () {
		ArrayList<FighterClass> classes = new ArrayList<FighterClass>();
		FighterClass Fighter1 = new Fighter("Fighter1");
		classes.add(Fighter1);
		FighterClass Knight1 = new Knight("Knight1");
		classes.add(Knight1);
		FighterClass Wizard1 = new Wizard("Wizard1");
		classes.add(Wizard1);
		FighterClass HeavySwordsman1 = new HeavySwordsman("HeavySwordsman1");
		classes.add(HeavySwordsman1);
		FighterClass Rogue1 = new Rogue("Rogue1");
		classes.add(Rogue1);
		
		return classes;
	}
	
	public String playernames(String P1name, String P2name) {
		
		player1 = P1name;
		player2 = P2name;
		return "Player 1: " + P1name + " VS " + "Player 2: " + P2name;
	}
	
	public void engageCombat() {
		
		System.out.println("Combat Start");
		
		System.out.println("---");
		
		System.out.println("Player: " + player1 + " VS " + "Player: " + player2);
		
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
	
//	public void CharacterChoice1() {
//		CharacterChoice2(player1, classes);
//		CharacterChoice2(player2);
//	}
	
	public void CharacterChoice2(String player, ArrayList<FighterClass> classes) {
		System.out.println(player1 + " choose class"); //player 1 choosing their class
		for (FighterClass x: classes) {
			System.out.println(x.getClassname());
		}
		String p1class_choice = scan.nextLine();
		chooseClass(p1class_choice, player1);
	}
	
	public void combatstart (String player1, String player2) {
		boolean onefirst;
		System.out.println("Deciding Fastest");
		if(players.get(player1).getSpeed()>players.get(player2).getSpeed()) {
			onefirst = true;
			System.out.println(player1 + " goes first");
		} else if((players.get(player1).getSpeed() < players.get(player2).getSpeed())) {
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
				combatmenu(first, second);
			}
			else if (turnorder == true) {
				System.out.println(second + "'s turn");
				combatmenu(second, first);
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
	
	public void combatmenu(String first, String second) {
		System.out.println("---");
		System.out.println("What would you like to do " + first);
		System.out.println("Attack");
		System.out.println("Skill");
		System.out.println("Info");
		
		String chosenaction = scan.nextLine();
		
		if(chosenaction.contains("Attack")) {
			attackround(first, second);
		}
		else if(chosenaction.contains("Skill")) {
			skillround(first, second);
		}
		else if(chosenaction.contains("Info")) {
			players.get(first).PrintAll();
			combatmenu(first, second);
		}
		
	}
	
	public void skillround(String attacker, String target) {
		
			if (players.get(attacker).getSkilltype()=="passive") {
				System.out.println(players.get(attacker).getSkill_Discription());
				combatmenu(attacker, target);
			}
			else if (players.get(attacker).getSkilltype()=="active") {
				if (players.get(attacker).getskillused() == true) {
					System.out.println("---");
					System.out.println("Skill has already been used");
					combatmenu(attacker, target);
				} else if (players.get(attacker).getskillused() == false) {
					ArrayList<Attack> Skill = players.get(attacker).getSkill();
					for (Attack x : Skill) {
					players.get(attacker).useAttack(x, players.get(target));
					}
				}
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
	
	public ArrayList<FighterClass> combatroundget(FighterClass Attacker, FighterClass Target, Attack attack){
		ArrayList<FighterClass> roundgroup = new ArrayList<FighterClass>();
		

		
		return roundgroup;
	}
	
	public ArrayList<FighterClass> useAttack(FighterClass Attacker, FighterClass target, Attack attack) {
		
		ArrayList<FighterClass> roundgroup = new ArrayList<FighterClass>();
		
		if(attack.getAttackType().contains("Damage")) {
			int succeshits = 0;
			
			for(int a = 0; a<attack.gethits(); a++) {
				if(attack.getDamageType()== "Physical") {
					double hit = Math.random()*100;
					double damage = (int)(((attack.getPower()*((Attacker.getStrength()*0.01)+1)))/2);
					if ((int)hit <= attack.getCritrate()) {
						damage = damage*2;
						System.out.println("CRITICAL!");
					}	
					damage = (damage*(1-(target.getAll_Defence())+(target.getPhysical_Defence())));
				
					if (hit < attack.getAccuracy()-(target.getSpeed()*0.1)){
						target.hp_current -= (int)damage;
//						System.out.println(target.getNickname() + " has taken " + (int)damage + " damage from " + this.Nickname + "!");
						succeshits += 1;
					}
				
					else {
//						System.out.println(this.Nickname + " missed!");
					}
					} else if(attack.getDamageType()== "Magic") {
						double hit = Math.random()*100;
						double damage = (int)(((attack.getPower()*((Attacker.getMagic()*0.01)+1)))/2);
						if ((int)hit <= attack.getCritrate()) {
							damage = damage*2;
							System.out.println("CRITICAL!");
						}
						damage = (damage*(1-(target.getAll_Defence())+(target.getMagical_Defence())));
				
						if (hit < attack.getAccuracy()-(target.getSpeed()*0.2)){
							target.hp_current -= (int)damage;
//							System.out.println(target.Nickname + " has taken " + (int)damage + " damage from " + this.Nickname + "!");
							succeshits += 1;
						}
				
						else {
//							System.out.println(this.Nickname + " missed!");
						}	
					}
				}
			System.out.println("---");
			if( attack.getMultihit() == true) {
//				System.out.println(this.Nickname + " hit " + succeshits + " times!");
				System.out.println("---");
			}
			} else if(attack.getAttackType().contains("Buff")) {
				if(attack.getStatboosttype().contains("Strength")) {
//					System.out.println(Attacker.getNickname() + " increased their strength");
					Attacker.setStrength(Attacker.getStrength()*((attack.getStatboost()/100)+1));
				} else if (attack.getStatboosttype().contains("Speed")) {
					Attacker.setSpeed(Attacker.getSpeed()*((attack.getStatboost()/100)+1));
//					System.out.println(this.Nickname + " increased their speed");
				} else if (attack.getStatboosttype().contains("Magic_D")) {
					Attacker.setMagical_Defence(Attacker.getMagical_Defence()*((attack.getStatboost()/100)+1));
//					System.out.println(this.Nickname + " increased their magic defence");
				}else if (attack.getStatboosttype().contains("Magic")) {
					Attacker.setMagic(Attacker.getMagic()*((attack.getStatboost()/100)+1));
//					System.out.println(this.Nickname + " increased their magic");
				}  else if (attack.getStatboosttype().contains("Physical_D")) {
					Attacker.setPhysical_Defence(Attacker.getPhysical_Defence()*((attack.getStatboost()/100)+1));
//					System.out.println(this.Nickname + " increased their Physical defence");
				}
				else {
					System.out.println("-!-");
					System.out.println("Something went wrong during Stat boost");
					System.out.println("-!-");
				}
			}
			
			
//				target.PrintAll();
				System.out.println("---");
				
				roundgroup.add(Attacker);
				roundgroup.add(target);
				
				return roundgroup;
			}
}
