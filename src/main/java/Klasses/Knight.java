package Klasses;

import Skills.*;

public class Knight extends FighterClass{
	
	public Knight(String nickname) {
		super.classname = "Knight";
		super.Physical_Defence += 0.2;
		super.Nickname = nickname;
		super.Strength = 50;
		super.Speed = 40;
		super.Vitality = 100;
		super.Magic = 10;
		super.hp_max = ((int)this.Vitality*2);
		super.hp_current = ((int)this.Vitality*2);
		
		super.Skillname = "Fullplate";
		super.skilltype = "passive";
		super.Skill_Discription = "Lower the damage from physical attacks by 20%";
		super.skillused = true;
		
		Attack Horizontal_Slash = new Horizontal_Slash();
		Attack Sword_Flurry = new Sword_Flurry();
		
		super.attacks.add(Horizontal_Slash);
		super.attacks.add(Sword_Flurry);
	}
	
	
//	public void attack (FighterClass target) {
//		System.out.println("---");
//		double hit = Math.random()*100;
//		int damage = ((int)(40*(this.Strength*0.02)))/2;
//		damage = (int) (damage/(1-(target.all_Defence)+(target.Physical_Defence)));
//		if (hit < 80-(target.Speed*0.02)){
//			target.hp_current -= damage;
//			System.out.println(target.Nickname + " has taken " + damage + " damage from " + this.Nickname + "!");
//			target.PrintInfo();
//		}
//		else {
//			System.out.println(this.Nickname + " missed!");
//		}
//	}
	
	public void Magic_guard() {
		System.out.println("---");
		super.Magical_Defence += 0.2;
		System.out.println(this.Nickname + " Magic defence rose by 20%!");
	}
}
