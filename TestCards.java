// Authored by Jie Huang
// 11/13/2017
// completed on
//

import java.util.*;

public class TestCards{
	public static void main(String[] args) {
		Deck deck = new Deck();
		for(Card card : deck.listOfCards){
			System.out.println(card);
		}
	}
}
