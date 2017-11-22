// Authored by Jie Huang
// 11/17/2017
// completed on
//

import java.util.*;

/**
*	Player : class
*----------------------------
*	-playerId : int{0}
*	-totalCash : int{0}
*	-cardList : List<Card>{null}
*	-totalSumOfCards : int{0}
*----------------------------
*	<<constructor>> Player(int id, int totalCash)
*	-setPlayerId(int id) : void
*	+getPlayerId() : int
*	-setTotalCash(int cash) : void
*	+getTotalCash() : int
*	-setTotalSumOfCards(int total) : void
*	-calculateTotalSumOfCards() : void
*	+getTotalSumOfCards() : int
*	+clearHand() : boolean
*	+hasCards() : boolean
*	addCard(Card) : boolean
*
*/

public class Player{
// constructor
	public Player(int id, int totalCash){
		setPlayerId(id);
		setTotalCash(totalCash);
		calculateTotalSumOfCards();
		cardList = new ArrayList<>();
	}

// fields
	private int playerId = 0;
	private int totalCash = 0;
	List<Card> cardList = null;
	private int totalSumOfCards = 0;

// methods
	// playerId
	private void setPlayerId(int id){
		playerId = id;
	}
	public int getPlayerId(){
		return playerId;
	}

    // totalCash
	private void setTotalCash(int cash){
		totalCash = cash;
	}
	public int getTotalCash(){
		return totalCash;
	}

    // totalSumOfCards
	private void setTotalSumOfCards(int total){
		totalSumOfCards = total;
	}
	private void calculateTotalSumOfCards(){
		// when adding card ace, if the totalSumOfCards is less than 12, use ace
        // 		card as a 10
        // if totalSumOfCards is greater than 12, if player has an ace, turn it
        // 		into a 1 instead
		if(cardList == null || cardList.size() == 0){
			setTotalSumOfCards(0);
		}else{
			int sum = 0;
			// System.out.println("sum before: " + sum);
	        // check if there's multiple ACEs
			boolean hasAceUsedAsEleven = false;
			for(int i = 0; i < cardList.size(); i++){
				int number = cardList.get(i).getNumber();
				// System.out.println("number: " + number);
				// System.out.println("\thasAceUsedAsEleven: " + hasAceUsedAsEleven);
				if(number == 11){
					if((sum + number) <= 11){
						sum += number;
						hasAceUsedAsEleven = true;
					}else{ // sum greater than 10
						if(hasAceUsedAsEleven == true){
							if(sum < 21){
								sum += 1;
							}else{
								sum -= 9;
								hasAceUsedAsEleven = false;
							}
						}else{
							sum += 1;
						}
					}
				}else{
					if(hasAceUsedAsEleven == true){
						if(sum + number > 21){
							hasAceUsedAsEleven = false;
							sum += (10 - number);
						}else{
							sum += number;
						}
					}else{
						sum += number;
					}
				}
				// System.out.println("\tsum: " + sum + "\thasAceUsedAsEleven: " + hasAceUsedAsEleven);
			}
			// System.out.println("sum after: " + sum);
			setTotalSumOfCards(sum);
		}
		// System.out.println();
	}
	public int getTotalSumOfCards(){
		return totalSumOfCards;
	}

	public boolean clearHand(){
		cardList.clear();
		setTotalSumOfCards(0);
		return true;
	}
	public boolean hasCards(){
		return cardList.size() == 0 ? false : true;
	}
	public boolean addCard(Card card){
		cardList.add(card);
		calculateTotalSumOfCards();
		return true;
	}
}
