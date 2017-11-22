// Authored by Jie Huang
// 11/13/2017
// completed on
//

import java.util.*;

/**
*	Card : class
*----------------------------
*	suitType : Suit
*	numberType : Number
*	number : int
*----------------------------
*	<<constructor>> Card
*	-setSuitType(Suit) : void
*	+getSuitType() : Suit
*	-setNumberType(Number) : void
*	+getNumberType() : Number
*	-setNumber(int) : void
*	+getNumber() : int
*	+toString : @Override String
*/

public class Card{
// constructor
	Card(Suit suitType, Number numberType){
		setSuitType(suitType);
		setNumberType(numberType);
	}

// fields
	private Suit suitType = null;
	private Number numberType = null;
	private int number = 0;

// methods
	private void setSuitType(Suit suitType){
		this.suitType = suitType;
	}
	public Suit getSuitType(){
		return suitType;
	}

	private void setNumberType(Number numberType){
		this.numberType = numberType;
		setNumber(numberType.getNumber());
	}
	public Number getNumberType(){
		return numberType;
	}

	private void setNumber(int number){
		this.number = number;
	}
	public int getNumber(){
		return number;
	}

	@Override
	public String toString(){
		return getSuitType().name() + " " + getNumberType().name();
	}
}
