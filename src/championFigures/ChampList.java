package championFigures;

import itemFigures.Item;

import java.util.*;
import java.util.stream.Collectors;

public class ChampList implements StrToObj, OutputInfo {
	protected ArrayList<ChampInfo> deck = new ArrayList<ChampInfo>();
	private boolean isWrongChamp = false, isWrongItem = false;
	
	public void addChamp(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		try {
			deck.add((ChampInfo) changeStrToObj("championNames", name));
		}
		catch (Exception ex) {
			isWrongChamp = true;
			System.out.println("Error: Wrong champion's name input.");
		}
	}
	
	public void removeChamp(String name, int pos)
	{
		ArrayList<Integer> idx = new ArrayList<>();
		try {
			for (int i = 0; i < deck.size(); i++)
			{
				if (deck.get(i).outputName().equals(name))
					idx.add(i);
			}
		
			int revInx = outputIndex(deck, name, pos);
			deck.remove(revInx);
		}
		catch (Exception ex)
		{
			System.out.println("Wrong champion's name input or champion's index.");
		}
	}
	
	public void removeChamp(String name)
	{
		boolean rs = deck.remove(getChamp(name));

		if (!rs)
		{
			isWrongChamp = true;
			System.out.println("Wrong champion's name input.");
		}
	}
	
	public void countSynergy() throws ClassNotFoundException, InstantiationException, IllegalAccessException 
	{
		// deckSyn: mảng các tộc hệ
		// filteredDeck: mảng các tộc hệ đã được l�?c các tộc hệ thừa (VD: 3 samira => 1 sureshot) 
		// synList: mảng các tộc hệ đã được l�?c các tộc hệ thừa (VD: sureshot, sureshot => sureshot)
		
		myDeck();
		
		ArrayList<ChampInfo> newDeck = filteredDeck();
		
		ArrayList<String> deckSyn = new ArrayList<>();
		for (ChampInfo c: newDeck)
			deckSyn.addAll(c.showSyn());
		
		ArrayList<String> synList = (ArrayList<String>) deckSyn.stream().distinct().collect(Collectors.toList());
		
		synList.sort((String s1, String s2)->{
			String trait1 = null, trait2 = null;
			try {
				trait1 = StrToTraitName(s1);
				trait2 = StrToTraitName(s2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return trait2.compareTo(trait1);
		});
		
		for (String s: synList)
		{
			int curNum = Collections.frequency(deckSyn, s);
			System.out.println(curNum + " " + s + StrToItsTrait(s).currentThreshold(curNum));
		}
	}
	
	boolean endIO(String s, String cmd) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		if (s.equals(cmd))
			return true;
		
		return false;
	}
	
	int IOIndex(String champ)
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		ArrayList <String> strDeck = new ArrayList<>();
		for (ChampInfo c: deck)
			strDeck.add(c.outputName());
		
		int idx = 0;
		if (Collections.frequency(strDeck, champ) > 1)
		{
			System.out.print("Choose a position: ");
			try {
				idx = Integer.parseInt(sc.nextLine()); // change from entering Int in to String => [anti-command line bypass - not sure the right word
			} catch (Exception ex) {
				System.out.println("Invalid input (must be Int value).");
			}
		}
		
		return idx;
	}
	public void playTheGame() throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			String champ = null;
			String item= null;
			int idx = 0;
			try {
				do {
					resetBool();
					System.out.print("Enter a Champion's name: ");
					champ = ChampList.capitalizeWord(sc.nextLine());
					
					if (endIO(champ, "0"))
						break;
					
					addChamp(champ);
					
				} while (isWrongChamp);
				
				if (endIO(champ, "0"))
					break;
				
				countSynergy();
				
				while (true)
				{
					idx = 0;
					do {
						System.out.print("Choose an item: ");
						item = ChampList.capitalizeWord(sc.nextLine());
						
						if (endIO(item, "0"))
							break;
						
						System.out.print("for which Champion?: ");
						champ = ChampList.capitalizeWord(sc.nextLine());
						
						ArrayList <String> strDeck = new ArrayList<>();
						for (ChampInfo c: deck)
							strDeck.add(c.outputName());
						
						idx = IOIndex(champ);
						
					} while (isWrongItem);
					
					if (endIO(item, "0"))
						break;
					
					addItem(item, champ, idx);
					countSynergy();
					resetBool();
				}
				
				while (true)
				{
					idx = 0;
					do {
						System.out.print("Remove an item: ");
						item = ChampList.capitalizeWord(sc.nextLine());
						
						if (endIO(item, "0"))
							break;
						
						System.out.print("from which Champion?: ");
						champ = ChampList.capitalizeWord(sc.nextLine());
						
						idx = IOIndex(champ);
						
					} while (isWrongItem);
					
					if (endIO(item, "0"))
						break;
					
					removeItem(item, champ, idx);
					countSynergy();
					resetBool();
				}
	
				while (true && deck.size() > 0)
				{
					idx = 0;
					do {
						System.out.print("Remove a Champion: ");
						champ = ChampList.capitalizeWord(sc.nextLine());
						if (endIO(champ, "0"))
							break;
						
						idx = IOIndex(champ);
					} while (isWrongChamp);
					
					if (endIO(champ, "0"))
						break;
					
					if (idx == 0)
						removeChamp(champ);
					else
						removeChamp(champ, idx);
					
					countSynergy();
					resetBool();
				}
			} catch (Exception ex) {
				System.out.println("Invalid input.");
			}
		}
		countSynergy();
	}
	
	void resetBool()
	{
		isWrongChamp = false;
		isWrongItem = false;
	}
	
	ChampInfo getChamp(String champ)
	{
		for (ChampInfo c: deck)
		{
			if (c.getClass().getSimpleName().equals(champ))
				return c;
		}
		return null;
	}
	
	public static String capitalizeWord(String str){  
		str = str.toLowerCase();
	    String words[] = str.split(" ");  
	    String capitalizeWord = "";  

	    for (int i = 0; i < words.length; i++)
	    {
	    	String first = words[i].substring(0, 1);
	    	String afterfirst = words[i].substring(1);
	    	capitalizeWord += first.toUpperCase() + afterfirst;
	    	if (i < words.length - 1)
	    		capitalizeWord += "_";
	    }
	    
	    return capitalizeWord.trim();  
	}  
	
	public void addItem(String item, String champ, int champPos) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		try {
			try {
				deck.get(outputIndex(deck, champ, champPos)).addItem((Item) changeStrToObj("emblems", item));
			}
			catch (Exception ex){
				deck.get(outputIndex(deck, champ, champPos)).addItem((Item) changeStrToObj("items", item));
			}
		}
		catch (Exception ex){
			isWrongItem = true;
			System.out.println("Error: Wrong item's name or champion's name input.");
		}
	}
	
	public void removeItem(String item, String champ, int champPos)
	{
		try {
			try {
				deck.get(outputIndex(deck, champ, champPos)).removeItem((Item) changeStrToObj("emblems", item));
			}
			catch (Exception ex){
				deck.get(outputIndex(deck, champ, champPos)).removeItem((Item) changeStrToObj("items", item));
			}
		}
		catch (Exception ex){
			isWrongItem = true;
			System.out.println("Error: Wrong item's name or champion's name input.");
		}
	}
	
	public ArrayList<ChampInfo> filteredDeck()
	{
		ArrayList<ChampInfo> newDeck = new ArrayList<ChampInfo>(deck);
		for (int i = 0; i < newDeck.size() - 1; i++)
		{
			for (int j = i + 1; j < newDeck.size(); j++)
			{
				if (newDeck.get(i).outputName().equals(newDeck.get(j).outputName()))
					newDeck.remove(j);
			}
		}
		
		return newDeck;
	}
	
	public void myDeck()
	{
		System.out.print("Your Deck: [");
		for (int i = 0; i < deck.size(); i++)
		{
			System.out.print(deck.get(i).outputName());
			myItems(deck.get(i).item);
			
			if (i + 1 < deck.size())
				System.out.print(", ");
		}
		System.out.println("]");
	}
	
	public void myItems(ArrayList<Item> ls)
	{
		if (ls.size() > 0)
		{
			System.out.print(" {");
			for (int i = 0; i < ls.size(); i++)
			{
				System.out.print(ls.get(i).outputName());
				
				if (i + 1 < ls.size())
					System.out.print(", ");
			}
			
			System.out.print("}");
		}
	}
	
}
