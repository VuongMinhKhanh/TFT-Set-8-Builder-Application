package itemFigures;

import championFigures.Synergy;

public class Emblem extends Item {
	protected Synergy trait;
	{
		uniqueness = true;
	}
	
	public String toString()
	{
		return "The holder gains the " + name + " trait"; 
	}
	
}
