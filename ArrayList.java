/** 
 * 1)Purpose: The purpose of this class is to create a data structure ArryList using array.
 * Available Instance methods are add(Object x), add(int index, Object x), get(int index),
 * size(), isEmpty(), isIn(Object ob), find(Object n), remove(Object n)
 * 
 * 2)There are no specific algorithms that are used. The methods call each other several times
 * to make this program more efficient and use the concept of code reusibility.
 * 
 * 3)There is only one data structure that is applied (array). All the manipulations are 
 * performed only on arrays of objects. Using just arrays to create ArrayList would give 
 * more knowledge about the usage of ArrayList class and it's applications
 * 
 * 4)This class is a template of an ArrayList, which has been modified to work with Card()
 * class objects. Some of the methods may not work if the object is not a Card() object. 
 * To execute propery, an ArrayList of Card() objects must be created
 * 
 * 5) This class only works as a template and doesn' t contain a main method. It doesn't 
 * contain any static methods or varibles, so objects can be created outside this class.
 * 
 * @author Naman Kanwar
 * @version 2/12/17
*/

import java.util.*;
public class ArrayList 
{
    protected Object a[];                       //The main array is declared protected so only the child classes can access data 
    private Card c= new Card();
    public ArrayList(){                         //Deafault Constructor
        a = new Object[10];                     //Creates an array of 10 elements
    }
    
    public ArrayList(int n){                    //Constructor that takes one parameter
        a = new Object[n];                      //Creates a array of size provided by the parameters
    }
    
    public void add(Object x){                  //Takes an object as parameter and adds the object at the end on the ArrayList
        Object n[];
        int i=0;
        if(this.size()==a.length){               //Checks whether the ArrayList is full
            n= new Object[a.length+1];      
            for(i= 0; i<a.length;i++){
             n[i]=a[i];
            }
            n[a.length]= x;
            a= n;
        }
        else{                                   //If the ArrayList is not full
            while(a[i]!=null)
                i++;
            a[i]=x;                             //Add the given object on the next null index 
        }
    }
    
    public void add(int index, Object x){       //Takes an index and an object as perameter and adds the object on the given index in the ArrayList
        Object n[];
        int i;
        int flag=0;
        n= new Object[a.length+1];
        for(i=0; i< a.length; i++){                
            if(i==index){
                n[i]=x;
                i++;
                flag=1;
            }    
            if(flag!=0)
                n[i]=a[i-1];
            else
                n[i]=a[i];                          //Copies all the values before the index into n
        }
        a=n;                                        //assigns n to a
    }
    
    public Object get(int index){               //Takes and int as parameter and returns the object located on that index
        return (a[index]);
    }
    
    public int size(){                          //Takes no parameters and returns an integer (number of occupied elements) 
        int count= 0;
        for(int i=0; i<a.length;i++){
           if(a[i]!= null)                      //If the element is not null then increase the count
            count++;
        }
        return count;                           //Returns the number of non- null elements inside the ArrayList
    }
    
    public boolean isEmpty(){                   //Takes no parameters and returs a boolean value 
        for(int i= 0; i< a.length; i++){
            if(a[i]!= null)
                return false;                   //If the ArrayList is not empty
        }
        return true;                            //If the ArrayList is empty
    }
    
    public boolean isIn(Object n){              //Takes no parameters and returns a boolean value
        if(find(n)!=-1)                         //If the element is located inside the ArrayList
            return true;
        return false;                            //If the element is not located inside the ArrayList   
    }
    
    public int find(Object n){                   //Takes an object for parameter and returns an integer
        Card given= (Card)n;
        for(int i= 0; i< a.length; i++){        
            Card temp= (Card)a[i];              //Creates a temporary card that stores values of array 
            if(given== null||temp==null)        //To check in nonull elemencts are being compared
             break;
            if(temp.getSuit().equals(given.getSuit()) && temp.getRank()==given.getRank())       //Compares the Rank and Suit of given card and the deck
             return i;
        }
        return -1;                              //If the Element is not found then returns -1
    }
    
    public void remove(Object n){               //Takes an Object as parameter
        if(isIn(n)){                            //Checks if the element is located inside the ArrayList
            Object w[]= new Object[a.length-1]; //Creates a new ArrayList with size length-1
            for(int i=0; i<find(n); i++){      
                if(i==find(n))                  //Does not copy the removed element 
                    i=i++;
                w[i]= a[i];                     //Copies all other elements to ArrayList w
            }
            for(int i=find(n); i<w.length;i++)
                w[i]= a[i+1];
            a=w;                                //Assigns w to a
        }    
        
    }
}
