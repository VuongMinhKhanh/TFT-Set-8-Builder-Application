package classes;

import championFigures.ChampInfo;
import championFigures.Synergy;
import championNames.Ashe;

public class Recon extends Synergy{
	{
		champions = new ChampInfo[] {new Ashe()};
	}
	{
		level = new int[] {2,3,4};
	}
	
	public String toString()
	{
		return "Innate: Gain 2 hex Attack Range." + "\nIf there is an enemy nearby, Recon units will dash to safety before casting their Ability.";
	}
	
	public void traitFunction() {
		
	}
}
