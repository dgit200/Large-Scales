package PhoneMain;

import java.io.*;
import PhoneProperties.Properties;
import DriverProgram.Test;

public class phone 
{//This is the Declaration of the class phone which will hold the entries for the directory.
	private	String [] num;
	private String [] name;
	private int current, lenght;
	
	public void construct(int len)
	{//This is my constructor method it initializes my class variables
	//It is assumed that You can only add 10 new directories at a time.
		lenght = len + 10;
		current = 0;
		num = new String[lenght];
		name = new String[lenght];
	}
	
	public void addEntry(String fname, String number)
	{//This add a new entry to the directory in memory.
		name[current] = fname;
		num[current] = number;
		current++;
		System.out.println("The entry was successfully entered");
	}

	public void delEntry(String pname)
	{//This deletes a selected entry from the directory in memory.
		int i = 0;
		while(i < current)
		{
			if(pname.equals(name[i]))
			{
				for(int j=i; j< current; j++)
				{
					name[j] = name[j+1];
					num[j] = num[j+1];
				}
				break;
			}
			i++;
		}
		if(i > current)
		{
			System.out.println("That Person was not found in the directory");
		}
		else
		{
			System.out.println("The entry was successfully deleted");
		}
	}

	public String getNum(String pname)
	{//This return the number of a particular name in the direcory or else it returns -1.
		int i = 0;
		while(i < current)
		{
			if(pname.equals(name[i]))
			{
				return num[i];
			}
			i++;
		}
		System.out.println("That Person was not found in the directory");
		return "-1";
	}

	public void updateEntry(String pname, String number, String newName)
	{//This updates the value of an entry.
		int i = 0;
		while(i <= current)
		{
			if(pname.equals(name[i]))
			{
				name[i] = newName;
				num[i] = number;
				break;
			}
			i++;
		}
		if(i > current)
		{
			System.out.println("That Person was not found in the directory");
		}
		else
		{
			System.out.println("The entry was successfully deleted");
		}
	}

	public void writeToFile()
	{//This function is used to write the directory from main memory back out to the file.
		int i = 0;
		try
		{
			FileWriter outstream = new FileWriter(Properties.path);
			PrintWriter out = new PrintWriter(outstream);

			while(i < current)
			{
				out.println(name[i]);
				out.println(num[i]);
				i++;
			}
			out.close();
		}
		catch(IOException e)
		{
			System.out.println("There Was and Error with the File");
		}
	}

	public void printDirectory()
	{//This method outputs the present contents in the directory to the screen.
		int i = 0;
		while(i < current)
		{
			System.out.println(name[i]);
			System.out.println(num[i]);
			i++;
		}
	}

}

