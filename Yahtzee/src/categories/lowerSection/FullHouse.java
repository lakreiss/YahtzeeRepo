package categories.lowerSection;

import categories.Category;
import main.Dice;

public class FullHouse extends Category implements LowerSection {

	public FullHouse() {
		super(2);
	}

	@Override
	public int calculateScore(Dice[] dice) {
		boolean foundThreeOfAKind = false;
		int threeOfAKindValue = -1;
		for (int i = 1; i <= 6; i++){
			int counter = 0;
			for (Dice d : dice){
				if (d.getValue() == i){
					counter++;
					if (counter == 3){
						threeOfAKindValue = i;
					}
				}
			}
			if (counter >= 3){
				foundThreeOfAKind = true;
			}
		}
		
		if (foundThreeOfAKind){
			boolean foundTwoOfAKind = false;
			for (int i = 1; i <= 6; i++){
				if (i != threeOfAKindValue){
					int counter = 0;
					for (Dice d : dice){
						if (d.getValue() == i){
							counter++;
						}
					}
					if (counter >= 2){
						foundTwoOfAKind = true;
					}
				}
			}
			if (foundTwoOfAKind){
				return 25;
			}
		}
		if (checkYahtzee(dice)){
			return 25;
		}
		return 0;
	}
	
	public String getCall(){
		return "fullhouse";
	}
	
	public String toString(){
		return "Full House: " + super.toString();
	}

}
