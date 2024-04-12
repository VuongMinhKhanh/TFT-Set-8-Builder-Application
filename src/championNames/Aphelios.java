package championNames;

import championFigures.ChampStat;

public class Aphelios extends ChampStat{
	{
		origins.add("Arsenal");
		classes.add("Sureshot");
	}
	{
		ultName = "Weapons of the Faithful";
		cost = 5;
	}
	
	{
		range = 4;
		mana = new int[] {40,140};
	}
	
	public String ultDesc() {
		return "(Some descriptions...)";
	}
	
	
	
}
