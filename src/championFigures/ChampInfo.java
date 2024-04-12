package championFigures;

import itemFigures.Item;

import java.util.ArrayList;
import java.util.Collections;

public abstract class ChampInfo implements StrToObj, OutputInfo{
	protected ArrayList<String> origins = new ArrayList<>(), classes = new ArrayList<>();
	protected int star = 1, cost, itemLim = 3;
	protected ArrayList<Item> item = new ArrayList<>();
	
	public void upgradeStar() {
		
	}
	
	public static boolean contains(ArrayList<Item> ls, Item it)
	{
		for (Item i: ls)
			if (i.outputName().equals(it.outputName()))
				return true;
		
		return false;
	}
	
	public void addItem(Item it) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (item.size() >= itemLim)
		{
			System.out.println("A champion can only be equipped up to " + itemLim + " items");
			return;
		}

		if (ChampInfo.contains(item, it) && it.getUnique())
		{
			System.out.println(it.outputName() + " can be equipped only one per champion");
			return;
		}
		
		if (origins.contains(it.outputClassName()) || classes.contains(it.outputClassName()))
		{
			System.out.println(this.outputName() + " already has " + it.outputName() + " trait.");
			return; 
		}
		
		item.add(it);
		if (it.getClass().getPackage().getName().equals("emblems"))
		{
			String name = it.getClass().getSimpleName();
			String traitName = StrToTraitName(name);
			if (traitName.equals("origins"))
				origins.add(name);
			else
				classes.add(name);
		}
	}
	
	public void removeItem(Item it) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		for (int i = 0; i < item.size(); i++)
		{
			if (item.get(i).outputName().equals(it.outputName()))
			{
				item.remove(i);
				if (it.getClass().getPackage().getName().equals("emblems"))
				{
					String name = it.getClass().getSimpleName();
					String traitName = StrToTraitName(name);
					if (traitName.equals("origins"))
						origins.remove(name);
					else
						classes.remove(name);
				}
				return;
			}
		}
		
		System.out.println("No " + it.outputName() + " on " + this.outputName());
	}
	
	public abstract String toString();
	
	public ArrayList<String> showSyn() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ArrayList<String> collectSyn = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<>();

		for (String s: origins)
			collectSyn.add(s);

		Collections.sort(collectSyn);
		
		for (String s: classes)
			temp.add(s);
		
		Collections.sort(temp);
		
		collectSyn.addAll(temp);
		
		return collectSyn;
	}
	
	public void showSynFuncion() throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		for (String s: classes)
		{
			System.out.println(s + " " + changeStrToObj("classes", s) + " ");
		}
		
		System.out.println();
	}
	
	/*public String outputName()
	{
		return getClass().getSimpleName();
	}*/
}
