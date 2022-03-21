package Skills;

public class Attack {
	String name;
	int power;
	int accuracy;
	String Type;
	String Effect;
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
	public String getType() {
		return Type;
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
}
