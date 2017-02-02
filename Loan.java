import java.util.*;
import java.text.*;
public class Loan extends Account
{
	    private int day;
	    private double monthly,fee;

        public Loan(String N)
        {
			name = N;
		}

		public void getInput()
		{

			Scanner keyboard = new Scanner(System.in);
			super.getInput();
			System.out.println("\n number of days past grace period: ");
			day = keyboard.nextInt();
			System.out.println("\n monthly payment :");
			monthly = keyboard.nextDouble();

			//Code to ask the user and get input for all the instance variables
		}
		public void setday(int aday)
		{
			day = aday;
		}
		public int getday()
		{
			return day;
		}
		public double getmonthly()
		{
			return monthly;
		}
		public String getusmonthly()
		{
			NumberFormat mf = NumberFormat.getCurrencyInstance(Locale.US);



		return mf.format(monthly);
	    }
		public void setmonthly(double amonthly)
		{
			monthly = amonthly;
		}
		public String toString()
		{
			String out = "";
			out += super.toString();
			out += "\n umber of days past grace period: " + day;
			out += "\n monthly payment: " + getusmonthly();
			out += "\n the fee is: "+ getfee();
			return out;
		}

         /**
         *This method overrides the abstract method in the base class per the requirements of the
         *problem definition
         */
		public String getfee()
		{

			if(day > 0)
			{

				fee = 5*day + 0.01*monthly;
			}
			else
			{
				fee = 0.00;
			}


			NumberFormat af = NumberFormat.getCurrencyInstance(Locale.US);
			return af.format(fee);


		}
	}