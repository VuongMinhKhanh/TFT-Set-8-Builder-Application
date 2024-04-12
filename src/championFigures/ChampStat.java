package championFigures;

public abstract class ChampStat extends ChampInfo{
	protected String ultName;
	protected int range, mana[];
	
	public String manaOutput() {
		String s = "";
		for (int i: mana)
		{
			s += i + "/";
		}
		
		return s.substring(0, s.length() - 1);
	}
	
	public abstract String ultDesc();
	
	public String toString() {
		return this.getClass().getSimpleName() + " - " + cost + " gold\n"
				+ "Attack Range: " + range + "\n"
						+ "Ultimate: " + ultName + "\n"
								+ "Mana: " + manaOutput() + "\n"
										+ ultDesc() + "\n"
											+ "";
				
	}
}
