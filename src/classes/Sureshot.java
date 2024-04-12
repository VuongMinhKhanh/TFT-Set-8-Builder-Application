package classes;

import championFigures.ChampInfo;
import championFigures.Synergy;
import championNames.Aphelios;
import championNames.Samira;

public class Sureshot extends Synergy{
	 {
		champions = new ChampInfo[] {new Aphelios(), new Samira()};
	}
	{
		level = new int[] {2,4};
	}
	
	public String toString()
	{
		return "Combat start: gain bonus Attack Damage now, and every 4 seconds.";
	}
	
	public void traitFunction() {
		
	}
	
	public void test() {
		for (ChampInfo x: champions)
		{
			System.out.println(x);
		}
	}
}
