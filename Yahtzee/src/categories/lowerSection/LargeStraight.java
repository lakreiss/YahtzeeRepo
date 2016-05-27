package categories.lowerSection;

import java.util.Arrays;

import categories.Category;
import player.Dice;

public class LargeStraight extends Category implements LowerSection {

	public LargeStraight() {
		super(4);
	}

	@Override
	public int calculateScore(Dice[] dice) {
		Arrays.sort(dice);
		if (assertDiceStraight(1, 2, 3, 4, 5, dice) ||  assertDiceStraight(2, 3, 4, 5, 6, dice)){
			return 40;
		}
		if (checkYahtzee(dice)){
			return 40;
		}
		return 0;
	}

	private boolean assertDiceStraight(int i, int j, int k, int l, int m, Dice[] dice) {
		boolean hasI = false;
		boolean hasJ = false;
		boolean hasK = false;
		boolean hasL = false;
		boolean hasM = false;
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
			if (d.getValue() == m){
				hasM = true;
			}
		}
		return hasI && hasJ && hasK && hasL && hasM;
	}

	public String getCall(){
		return "largestraight";
	}
	
	public String toString(){
		return "Large Straight: " + super.toString();
	}
}
