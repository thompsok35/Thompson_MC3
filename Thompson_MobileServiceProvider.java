 /* 
   Programmer:    Keith Thompson
   Program Name:  Thompson_MobileServiceProvider.java
   Date:          October 6, 2018
   
   This is the "Test-Edit" branch of this code
   
  Purpose: 
      This program calculates a customer’s monthly internet service bill based on one of 
      three potential pricing plans. The customer is asked the enter the package type 
      (A,B or C) and the number of calling minutes used for the month. The program 
      calculates the total charges for the month based on the following rates and 
      displays the results to the screen.
         Package A (39.99 per month, 450 minutes, .45 per overage minute)
         Package B (59.99 per month, 900 minutes, .40 per overage minute)
         Package C (69.99 per month, unlimited minutes)
         
   Met Specifications: (yes)
   
   Program pseudocode:
   
	   Constant Declarations(in caps):
         PKGA_RATE, PKGB_RATE, PKGC_RATE (double)
         PKGA_MINUTES_LIMIT, PKGB_MINUTES_LIMIT (int)
         PKGA_MINUTES_RATE, PKGB_MINUTES_RATE (double)
         
	   Variable Declarations(in camel):
         MinutesUsed, MinutesOver, MinutesOverageCost, TotalCost (double)
         
	Input:
         Prompt the user to enter the letter of the package plan they have.
         Prompt the user to enter the minutes they consumed for the month
         
	Processing:   
      If package_MINUTES_LIMIT is greater than MinutesUsed than (MinutesOver = package_MINUTES_LIMIT - MinutesUsed
      MinutesOverageCost = MinutesOver * package_MINUTES_RATE
      TotalCost = packageRATE + MinutesOverageCost)      
      If package entered is C than (TotalCost = packageRATE)
      
	Output:
		Display: “Your total monthly bill is: $00.00”
*/

import java.util.Scanner;

public class Thompson_MobileServiceProvider {

	public static void main(String[] args) {
	      //Declare the constant variables 
		   final double PKGA_RATE = 39.99;
	      final double PKGB_RATE = 59.99;
	      final double PKGC_RATE = 79.99;
		   final int PKGA_MIN_LIMIT = 450;
	      final int PKGB_MIN_LIMIT = 900;
	      final double PKGA_MIN_RATE = 0.45;
	      final double PKGB_MIN_RATE = 0.40;
	      
	      //Declare input variables
	      double dbl_MinUsed, dbl_MinOver, dbl_OverageCost, dbl_TotalCost;
	      char chr_Package;
      
	      //Declare scanner user input variable   
	      Scanner input = new Scanner(System.in);
	      
	      //Set the package variable
	      System.out.println("Enter Service Plan ([A]=Plan A, [B]=Plan B, [C]=Plan C):");	 
	      chr_Package = input.next().toLowerCase().charAt(0);	 
	      
	      //Process cost based on plan price
	      switch(chr_Package){
	      case 'a':
	    	  //Set the minutes used variable
		      System.out.println("Enter the number minutes used this billing cycle:");	      
		      dbl_MinUsed = input.nextDouble();
		      //Calculate bill
	    	  if(dbl_MinUsed > PKGA_MIN_LIMIT){
	    		  dbl_MinOver = dbl_MinUsed-PKGA_MIN_LIMIT;
	    		  dbl_OverageCost = dbl_MinOver * PKGA_MIN_RATE;
	    		  dbl_TotalCost = PKGA_RATE + dbl_OverageCost;
	    	  }
	    	  else{
	    		  dbl_TotalCost = PKGA_RATE;
	    	  }
	    	  System.out.printf("Your total monthly bill is $%.2f", dbl_TotalCost);
	    	  break;
	    	  
	      case 'b':
	    	//Set the minutes used variable
		     System.out.println("Enter the number minutes used this billing cycle:");	      
		     dbl_MinUsed = input.nextDouble();
	    	  if(dbl_MinUsed > PKGB_MIN_LIMIT){
	    		  dbl_MinOver = dbl_MinUsed-PKGB_MIN_LIMIT;
	    		  dbl_OverageCost = dbl_MinOver * PKGB_MIN_RATE;
	    		  dbl_TotalCost = PKGB_RATE + dbl_OverageCost;
	    	  }
	    	  else{
	    		  dbl_TotalCost = PKGB_RATE;
	    	  }
	    	  System.out.printf("Your total monthly bill is $%.2f", dbl_TotalCost);
	    	  break;
	    	  
	      case 'c':
	    	  dbl_TotalCost = PKGC_RATE;
	    	  System.out.printf("Your total monthly bill is $%.2f", dbl_TotalCost);
	    	  break;	    	  
	      
	      default:
	    		  System.out.println("Enter a valid letter for your Service Plan");
	    		  break;
	      }
	      //End the program
	      System.exit(0);
	}
}
