package championNames;

import origins.Arsenal;
import classes.Sureshot;
import championFigures.ChampStat;

public class Samira extends ChampStat{
	{
		origins.add("Ace");
		classes.add("Sureshot");
	}
	{
		ultName = "Flair";
		cost = 4;
	}
	
	{
		range = 4;
		mana = new int[] {0,75};
	}
	
	public String ultDesc() {
		return "(Some descriptions...)";
	}
	
	
}
