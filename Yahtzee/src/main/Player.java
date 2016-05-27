package main;

import java.util.Scanner;

import categories.Category;
import categories.lowerSection.Chance;
import categories.lowerSection.FourOfAKind;
import categories.lowerSection.FullHouse;
import categories.lowerSection.LargeStraight;
import categories.lowerSection.SmallStraight;
import categories.lowerSection.ThreeOfAKind;
import categories.lowerSection.Yahtzee;
import categories.upperSection.Fives;
import categories.upperSection.Fours;
import categories.upperSection.Ones;
import categories.upperSection.Sixes;
import categories.upperSection.Threes;
import categories.upperSection.Twos;

public class Player {

	private String name;
	private GameCard gameCard;
	private Dice[] cup;
	
	public Player(String name){
		this.name = name;
		this.gameCard = new GameCard();
		this.cup = new Dice[]{new Dice(), new Dice(), new Dice(), new Dice(), new Dice()};
	}

	public GameCard getGameCard() {
		return gameCard;
	}

	public String getName() {
		return name;
	}

	public Dice[] getCup() {
		return cup;
	}

	public void setCup(Dice[] cup) {
		this.cup = cup;
	}
	
	public String roll(Scanner console){
		for (Dice d : getCup()){
			if (d.isBeingRolled()){
				d.roll();
			}
		}
		printCup();
		System.out.print("What is your play? ");
		while (console.hasNextInt()){
			// -1 for array indexing
			int inputNum = console.nextInt() - 1;
			if (inputNum >= 0 && inputNum < 5){
				getCup()[inputNum].toggleIsBeingRolled();
				printCup();
			} else {
				System.out.println("Invalid entry.");
			}
			System.out.print("What is your play? ");
		}
		
		//clears the previous line
		String nextPlay = console.nextLine().toLowerCase();
		if (nextPlay.equals("")){
			nextPlay = console.nextLine().toLowerCase();
		}
		while (!nextPlay.equals("roll") && nextPlayCategory(nextPlay) == null){
			//TODO fix problem where this always prints
			System.out.print("Invalid entry. Please try again: ");
			nextPlay = console.nextLine().toLowerCase();
		}
		if (nextPlay.equals("roll")){
			return nextPlay;
		}
		return nextPlay;
	}
	
	public Category nextPlayCategory(String nextPlay) {
		for (Category c : gameCard.getUpperSection()){
			//checks to make sure the category hasn't been played yet
			if (!c.isPlayed()){
				if (nextPlay.equals(c.getCall())){
					return c;
				}
			}
		}
		
		for (Category c : gameCard.getLowerSection()){
			//checks to make sure the category hasn't been played yet
			if (!c.isPlayed()){
				if (nextPlay.equals(c.getCall())){
					return c;
				}
			}
		}
		return null;
	}

	public void printCup(){
		System.out.print("[");
		System.out.print(cup[0].toString());
		for (int i = 1; i < cup.length; i++){
			System.out.print(", " + cup[i].toString());

		}
		System.out.print("]");
		System.out.println();
	}

	public void printScoreCard() {
		System.out.println();
		System.out.println(getName() + "'s Score Card");
		System.out.println("Upper Section:");
		for (Category c : gameCard.getUpperSection()){
			System.out.print(" " + c.toString());
		}
		System.out.println();
		System.out.println("Lower Section:");
		for (Category c: gameCard.getLowerSection()){
			System.out.print(" " + c.toString());
		}
		System.out.println();
		System.out.println("Upper Section subscore: " + gameCard.getUpperSectionScore());
		System.out.println("Lower Section subscore: " + gameCard.getLowerSectionScore());
		System.out.println("Total Score: " + gameCard.getTotalScore());
		System.out.println();
	}

	public void resetCup() {
		for (Dice d : cup){
			d.setBeingRolled(true);
		}
	}
	
}
