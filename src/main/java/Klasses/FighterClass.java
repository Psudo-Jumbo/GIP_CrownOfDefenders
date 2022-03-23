package Klasses;

import java.util.ArrayList;
import Skills.Attack;

public class FighterClass {

	String classname;
	String Nickname;
	int hp_max;
	public int hp_current;
	double Strength;
	double Speed;
	double Vitality;
	double Magic;
	double Physical_Defence;
	double Magical_Defence;
	double all_Defence;
	ArrayList<Skills.Attack> attacks = new ArrayList<Attack>();
	
	ArrayList<Skills.Attack> Skill = new ArrayList<Attack>();
	
	String Skillname;
	String skilltype;
	String Skill_Discription;
	boolean skillused = false;
	
	
	public ArrayList<Attack> getSkill(){
		return Skill;
	}
	public ArrayList<Attack> getAttacks() {
		return attacks;
	}
	public String GetSkillType() {
		return skilltype;
	}
	
	public double GetStrength() {
		return this.Strength;
	}
	public double GetSpeed() {
		return this.Speed;
	}
	public double GetVitality() {
		return this.Vitality;
	}
	public double GetMagic() {
		return this.Magic;
	}
	public boolean Getskillused() {
		return this.skillused;
	}
	
	public void PrintInfo() {
		System.out.println("---");
		System.out.println(this.Nickname);
		System.out.println(this.classname);
		System.out.println("HitPoints: " + this.hp_current + " / " + this.hp_max);
	}
	public void PrintAll() {
		System.out.println("---");
		System.out.println(this.Nickname);
		System.out.println(this.classname);
		System.out.println("Skill: " + this.Skillname);
		System.out.println(this.Skill_Discription);
		System.out.println("HitPoints: " + this.hp_current + " / " + this.hp_max);
		System.out.println("Strength: " + this.Strength);
		System.out.println("Speed: " + this.Speed);
		System.out.println("Vitality: " + this.Vitality);
		System.out.println("Magic: " + this.Magic);
	}
	
	public String getclassname() {
		return this.classname;
	}
	
	public String getSkillname() {
		return Skillname;
	}


	public String getSkill_Discription() {
		return Skill_Discription;
	}
	
	public void checkattack(String usedattack, FighterClass target) {
		
		int attackint = 0;
		boolean containsattack = false;
		
		for(int a = 0; a<attacks.size(); a++) {
			if(attacks.get(a).getName().contains(usedattack)) {
				attackint = a;
				containsattack = true;
			} else {}
		}
		if (containsattack == true) {
			useAttack(attacks.get(attackint), target);
		} else {
			System.out.println(this.Nickname + " does not know this move.");
		}
	}
	
	public void useAttack(Attack attack, FighterClass target) {
		
	if(attack.getAttackType().contains("Damage")) {
		int succeshits = 0;
		System.out.println(this.Nickname + " uses " + attack.getName() + " on " + target.Nickname);
		
		for(int a = 0; a<attack.gethits(); a++) {
			if(attack.getDamageType()== "Physical") {
				double hit = Math.random()*100;
				double damage = (int)(((attack.getPower()*((this.Strength*0.01)+1)))/2);
				if ((int)hit <= attack.getCritrate()) {
					damage = damage*2;
					System.out.println("CRITICAL!");
				}	
				damage = (damage*(1-(target.all_Defence)+(target.Physical_Defence)));
			
				if (hit < attack.getAccuracy()-(target.Speed*0.1)){
					target.hp_current -= (int)damage;
					System.out.println(target.Nickname + " has taken " + (int)damage + " damage from " + this.Nickname + "!");
					succeshits += 1;
				}
			
				else {
					System.out.println(this.Nickname + " missed!");
				}
				} else if(attack.getDamageType()== "Magic") {
					double hit = Math.random()*100;
					double damage = (int)(((attack.getPower()*((this.Magic*0.01)+1)))/2);
					if ((int)hit <= attack.getCritrate()) {
						damage = damage*2;
						System.out.println("CRITICAL!");
					}
					damage = (damage*(1-(target.all_Defence)+(target.Magical_Defence)));
			
					if (hit < attack.getAccuracy()-(target.Speed*0.2)){
						target.hp_current -= (int)damage;
						System.out.println(target.Nickname + " has taken " + (int)damage + " damage from " + this.Nickname + "!");
						succeshits += 1;
					}
			
					else {
						System.out.println(this.Nickname + " missed!");
					}	
				}
			}
		System.out.println("---");
		if( attack.getMultihit() == true) {
			System.out.println(this.Nickname + " hit " + succeshits + " times!");
			System.out.println("---");
		}
		} else if(attack.getAttackType().contains("Buff")) {
			if(attack.getStatboosttype().contains("Strength")) {
				System.out.println(this.Nickname + " increased their strength");
				this.Strength = this.Strength*((attack.getStatboost()/100)+1);
			} else if (attack.getStatboosttype().contains("Speed")) {
				this.Speed = this.Speed*((attack.getStatboost()/100)+1);
				System.out.println(this.Nickname + " increased their speed");
			} else if (attack.getStatboosttype().contains("Magic_D")) {
				this.Magical_Defence = this.Magical_Defence*((attack.getStatboost()/100)+1);
				System.out.println(this.Nickname + " increased their magic defence");
			}else if (attack.getStatboosttype().contains("Magic")) {
				this.Magic = this.Magic*((attack.getStatboost()/100)+1);
				System.out.println(this.Nickname + " increased their magic");
			}  else if (attack.getStatboosttype().contains("Physical_D")) {
				this.Physical_Defence = this.Physical_Defence*((attack.getStatboost()/100)+1);
				System.out.println(this.Nickname + " increased their Physical defence");
			}
			else {
				System.out.println("-!-");
				System.out.println("Something went wrong during Stat boost");
				System.out.println("-!-");
			}
		}
		
		
			target.PrintAll();
			System.out.println("---");
		}
	}	
