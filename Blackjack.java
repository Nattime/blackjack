// Authored by Jie Huang
// 12/04/2017
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
		dealer = new Dealer(0, 0);
		listOfPlayers = new ArrayList<>();
		alreadyWonPlayersList = new ArrayList<>();
		hasInsurancePhase = false;
		splitHandsMap = new LinkedHashMap<>();
	}

// fields
	private final static boolean DEBUGGING = true;
	private static final int MINIMUM_BET = 0;
	private static final int MAXIMUM_BET = 0;
	private boolean dealerAutoWins = false;
	private Deck deck = null;
	private Dealer dealer = null;
	private List<Player> listOfPlayers = null;
	// private List<Player> listOfPlayersWaiting = null;
	private List<Player> alreadyWonPlayersList = null;
	private boolean hasInsurancePhase = false;
	private LinkedHashMap<Player, List<List<Card>>> splitHandsMap = null;

// methods
	public void phase_1_standby(){
		if(DEBUGGING){
			System.out.println();
			System.out.println("phase_1_standby");
		}
		if(!hasEnoughCards()){
			deck.newDeck();
		}
        debugging_printGameOptions();
	}

	public void phase_2_add_players(){
        // if new players join, add new player(s)
		if(DEBUGGING){
			System.out.println();
			System.out.println("phase_2_add_players");
		}
	}

	public void phase_3_betting(){
		if(DEBUGGING){
			System.out.println();
			System.out.println("phase_3_betting");
		}
	}

	public void phase_4_deal_cards(){
		if(DEBUGGING){
			System.out.println();
			System.out.println("phase_4_deal_cards");
		}
		for(int n = 1; n <= 2; n++){
			for(int i = 0; i < listOfPlayers.size(); i++){
				Card card = deck.getCard();
				listOfPlayers.get(i).addCard(card);
			}
			dealer.addCard(deck.getCard());
		}

        // show dealer's face up card
		System.out.print("Dealer's Hand:\t");
		for(Card card : dealer.cardList){
			System.out.println(card + "\t");
			break;
		}
	}

	public void phase_5_side_bet_winnings(){
		if(DEBUGGING){
			System.out.println();
			System.out.println("phase_5_side_bet_winnings");
		}
	}

	public void phase_6_insurance(){
        // check for natural blackjack
		if(DEBUGGING){
			System.out.println();
			System.out.println("phase_6_insurance");
		}

		if(dealer.cardList.get(0).getNumber() == 11){
			System.out.println("asking for insurance");
            // go around table and ask each player if they want to put insurance
			hasInsurancePhase = true;

		}else{
			System.out.println("\tinsurance not needed");
            // check if players have natural blackjack
			for(Player player : listOfPlayers){
				if(player.getTotalSumOfCards() == 21){
                    // if dealer doesn't have a 10, player automatically wins,
                    // distribute accordingly
					alreadyWonPlayersList.add(player);
				}
			}
		}
	}

	public void phase_7_insurance_winnings(){
		if(DEBUGGING){
			System.out.println();
			System.out.println("phase_7_insurance_winnings");
		}
		if(dealer.getTotalSumOfCards() == 21){
			dealerAutoWins = true;
		}else{
            // collect insurance wagers


		}
	}

	public void phase_8_play_round(){
		if(DEBUGGING){
			System.out.println();
			System.out.println("phase_8_play_round");
		}
		Scanner sc = new Scanner(System.in);
		for(Player player : listOfPlayers){
			if(alreadyWonPlayersList.contains(player)){
				continue;
			}
			System.out.println("Player" + player.getPlayerId() + "'s turn: ");
			// System.out.println("cash: " + player.getTotalCash());
			debugging_printPlayersCards(player);
			debugging_printOptions();
			System.out.println("\t\t3) Double down");
            // if player has a pair
			if(player.cardList.get(0).getNumber() == player.cardList.get(1).getNumber()){
				System.out.println("\t\t4) Split cards");
			}
			int playerOptionNumber = sc.nextInt();
			if(playerOptionNumber == 3){ // player double downs
				player.addCard(deck.getCard());
				debugging_printPlayersCards(player);
				if(player.getTotalSumOfCards() > 21){
					System.out.println("Player Busted");
				}
			}else if(playerOptionNumber == 4){ // player split his cards
				player_phase_split_cards(player, player.cardList.get(0), player.cardList.get(1));
                // iterate through hands of split cards
				List<List<Card>> listListOfHands = splitHandsMap.get(player);
				for(int i = 0; i < listListOfHands.size(); i++){
					System.out.print("\n\thand" + i + ": ");
					List<Card> cardsInHand = listListOfHands.get(i);
					printCardsInHand(cardsInHand);
					int sumOfCardsInHand = sumOfHand(cardsInHand);
					System.out.println("\thandSumTotal: " + sumOfCardsInHand);

					debugging_printOptions();

                    // can't double down if split pairs were ACEs
					if(cardsInHand.get(0).getNumber() != 11){
						System.out.println("\t\t3) Double down");
					}
					playerOptionNumber = sc.nextInt();

					while(playerOptionNumber == 3 && cardsInHand.get(0).getNumber() == 11){
						System.out.println("\ninvalid option!");
						debugging_printOptions();
						playerOptionNumber = sc.nextInt();
					}

					if(playerOptionNumber == 3){
						cardsInHand.add(deck.getCard());
						debugging_printPlayersCards(player);
						if(player.getTotalSumOfCards() > 21){
							System.out.println("Player Busted");
						}
					}else{
						while(playerOptionNumber == 1){ // hit
							cardsInHand.add(deck.getCard());
							printCardsInHand(cardsInHand);
							sumOfCardsInHand = sumOfHand(cardsInHand);
							System.out.println("\thandSumTotal: " + sumOfCardsInHand);
							if(sumOfCardsInHand > 21){
								System.out.println("Player hand" + (i + 1) + " busted");
								break;
							}else{
								debugging_printOptions();
								playerOptionNumber = sc.nextInt();
							}
						}
					}
				}
			}else{
				while(playerOptionNumber == 1){ // hit
					player.addCard(deck.getCard());
					debugging_printPlayersCards(player);
					if(player.getTotalSumOfCards() > 21){
						System.out.println("Player Busted");
						break;
					}else{
						debugging_printOptions();
						playerOptionNumber = sc.nextInt();
					}
				}
			}
		}

		System.out.println();
		// dealer's turn
		System.out.println("Dealer's turn: ");
		debugging_printPlayersCards(dealer);
		if(dealer.getTotalSumOfCards() < 17){
			while(dealer.getTotalSumOfCards() < 17){
				dealer.addCard(deck.getCard());
				debugging_printPlayersCards(dealer);
			}
		}
	}

	public void printCardsInHand(List<Card> list){
		for(Card card : list){
			System.out.print("\t" + card);
		}
		System.out.print("\n");
	}

	public void phase_9_distribute_reset(){
		if(DEBUGGING){
			System.out.println();
			System.out.println("phase_9_distribute_reset");
			System.out.println();
			if(dealer.getTotalSumOfCards() > 21){
				System.out.println("Dealer Busted");
			}
			debugging_printWinners();
		}
        // distribute winnings

        // reset table settings
		clearTable();
	}

	public void player_phase_split_cards(Player player, Card card1, Card card2){
		System.out.print("player" + player.getPlayerId() + " split hand: ");
		// System.out.println("\tcard1: " + card1 + "\tcard2: " + card2);
		if(!splitHandsMap.containsKey(player)){
			List<List<Card>> listListOfHands = new ArrayList<>();
			List<Card> card1List = new ArrayList<>();
			card1List.add(card1);
			Card newCard1 = deck.getCard();
			card1List.add(newCard1);

			List<Card> card2List = new ArrayList<>();
			Card newCard2 = deck.getCard();
			card2List.add(card2);
			card2List.add(newCard2);

			listListOfHands.add(card1List);
			listListOfHands.add(card2List);
			splitHandsMap.put(player, listListOfHands);
			if(card1.getNumber() != 11){
				checkIfPlayerCanSplitAgain(player);
			}
		}else{
			List<List<Card>> listListOfHands = splitHandsMap.get(player);
			List<Card> card1List = new ArrayList<>();
			card1List.add(card1);
			Card newCard1 = deck.getCard();
			card1List.add(newCard1);

			List<Card> card2List = new ArrayList<>();
			Card newCard2 = deck.getCard();
			card2List.add(card2);
			card2List.add(newCard2);

			listListOfHands.add(card1List);
			listListOfHands.add(card2List);
			splitHandsMap.put(player, listListOfHands);
		}

	}

	public void checkIfPlayerCanSplitAgain(Player player){
		List<List<Card>> listListOfHands = splitHandsMap.get(player);
		if(listListOfHands.size() < 4){
			for(int i = 0; i < listListOfHands.size(); i++){
				List<Card> hand = listListOfHands.get(i);
				Card card1 = hand.get(0);
				Card card2 = hand.get(1);
				if(card1.getNumber() == card2.getNumber()){
					System.out.println("split hand cards:\t" + card1 + "\t" + card2);
					System.out.println("Split again Options:");
					System.out.println("\t1) Yes");
					System.out.println("\t2) No");
					Scanner sc = new Scanner(System.in);
					int playerSplitOption = sc.nextInt();
					if(playerSplitOption == 1){
						player_phase_split_cards(player, card1, card2);
						listListOfHands.remove(i);
						i--;
					}
				}
			}
		}else{
			return;
		}
	}

	public void addPlayer(Player player){
		listOfPlayers.add(player);
	}

	public boolean hasEnoughCards(){
		return true;
	}

	public void debugging_setNumberOfPlayers(int numberOfPlayers){
		for(int i = 1; i <= numberOfPlayers; i++){
			addPlayer(new Player(i, i * 1000));
		}
		System.out.println(numberOfPlayers + " player(s) added\n");
	}

	public void playGame(){
		if(DEBUGGING){
			System.out.println("Game options:");
			System.out.println("\t\t1) Play Game");
			System.out.println("\t\t2) Quit");

			Scanner sc = new Scanner(System.in);
			int optionNumber = sc.nextInt();
			if(optionNumber == 1){
				System.out.print("How many players, (1 to 6): ");
				int numberOfPlayers = sc.nextInt();
				System.out.println();
				debugging_setNumberOfPlayers(numberOfPlayers);
			}

			while(optionNumber == 1){
				// phase_1_standby();
				// phase_2_add_players();
				// phase_3_betting();
				phase_4_deal_cards();
				// phase_5_side_bet_winnings();
				phase_6_insurance();
				if(hasInsurancePhase){
					phase_7_insurance_winnings();
				}
				if(!dealerAutoWins){
					phase_8_play_round();
				}
				phase_9_distribute_reset();

				System.out.println();
				debugging_printGameOptions();
				optionNumber = sc.nextInt();
				while(optionNumber == 3){
					if(optionNumber == 3){
						System.out.println("\t\t\tnumOfCardsLeft: " + deck.cardCount());
					}
					debugging_printGameOptions();
					optionNumber = sc.nextInt();
				}
			}
			sc.close();
			System.out.println("Game Ended");
		}
	}

	public void debugging_printWinners(){
		int dealerSum = dealer.getTotalSumOfCards();
		if(dealerSum == 21){
			System.out.println("Dealer won with blackjack");
			System.out.print("Player's total(s): ");
			if(splitHandsMap.isEmpty()){
				for(Player player : listOfPlayers){
					System.out.print(player.getPlayerId() + "(" + player.getTotalSumOfCards() + "), ");
				}
				// print players who also had blackjack
				System.out.println("\nPush:");
				System.out.print("\t");
				for(Player player : listOfPlayers){
					if(player.getTotalSumOfCards() == 21){
						System.out.print(player.getPlayerId() + "(" + player.getTotalSumOfCards() + "), ");
					}
				}
			}else{
				System.out.println("players have split cards played");
				for(Player player : listOfPlayers){
					if(splitHandsMap.containsKey(player)){
						List<List<Card>> listOfListOfCards = splitHandsMap.get(player);
						for(List<Card> hand : listOfListOfCards){
							System.out.print(player.getPlayerId() + "(" + sumOfHand(hand) + "), ");
						}
					}else{
						System.out.print(player.getPlayerId() + "(" + player.getTotalSumOfCards() + "), ");
					}
				}
				// print players who also had blackjack
				System.out.println("\nPush:");
				System.out.print("\t");
				for(Player player : listOfPlayers){
					if(splitHandsMap.containsKey(player)){
						List<List<Card>> listOfListOfCards = splitHandsMap.get(player);
						for(List<Card> hand : listOfListOfCards){
							int sum = sumOfHand(hand);
							if(sum == 21){
								System.out.print(player.getPlayerId() + "(" + 21 + "), ");
							}
						}
					}else{
						if(player.getTotalSumOfCards() == 21){
							System.out.print(player.getPlayerId() + "(" + player.getTotalSumOfCards() + "), ");
						}
					}
				}
			}
		}else{
			System.out.println("Dealer's total: " + dealer.getTotalSumOfCards());
			System.out.print("Player's total(s): ");

			if(splitHandsMap.isEmpty()){
				for(Player player : listOfPlayers){
					System.out.print(player.getPlayerId() + "(" + player.getTotalSumOfCards() + "), ");
				}
			}else{
				System.out.println("players have split cards played");
				for(Player player : listOfPlayers){
					if(splitHandsMap.containsKey(player)){
						List<List<Card>> listOfListOfCards = splitHandsMap.get(player);
						for(List<Card> hand : listOfListOfCards){
							System.out.print(player.getPlayerId() + "(" + sumOfHand(hand) + "), ");
						}
					}else{
						System.out.print(player.getPlayerId() + "(" + player.getTotalSumOfCards() + "), ");
					}
				}

				for(Player player : listOfPlayers){
					if(splitHandsMap.containsKey(player)){
						List<List<Card>> listOfListOfCards = splitHandsMap.get(player);
						for(List<Card> hand : listOfListOfCards){
							int sum = sumOfHand(hand);
							if(sum == 21){
								System.out.print(player.getPlayerId() + "(" + 21 + "), ");
							}
						}
					}else{
						if(player.getTotalSumOfCards() == 21){
							System.out.print(player.getPlayerId() + "(" + player.getTotalSumOfCards() + "), ");
						}
					}
				}
			}
			System.out.println("\nWinners:");
			System.out.print("\t");
			if(splitHandsMap.isEmpty()){
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
			}else{
				if(dealerSum > 21){ // dealer busted
					for(Player player : listOfPlayers){
						if(splitHandsMap.containsKey(player)){
							List<List<Card>> listOfListOfCards = splitHandsMap.get(player);
							for(List<Card> hand : listOfListOfCards){
								int sum = sumOfHand(hand);
								if(sum <= 21){
									System.out.print(player.getPlayerId() + "(" + sum + "), ");
								}
							}
						}else{
							if(player.getTotalSumOfCards() <= 21){
								System.out.print(player.getPlayerId() + "(" + player.getTotalSumOfCards() + "), ");
							}
						}
					}
				}else{ // dealer didn't bust
					for(Player player : listOfPlayers){
						if(splitHandsMap.containsKey(player)){
							List<List<Card>> listOfListOfCards = splitHandsMap.get(player);
							for(List<Card> hand : listOfListOfCards){
								int sum = sumOfHand(hand);
								if(sum > dealerSum && sum <= 21){
									System.out.print(player.getPlayerId() + "(" + sum + "), ");
								}
							}
						}else{
							if(player.getTotalSumOfCards() > dealerSum && player.getTotalSumOfCards() <= 21){
								System.out.print(player.getPlayerId() + "(" + player.getTotalSumOfCards() + "), ");
							}
						}
					}
				}
			}


		}

		System.out.println();
	}

	public int sumOfHand(List<Card> list){
		int sum = 0;
		// System.out.println("sum before: " + sum);
		// check if there's multiple ACEs
		boolean hasAceUsedAsEleven = false;
		for(int i = 0; i < list.size(); i++){
			int number = list.get(i).getNumber();
			// System.out.println("number: " + number);
			// System.out.println("\thasAceUsedAsEleven: " + hasAceUsedAsEleven);
			if(number == 11){
				if((sum + number) <= 21){
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

		return sum;
	}

	public void clearTable(){
		dealer.clearHand();
		for(Player player : listOfPlayers){
			player.clearHand();
		}
		hasInsurancePhase = false;
		dealerAutoWins = false;
		alreadyWonPlayersList.clear();
		splitHandsMap.clear();
	}

	static boolean hasNaturalBlackjack(Player player){
		return (player.getTotalSumOfCards() == 21) ? true : false;
	}

	static void debugging_printGameOptions(){
		System.out.println("Game options:");
		System.out.println("\t\t1) Continue Playing");
		System.out.println("\t\t2) Quit");
		System.out.println("\t\t3) Print number of cards left");
		// System.out.println("\t\t4) ");
	}

	static void debugging_printOptions(){
		System.out.println("\tOptions:");
		System.out.println("\t\t1) Hit");
		System.out.println("\t\t2) Stay");
		// System.out.println("\t3) Split");
	}

	static void debugging_printPlayersCards(Player player){
		// System.out.print("\tPlayer_" + player.getPlayerId() + ": ");
		System.out.print("\tCards: ");
		for(Card card : player.cardList){
			System.out.print(card + "\t");
		}
		System.out.println("\n\tplayerTotalSumOfCards: " + player.getTotalSumOfCards());
		System.out.println();
	}
}
