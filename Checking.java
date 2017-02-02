import java.util.*;
import java.text.*;
public class Checking extends Account
{
	    private int Numofcheck;
	    private double fee;
	    public Checking(String N)
	    {
			name = N;
		}


		public void getInput()
		{
			Scanner keyboard = new Scanner(System.in);
			super.getInput();
			System.out.print("Number of checks: ");
			Numofcheck = keyboard.nextInt();
			//Code to ask the user and get input for all the instance variables
		}
		public int getNumofcheck()
		{
			return Numofcheck;
		}
		public void setNumofcheck( int wNumofcheck)
		{
			Numofcheck = wNumofcheck;
		}

		public String toString()
		{
			String out = "";
			out += "\n "+ super.toString();
			out += "\n number of check: " + Numofcheck;
			out +="the fee is "+ getfee();
			return out;
		}

		public String getfee()
		{

			if(Numofcheck > 12)
			{
				int n = Numofcheck - 12;
				fee = 3*n;
			}
			else
			{
				fee = 0.00;
			}
					NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
					//double dblNo = 789289.23;
		            //System.out.println(nf.format(fee));


			return nf.format(fee);

		}
	}