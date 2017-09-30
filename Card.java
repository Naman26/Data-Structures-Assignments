/** 
 * 1)Purpose: The purpose of this class is to create a template that can generate 
 * playing cards with a rank and a suit
 * 
 * 2)There are no specific algorithms that are used. 
 * 
 * 3)There are no data STructure used inside this class
 * 
 * 4)This class is a template to create objects. There is no main method or any created 
 * objects in the class. This class created so that the test class can use this class
 * as blueprints to create cards. there is no output to just this class. inputs are 
 * provided at runtime.
 * 
 * 5) This class only works as a template and doesn' t contain a main method. It doesn't 
 * contain any static methods or static varibles, so objects can be created outside this class.
 * 
 * @author Naman Kanwar
 * @version 2/12/17
*/
import java.util.*;
public class Card {
    private int rank;               //Creates an int for card number
    private String suit;            //Creates a String for card's suit
    
    public Card(){                  //Default Constructor
        rank=14;    
        suit= "Spades";             //sets rank to 14 and suit to Spades
    }
    
    public Card(int i, String j){   //Constructor with Parameter
        rank= i;
        suit= j;
    }
    
    public int getRank(){           //Return rank of a card
        return this.rank;
    }

    public String getSuit(){        //Returns suit of card 
        return this.suit;
    }
    
    public void setRank(int rank){  //Sets rank by the given parameter
        this.rank= rank;
    }
    
    public void setSuit(String suit){//Sets rank by the given parameter
        this.suit=suit;
    }
    
    public void printCard(){            //Prints the card with rank and suit
        switch(this.rank){
        case 11:                        //If the rank is 11
            System.out.println("Jack of "+this.suit+" ");
            break;
        case 12:                        //If the rank is 12
            System.out.println("Queen of "+this.suit+" ");
            break;  
        case 13:                        //If the rank is 13
            System.out.println("King of "+this.suit+" ");
            break;
        case 14:                        //If the rank is 14
            System.out.println("Ace of "+this.suit+" ");
            break;  
        default:                        //If the rank is neither 11,12, or 13
            System.out.println(this.rank+ " of "+this.suit+" ");
            break;
        }
    }
}

