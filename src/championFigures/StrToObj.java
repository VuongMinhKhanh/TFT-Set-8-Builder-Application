package championFigures;

public interface StrToObj {
	default Object changeStrToObj(String packLink, String obj) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		String str = packLink + "." + obj; 
		Class<?> c = Class.forName(str);
		return c.newInstance();
	}
	
	default String StrToTraitName(String thisSyn) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Synergy syn = null;
		try {
			syn = (Synergy) changeStrToObj("classes" ,thisSyn);
		}
		catch (Exception ex){
			syn = (Synergy) changeStrToObj("origins", thisSyn);
		}
		
		return syn.getClass().getPackage().getName();
	}
	
	default Synergy StrToItsTrait(String thisSyn) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Synergy syn = null;
		try {
			syn = (Synergy) changeStrToObj("classes" ,thisSyn);
		}
		catch (Exception ex){
			syn = (Synergy) changeStrToObj("origins", thisSyn);
		}
		
		return syn;
	}
}
