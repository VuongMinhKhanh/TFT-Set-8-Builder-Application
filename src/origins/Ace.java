package origins;

import championFigures.ChampInfo;
import championFigures.Synergy;
import championNames.Samira;

public class Ace extends Synergy{
	{
		champions = new ChampInfo[] {new Samira()};
	}
	{
		level = new int[] {1, 4};
	}
	public String toString()
	{
		return "Combat start: strike a pose that grants your team 18% bonus damage, which increases by 3% for every 3-star champion on your team.";
	}
	
	public void traitFunction() {
		
	}
}
