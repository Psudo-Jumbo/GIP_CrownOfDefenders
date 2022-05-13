package Klasses;

import Skills.*;

public class Fighter extends FighterClass{

	public Fighter(String nickname) {
		super.id = 1;
		super.classname = "Fighter";
		super.Skillname = "Battle born";
		super.skilltype = "passive";
		super.Skill_Discription = "incoming damage is decreased by 20%";
		super.all_Defence += 0.2;
		super.skillused = true;
		super.Nickname = nickname;
		super.Strength = 50;
		super.Speed = 50;
		super.Vitality = 50;
		super.Magic = 50;
		super.hp_max = ((int)this.Vitality*2);
		super.hp_current = ((int)this.Vitality*2);
		super.image = "Fighter.png";
		
		Attack Horizontal_Slash = new Horizontal_Slash();
		Attack Fire_Bolt = new Fire_Bolt();
		Attack Sword_Flurry = new Sword_Flurry();
		
		super.attacks.add(Horizontal_Slash);
		super.attacks.add(Fire_Bolt);
		super.attacks.add(Sword_Flurry);
	}
}
