package Skills;

public class Sword_Flurry extends Attack{

	public Sword_Flurry() {
		super.name = "Sword Flurry";
		super.accuracy = 80;
		super.power = 20;
		super.Type = "Physical";
		super.Effect = "On hit deal 20 physical damage, can hit 2-6 times";
		double hitrate = Math.random()*4;
		super.hits = ((int)hitrate)+2;
		super.multihit = true;
	}
}
