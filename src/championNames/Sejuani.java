package championNames;

import championFigures.ChampStat;

public class Sejuani extends ChampStat {
	{
		origins.add("LaserCorps");
		classes.add("Brawler");
	}
	{
		ultName = "Cryo Grenade";
		cost = 4;
	}
	
	{
		range = 1;
		mana = new int[] {80,180};
	}
	
	public String ultDesc() {
		return "(Some descriptions...)";
	}
}
