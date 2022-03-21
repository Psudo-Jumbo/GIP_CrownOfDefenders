package Klasses;

import Skills.*;

public class Rogue extends FighterClass{
	
	public Rogue(String nickname) {
		super.classname = "Rogue";
		super.Skillname = "Vital Strike";
		super.Nickname = nickname;
		super.Strength = 50;
		super.Speed = 100;
		super.Vitality = 40;
		super.Magic = 10;
		super.hp_max = ((int)this.Vitality*2);
		super.hp_current = ((int)this.Vitality*2);	
		
		Attack Sword_Flurry = new Sword_Flurry();
		Attack Backstab = new Backstab();
		
		super.attacks.add(Backstab);
		super.attacks.add(Sword_Flurry);
	}
}
