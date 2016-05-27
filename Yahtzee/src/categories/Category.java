package categories;

import player.Dice;

public abstract class Category {
	private boolean played;
	private int score;
	private int scoreCardIndex;
	
	public Category(){
		this.scoreCardIndex = -1;
		this.score = 0;
		this.played = false;
	}
	
	public Category(int index){
		this.scoreCardIndex = index;
		this.score = 0;
		this.played = false;
	}

	public int getScore() {
		return score;
	}
	
	public void setScore(Dice[] dice){
		this.score = calculateScore(dice);
		this.played = true;
	}

	public abstract int calculateScore(Dice[] dice);
	
	public abstract String getCall();

	public boolean isPlayed() {
		return played;
	}

	public int sumDice(Dice[] dice) {
		int score = 0;
		for (Dice d : dice){
			score += d.getValue();
		}
		return score;
	}
	
	//fewest possible checks
	public boolean checkYahtzee(Dice[] dice){
		return dice[0].getValue() == dice[1].getValue() && dice[2].getValue() == dice[3].getValue() &&
				dice[4].getValue() == dice[0].getValue();
		
	}

	public int getScoreCardIndex() {
		return scoreCardIndex;
	}
	
	public String toString(){
		return this.score + ".";
	}
}
