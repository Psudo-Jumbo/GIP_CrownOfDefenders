package Skills;

public class Attack {
	String name;
	int power;
	int accuracy;
	String DamageType;
	String AttackType;
	String Effect;
	String Statboosttype;
	double Statboost;
	int hits = 1;
	Boolean multihit = false;
	int critrate = 10;
	
	public String getName() {
		return name;
	}
	public int getPower() {
		return power;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public String getDamageType() {
		return DamageType;
	}
	public String getAttackType() {
		return AttackType;
	}
	public String getEffect() {
		return Effect;
	}
	public int gethits() {
		return hits;
	}
	public int getCritrate() {
		return critrate;
	}
	public boolean getMultihit() {
		return multihit;
	}
	public String getStatboosttype() {
		return Statboosttype;
	}
	public double getStatboost() {
		return Statboost;
	}
}
