// Authored by Jie Huang
// 11/13/2017
// completed on
//

import java.util.*;

public class TestCards{
	public static void main(String[] args) {
		// testing Blackjack class
		Blackjack bj = new Blackjack();
		// bj.addPlayer(new Player(1, 1000));
		// bj.addPlayer(new Player(2, 2000));
		// bj.addPlayer(new Player(3, 3000));
		bj.playGame();



		// Deck deck = new Deck();
		// Deck deck = new Deck(2);
		// deck.printDeck();
		// deck.shuffle();
		// deck.printDeck();
		// System.out.println("card count: " + deck.cardCount());
		// System.out.println("numberOfCards: " + deck.listOfCards.size());
		// System.out.println(deck.removeCard());
		// System.out.println("card count: " + deck.cardCount());



        // testing Player class
		// Player player1 = new Player(1, 100);
		// System.out.println("playerId: " + player1.getPlayerId());
		// System.out.println("\tplayerTotalCash: " + player1.getTotalCash());
		// System.out.println("\tplayerTotalSumOfCards: " + player1.getTotalSumOfCards());
		// System.out.println("\tplayerHasCards: " + player1.hasCards());
		// Card card1 = deck.removeCard();
		// System.out.println("\tcard1: " + card1);
		// player1.addCard(card1);
		// System.out.println("\tplayerHasCards: " + player1.hasCards());

        // // testing Dealer class
		// Dealer dealer1 = new Dealer(2, 0);
		// System.out.println("dealerId: " + dealer1.getPlayerId());
		// System.out.println("dealerTotalCash: " + dealer1.getTotalCash());
		// System.out.println("dealerTotalSumOfCards: " + dealer1.getTotalSumOfCards());
		// System.out.println("dealerHasCards: " + dealer1.hasCards());


        // testing Cards
		// Card card1 = deck.removeCard();
		// System.out.println("card1: " + card1);
		// System.out.println("\tcardSuitType: " + card1.getSuitType());
		// System.out.println("\tcardNumberType: " + card1.getNumberType());
		// System.out.println("\tcardNumber: " + card1.getNumber());
		// Card card2 = deck.removeCard();
		// System.out.println("card2: " + card2);
		// System.out.println("\tcardNumberType: " + card2.getNumberType());
		// System.out.println("\tcardNumber: " + card2.getNumber());
		// Card card3 = deck.removeCard();
		// System.out.println("card3: " + card3);
		// System.out.println("\tcardNumberType: " + card3.getNumberType());
		// System.out.println("\tcardNumber: " + card3.getNumber());
		// Card card4 = deck.removeCard();
		// System.out.println("card4: " + card4);
		// System.out.println("\tcardNumberType: " + card4.getNumberType());
		// System.out.println("\tcardNumber: " + card4.getNumber());
		// Card card5 = deck.removeCard();
		// System.out.println("card5: " + card5);
		// System.out.println("\tcardNumberType: " + card5.getNumberType());
		// System.out.println("\tcardNumber: " + card5.getNumber());
		// Card card6 = deck.removeCard();
		// System.out.println("card6: " + card6);
		// System.out.println("\tcardNumberType: " + card6.getNumberType());
		// System.out.println("\tcardNumber: " + card6.getNumber());
		// Card card7 = deck.removeCard();
		// System.out.println("card7: " + card7);
		// System.out.println("\tcardNumberType: " + card7.getNumberType());
		// System.out.println("\tcardNumber: " + card7.getNumber());
		// Card card8 = deck.removeCard();
		// System.out.println("card8: " + card8);
		// System.out.println("\tcardNumberType: " + card8.getNumberType());
		// System.out.println("\tcardNumber: " + card8.getNumber());
		// Card card9 = deck.removeCard();
		// System.out.println("card9: " + card9);
		// System.out.println("\tcardNumberType: " + card9.getNumberType());
		// System.out.println("\tcardNumber: " + card9.getNumber());
		// Card card10 = deck.removeCard();
		// System.out.println("card10: " + card10);
		// System.out.println("\tcardNumberType: " + card10.getNumberType());
		// System.out.println("\tcardNumber: " + card10.getNumber());
		// Card card11 = deck.removeCard();
		// System.out.println("card11: " + card11);
		// System.out.println("\tcardNumberType: " + card11.getNumberType());
		// System.out.println("\tcardNumber: " + card11.getNumber());
		// Card card12 = deck.removeCard();
		// System.out.println("card12: " + card12);
		// System.out.println("\tcardNumberType: " + card12.getNumberType());
		// System.out.println("\tcardNumber: " + card12.getNumber());
		// Card card13 = deck.removeCard();
		// System.out.println("card13: " + card13);
		// System.out.println("\tcardNumberType: " + card13.getNumberType());
		// System.out.println("\tcardNumber: " + card13.getNumber());


        // testing Number enum
		// Card card2 = deck.removeCard();
		// System.out.println(card2);
		// System.out.println("cardGetNumber: " + card2.getNumber());

        // testing adding multiple ACEs
		// Player player1 = new Player(1, 100);
		// Card card1 = new Card(Suit.SPADE, Number.ACE);
		// System.out.println("card1: " + card1);
		// player1.addCard(card1);
		// System.out.println("\tplayerTotalSumOfCards: " + player1.getTotalSumOfCards());
		// System.out.println();
		// // player1.addCard(card1);
		// // System.out.println("\tplayerTotalSumOfCards: " + player1.getTotalSumOfCards());
		// // player1.addCard(card1);
		// // System.out.println("\tplayerTotalSumOfCards: " + player1.getTotalSumOfCards());
		// // player1.addCard(card1);
		// // System.out.println("\tplayerTotalSumOfCards: " + player1.getTotalSumOfCards());
		// // player1.addCard(card1);
		// // System.out.println("\tplayerTotalSumOfCards: " + player1.getTotalSumOfCards());
		// // player1.addCard(card1);
		// // System.out.println("\tplayerTotalSumOfCards: " + player1.getTotalSumOfCards());
		// // player1.addCard(card1);
		// // System.out.println("\tplayerTotalSumOfCards: " + player1.getTotalSumOfCards());
		// // player1.addCard(card1);
		// // System.out.println("\tplayerTotalSumOfCards: " + player1.getTotalSumOfCards());
		// // player1.addCard(card1);
		// // System.out.println("\tplayerTotalSumOfCards: " + player1.getTotalSumOfCards());
		// // player1.addCard(card1);
		// // System.out.println("\tplayerTotalSumOfCards: " + player1.getTotalSumOfCards());
		// // player1.addCard(card1);
		// // System.out.println("\tplayerTotalSumOfCards: " + player1.getTotalSumOfCards());
		// // player1.addCard(card1);
		// // System.out.println("\tplayerTotalSumOfCards: " + player1.getTotalSumOfCards());
		// card1 = new Card(Suit.SPADE, Number.TEN);
		// player1.addCard(card1);
		// System.out.println("\tplayerTotalSumOfCards: " + player1.getTotalSumOfCards());
		// System.out.println();
		// player1.addCard(card1);
		// System.out.println("\tplayerTotalSumOfCards: " + player1.getTotalSumOfCards());
		// System.out.println();

        // checking hand: 8, 2, ACE; giving sum of 11 instead of 21
		// Player player = new Player(1, 1000);
		// player.addCard(new Card(Suit.DIAMOND, Number.EIGHT));
		// player.addCard(new Card(Suit.DIAMOND, Number.TWO));
		// player.addCard(new Card(Suit.DIAMOND, Number.ACE));
		// System.out.println("playerTotalSumOfCards: " + player.getTotalSumOfCards());


	}
}
