// Authored by Jie Huang
// 11/17/2017
// completed on
//

import java.util.*;

/**
*	Blackjack : class
*----------------------------
*
*----------------------------
*	<<constructor>> Blackjack()
*	<<constructor>> Blackjack(int numOfDecks)
*
*
*/

public class Blackjack{
// constructor
	public Blackjack(){
		this(6);
	}
	public Blackjack(int numberOfDecks){
		deck = new Deck(numberOfDecks);
		dealer = new Dealer(1, 0);
		listOfPlayers = new ArrayList<>();
	}

// fields
	private Deck deck = null;
	private Dealer dealer = null;
	private List<Player> listOfPlayers = null;

// methods
	public void addPlayer(Player player){
		listOfPlayers.add(player);
	}
	public boolean hasEnoughCards(){
		return true;
	}
	public void playGame(){
		System.out.println("Blackjack options:");
		System.out.println("\t\t1) Continue Playing");
		System.out.println("\t\t2) Quit");

		Scanner sc = new Scanner(System.in);
		int optionNumber = sc.nextInt();

		while(optionNumber == 1){
			for(int n = 1; n <= 2; n++){
				for(int i = 0; i < listOfPlayers.size(); i++){
					Card card = deck.getCard();
					listOfPlayers.get(i).addCard(card);
				}
				dealer.addCard(deck.getCard());
			}

			for(Player player : listOfPlayers){
				System.out.print("player:\t");
				for(Card card : player.cardList){
					System.out.print(card + "\t");
				}
				System.out.println("\tplayerTotalSumOfCards: " + player.getTotalSumOfCards());
				System.out.println();
			}
			System.out.print("dealer:\t");
			for(Card card : dealer.cardList){
				System.out.print(card + "\t");
			}
			System.out.print("\tdealerTotalSumOfCards: " + dealer.getTotalSumOfCards());
			System.out.println();

			System.out.println("Blackjack options:");
			System.out.println("\t\t1) Continue Playing");
			System.out.println("\t\t2) Quit");
			optionNumber = sc.nextInt();
		}
	}
}
