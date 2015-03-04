package recursion;

import java.util.Scanner;

public class TextReverser {

	public static void main(String[] args) {
		System.out.println("Skriv inn det ordet du vil snu om på: ");
		Scanner input = new Scanner(System.in);
		String inputText = input.next();
		reverse(inputText);

	}
	public static void reverse(String text){
		int n = text.length();
		if(n == 1){
			System.out.print(text.charAt(0));
		}
		else{
			System.out.print(text.charAt(text.length()-1));
			text = text.substring(0, text.length()-1);
			
			reverse(text);
		}
	}

}
