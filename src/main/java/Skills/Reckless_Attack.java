package Skills;

public class Reckless_Attack extends Attack{

	public Reckless_Attack(){
		super.name = "Reckless Attack";
		super.accuracy = 75;
		super.power = 45;
		super.DamageType = "Physical";
		super.AttackType = "Damage";
		super.critrate = 20;
		super.Effect = "On hit deal 45 physical damage, has an increased chance to crit";
	}
	
}
