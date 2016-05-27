package main;

import java.util.Random;

public class Dice implements Comparable<Object>{
	private boolean isBeingRolled;
	private int value;
	private Random r;

	public Dice(){
		this.setBeingRolled(true);
		this.r = new Random();
	}
	
	public void roll(){
		this.value = r.nextInt(6) + 1;
	}

	public boolean isBeingRolled() {
		return isBeingRolled;
	}

	public void setBeingRolled(boolean isBeingRolled) {
		this.isBeingRolled = isBeingRolled;
	}
	
	public void toggleIsBeingRolled(){
		this.isBeingRolled = !isBeingRolled;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Dice){
			return ((Dice)o).getValue() - this.getValue();
		}
		return -1;
	}
	
	public String toString(){
		if (isBeingRolled){
			return this.value + "(A)"; 
		}
		return this.value + "(I)";
	}
}
