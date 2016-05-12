package ba.unsa.etf.si.tim11.dbmodels;

/**
 * 
 * @author Elvedin
 *	Klasa za validaciju podataka
 */

public class Validator
{
	/**
	 * 
	 * @param s
	 * @return
	 * Provjerava da li je string prazan
	 */
	public static Boolean daLiJeStringPrazan(String s)
	{
		String prazan="^[\\s]+$";
		if(s.equals(null)||s.matches(prazan))
		{
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param s
	 * @return
	 * Provjerava da li se string sastoji samo od slova uključujući afrikate i whitespace
	 */
	public static Boolean daLiJeStringSamoSlova(String s)
	{
		String regex="^[a-zA-ZčćžšđČĆŽŠĐ\\s]+$";
		if(s.matches(regex))
		{
			return true;
		}
		return false;
	}
	public static Boolean samoJedanBroj(String s)
	{
		String broj="^[0-9]+$";
		if(s.length()==1&&s.matches(broj))
		{
			return true;
		}
		return false;
	}
	public static Boolean daLiJeTrueFalse(String s)
	{
		if(s.matches("^true")||s.matches("^false"))
		{
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param s
	 * @return
	 * Provjerava da li se string sastoji samo od slova i brojeva uključujući afrikate i whitespace
	 */
	public static Boolean daLiJeStringSlovaIBrojevi(String s)
	{
		String regex="^[a-zA-ZčćžšđČĆŽŠĐ0-9\\s]+$";
		if(s.matches(regex))
		{
			return true;
		}
		return false;
	}
	public static Boolean daLiJeNizPrazan(char c[])
	{
		Boolean prazan=false;
		if(c.length==0)
		{
			return true;
		}
		for(int i=0;i<c.length;i++)
		{
			if(c[i]==' ')
			{
				prazan=true;
				break;
			}
		}
		if(prazan)
		{
			return true;
		}
		
		return false;
	}
	public static Boolean istiNizovi(char c1[], char c2[])
	{
		if(c1.length!=c2.length)
		{
			return false;
		}
		for(int i=0;i<c1.length;i++)
		{
			if(c1[i]!=c2[i])
			{
				return false;
			}
		}
		return true;
	}
}









