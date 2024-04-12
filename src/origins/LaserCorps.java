package origins;

import championFigures.ChampInfo;
import championFigures.Synergy;
import championNames.Ashe;
import championNames.Sejuani;

public class LaserCorps extends Synergy {
	{
		champions = new ChampInfo[] {new Ashe(), new Sejuani()};
	}
	{
		level = new int[] {3,6,9};
	}
	
	public String toString()
	{
		return "When a LaserCorp agent attacks or is hit by an attack, their combat drone has a 50% chance to deal magic damage to the agent's target (0.5 second cooldown). "
				+ "When a LaserCorps agent dies, their drone is reassigned to the nearest living agent.";
	}
	
	public void traitFunction() {
		
	}
}
