package main;

import java.util.Scanner;

import categories.Category;
import categories.lowerSection.LowerSection;
import categories.upperSection.UpperSection;

public class MainGame {

	private static final int MAX_NUM_PLAYERS = 10;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		printIntro();
		printRules();
		int numPlayers = getNumPlayers(console);
		Player[] playerList = new Player[numPlayers];
		for (int i = 0; i < numPlayers; i++){
			playerList[i] = getNewPlayer(console, i + 1);
		}
		
		while (!eachGameCardIsFull(playerList)){
			for (Player p : playerList){
				if (p.getGameCard().isFull()){
					System.out.println(p.getName() + " has finished their game.");
				} else {
					playerTurn(p, console);
				}
			}
		}
	}
	
	private static boolean eachGameCardIsFull(Player[] playerList) {
		for (Player p : playerList){
			if (!p.getGameCard().isFull()){
				return false;
			}
		}
		return true;
	}

	private static int getNumPlayers(Scanner console) {
		System.out.print("How many people want to play? ");
		while (!console.hasNextInt()){
			
			//clears the line 
			console.nextLine();
			
			System.out.print("That wasn't a valid entry.\nHow many people want to play? ");
		}
		int numPlayers = console.nextInt();
		
		//clears the line
		console.nextLine();
		
		if (numPlayers < 1 || numPlayers > MAX_NUM_PLAYERS){
			System.out.println("You entered an invalid number of players.");
			return getNumPlayers(console);
		}
		return numPlayers;
	}

	private static void playerTurn(Player p, Scanner console) {
		p.resetCup();
		boolean turnContinuing = true;
		int turnCounter = 0;
		System.out.println();
		System.out.println(p.getName() + " rolls the dice");
		while (turnContinuing){
			if (turnCounter < 2){
				turnCounter++;
				String nextPlay = p.roll(console);
				if (nextPlay.equals("roll")){
					//turn should continue
				} else {
					// nextPlay is a category call
					turnContinuing = false;
					submitScore(p, nextPlay);
					p.printScoreCard();
				}
			} else {
				//third roll cannot have a nextPlay of roll
				String nextPlay = p.roll(console);
				if (p.nextPlayCategory(nextPlay) == null){
					System.out.println("Invalid entry. You must choose a category.");
					System.out.print("Please try again: ");
					nextPlay = console.nextLine();
				}
				turnContinuing = false;
				submitScore(p, nextPlay);
				p.printScoreCard();
			}
		}
	}
	
	public static void submitScore(Player p, String nextPlay){
		Category c = p.nextPlayCategory(nextPlay);
		if (c instanceof UpperSection){
			p.getGameCard().getUpperSection()[c.getScoreCardIndex()].setScore(p.getCup());
		} else if (c instanceof LowerSection){
			p.getGameCard().getLowerSection()[c.getScoreCardIndex()].setScore(p.getCup());
		}
	}

	private static Player getNewPlayer(Scanner console, int i) {
		
		System.out.print("What is player " + i + "'s name? ");
		String name = console.nextLine();
		System.out.println("Good luck, " + name);
		
		return new Player(name);
	}

	private static void printIntro() {
		System.out.println("Welcome to Yahtzee!");
		
	}

	private static void printRules() {
		System.out.println("type \"roll\" to roll, or the dice number you wish to hold/unhold");
	}

}
