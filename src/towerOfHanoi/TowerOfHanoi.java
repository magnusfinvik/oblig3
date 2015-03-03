package towerOfHanoi;

import java.util.Scanner;

public class TowerOfHanoi {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("skriv inn antall disker: ");
		int numberOfDisks = input.nextInt();

		System.out.println("trekkene er:");
		moveDisks(numberOfDisks, 'A', 'B', 'C');
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
