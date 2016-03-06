package PhoneProperties;

import java.io.*;
import java.util.Scanner;
import java.util.*;
import PhoneMain.phone;

public class Properties 
{//Figure out how to read and write properly in java and you will be good,
//also comment every method in your classes so that you look professional 
	public static String path = "PhoneDirectory.txt";
		
		public static int getLength()
		{//This gets the number of entries that are stored in the file to help dynamically allocate space in memory for it.
			int len = 0;
			
			try
			{
				String temp;
				FileReader instream = new FileReader(Properties.path);
				BufferedReader in = new BufferedReader(instream);
				if((temp = in.readLine()) != null)
				{
					while((temp = in.readLine()) != null)
					{
						len++;
					}
				}
				else
				{
					len = 0;
				}
				in.close();
			}
			catch(IOException e)
			{
				System.out.println("Error File Not Found");
			}
			return len;
		}

		public static void populateInMem(phone thisPhone)
		{//This reads the directory's contents from the file into memory.
			String Name, Num;
			try
			{
				FileReader instream = new FileReader(Properties.path);
				BufferedReader in = new BufferedReader(instream);
				
				while((Name = in.readLine()) != null)
				{
					Num = in.readLine();
					thisPhone.addEntry(Name, Num);
				}
				in.close();
			}
			catch(IOException e)
			{
				System.out.println("Error File Not Found");
			}
		}

		public static String getUserName()
		{//This method is used to get the names from the user.
			Scanner reader = new Scanner(System.in);
			System.out.println("Enter the Name of the entry");
			String name = reader.next();
			return name;
		}
		
		public static String getUserNum()
		{//This method is used to get the numbers from the user.
			Scanner reader = new Scanner(System.in);
			System.out.println("Enter the number for the entry");
			String num = reader.next();
			return num;
		}

	}
