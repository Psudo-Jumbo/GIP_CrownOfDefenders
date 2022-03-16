package Klasses;

import java.util.ArrayList;

import Skills.Attack;

public class FighterClass {

	String classname;
	String Skillname;
	String Nickname;
	int hp_max;
	int hp_current;
	double Strength;
	double Speed;
	double Vitality;
	double Magic;
	double Physical_Defence;
	double Magical_Defence;
	double all_Defence;
	ArrayList<Skills.Attack> attacks = new ArrayList<Attack>();
	
	
	public void UseSkill() {}
	public void PrintInfo() {
		System.out.println("---");
		System.out.println(this.Nickname);
		System.out.println(this.classname);
		System.out.println("HitPoints: " + this.hp_current + " / " + this.hp_max);
	}
	
	public String getclassname() {
		return this.classname;
	}
	
	public void TakeDamage(int damagetaken) {
		this.hp_current -= damagetaken;
		System.out.println("---");
		System.out.println(this.Nickname + " has taken " + damagetaken + " damage");
	}

}
