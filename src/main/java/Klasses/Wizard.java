package Klasses;

import Skills.Attack;
import Skills.*;

public class Wizard extends FighterClass{

	public Wizard(String nickname) {
		super.classname = "Wizard";
		super.Magical_Defence += 0.2;
		super.Nickname = nickname;
		super.Strength = 10;
		super.Speed = 50;
		super.Vitality = 40;
		super.Magic = 100;
		super.hp_max = ((int)this.Vitality*2);
		super.hp_current = ((int)this.Vitality*2);
		
		super.Skillname = "Magic apprentice";
		super.skilltype = "passive";
		super.Skill_Discription = "Lower the damage from Magic attacks by 20%";
		super.skillused = true;
		
		Attack Fire_Bolt = new Fire_Bolt();
		Attack Lightning_Pierce = new Lightning_Pierce();
		
		super.attacks.add(Fire_Bolt);
		super.attacks.add(Lightning_Pierce);
	}
	
	public void Wonder_guard() {
		System.out.println("---");
		super.all_Defence += 0.2;
		
		System.out.println(this.Nickname + " Magic and Physical defence rose by 20%!");
	}
}
