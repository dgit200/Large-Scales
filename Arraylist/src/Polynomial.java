/** This call is used to represent the polynomial it takes the terms and combines them into full polynomials
 * 
 * @author DwightThomas
 *
 */

import java.util.*;


public class Polynomial 
{
	/** This the private instance variables of the class, the arraylist and polynomial number */
	private ArrayList<Term> poly;
	private String poly_num;
	
	/**This is the constructor method it initializes the arraylist and P number*/
	
	Polynomial(String p_num)
	{
		poly = new ArrayList<Term>();
		poly_num = p_num;
	}
	
	/**This is the insert method which inserts a term into polynomial*/
	
	public void insert(int c, int e)
	{
		Term t = new Term(c, e);
			if(poly.size()==0)
			{
				poly.add(t);
			}
			else
			{
				int j = 0;
				while(j < poly.size())
				{
					if(poly.get(j).getExp() >= t.getExp())
					{
						poly.add(j, t);
						break;
					}
					j++;
				}
				if(j == poly.size())
				{
					poly.add(t);
				}
			}
		}
	
	/**This is the delete method which is used to remove a term from polynomial*/
	
	public void delete(int c, int e)
	{
		Term t = new Term(c, e);
		for(int i = 0; i < poly.size(); i++)
		{
			if(t.getCoe() == poly.get(i).getCoe() && t.getExp() == poly.get(i).getExp())
			{
				poly.remove(i);
				break;
			}
			else
			{
				if(i == poly.size()-1)
				{
					System.out.println("This term is not in the polynomial.");
				}
			}
		}
	}

	/**This method reverses the order of the polynomial*/
	
	public String reverseP()
	{
		String rev = (poly_num + "(X) =");
		int i = poly.size()-1;
		while(i>=0)
		{
			if(i == poly.size()-1 && poly.get(i).getCoe() >=0)
			{
				rev = rev.concat(" " + poly.get(i).toString().substring(1));
			}
			else
			{
				rev = rev.concat(" " + poly.get(i).toString());
			}
			i--;
		}
		return rev;
	}

	/** This method returns the polynomial as its full self*/
	
	public String productP()
	{
		String prod = (poly_num + "(X)=");
		for(int i=0; i<poly.size();i++)
		{
			if(i == 0 && poly.get(i).getCoe() >=0)
			{
				String temp = poly.get(i).toString().substring(1);
				prod = prod.concat(" " + temp);
			}
			else
			{
				prod = prod.concat(" " + poly.get(i).toString());
			}
		}
		return prod;
	}
}
