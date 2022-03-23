package Klasses;

import Skills.*;

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
	
	
	Attack Horizontal_Slash = new Horizontal_Slash();
	Attack Reckless_Attack = new Reckless_Attack();
	Attack Magic_Guard = new Magic_Guard();
	
	super.attacks.add(Horizontal_Slash);
	super.attacks.add(Reckless_Attack);
	super.attacks.add(Magic_Guard);
	}
}
