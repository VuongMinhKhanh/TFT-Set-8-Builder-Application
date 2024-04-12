package main;

import java.io.FileNotFoundException;

import championFigures.ChampList;


public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {
		ChampList ls = new ChampList();
		/*ls.addChamp("Aphelios");	
		ls.addChamp("Ashe");
		ls.addChamp("Samira");
		//ls.addChamp("Ashe");
		//ls.removeChamp("Ashe", 3);
		//ls.removeChamp("Samira");
		//ls.addChamp("Samira");
		ls.addItem("Ace", "Ashe");//
		ls.removeItem("Ace", "Ashe");
		ls.removeItem("Ace", "Ashe");
		//ls.addItem("Infinity_Edge", "Ashe");
		//ls.addItem("Ace", "Samira");
		//ls.addChamp("Sejuani");
		ls.countSynergy();*/
		ls.playTheGame();//
		
	}

}
