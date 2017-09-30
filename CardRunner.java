import java.util.*;
public class CardRunner {
	public static void main(String[]args){
		Card c1= new Card();
		c1.printCard();
		
		Card c2= new Card(10, "Hearts");
		c2.printCard();
	}
}
