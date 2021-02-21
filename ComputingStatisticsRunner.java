import java.util.*;
import java.io.*;
import java.text.*;

public class ComputingStatisticsRunner {
   public static void main(String[] args) throws FileNotFoundException {
      // Specifies the data file to be used.
      String file = "kiva_loans_small.csv";
      
      // Creates an ArrayList to store the data and calls the readData() method. 
      ArrayList<Loan> list = readData(file);
      
      // Loop to print out the existing data to see how it is structured.
      //for(int i = 0; i < list.size(); i++) {
      //   System.out.println(list.get(i));
      //}
      
      //Use this code to test the methods in the ComputingStatistics class
      ComputingStatistics analysis = new ComputingStatistics(list);
      System.out.println(analysis.totalAmount());              //Level 1 Question 1
//       System.out.println(analysis.avgLoan());               //Level 1 Question 2
//       System.out.println(analysis.largestLoan());           //Level 1 Question 3
//       System.out.println(analysis.smallestLoan());          //Level 1 Question 4
//       System.out.println(analysis.largestLoanCountry());    //Level 1 Question 5
//       System.out.println(analysis.smallestLoanCountry());   //Level 1 Question 6
//       System.out.println(analysis.avgDaysToFund());         //Level 2 Question 1
//       System.out.println(analysis.largestLoanKenya());      //Level 2 Question 2
//       System.out.println(analysis.avgLoanPhilippines());    //Level 2 Question 3
//       System.out.println(analysis.longestToFundCountry());  //Level 2 Question 4
//       System.out.println(analysis.mostLoansFunded());       //Level 2 Question 5
//       System.out.println(analysis.variance());              //Level 2 Question 1
//       System.out.println(analysis.standardDeviation());     //Level 2 Question 2
//       System.out.println(analysis.empiricalRule());         //Level 2 Question 3
   }
   
   
   /**
    * Reads in the provided file and creates an ArrayList of the data.
    * @param file the name of the text file containing the data.
    * @return the ArrayList containing the data from the text file.
    */
   public static ArrayList<Loan> readData(String file) throws FileNotFoundException {
      // Scanner used to read in the data from the file.
      Scanner in = new Scanner(new File(file));
      // ArrayList to store the data.
      ArrayList<Loan> list = new ArrayList<Loan>();
      // Read in the header line so it is not added to the ArrayLists.
      String header = in.nextLine();
      // Check to see if the file still has data to be read in.
      while(in.hasNextLine()) {
      
         // Read in the line of data and 
         // use a space as a delimiter to separate the different columns.
         String[] line = in.nextLine().split(",");
         
         // Local variable containing the ID.
         int ID = Integer.parseInt(line[0]);
         
         // Local variable containing the amount.
         int amount = Integer.parseInt(line[1]);
         
         // Local variable containing the country.
         String country = line[2];
         
         // Local variable containing the lenders.
         int lenders = Integer.parseInt(line[5]);
         
         // Local variable containing the difference in days.
         int differenceInDays = Integer.parseInt(line[4]);
         
         // Add the loan to the arraylist.
        list.add(new Loan(ID, amount, country, differenceInDays, lenders));         
        
      }
      // Return the completed ArrayLists.
      return list;
   }

}
