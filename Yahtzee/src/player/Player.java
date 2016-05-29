package player;

import java.util.Scanner;

import categories.Category;

public class Player {

	private String name;
	private GameCard gameCard;
	private Dice[] cup;
	private final String DICE_TOP_AND_BOTTOM_STRING = " -----    -----    -----    -----    -----";;
	
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
		System.out.println("What is your play? ");
		System.out.println("If you don't type a dice index, it will be assumed that");
		System.out.print("you are going to submit the dice. ");
		while (console.hasNextInt()){
			// -1 for array indexing
			int inputNum = console.nextInt() - 1;
			
			//clears line
			console.nextLine();
			
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
		System.out.println(DICE_TOP_AND_BOTTOM_STRING);
		System.out.print(cup[0].toString());
		for (int i = 1; i < cup.length; i++){
			System.out.print(", " + cup[i].toString());
		}
		System.out.println();
		System.out.println(DICE_TOP_AND_BOTTOM_STRING);
		
//		System.out.print("[");
//		for (int i = 1; i < cup.length; i++){
//			System.out.print(", " + cup[i].toString());
//		}
//		System.out.println("]");
	}

	public void printScoreCard() {
		System.out.println();
		System.out.println(getName() + "'s Score Card");
		System.out.println(getGameCard().toString());
		System.out.println();
	}

	public void resetCup() {
		for (Dice d : cup){
			d.setBeingRolled(true);
		}
	}
	
}
