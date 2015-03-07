package recursion;

import java.util.Scanner;

public class TextReverser {

	private static int count = 0;
	public static void main(String[] args) {
		System.out.println("Skriv inn det ordet du vil snu om på: ");
		Scanner input = new Scanner(System.in);
		String inputText = input.nextLine();
		System.out.print("Det omsnudde ordet er : ");
		reverse(inputText);

	}
	
	public static void reverse(String text, int last){
		if(last >= 1){
			System.out.print(text.charAt(last-1));
			count++;
			reverse(text, last-1);
		}
		else{
			System.out.println("\nNumber of characters: " + count);
			count = 0;
			
		}
	}
	
	public static void reverse(String text){
		System.out.print(text.charAt(text.length()-1));
		count++;
		reverse(text, text.length()-1);
	}

}
