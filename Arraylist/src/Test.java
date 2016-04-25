/** This is test class which is where the polynomial and term class are implememted
 * 
 * @author DwightThomas
 *
 */

import java.util.Scanner;
import java.io.*;


public class Test 
{
	/** This is the main class where all the actual implementation happens*/
	public static void main(String args[])
	{
		String[] the_input = r_file();
		Polynomial[] the_poly_file = pop_pol(the_input);
		Scanner reader = new Scanner(System.in);
		int response, pNum, coe, exp;
		String ans = "yes";
		/** This while loop is used to allow the user to continually loop through and test this programs funtionality*/
		while(ans.equals("yes"))
		{
			System.out.println("Do you want to add an term to polynomial 1");
			System.out.println("Do you want to delete an term from polynomial 2");
			System.out.println("Do you want to revesre the polynomial 3");
			response = reader.nextInt();
			switch(response)
			{
			case 1:
				System.out.println("Enter the Polynomial Number: enter the coefiecent and exponent to be inserted");
				pNum = reader.nextInt();
				coe = reader.nextInt();
				exp = reader.nextInt();
				the_poly_file[pNum-1].insert(coe, exp);
				System.out.println(the_poly_file[pNum-1].productP());
				break;
			case 2:
				System.out.println("Enter the Polynomial Number: enter the coefiecent and exponent to be deleted");
				pNum = reader.nextInt();
				coe = reader.nextInt();
				exp = reader.nextInt();
				the_poly_file[pNum-1].delete(coe, exp);
				System.out.println(the_poly_file[pNum-1].productP());
				break;
			case 3:
				System.out.println("Enter the polynomial number to be reversed");
				pNum = reader.nextInt();
				System.out.println(the_poly_file[pNum-1].reverseP());
				break;
				default:
					System.out.println("You entered an invalid option");
			}
			System.out.println("Would you like to continue: yes/no?");
			ans = reader.next();
		}
	}

	/**This is a helper class that reads the polynomials from the file*/
	public static String[] r_file()
	{
		String[] file = new String[15];
		try
		{
			FileReader instream = new FileReader("C:\\Users\\DwightThomas\\workspace\\Arraylist\\src\\Pfile");
			BufferedReader in = new BufferedReader(instream);
			int i = 0;
			file[i] = in.readLine();
			while(file[i] != null)
			{
				i++;
				file[i] = in.readLine();
			}
		}
		catch(IOException e)
		{
			System.out.println("This file not found");
		}
		return file;
	}

	/**This is a help class that populates all the polynomials from the info read from the file*/
	public static Polynomial[] pop_pol(String[] input)
	{
		Polynomial[] pol = new Polynomial[15];
		int i = 0;
		while(input[i]!= null)
		{
			String temp = input[i];
			String p_num = temp.substring(0, 2);
			temp = temp.substring(3);
			int len_of_poly = temp.length();
			int[] p_in = new int[len_of_poly];
			int j = 0;
			for(int k = 0; k<len_of_poly; k+=2)
			{
				if(temp.substring(k, k+1).equals("-"))
				{
					p_in[j] = Integer.parseInt(temp.substring(k, k+2));
					k++;
					j++;
				}
				else
				{
					p_in[j] = Integer.parseInt(temp.substring(k, k+1));
					j++;
				}
			}
			len_of_poly = j;
			pol[i] = new Polynomial(p_num);
			System.out.println("This is populating the Polynomials");
			for(int k = 0; k<len_of_poly; k+=2)
			{
				pol[i].insert(p_in[k], p_in[k+1]);
				System.out.println("This a term being inserted: " + pol[i].productP());
			}
			i++;
		}
		return pol;
	}

	
}
