package classes;

import championFigures.ChampInfo;
import championFigures.Synergy;
import championNames.Sejuani;

public class Brawler extends Synergy {
	{
		champions = new ChampInfo[] {new Sejuani()};
	}
	{
		level = new int[] {2,4,6,8};
	}
	
	public String toString()
	{
		return "Brawlers gain additional maximum Health.";
	}
	
	public void traitFunction() {
		
	}
}
