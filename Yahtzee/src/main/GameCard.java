package main;

import categories.Category;
import categories.lowerSection.Chance;
import categories.lowerSection.FourOfAKind;
import categories.lowerSection.FullHouse;
import categories.lowerSection.LargeStraight;
import categories.lowerSection.SmallStraight;
import categories.lowerSection.ThreeOfAKind;
import categories.lowerSection.Yahtzee;
import categories.upperSection.Ones;
import categories.upperSection.Fives;
import categories.upperSection.Fours;
import categories.upperSection.Sixes;
import categories.upperSection.Threes;
import categories.upperSection.Twos;

public class GameCard {
	private static final int UPPER_SECTION_BONUS_LIMIT = 63;
	private static final int UPPER_SECTION_BONUS = 35;
	private Category[] upperSection;
	private Category[] lowerSection;
	
	public Category[] getUpperSection() {
		return upperSection;
	}

	public Category[] getLowerSection() {
		return lowerSection;
	}
	
	public GameCard(){
		upperSection = new Category[]{new Ones(), new Twos(), new Threes(), 
				new Fours(), new Fives(), new Sixes()};
		lowerSection = new Category[]{new ThreeOfAKind(), new FourOfAKind(), new FullHouse(), 
				new SmallStraight(), new LargeStraight(), new Yahtzee(), new Chance()};
	}
	
	public boolean isFull(){
		for (Category c : upperSection){
			if (!c.isPlayed()){
				return false;
			}
		}
		for (Category c : lowerSection){
			if (!c.isPlayed()){
				return false;
			}
		}
		return true;
	}

	public int getUpperSectionScore() {
		int score = 0;
		for (Category c : upperSection){
			score += c.getScore();
		}
		
		if (score >= UPPER_SECTION_BONUS_LIMIT){
			return score + UPPER_SECTION_BONUS;
		}
		return score;
	}
	
	public int getLowerSectionScore() {
		int score = 0;
		for (Category c : lowerSection){
			score += c.getScore();
		}
		return score;
	}
	
	public int getTotalScore(){
		return getUpperSectionScore() + getLowerSectionScore();
	}
}
