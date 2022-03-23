package Skills;

public class Skill_VitalStrike_Boost extends Attack{

	public Skill_VitalStrike_Boost() {
		super.AttackType = "Buff";
		super.Effect = "Increases Speed by 20%";
		super.Statboosttype = "Speed";
		super.Statboost = 20;
	}
}
