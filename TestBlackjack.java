// Authored by Jie Huang
// 11/17/2017
// completed on
//

import java.util.*;

/**
*	TestBlackjack : class
*----------------------------
*
*----------------------------
*	<<constructor>> TestBlackjack()
*	<<constructor>> TestBlackjack(int numOfDecks)
*
*
*/

public class TestBlackjack{
// constructor
	public TestBlackjack(){
		this(6);
	}
	public TestBlackjack(int numberOfDecks){
		deck = new Deck(numberOfDecks);
		dealer = new Dealer(0, 0);
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
	public void setNumberOfPlayers(int numberOfPlayers){
		for(int i = 1; i <= numberOfPlayers; i++){
			addPlayer(new Player(i, i * 1000));
		}
		System.out.println(numberOfPlayers + " player(s) added\n");
	}
	public void playGame(){
		System.out.println("Game options:");
		System.out.println("\t\t1) Play Game");
		System.out.println("\t\t2) Quit");

		Scanner sc = new Scanner(System.in);
		int optionNumber = sc.nextInt();
		if(optionNumber == 1){
			System.out.println("How many players, (1 to 6)?");
			int numberOfPlayers = sc.nextInt();
			setNumberOfPlayers(numberOfPlayers);
		}
		while(optionNumber == 1){
			for(int n = 1; n <= 2; n++){
				for(int i = 0; i < listOfPlayers.size(); i++){
					Card card = deck.getCard();
					listOfPlayers.get(i).addCard(card);
				}
				dealer.addCard(deck.getCard());
			}
            //
			// for(Player player : listOfPlayers){
			// 	System.out.print("player:\t");
			// 	printPlayersCards(player);
			// }
			System.out.print("dealer:\t");
			for(Card card : dealer.cardList){
				System.out.print(card + "\t");
				break;
			}
			// System.out.print("\tdealerTotalSumOfCards: " + dealer.getTotalSumOfCards());
			// System.out.println();

            // check for natural blackjack, dealers first
            System.out.println("\n\nchecking for blackjack");
			System.out.println("\tdealer: " + hasNaturalBlackjack(dealer));
            // if dealer has natural blackjack, he automatically wins
            // check if players also have natural blackjack, if player also has
            // natural blackjack, they tie; otherwise, players lose

			for(Player player : listOfPlayers){
				System.out.println("\t" + player.getPlayerId() + ": " + hasNaturalBlackjack(player));
			}

			System.out.println();

			if(hasNaturalBlackjack(dealer) == true){

			}else{
				for(Player player : listOfPlayers){
					System.out.println("Player" + player.getPlayerId() + "'s turn: ");
					printPlayersCards(player);
					printOptions();
					optionNumber = sc.nextInt();
					while(optionNumber == 1){ // hit
						player.addCard(deck.getCard());
						printPlayersCards(player);
						if(player.getTotalSumOfCards() > 21){
							System.out.println("Player Busted");
							break;
						}else{
							printOptions();
							optionNumber = sc.nextInt();
						}
					}
				}

				System.out.println();
                // dealer's turn
				System.out.println("Dealer's turn: ");
				printPlayersCards(dealer);
				if(dealer.getTotalSumOfCards() < 17){
					while(dealer.getTotalSumOfCards() < 17){
						dealer.addCard(deck.getCard());
						printPlayersCards(dealer);
					}
				}
				if(dealer.getTotalSumOfCards() > 21){
					System.out.println("Dealer Busted");
				}else{
                    // check players if they won
				}
			}
			System.out.println();
			printWinners();

            // clear table
			// System.out.println("clearing table");
			clearTable();

			System.out.println();
			printGameOptions();
			optionNumber = sc.nextInt();
			while(optionNumber == 3){
				if(optionNumber == 3){
					System.out.println("\t\t\tnumOfCardsLeft: " + deck.cardCount());
				}
				printGameOptions();
				optionNumber = sc.nextInt();
			}
		}
		System.out.println("Game Ended");
	}
	public void printWinners(){
		int dealerSum = dealer.getTotalSumOfCards();
		if(dealerSum == 21){
			System.out.println("Dealer won with blackjack");
		}else{
			System.out.println("Dealer's total: " + dealer.getTotalSumOfCards());
			System.out.print("Player's total(s): ");
			for(Player player : listOfPlayers){
				System.out.print(player.getPlayerId() + "(" + player.getTotalSumOfCards() + "), ");
			}
			System.out.println();
			System.out.println("Winners:");
			System.out.print("\t");
			if(dealerSum > 21){ // dealer busted
				for(Player player : listOfPlayers){
					if(player.getTotalSumOfCards() <= 21){
						System.out.print(player.getPlayerId() + "(" + player.getTotalSumOfCards() + "), ");
					}
				}
			}else{ // dealer didn't bust
				for(Player player : listOfPlayers){
					if(player.getTotalSumOfCards() > dealerSum && player.getTotalSumOfCards() <= 21){
						System.out.print(player.getPlayerId() + "(" + player.getTotalSumOfCards() + "), ");
					}
				}
			}
		}

		System.out.println();
	}
	public void clearTable(){
		dealer.clearHand();
		for(Player player : listOfPlayers){
			player.clearHand();
		}
	}
	static boolean hasNaturalBlackjack(Player player){
		return (player.getTotalSumOfCards() == 21) ? true : false;
	}
	static void printGameOptions(){
		System.out.println("Game options:");
		System.out.println("\t\t1) Continue Playing");
		System.out.println("\t\t2) Quit");
		System.out.println("\t\t3) Print number of cards left");
		// System.out.println("\t\t4) ");
	}
	static void printOptions(){
		System.out.println("\tOptions:");
		System.out.println("\t\t1) Hit");
		System.out.println("\t\t2) Stay");
		// System.out.println("\t3) Split");
	}
	static void printPlayersCards(Player player){
		// System.out.print("\tPlayer_" + player.getPlayerId() + ": ");
		System.out.print("\tCards: ");
		for(Card card : player.cardList){
			System.out.print(card + "\t");
		}
		System.out.println("\n\tplayerTotalSumOfCards: " + player.getTotalSumOfCards());
		System.out.println();
	}
}
