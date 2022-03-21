package Klasses;

import Skills.Attack;
import Skills.Horizontal_Slash;
import Skills.Reckless_Attack;

public class HeavySwordsman extends FighterClass{

	public HeavySwordsman(String nickname) {
	super.classname = "Heavy Swordsman";
	super.Skillname = "Full Swing";
	super.Nickname = nickname;
	super.Strength = 90;
	super.Speed = 40;
	super.Vitality = 60;
	super.Magic = 10;
	super.hp_max = ((int)this.Vitality*2);
	super.hp_current = ((int)this.Vitality*2);	
	
	Attack Horizontal_Slash = new Horizontal_Slash();
	Attack Reckless_Attack = new Reckless_Attack();
	
	super.attacks.add(Horizontal_Slash);
	super.attacks.add(Reckless_Attack);
	}
	
//	public void attack (FighterClass target) {
//		System.out.println("---");
//		double hit = Math.random()*100;
//		int damage = ((int)(60*(this.Strength*0.02)))/2;
//		damage = (int) (damage/(1-(target.all_Defence)+(target.Physical_Defence)));
//		if (hit < 90-(target.Speed*0.02)){
//			target.hp_current -= damage;
//			System.out.println(target.Nickname + " has taken " + damage + " damage from " + this.Nickname + "!");
//			target.PrintInfo();
//		}
//		else {
//			System.out.println(this.Nickname + " missed!");
//		}
//	}
}
