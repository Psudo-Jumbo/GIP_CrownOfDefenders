package Skills;

public class Mage_Armor extends Attack{

	public Mage_Armor() {
		super.name = "Mage Armor";
		super.AttackType = "Buff";
		super.Effect = "Decreases incoming damage from physical attacks by 20%";
		super.Statboosttype = "Physical_D";
		super.Statboost = 20;
	}
}
