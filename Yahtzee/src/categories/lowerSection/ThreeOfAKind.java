package categories.lowerSection;

import categories.Category;
import main.Dice;

public class ThreeOfAKind extends Category implements LowerSection {

	public ThreeOfAKind() {
		super(0);
	}

	@Override
	public int calculateScore(Dice[] dice) {
		boolean foundThreeOfAKind = false;
		for (int i = 1; i <= 6; i++){
			int counter = 0;
			for (Dice d : dice){
				if (d.getValue() == i){
					counter++;
				}
			}
			if (counter >= 3){
				foundThreeOfAKind = true;
			}
		}
		if (foundThreeOfAKind){
			return super.sumDice(dice);
		}
		return 0;
	}

	public String getCall(){
		return "threeofakind";
	}
	
	public String toString(){
		return "Three of a Kind: " + super.toString();
	}
}
