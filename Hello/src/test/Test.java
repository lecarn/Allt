package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Test {


	public static void main(String[] args) {

		int random = 1;
		int multi = 1;
		int count = 0;
		int total = 0;

		for (int i = 0; i < 8; i++) {
			count++;
			//System.out.println("\r");
			//skapar ny rad
			multi = 0;
			for (int k = 7; k > i; k--)
				System.out.print("\t");
			//skapar mellanrum

			for (int l = 0; l < i; l++) {
				total = (int) Math.pow(3, multi);
				int tmp = (int) total;
				System.out.print(tmp+ "\t");
				multi++;

			}
			// omv�nder f�r funktionen f�r att r�kna ner samtidigt spara jag h�gsta v�rdet som jag tar hit
			for (int q = 0; q < count; q++) {
				total = (int) Math.pow(-3, multi);

				if (total < 0)
					total *= -1;
				int tmp = (int) total;
				//anv�nder if f�r att inte bli minus

				System.out.print(tmp+ "\t");
				multi--;

			}
			// close enough lol, det �r ett stort h�l i pyramiden och ja fattar inte var�fr

		}


	}
}