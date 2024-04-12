package championFigures;

import java.util.ArrayList;

public interface OutputInfo {
	default String outputClassName() {
		return this.getClass().getSimpleName();
	}
	default String outputName()
	{
		String name = this.outputClassName().replace('_', ' ');
		if (this.getClass().getPackage().getName().equals("emblems"))
			name += " Emblem";
		
		return name;
	}
	
	default int outputIndex(ArrayList<ChampInfo> deck, String name, int pos)
	{
		ArrayList<Integer> idx = new ArrayList<>();
		for (int i = 0; i < deck.size(); i++)
		{
			if (deck.get(i).outputName().equals(name))
				idx.add(i);
		}
		
		if (pos == 0)
			pos++;

		return idx.get(pos - 1);
	}
}
