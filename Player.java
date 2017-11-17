// Authored by Jie Huang
// 11/17/2017
// completed on
//

import java.util.*;

/**
*	Player : class
*----------------------------
*	-playerId : int
*	-totalCash : int
*	-cardList : List<Card>
*----------------------------
*	<<constructor>> Player
*	addCard(Card) : boolean
*	removeCards() : boolean
*
*/

public class Player{
// instance variables
	private int playerId;
	private int totalCash = 0;
	List<Card> cardList = null;
	private int totalSumOfCards;

// constructor
	public Player(int id, int totalCash){
		playerId = id;
		this.totalCash = totalCash;
		cardList = new ArrayList<>();
	}

// methods
	public boolean addCard(Card card){
        // when adding card ace, if the totalSumOfCards is less than 12, use ace
        // 		card as a 10
        // if totalSumOfCards is greater than 12, if player has an ace, turn it
        // 		into a 1 instead
		return true;
	}
	public int getTotalSumOfCards(){
		return totalSumOfCards;
	}
	public boolean removeCards(){
		cardList.clear();
		return true;
	}


}
