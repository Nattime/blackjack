// Authored by Jie Huang
// 11/13/2017
// completed on
//

import java.util.*;

public class Card{
	Suit suit = null;
	Number number = null;
	int num = 0;
	Card(Suit suit, Number number){
		this.suit = suit;
		this.number = number;
	}
	@Override
	public String toString(){
		return suit.name() + " " + number.name();
	}
}
