package Skills;

public class Reckless_Attack extends Attack{

	public Reckless_Attack(){
		super.name = "Reckless Attack";
		super.accuracy = 70;
		super.power = 40;
		super.DamageType = "Physical";
		super.AttackType = "Damage";
		super.critrate = 20;
		super.Effect = "On hit deal 90 Magic damage, has an increased chance to crit";
	}
	
}
