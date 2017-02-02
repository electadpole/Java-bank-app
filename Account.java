import java.util.*;
import java.text.*;
import java.io.Serializable;
public abstract class Account implements Serializable
{
	private int accountNum;
	public String name,bankname;
	private String city;
	private double balance;
	private Person owner;

	public void getowner(Person a)
	{
		owner = a;
	}

    public String getownername()
    {
		return owner.getname();
	}

	public double getIncome()
	{
		return owner.getIncome();
	}
	public String getusIncome()
	{
		return owner.getusIncome();
	}



	public void getInput()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("account number: ");
		accountNum = keyboard.nextInt();
		System.out.print("account balance: ");
		balance = keyboard.nextDouble();
		System.out.print("city:");
		city = keyboard.next();
		System.out.println("bank name:");
		bankname = keyboard.next();
	}

	public void setname(String xname)
	{
		name = xname;
	}
	public String getname()
	{
		return name;
	}
	public void setcity(String xcity)
	{
		city = xcity;
	}
	public String getcity()
	{
		return city;
	}
	public void setnum(int xnum)
	{
		accountNum = xnum;
	}
	public int getnum()
	{
		return accountNum;
	}
	public void setbalance(double xbalance)
	{
		balance = xbalance;
	}
	public double getbalance()
	{

		return balance;
	}
	public String getusbalance()
	{
		NumberFormat wf = NumberFormat.getCurrencyInstance(Locale.US);



			return wf.format(balance);
	}

	public String toString()
	{
		String out = name;
		out += "\n name: " + name;
		out += "\n account number: " + accountNum;
		out += "\n city: " + city;
		out += "\n balance: " + getusbalance();
		out +="\n bank name: " +bankname;
		return out;

		//code to print out values of the instance variables
	}

	public abstract String getfee(); //This abstract method will be overridden in the derived classes



}