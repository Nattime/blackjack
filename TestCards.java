// Authored by Jie Huang
// 11/13/2017
// completed on
//

import java.util.*;

public class TestCards{
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();
		// for(Card card : deck.listOfCards){
		// 	System.out.println(card);
		// }
		System.out.println("card count: " + deck.cardCount());
		System.out.println(deck.removeCard());
		System.out.println("card count: " + deck.cardCount());
	}
}
