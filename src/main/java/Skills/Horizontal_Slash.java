package Skills;

public class Horizontal_Slash extends Attack{
	
	public Horizontal_Slash() {
		super.name = "Horizontal Slash";
		super.accuracy = 80;
		super.power = 50;
		super.DamageType = "Physical";
		super.AttackType = "Damage";
		super.Effect = "On hit deal 50 physical damage.";
	}
}
