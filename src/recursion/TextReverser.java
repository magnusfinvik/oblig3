package recursion;

import java.util.Scanner;

public class TextReverser {

	public static void main(String[] args) {
		System.out.println("Skriv inn det ordet du vil snu om p�: ");
		Scanner input = new Scanner(System.in);
		String inputText = input.next();
		System.out.print("Det omsnudde ordet er : ");
		reverse(inputText);
		//skal denne kunne snu om en hel setning eller kun enkeltord?

	}
	
	public static void reverse(String text){
		int n = text.length();
		if(n == 1){
			System.out.println(text.charAt(0));
		}
		else{
			System.out.print(text.charAt(text.length()-1));
			text = text.substring(0, text.length()-1);
			reverse(text);
		}
	}

}
