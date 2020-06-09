package test;

import java.util.Scanner;

public class TvaEtt {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Skriv en text");
		String text = input.nextLine(); 
		int consonants = consonants(text);//räknar konsonanter
		int vowels = vowels(text);//räknar vokaler
		System.out.println("Din text har "+vowels+" vokaler och "+consonants+" konsonanter.");

		input.close();
	}


	public static int vowels(String vowels) {
		//räknar vokaler
		int count = 0;
		for (int i =0; i < vowels.length(); i++) {
			if (vowels.charAt(i) == 'a' || vowels.charAt(i) == 'e' ||vowels.charAt(i) == 'i' ||vowels.charAt(i) == 'o' ||vowels.charAt(i) == 'u' ||
					vowels.charAt(i) == 'y' ||vowels.charAt(i) == 'å' ||vowels.charAt(i) == 'ä' ||vowels.charAt(i) == 'ö')
				count++;
		}
		return(count);
	}
	public static int consonants(String consonants) {
		//räknar konsonanter
		int count = 0;
		for (int i =0; i < consonants.length(); i++) {
			if (consonants.charAt(i) == 'b' ||consonants.charAt(i) == 'c' ||consonants.charAt(i) == 'd' ||consonants.charAt(i) == 'f' ||consonants.charAt(i) == 'g' ||
					consonants.charAt(i) == 'h' ||consonants.charAt(i) == 'j' ||consonants.charAt(i) == 'k' ||consonants.charAt(i) == 'l' ||consonants.charAt(i) == 'm' ||
					consonants.charAt(i) == 'n' ||consonants.charAt(i) == 'p' ||consonants.charAt(i) == 'q' ||consonants.charAt(i) == 'r' ||consonants.charAt(i) == 's' ||
					consonants.charAt(i) == 't' ||consonants.charAt(i) == 'v' ||consonants.charAt(i) == 'w' ||consonants.charAt(i) == 'x' ||consonants.charAt(i) == 'z')
				count++;
		}
		return(count);
	}
}