
/**
 * 1)Purpose: This class creates and maintains a record of bank accounts. The bank 
 * accounts are created at runtime with human input. The user have options to 
 * see, delete, change first name, change last name, add, change phone number, withdraw,
 * and deposit to the account. There is also an option to quit the program.
 * 
 * 2)This class creates a customer object(first name, last name, phone number and balance))
 * and stores it into a linked list. The linked list keeps track of records. To create a 
 * list of options switch statement is used. There is no specific algorithm used
 *
 * 3)There is only one data structure used, the Linkedist to keep a dynamic record of 
 * bank accounts
 * 
 * 4)This class is a driver class (it would run and requre user input). At beginning, there
 * will be a list of options and the user could follow directions provided by the prompt.
 * The output will be displayed on the same window that showed options. All the opertions 
 * can be executed (including exiting the program) by following the prompt.
 *
 * 5)This class is a driver class which creates a customer object and stores those objects
 * inside a linked list. All the manipulation and access on the list and the individual
 * objects are possible through this class
 * 
 * @author Naman Kanwar 
 * @version Feb 22 2017
 */
import java.util.*;
public class bankrecord
{
    public static void main(String[]args)
    {
        Scanner console= new Scanner(System.in);
        int i=0;
        LinkedList <Customer> record= new LinkedList<Customer>();                               //Creates a Linked List of Customers 
        a:                                                                                      //If the input is 9 to exit, then breaks out of the loop
        while(i!=9)																				//i would be 0 initially, for the first iteration
        {
            printPrompt();
            i=console.nextInt();
            String fn,ln,ch,number;
            int flag=0;
            double bal=0;
            switch(i)
            {
                case 1: //Shows all records
                System.out.println("First Name\t        Last Name\t        Phone Number\t        Balance");
                System.out.println("----------\t        ---------\t        ------------\t        -------");
                for(i=0;i<record.size();i++)
                {
                    record.get(i).printCustInfo();                                              //Printing the list of just names, phone numbers, and balance 
                }
                break;
            
                case 2:                                                                         //Delete a selected record
                System.out.println("First Name\t        Last Name\t        Phone Number\t        Balance");
                System.out.println("----------\t        ---------\t        ------------\t        -------");
                for(i=0;i<record.size();i++)
                {
                    record.get(i).printCustInfo();                                              //Printing the list of just names, phone numbers, and balance 
                }
                System.out.print("Enter the first name of the record you want to delete: ");
                fn= console.next();                                                             //Taking first name of Customer
                System.out.print("Enter the last name of the record you want to delete: ");
                ln= console.next();                                                             //Taking last name of Customer
                for(i=0; i<record.size();i++)
                {
                    Customer c= new Customer(fn,ln,"",0);                                       //To compare first and last name of list with the entry
                    if(record.get(i).getFName().equals(c.getFName())&& record.get(i).getLName().equals(c.getLName()))
                    {
                        record.remove(i);                                                       //If the record with the provided first and last name are found
                        System.out.println("The record is deleted.");
                        flag=1;
                    }
                }
                if(flag==0)                                                                     //If the entered customer is not found in the list 
                {
                    System.out.println("No record selected.");
                }
                break;
            
                case 3:                                                                         //Change the first name of a selected record
                System.out.println("First Name\t        Last Name\t        Phone Number\t        Balance");
                System.out.println("----------\t        ---------\t        ------------\t        -------");
                for(i=0;i<record.size();i++)
                {
                    record.get(i).printCustInfo();                                              //Printing the list of just names, phone numbers, and balance 
                }
                System.out.print("Enter the first name of the record you want to change the first name of: ");
                fn= console.next();                                                             //Prompting first name
                System.out.print("Enter the last name of the record you want to change the first name of: ");
                ln= console.next();                                                             //Prompting last name
                System.out.print("Enter the first name that you want to change to: ");
                ch= console.next();                                                             //Prompting for the new first name
                flag=0;
                for(i=0; i<record.size();i++)
                {
                    Customer c= new Customer(fn,ln,"",0);
                    if(record.get(i).firstName.equalsIgnoreCase(c.firstName)&& record.get(i).lastName.equalsIgnoreCase(c.lastName))
                    {
                        record.get(i).firstName=ch;                                             //If record is found then change the firstname
                        System.out.println("The first name is changed successfully.");
                        flag=1;
                    }
                }
                if(flag==0)
                {
                    System.out.println("No record selected.");                                  //If record is not found
                }
                break;
            
                case 4:                                                                         //Change the last name of a selected record
                System.out.println("First Name\t        Last Name\t        Phone Number\t        Balance");
                System.out.println("----------\t        ---------\t        ------------\t        -------");
                for(i=0;i<record.size();i++)
                {
                    record.get(i).printCustInfo();                                              //Printing the list of just names, phone numbers, and balance 
                }
                System.out.print("Enter the first name of the record you want to change the last name of: ");
                fn= console.next();                                                             //Prompting the first name
                System.out.print("Enter the last name of the record you want to change the last name of: ");
                ln= console.next();                                                             //Prompting the last name
                System.out.print("Enter the last name that you want to change to: ");
                ch= console.next();                                                             //Prompting the new last name
                flag=0;
                for(i=0; i<record.size();i++)
                {
                    Customer c= new Customer(fn,ln,"",0);
                    if(record.get(i).firstName.equalsIgnoreCase(c.firstName)&& record.get(i).lastName.equalsIgnoreCase(c.lastName))
                    {    
                        record.get(i).lastName=ch;                                              //If record is found
                        System.out.println("The last name is changed successfully.");
                        flag=1;
                    }    
                }
                if(flag==0)
                {
                    System.out.println("No record selected.");                                  //If record is not found
                }
                break;
            
                case 5:                                                                         //Add a new record
                System.out.print("Enter the first name: ");                                     //Prompt for first name
                fn= console.next();
                System.out.print("Enter the last name: ");                                      //Prompt for last name
                ln= console.next();
                System.out.print("Enter the phone number: ");                                   //Prompt for phone number
                number= console.next();
                while(number.length()!=10)                                                      //while the input number is not a 10 digit number
                { 
                    System.out.println("Please enter the number again.");
                    number=console.next();
                }
                System.out.print("Enter balance: ");
                bal= console.nextDouble();                                                       //Input balance
                record.add(new Customer(fn,ln, number,bal));                                     //Add a new customer at the end of the Linked List
                break;
            
                case 6:                                                                         //Change the phone number of a selected record
                System.out.println("First Name\t        Last Name\t        Phone Number\t        Balance");
                System.out.println("----------\t        ---------\t        ------------\t        -------");
                for(i=0;i<record.size();i++)
                {
                    record.get(i).printCustInfo();                                              //Printing the list of just names, phone numbers, and balance 
                }
                System.out.print("Enter the first name of the record you want to change the phone number of: ");
                fn= console.next();                                                             //Prompting the first name
                System.out.print("Enter the last name of the record you want to change the phone number of: ");
                ln= console.next();                                                             //Prompting the last name
                System.out.print("Enter the phone number that you want to change to: ");
                number= console.next();                                                         //Prompting the new phone number
                while(number.length()!=10)                                                      //while the input number is not a 10 digit number
                { 
                    System.out.println("Please enter the number again.");
                    number=console.next();
                }
                flag=0;
                for(i=0; i<record.size();i++)
                {
                    Customer c= new Customer(fn,ln,"",0);
                    if(record.get(i).firstName.equalsIgnoreCase(c.firstName)&& record.get(i).lastName.equalsIgnoreCase(c.lastName))
                    {    
                        record.get(i).phoneNumber=number;                                       //If record is found
                        System.out.println("The phone number is changed successfully.");
                        flag=1;
                    }    
                }
                if(flag==0)
                {
                    System.out.println("No record selected.");                                  //If record is not found
                }
                break;
            
                case 7:                                                                         //Withdraw an amount requested by the customer
                System.out.println("First Name\t        Last Name\t        Phone Number\t        Balance");
                System.out.println("----------\t        ---------\t        ------------\t        -------");
                for(i=0;i<record.size();i++)
                {
                    record.get(i).printCustInfo();                                              //Printing the list of just names, phone numbers, and balance 
                }
                System.out.print("Enter the first name of the record you want to withdraw money from: ");
                fn= console.next();                                                             //Prompting the first name
                System.out.print("Enter the last name of the record you want to withdraw money from: ");
                ln= console.next();                                                             //Prompting the last name
                flag=0;
                for(i=0; i<record.size();i++)
                {
                    Customer c= new Customer(fn,ln,"",0);
                    if(record.get(i).firstName.equalsIgnoreCase(c.firstName)&& record.get(i).lastName.equalsIgnoreCase(c.lastName))
                    {    
                        System.out.printf("The record is: %s %s has now $%.2f\n",record.get(i).firstName,record.get(i).lastName,record.get(i).balance);
                        flag=1;
                        System.out.print("Enter the withdraw amount: ");
                        bal= console.nextDouble();                                                  //Prompting the amount to withdraw
                        record.get(i).balance-=bal;                                                 //If record is found
                        System.out.printf("The record now has $%.2f\n", record.get(i).balance); 
                    }    
                }
                if(flag==0)
                {
                    System.out.println("No record selected.");                                  //If record is not found
                }
                break;
            
                case 8:                                                                         //Add a deposit for a selected record
                System.out.println("First Name\t        Last Name\t        Phone Number\t        Balance");
                System.out.println("----------\t        ---------\t        ------------\t        -------");
                for(i=0;i<record.size();i++)
                {
                    record.get(i).printCustInfo();                                              //Printing the list of just names, phone numbers, and balance 
                }
                System.out.print("Enter the first name of the record you want to add a deposit: ");
                fn= console.next();                                                             //Prompting the first name
                System.out.print("Enter the last name of the record you want to add a deposit: ");
                ln= console.next();                                                             //Prompting the last name
                flag=0;
                for(i=0; i<record.size();i++)
                {
                    Customer c= new Customer(fn,ln,"",0);
                    if(record.get(i).firstName.equalsIgnoreCase(c.firstName)&& record.get(i).lastName.equalsIgnoreCase(c.lastName))
                    {    
                        System.out.printf("The record is: %s %s has now $%.2f\n",record.get(i).firstName,record.get(i).lastName,record.get(i).balance);
                        flag=1;
                        System.out.print("Enter the deposit amount: ");
                        bal= console.nextDouble();                                                  //Prompting the amount to deposit
                        record.get(i).balance+=bal;                                                 //If record is found
                        System.out.printf("The record now has $%.2f\n", record.get(i).balance);    
                    }    
                }
                if(flag==0)
                {
                    System.out.println("No record selected.");                                  //If record is not found
                }
                break;
            
                case 9:                                                                         //Quit
                break a;                                                                        //Go to label a
            
                default:
                System.out.println("Illegal command");
                break;
            }
        }
    }
    
    public static void printPrompt(){                                                           //Has no return type and takes no parameters
        System.out.println("1. Show all records");                                              //Prints the prompt for user
        System.out.println("2. Delete a selected record");
        System.out.println("3. Change the first name of a selected record");
        System.out.println("4. Change the last name of a selected record");
        System.out.println("5. Add a new record");
        System.out.println("6. Change a phone number of a selected record");
        System.out.println("7. Withdraw an amount requested by the record");
        System.out.println("8. Add a deposit for a selected record");
        System.out.println("9. Quit");
        System.out.print("Enter a command from the list above (9 to quit):");
    }
    
    public static LinkedList<Customer> sort(LinkedList<Customer> a, Customer c)               //Returns a sorted Linked List of Customer(alphabetical order) takes Linked List of Customer as parameters
    {
        if(a.size()==0)
        {
            a.add(c);
            return a;
        }
        for(int i=0; i<a.size()+1; i++)             
        {
            int size= Math.min(a.get(i).lastName.length(),c.lastName.length());
            if(a.get(i).lastName.substring(0,size).compareToIgnoreCase(c.lastName.substring(0,size))>0) //if a[i] is greater than c
            {
                a.add(i, c);
            }
            else if(a.get(i).lastName.substring(0,size).compareToIgnoreCase(c.lastName.substring(0,size))==0)
            {
                size= Math.min(a.get(i).firstName.length(),c.firstName.length());
                if(a.get(i).firstName.substring(0,size).compareToIgnoreCase(c.firstName.substring(0,size))>0) //if a[i] is greater than c
                {
                    a.add(i, c);
                }
                else if(a.get(i).firstName.substring(0,size).compareToIgnoreCase(c.firstName.substring(0,size))==0)
                {
                    if(a.get(i).phoneNumber.compareToIgnoreCase(c.phoneNumber)>0)
                    {
                        a.add(i,c);
                    }
                }
            }
        }
        a.add(c);
        return a;
    }
}

