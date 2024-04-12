package items;

import itemFigures.Item;

public class Infinity_Edge extends Item{
	protected double bonusAD = 0.2, bonusCSC = 0.15;
	{
		critAbility = true;
	}
	public String toString()
	{
		return "Grant " + bonusAD * 100 + "% bonus Attack Damage and " + bonusCSC * 100 + "% bonus Critical Strike Chance."; 
	}
}	
