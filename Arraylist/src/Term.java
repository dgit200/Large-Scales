/**This class takes use to create the terms in the polynomial
 * 
 * @author DwightThomas
 *
 */

public class Term 
{
	/** These are my private instance variables they are the coeficent and exponent of the term*/
	
	private int coe;
	private int exp;
	private String fterm;
	
	/** This is my constructor method with takes in the coeficent and exponent as parameter*/
	
	public Term(int c, int e)
	{
		coe = c;
		exp = e;
	}
	
	/** This method returns the term as string in its matematical representation*/
	
	public String toString()
	{
		if(exp == 0)
		{
			if(coe >= 0)
			{
				fterm = ("+" + Integer.toString(coe));
			}
			else
			{
				fterm = (Integer.toString(coe));
			}
		}
		else
		{
			if(coe>=0)
			{
				fterm = ("+" + Integer.toString(coe) + "x^" + Integer.toString(exp));
			}
			else
			{
				fterm = (Integer.toString(coe) + "x^" + Integer.toString(exp));
			}
		}
		return fterm;
	}
	
	/** This method return the exponent of the term*/
	public int getExp()
	{
		return exp;
	}
	
	/** This method returns the coeficent of the term*/
	public int getCoe()
	{
		return coe;
	}

}
