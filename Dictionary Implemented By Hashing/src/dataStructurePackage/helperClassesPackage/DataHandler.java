package dataStructurePackage.helperClassesPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataHandler {

	private List<String> allData;
	
	public DataHandler(String path){
		allData= new ArrayList<>();
		allData= readAllLines(path);
	}
	
	public List<String> getAllData() {
		return allData;
	}


	 private ArrayList<String> readAllLines(String path) {
			Scanner reader = null;
			ArrayList<String> allLines = new ArrayList<>();
			try {
				reader = new Scanner(new FileReader(path));
				while (reader.hasNextLine())
					allLines.add(readALineFromFile(reader));

			} catch (FileNotFoundException e) {
				System.out.println("File not found");
				e.toString();
			}
			finally {
				reader.close();
			}
			return allLines;
		}
		 
		private String readALineFromFile(Scanner reader) {
			String str = "";
			while (true) {
				str = reader.nextLine();
				if (!str.equals(""))
					break;
			}
			return str;
		 }
}
