import java.util.Scanner;
import java.io.*;

public class accountdriver{
	private int Numofaccount = 0;
	Account[] account;

	public static void main(String[] args)
	{
		accountdriver myDemo = new accountdriver();
		myDemo.runMenu();
	}

	public void runMenu()
	{
			Scanner keyboard = new Scanner(System.in);
			account = new Account[25];
			readFileData();
			//System.out.println(Numofaccount);
		    int choice = 0;
			while(choice !=  5)
			{
				System.out.println("==== Menu ====");
				System.out.println("1. To add an account");
				System.out.println("2. To list account number, owner's name and fees assessed");
				System.out.println("3. To display account number together with the balance for all checking and savings accounts whose balance is less than 10% of the associated Person salary");
				System.out.println("4. To display account and owner's information for all account");
				System.out.println("5. To exit the program");
				System.out.print("Your choice: ");
				choice = keyboard.nextInt();
				switch (choice)
				{
						case 1:
									runOption1();
									break;
						case 2:
								    runOption2();
								    break;
						case 3:
									runOption3();
									break;
						case 4:
						            runOption4();
						            break;
						case 5:
						            runOption5();
						            break;

				}
			}
	}
	private void runOption1()
	{
		Scanner keyboard = new Scanner(System.in);
		Account newaccount = null;
		Person newowner = new Person();
		int choice = 0;

		do{
			System.out.println("Type of account? ");
			System.out.println("1-checking;2-saving;3-loan");
			choice = keyboard.nextInt();

			if(choice == 1){
				Checking newchecking = new Checking("Checking");
				newchecking.getInput();
				newowner.getInput();
				newchecking.getowner(newowner);
				newaccount = newchecking;
			}

			else if(choice == 2){
				Saving newsaving = new Saving("Saving");
				newsaving.getInput();
				newowner.getInput();
				newsaving.getowner(newowner);
				newaccount = newsaving;
			}
			else if(choice == 3)
			{
				Loan newloan = new Loan("Loan");
				newloan.getInput();
				newowner.getInput();
				newloan.getowner(newowner);
				newaccount = newloan;
			}
			else
			{
				System.out.println("Wrong choice");
			}



		}while(choice < 1 || choice >3);

		account[Numofaccount] = newaccount;
		Numofaccount++;


		System.out.println("Number of accounts: "+ Numofaccount + "\n\n");
	}

   private void runOption2()
   {
        System.out.println("\n\n");
		System.out.println("=========================================");
		System.out.println("list the account number,owner and fee assessed");
		System.out.println("=========================================");
		System.out.println("account number    owner's name    fee");

		for( int a = 0; a <= (Numofaccount-1); a++)
		{	//System.out.println("value of a  -> "+a+ "and NOF -> "+Numofaccount);
		     String c = account[a].getfee();

		    if(!c.equals("$0.00"))
		    {
			System.out.println(account[a].getnum()+"                " + account[a].getownername()+"                 "+account[a].getfee());
		    }
			//System.out.println("blah blah");
		}
	}

	private void runOption3()
	{

		System.out.println("account number    balance");
	    int a = 0;


		while(a <= (Numofaccount-1))
		{
			String b = account[a].getname();
			double c = account[a].getbalance();
			double d = account[a].getIncome()*0.1;

			if((b.equalsIgnoreCase("saving")||b.equalsIgnoreCase("checking"))&&(c < d))
			{
				System.out.println(account[a].getnum() +"                  "+ account[a].getusbalance());

			}
			a++;

		}
	}





	private void runOption4()
	{
		int a = 0;
		while(a <=(Numofaccount-1))
		{
			System.out.println(account[a].toString());
			System.out.println("owner name: "+account[a].getownername());
			System.out.println("owner income: "+account[a].getusIncome());
			System.out.println("------------------------------");
			a++;
		}

    }

    private void runOption5()
    {
			Scanner keyboard = new Scanner(System.in);
			saveData();
			System.out.println("You chose to exit the program");
			System.out.println("Are you sure(Y/N)?");
			String yesNo = keyboard.next();
			if(yesNo.substring(0,1).equalsIgnoreCase("Y"))
			System.exit(0);
	}

	private void saveData()
	{
		ObjectOutputStream objout = null;
		try
		{
			objout = new ObjectOutputStream( new FileOutputStream ("accountdata.dat"));
			objout.writeObject(account);
			objout.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	private void readFileData()
	{
		ObjectInputStream objin = null;
			try
			{
			objin = new ObjectInputStream( new FileInputStream("accountdata.dat"));
			try
			  {	int i = 0;
			   account = (Account[]) objin.readObject();
				  while(account[i].getname()!=null)
				  {
					//System.out.println(account.length);
					//System.out.println(account[i].getname()+" -> "+ i);
					i++;




			         Numofaccount++;


		           }
		        }
		      catch(EOFException e)
		      {
			   System.out.println(e.getMessage());
		      }
		      catch(Exception e)
		      {
			   System.out.println(e.getMessage());
		       }

		       objin.close();
		   }
		 catch(IOException e)
	   {
		System.out.println(e.getMessage());
	   }
   }
}




