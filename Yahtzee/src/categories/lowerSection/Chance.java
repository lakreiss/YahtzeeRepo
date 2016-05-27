package categories.lowerSection;

import categories.Category;
import player.Dice;

public class Chance extends Category implements LowerSection {

	public Chance() {
		super(6);
	}

	@Override
	public int calculateScore(Dice[] dice) {
		return super.sumDice(dice);
	}

	public String getCall(){
		return "chance";
	}
	
	public String toString(){
		return "Chance: " + super.toString();
	}
}
