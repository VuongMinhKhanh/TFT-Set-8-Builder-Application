package itemFigures;

import championFigures.OutputInfo;

public abstract class Item implements OutputInfo{
	protected String name = this.getClass().getSimpleName();
	protected boolean uniqueness, elusiveness, critAbility;
	
	public abstract String toString();
	
	public void unique()
	{
		if (uniqueness == true)
			System.out.println("[Unique - Only One Per Champion]");
	}
	
	public void elusive()
	{
		if (elusiveness == true)
			System.out.println("[Elusive - Cannot be crafted]");
	}
	
	public void critAbility()
	{
		if (critAbility == true)
			System.out.println("Damage from an Ability can critically strike.");
	}
	
	public void showInfo()
	{
		System.out.println(toString());
		unique();
		elusive();
		critAbility();
	}
	
	public boolean getUnique()
	{
		return uniqueness;
	}
	
	
}
