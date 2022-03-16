package Klasses;

public class Wizard extends FighterClass{

	public Wizard(String nickname) {
		super.classname = "Wizard";
		super.Skillname = "Magic apprentice";
		super.Nickname = nickname;
		super.Strength = 10;
		super.Speed = 50;
		super.Vitality = 40;
		super.Magic = 100;
		super.hp_max = ((int)this.Vitality*2);
		super.hp_current = ((int)this.Vitality*2);
	}
	
	public void attack (FighterClass target) {
		System.out.println("---");
		double hit = Math.random()*100;
		int damage = ((int)(40*(this.Magic*0.02)))/2;
		damage = (int) (damage/(1-(target.all_Defence)+(target.Magical_Defence)));
		if (hit < 80-(target.Speed*0.02)){
			target.hp_current -= damage;
			System.out.println(target.Nickname + " has taken " + damage + " damage from " + this.Nickname + "!");
			target.PrintInfo();
		}
		else {
			System.out.println(this.Nickname + " missed!");
		}
	}
	
	public void Wonder_guard() {
		System.out.println("---");
		super.all_Defence += 0.2;
		
		System.out.println(this.Nickname + " Magic and Physical defence rose by 20%!");
	}
}
