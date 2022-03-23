package Skills;

public class Lightning_Pierce extends Attack{

	public Lightning_Pierce() {
		super.name = "Lightning Pierce";
		super.accuracy = 60;
		super.power = 35;
		super.DamageType = "Magic";
		super.AttackType = "Damage";
		super.critrate = 20;
		super.Effect = "On hit deal 35 Magic damage, has an increased chance to crit";
	}
}
