// Authored by Jie Huang
// 11/13/2017
// completed on
//

/**
*	Deck : class
*----------------------------
*	-numberOfCards : int
*	-numberOfDecks : int(1)
*	-listOfCards : List<Card>
*----------------------------
*	<<constructor>> Deck()
*	<<constructor>> Deck(int numOfDecks)
*	+newDeck() : boolean
*	-shuffle() : boolean
*	+removeCard() : Card
*	+cardCount() : int
*
*
*	+listOfCards : List<Card>
*/

import java.util.*;

class Deck{
	private int numberOfCards = 0;
	private int numberOfDecks = 1;
	List<Card> listOfCards = null;
	public Deck(){
		numberOfCards = 52;
		newDeck();
	}
	public Deck(int numberOfDecks){
		numberOfCards = 52 * numberOfDecks;
		this.numberOfDecks = numberOfDecks;
		newDeck();
	}
	public boolean newDeck(){
		listOfCards = new ArrayList<>();
		for(int i = 0; i < numberOfDecks; i++){
			for(Suit suit : Suit.values()){
				for(Number num : Number.values()){
					Card newCard = new Card(suit, num);
					listOfCards.add(newCard);
				}
			}
		}
		return true;
	}
	public boolean shuffle(){
		if(listOfCards == null){
			return false;
		}
		Collections.shuffle(listOfCards);
		return true;
	}
	public int cardCount(){
		return numberOfCards;
	}
	public Card removeCard(){
		Card ret = listOfCards.remove(0);
		numberOfCards--;
		return ret;
	}
}
