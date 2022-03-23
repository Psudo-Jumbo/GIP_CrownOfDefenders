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
		Attack Magic_Guard = new Magic_Guard();
		
		super.attacks.add(Horizontal_Slash);
		super.attacks.add(Sword_Flurry);
		super.attacks.add(Magic_Guard);
	}
}
