
/**
 *1)Purpose: This class create a template which can be use to create a Customer object 
 * . The object would have 4 instance variables: first name, last name, phone number,
 * and balance
 * 
 * 2)This class can be used to create a customer object(first name, last name, phone number and balance))
 * It consists of multiple methods (to print the customer object). All the data types are protected so 
 * there is no requirement of getters and setters. 
 *
 * 3)There are no data structures used in this class. The most complex data type used is String
 * 
 * 4)Rgis class requires a main method or another class to create and object (in order to execute)
 *
 * 5)This class is a layout class, it doesn't have a main method. There is a driver class required to test the 
 * execution of this class.
 * 
 * @author Naman Kanwar 
 * @version Feb 22 2017

 */
public class Customer
{
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected double balance;
    public Customer()
    {
        firstName= "";
        lastName= "";
        phoneNumber= "";
        balance= 0;
    }
    
    public Customer(String fName, String lName, String pNo, double bal)
    {
        firstName= fName;
        lastName= lName;
        phoneNumber= pNo;
        balance= bal;
    }
    
    public String getFName()
    {
        return this.firstName;
    }
    
    public String getLName()
    {
        return this.lastName;
    }
    
    public void printCustInfo()
    {
        System.out.printf("%-12s\t\t%-12s\t", this.firstName, this.lastName);
        printNumber(this.phoneNumber);
        System.out.printf("        \t$%.2f\n",balance);
    }
    
    public void printNumber(String num)                                                 //T
    {
        System.out.print("\t"+num.substring(0,3)+"-"+num.substring(3,6)+"-"+num.substring(6,10));
    }

}
