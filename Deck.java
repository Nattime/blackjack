// Authored by Jie Huang
// 11/13/2017
// completed on
//

/**
*	Deck : class
*----------------------------
*	-numberOfCards : int{0}
*	-numberOfDecks : int{1}
*	-listOfCards : List<Card>{null}
*----------------------------
*	<<constructor>> Deck()
*	<<constructor>> Deck(int numOfDecks)
*	+newDeck() : boolean
*	-shuffle() : boolean
*	+cardCount() : int
*	-removeCard() : Card
*	+getCard() : Card
*
* for debugging only
*	+printDeck() : void
*/

import java.util.*;

class Deck{
// constructor
	public Deck(){
		this(1);
	}
	public Deck(int numberOfDecks){
		numberOfCards = 52 * numberOfDecks;
		this.numberOfDecks = numberOfDecks;
		newDeck();
	}

// fields
	private int numberOfCards = 0;
	private int numberOfDecks = 1;
	List<Card> listOfCards = null;

// methods
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
		return shuffle();
	}
	private boolean shuffle(){
		if(listOfCards == null){
			return false;
		}
		Collections.shuffle(listOfCards);
		return true;
	}
	public int cardCount(){
		return numberOfCards;
	}
	private Card removeCard(){
		Card ret = listOfCards.remove(0);
		numberOfCards--;
		return ret;
	}
	public Card getCard(){
		return removeCard();
	}

// debugging purposes
	public void printDeck(){
		for(Card card : listOfCards){
			System.out.println(card);
		}System.out.println();
	}
}
