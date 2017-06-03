import java.io.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileReader;

public class Shares {
	public static void main(String[] args) {
		Double numShares;
		System.out.println("Welcome to the Asset Mangement System");
		System.out.print("Input the number of GOOG shares: ");
		Scanner input = new Scanner(System.in);
		numShares = input.nextDouble();
	
		System.out.println("Your GOOG assests:");

		String csvFile = "GOOGprices.csv";
		
		try {
			File file = new File(csvFile);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			int counter = 0;
			while ((line = bufferedReader.readLine()) != null){
				String strar[] = line.split(",");
				if (counter == 0){
					System.out.printf("%-20s%-20s%-20s\n", strar[0], "Number of Shares", "Total Value");
				}
				else{

				Double adjClose= Double.parseDouble(strar[6]);
				Double totalShares = adjClose * numShares;
				int intNumShares = (int) Math.round(numShares);
				
				System.out.printf("%-20s%-20s%-20s\n", strar[0], intNumShares, Math.round(totalShares*100.0)/100.0);
				}
				counter = counter + 1;
				}
			fileReader.close();
			
		}catch (IOException e){
			e.printStackTrace();
		}
	input.close();
	}
}