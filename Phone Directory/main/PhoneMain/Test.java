package PhoneMain;

import java.util.*;

public class Test 
{
	
	public static void main(String args[])
	{
		phone myPhone = new phone();
		int len = Resources.getLength();
		myPhone.construct(len);
		Resources.populateInMem(myPhone);
		String ans = "y";
		int response, entryCount = 0;
		Scanner reader = new Scanner(System.in);
		while(ans.equals("y"))
		{//This while loops runs constantly allowing the user to enter as much as 10 new entries and unlimited other options
			System.out.println("What would you like to do today?");
			System.out.println("1 Add a new entry\n2 Delete an entry\n3 Find a number\n4 Update an entry\n5 Print out the full directory\n");
			response = reader.nextInt();
			
			switch(response)
			{
			case 1:
				System.out.println("I got here");
				myPhone.addEntry(Resources.getUserName(), Resources.getUserNum());
				entryCount ++;
				break;
			case 2:
				myPhone.delEntry(Resources.getUserName());
				break;
			case 3:
				String aname = Resources.getUserName();
				String num;
				num = myPhone.getNum(aname);
				System.out.println("Name is: " + aname + "\nNumber is: " + num);
				break;
			case 4:
				myPhone.updateEntry(Resources.getUserName(), Resources.getUserNum(), Resources.getUserName());
				break;
			case 5:
				myPhone.printDirectory();
				break;
			default:
				System.out.println("You Entered an invalid option would you like to try again?");
				break;
			}
			if(entryCount >10)
			{
				System.out.println("You have entered 10 new entries you will have to run program\nagain if you want to add more\n");
				break;
			}
			System.out.println("\nWould you like to continue? y/n");
			ans = reader.next();	
		}
		myPhone.writeToFile();
		System.out.println("Goodbye now");
	}
	
}
