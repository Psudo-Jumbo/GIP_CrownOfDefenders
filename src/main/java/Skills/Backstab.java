package Skills;

public class Backstab extends Attack{

	public Backstab() {
		
		super.name = "Backstab";
		super.power = 50;
		super.accuracy = 65;
		super.AttackType = "Damage";
		super.DamageType = "Physical";
		super.Effect = "On hit deal 50 damage, has an increased chance to crit";
		super.critrate = 30;
	}
}
