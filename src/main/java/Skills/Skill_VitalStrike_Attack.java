package Skills;

public class Skill_VitalStrike_Attack extends Attack{

	public Skill_VitalStrike_Attack() {
		super.name = "Vital Strike";
		super.power = 100;
		super.accuracy = 60;
		super.AttackType = "Damage";
		super.DamageType = "Physical";
		super.Effect = "On hit deal 100 damage, increases speed by 20% afterwards.";
	}
}
