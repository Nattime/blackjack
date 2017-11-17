// Authored by Jie Huang
// 11/13/2017
// completed on
//

/**
*	Deck : class
*----------------------------
*	-numberOfCards : int
*----------------------------
*	<<constructor>> Deck()
*	<<constructor>> Deck(int numOfDecks)
*	-newDeck()
*	-shuffle()
*	+removeCard() : Card
*	+listOfCards : List<Card>
*/

import java.util.*;

class Deck{
	private int numberOfCards = 0;
	List<Card> listOfCards = null;
	Deck(){
		numberOfCards = 52;
		listOfCards = new ArrayList<>();
		for(Suit suit : Suit.values()){
			for(Number num : Number.values()){
				Card newCard = new Card(suit, num);
				listOfCards.add(newCard);
			}
		}
	}
	Deck(int numOfDecks){
		numberOfCards = 52 * numOfDecks;
		listOfCards = new ArrayList<>();
		for(int i = 0; i < numOfDecks; i++){
			for(Suit suit : Suit.values()){
				for(Number num : Number.values()){
					Card newCard = new Card(suit, num);
					listOfCards.add(newCard);
				}
			}
		}
	}
	public int cardCount(){
		return numberOfCards;
	}
}
