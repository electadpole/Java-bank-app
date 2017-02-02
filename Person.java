import java.util.*;
import java.text.*;
import java.io.Serializable;
public class Person implements Serializable
{
	private String pName;
	private double Income;

	public Person(String zname, double zincome)
	{
		pName = zname;
		zincome = Income;
	}
	public Person()
	{
	}

	public void getInput()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Person name:");
		pName = keyboard.next();
		System.out.println("Person Income:");
		Income = keyboard.nextDouble();
		//Code to ask the user and get input for all the instance variables
	}
	public double getIncome()
	{
		return Income;
	}

	public void setIncome( double qIncome)
	{
		Income = qIncome;
	}
	public String getusIncome()
	{
		NumberFormat df = NumberFormat.getCurrencyInstance(Locale.US);



		return df.format(Income);
	}

	public void setname(String qname)
	{
		pName = qname;
	}

	public String getname()
	{
		return pName;
	}

	public String toString()
	{
		String out = pName+ "    "+ Income;
		return out;
		//code to print out values of the instance variables
	}
}