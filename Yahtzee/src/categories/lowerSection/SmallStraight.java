package categories.lowerSection;

import java.util.Arrays;

import categories.Category;
import player.Dice;

public class SmallStraight extends Category implements LowerSection {
	
	public SmallStraight() {
		super(3);
	}

	@Override
	public int calculateScore(Dice[] dice) {
		Arrays.sort(dice);
		if (assertDiceStraight(1, 2, 3, 4, dice) ||  assertDiceStraight(2, 3, 4, 5, dice) 
				|| assertDiceStraight(3, 4, 5, 6, dice)){
			return 30;
		}
		if (checkYahtzee(dice)){
			return 30;
		}
		return 0;
	}

	private boolean assertDiceStraight(int i, int j, int k, int l, Dice[] dice) {
		boolean hasI = false;
		boolean hasJ = false;
		boolean hasK = false;
		boolean hasL = false;
		for (Dice d : dice){
			if (d.getValue() == i){
				hasI = true;
			}
			if (d.getValue() == j){
				hasJ = true;
			}
			if (d.getValue() == k){
				hasK = true;
			}
			if (d.getValue() == l){
				hasL = true;
			}
		}
		return hasI && hasJ && hasK && hasL;
	}
	
	public String getCall(){
		return "smallstraight";
	}
	
	public String toString(){
		return "Small Straight: " + super.toString();
	}

}
