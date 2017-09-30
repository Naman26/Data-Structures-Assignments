/**
 * 1)Purpose: This class is a test-class for ArrayList and Card class.
 * The aim of this class is to have a main method that creates instances of
 * Card and stores these objects into an ArrayList. This class creates a 
 * deck of 52 cards and then it randomly shuffles the deck. 
 * 
 * 2)The main method creates an ArrayList of Cards called deck of size 0. 
 * Then using the add method 52 cards are added and printed. Then the 
 * shuffle method is called which tests the add, remove, and printCard 
 * method.
 * 
 * 3)There are no data structures used inside this class. This class is only 
 * creating objects of other classes and manipulating on Card Objects.
 * 
 * 4)There is no requirement of additional input. The output should shows
 * the original deck (in order). Then methods (size, isEmpty, isIn, and find)
 * are demonstrated using constant perameters. After this the shuffled deck
 * is printed.
 * 
 * 5) The purpose of Card class is to provide flexibility of cards instantly.
 * The ArrayList allows to create a group of similar objects, in this case a
 * deck of cards. Then this class is created to test Card and ArrayList class
 * and shuffle the created deck randomly.
 * 
 *
 * @author Naman Kanwar 
 * @version Feb 12 2017
 */
import java.util.*;
public class testarray
{
   public static void main(String[]args){
       ArrayList a= new ArrayList();                //Testing Default constructor
       ArrayList deck= new ArrayList(0);            //Testing constructor with size parameter
       for(int i=1;i<14;i++){
           deck.add(new Card((i+1),"Spades"));      //Tests add(int index, Object x) by adding 13 cards of Spades
       }
       for(int i=1;i<14;i++){
           deck.add(new Card((i+1),"Diamonds"));    //Tests add(int index, Object x) by adding 13 cards of Diamonds
       }
       for(int i=1;i<14;i++){
           deck.add(new Card((i+1),"Clubs"));       //Tests add(int index, Object x) by adding 13 cards of Clubs
       }
       for(int i=1;i<14;i++){
           deck.add(new Card((i+1),"Hearts"));      //Tests add(int index, Object x) by adding 13 cards of Hearts
       }
       for(int i=0; i<52; i++)
       {
           Card c=(Card)deck.get(i);
           c.printCard();                           //Using printCard method to print th edeck in order
       }
       Card b= new Card(2,"Hearts");                //Card created to test methods
       System.out.println("The size if the deck is "+ deck.size()); //testing size() method; expected output: 52
       System.out.println("Is ArrayList a empty?: "+ a.isEmpty());  //testing isEmpty() method; expected output: true
       System.out.println("Does 2 of Hearts exist inside the deck?: "+ deck.isIn(b));   //testing isIn(Object n) method using Card b as argument; expected output: true
       System.out.println("2 of Hearts is located at index "+ deck.find(b));    //testing find(Object n) method using Card b as argument; expected output: 1<=#<=52
       shuffle(deck);                               //Calling the shuffle method
   }
   public static void shuffle(ArrayList deck){
       int k;       
       Card temp;
       for(int i=0; i< 52;i++){
           k= (int)(Math.random()*51+1);            //Generating a random number from 1 to 52
           temp= (Card)deck.get(k);                 //storing the card at temp located at index k 
           deck.remove(deck.get(k));                //Testing remove(Object n) method by deleting the card located at index k 
           deck.add(temp);                          //Testing add(Object x) method by insering temp at th end of the deck
       }
       for(int i=0; i<52; i++)
       {
           Card c=(Card)deck.get(i);
           c.printCard();                           //Printing the shuffled deck
       }
   }
}
