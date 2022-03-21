package Klasses;

import Skills.*;

public class Fighter extends FighterClass{

	public Fighter(String nickname) {
		super.classname = "Fighter";
		super.Skillname = "Accurate";
		super.Nickname = nickname;
		super.Strength = 50;
		super.Speed = 50;
		super.Vitality = 50;
		super.Magic = 50;
		super.hp_max = ((int)this.Vitality*2);
		super.hp_current = ((int)this.Vitality*2);
		
		Attack Horizontal_Slash = new Horizontal_Slash();
		Attack Fire_Bolt = new Fire_Bolt();
		Attack Sword_Flurry = new Sword_Flurry();
		
		super.attacks.add(Horizontal_Slash);
		super.attacks.add(Fire_Bolt);
		super.attacks.add(Sword_Flurry);
	}
}
