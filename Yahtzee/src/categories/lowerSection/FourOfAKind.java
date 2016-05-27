package categories.lowerSection;

import categories.Category;
import main.Dice;

public class FourOfAKind extends Category implements LowerSection {

	public FourOfAKind() {
		super(1);
	}

	@Override
	public int calculateScore(Dice[] dice) {
		boolean foundFourOfAKind = false;
		for (int i = 1; i <= 6; i++){
			int counter = 0;
			for (Dice d : dice){
				if (d.getValue() == i){
					counter++;
				}
			}
			if (counter >= 4){
				foundFourOfAKind = true;
			}
		}
		if (foundFourOfAKind){
			return super.sumDice(dice);
		}
		return 0;
	}
	
	public String getCall(){
		return "fourofakind";
	}
	
	public String toString(){
		return "Four of a Kind: " + super.toString();
	}

}
