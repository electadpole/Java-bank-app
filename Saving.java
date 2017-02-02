import java.util.*;
import java.text.*;
public class Saving extends Account
{
	    private double min, average,fee;

	    public Saving(String N)
	    {
			name = N;
		}


		public void getInput()
		{
			Scanner keyboard = new Scanner(System.in);
			super.getInput();
			System.out.println("minimun balance required: ");
			min= keyboard.nextDouble();
			System.out.println("average balance :");
			average = keyboard.nextDouble();
			//Code to ask the user and get input for all the instance variables
		}

		public double getmin()
		{
			return min;
		}
		public String getusmin()
		{
			NumberFormat minf = NumberFormat.getCurrencyInstance(Locale.US);



		     return minf.format(min);
		 }

		public void setmin(double amin)
		{
			min = amin;
		}
		public double getaverage()
		{
			return average;
		}
		public String getusaverage()
		{
					NumberFormat averagef = NumberFormat.getCurrencyInstance(Locale.US);



				     return averagef.format(average);
		 }
		public void setaverage(double xaverage)
		{
			average = xaverage;
		}
		public String toString()
		{
			String out = "";
			out += super.toString();
			out += "\n minimun balance required: " + getusmin();
			out += "\n average balance :" + getusaverage();
			out += "\n the fee: " + getfee();

			return out;
		}

         /**
         *This method overrides the abstract method in the base class per the requirements of the
         *problem definition
         */
		public String getfee()
		{

			if(average >= min)
			{

				fee = 0;
			}
			else if(average < (min-100))
			{
				fee = 25;
			}
			else if(average < (min-50))
			{
				fee = 50;
			}
			else
			{
			}
			NumberFormat cf = NumberFormat.getCurrencyInstance(Locale.US);
			return cf.format(fee);

		}
	}
