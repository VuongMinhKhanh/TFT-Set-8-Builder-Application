package championFigures;


public abstract class Synergy {
	protected String type = this.getClass().getPackage().getName();
	protected ChampInfo champions[];
	protected int level[];
	
	public int activateLevel() {
		return 1;
	}
	
	public abstract String toString();
	public abstract void traitFunction();
	
	public String currentThreshold(int curNum)
	{
		if (level.length == 1 && level[0] == 1)
			return "";
		
		String s = " (" + curNum;
		
		if (curNum < level[0])
			s += " / ";
		else
			s += " > ";
		
		int i = 0;
		while (curNum >= level[i])
			i++;
		
		return s + "" + level[i] + ")";
	}
}
