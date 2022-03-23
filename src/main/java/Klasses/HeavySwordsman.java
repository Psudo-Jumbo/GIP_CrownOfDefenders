package Klasses;

import Skills.Attack;
import Skills.Horizontal_Slash;
import Skills.Reckless_Attack;

public class HeavySwordsman extends FighterClass{

	public HeavySwordsman(String nickname) {
	super.classname = "Heavy Swordsman";
	super.Nickname = nickname;
	super.Strength = 90;
	super.Speed = 40;
	super.Vitality = 60;
	super.Magic = 10;
	super.hp_max = ((int)this.Vitality*2);
	super.hp_current = ((int)this.Vitality*2);	
	
	super.Skillname = "Full Swing";
	super.skilltype = "active";
	super.Skill_Discription = "A powerfull attack that increases Strength by 20% afterwards.";
//	super.skillpower = 100;
//	super.skillaccuracy = 50;
//	super.Skillstatboost = "Strength";
//	super.Skillboost = 20;
	
	
	Attack Horizontal_Slash = new Horizontal_Slash();
	Attack Reckless_Attack = new Reckless_Attack();
	
	super.attacks.add(Horizontal_Slash);
	super.attacks.add(Reckless_Attack);
	}
}
