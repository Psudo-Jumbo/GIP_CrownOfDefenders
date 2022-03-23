package Skills;

public class Fire_Bolt extends Attack{

	public Fire_Bolt() {
		super.name = "Fire Bolt";
		super.accuracy = 80;
		super.power = 50;
		super.DamageType = "Magic";
		super.AttackType = "Damage";
		super.Effect = "On hit deal 50 Magic damage.";
	}
}
