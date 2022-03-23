package Skills;

public class Magic_Guard extends Attack{
	
	public Magic_Guard() {
		super.name = "Magic Guard";
		super.AttackType = "Buff";
		super.Effect = "Decreases damage from magic by 20%";
		super.Statboosttype = "Magic_D";
		super.Statboost = 20;
	}
	
}
