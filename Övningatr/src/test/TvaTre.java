package test;


public class TvaTre {


	public static void main(String[] args) {

		int multi = 1;
		int count = 0;
		int total = 0;

		for (int i = 0; i < 8; i++) {
			count++;
			System.out.println("");
			//skapar ny rad
//anv�nde f�rst \n men vart en tomrad d�. med bara "" blir den tajtare, men f�rst�r inte varf�r eller hur en ny rad skapas.
// Men tar jag bort hela den printen blir det allt p� en rad....

			multi = 0;
			for (int k = 7; k > i; k--)
				System.out.print("\t");
			//skapar mellanrum s� det blir en pyramid

			for (int l = 0; l < i; l++) {
				total = (int) Math.pow(3, multi);
				int tmp = (int) total;
				System.out.print(tmp+ "\t");
				multi++;
				//printar v�nster sida pyramid

			}
			for (int q = 0; q < count; q++) {
				total = (int) Math.pow(-3, multi);
				//r�knar ner p� h�ger sida pyramid.

				if (total < 0)
					total *= -1;
				int tmp = (int) total;
				//k�r en if f�r att inte bli minus

				System.out.print(tmp+ "\t");
				multi--;
				//printar h�ger sida
				

			}

		}


	}
}