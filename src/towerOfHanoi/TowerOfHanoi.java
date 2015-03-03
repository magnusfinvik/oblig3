package towerOfHanoi;

import java.util.Scanner;

public class TowerOfHanoi {
	static int numberOfMoves = 0;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("skriv inn antall disker: ");
		int numberOfDisks = input.nextInt();
		numberOfMoves = ((int) Math.pow(2, numberOfDisks)-1);

		System.out.println("trekkene er:");
		moveDisks(numberOfDisks, 'A', 'B', 'C');
		System.out.println("antall trekk er: " + numberOfMoves);
	}

	private static void moveDisks(int n, char fromTower, char toTower, char helperTower) {
		if (n == 1){
			System.out.println("Flytt disk " + n + " fra " + fromTower + " til " + toTower);
		}
		else{
			moveDisks(n-1, fromTower, helperTower, toTower);
			System.out.println("Flytt disk " + n + " fra " + fromTower + " til " + toTower);
			moveDisks(n-1, helperTower, toTower, fromTower);
			
		}
	}
}
