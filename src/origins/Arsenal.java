package origins;

import championFigures.ChampInfo;
import championFigures.Synergy;
import championNames.Aphelios;

public class Arsenal extends Synergy{
	 {
		champions = new ChampInfo[] {new Aphelios()};
	}
	{
		level = new int[] {1};
	}
	
	public String toString()
	{
		return "When deploying the Arsenal champion, players may choose which weapon he will equip.";
	}
	
	public void traitFunction() {
		
	}
	
	
	
}
