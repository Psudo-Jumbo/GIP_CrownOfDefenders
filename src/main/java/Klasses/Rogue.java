package Klasses;

import Skills.*;

public class Rogue extends FighterClass{
	
	public Rogue(String nickname) {
		super.classname = "Rogue";
		super.Nickname = nickname;
		super.Strength = 50;
		super.Speed = 100;
		super.Vitality = 40;
		super.Magic = 10;
		super.hp_max = ((int)this.Vitality*2);
		super.hp_current = ((int)this.Vitality*2);	
		
		super.Skillname = "Vital Strike";
		super.skilltype = "active";
		super.Skill_Discription = "A quick strike that increases Speed by 20% afterwards";
		
				
		Attack Skill_VitalStrike_Attack = new Skill_VitalStrike_Attack();
		Attack Skill_VitalStrike_Boost = new Skill_VitalStrike_Boost();
		
		super.Skill.add(Skill_VitalStrike_Attack);
		super.Skill.add(Skill_VitalStrike_Boost);
		
		Attack Sword_Flurry = new Sword_Flurry();
		Attack Backstab = new Backstab();
		
		super.attacks.add(Backstab);
		super.attacks.add(Sword_Flurry);
	}
}
