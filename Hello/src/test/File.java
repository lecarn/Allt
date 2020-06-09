package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class File {

	public static void main(String[] args)throws Exception  {
		BufferedReader objReader = null; //startar buffern
		StringBuilder content = new StringBuilder();
		String line = "";
		FileWriter fw = new FileWriter("C:\\Users\\Marcus\\eclipse-workspace\\Hello\\src\\test\\testout.txt", true);
		Scanner input = new Scanner(System.in);

		//läser filen till buffern objReader		
		objReader = new BufferedReader(new FileReader("C:\\Users\\Marcus\\eclipse-workspace\\Hello\\src\\test\\testout.txt"));

		
		

		char continueLoop;

		System.out.println("Vill du skriva, läsa eller edditera?");
		continueLoop = input.nextLine().charAt(0);


		if(continueLoop == 's' || continueLoop == 'S') {

			System.out.println("Skriv nått");
			String nått = input.nextLine();
			try{    
				fw.write("\n"+ nått);    
				fw.close();    
			}catch(Exception e){System.out.println(e);}    
			System.out.println("Success...");    
		}
		else if (continueLoop == 'l' || continueLoop == 'L') {
		try {
			String strCurrentLine;

			objReader = new BufferedReader(new FileReader("C:\\Users\\Marcus\\eclipse-workspace\\Hello\\src\\test\\testout.txt"));

			while ((strCurrentLine = objReader.readLine()) != null) {
				System.out.println(strCurrentLine);
			}
			} catch (IOException e) {
				e.printStackTrace(); }

			}
		else if (continueLoop == 'e' || continueLoop == 'E') {
				Edit();
	}

	}


		public static void Edit() throws Exception {

			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Marcus\\eclipse-workspace\\Hello\\src\\test\\testout.txt"));
			String edit = null;
			int lines = 0;

			Scanner input = new Scanner(System.in);
			System.out.println(" Type in what sentence ");
			String ny = input.nextLine();

			StringBuilder test = new StringBuilder();
			String word = "";
			System.out.println(" Type in what line you want to replace ");
			int choice = input.nextInt();



			while ((word = br.readLine()) != null) {
				lines++;
				if (lines == choice)
					test.append((ny));
				else
					test.append(word);


				test.append(System.lineSeparator());
			}
			edit = test.toString();

			br.close();


			try {
				FileWriter fw = new FileWriter("C:\\Users\\Marcus\\eclipse-workspace\\Hello\\src\\test\\testout.txt");
				System.out.println("File edited complete");

				fw.write(edit);
				fw.close();


			} catch (Exception e) {
				System.out.println("File not created");
			}
		}
	}