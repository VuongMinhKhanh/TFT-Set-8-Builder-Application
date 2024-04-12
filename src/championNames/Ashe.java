package championNames;

import origins.LaserCorps;
import classes.Recon;
import championFigures.ChampStat;

public class Ashe extends ChampStat{
	{
		origins.add("LaserCorps");
		classes.add("Recon");
	}
	{
		ultName = "Ranger's Focus";
		cost = 1;
	}
	
	{
		range = 4;
		mana = new int[] {0,80};
	}
	
	public String ultDesc() {
		return "(Some descriptions...)";
	}
}
