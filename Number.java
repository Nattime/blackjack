// Authored by Jie Huang
// 11/13/2017
// completed on
//

import java.util.*;

enum Number{
	ACE{
		public int getNumber(){
			return 11;
		}
	}, TWO{
		public int getNumber(){
			return 2;
		}
	}, THREE{
		public int getNumber(){
			return 3;
		}
	}, FOUR{
		public int getNumber(){
			return 4;
		}
	}, FIVE{
		public int getNumber(){
			return 5;
		}
	}, SIX{
		public int getNumber(){
			return 6;
		}
	}, SEVEN{
		public int getNumber(){
			return 7;
		}
	}, EIGHT{
		public int getNumber(){
			return 8;
		}
	}, NINE{
		public int getNumber(){
			return 9;
		}
	}, TEN, JACK, QUEEN, KING;
	public int getNumber(){
		return 10;
	}
}
