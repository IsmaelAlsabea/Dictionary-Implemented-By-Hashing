package userInterfacePackage;

import driverPackage.userInterfaceHandlingPackage.IUserInterface;

public class Hashing_UI implements IUserInterface {
	
	InputReader ir;
	
	public Hashing_UI(){
		ir= new InputReader();
	}
	
	@Override
	public int chooseDataStructureTypeMenu() {
		int crt=-1;
		System.out.println("please specify the method of collision resolution\n" 
		+ "1) Linear Probing\n"
		+ "2) QuadratingProbing\n" 
		+ "3) Double Hashing\n" 
		+ "4) SeparateChaining\n");
		while(true) {
			crt = ir.readAnInt();
			if (crt < 1 || crt > 4) {
				System.out.println("Please insert a number between 1 and 4 to choose what type of Data Structure"
						+ " you want to use ");
				continue;	
			}
			break;
		}
		return crt;
	}
	
	@Override
	public String AskForWordMenu() {
		String wordToSearch= null;
		System.out.println("______________________________________________");
		System.out.println("what word do you like to search for its definition?");
		System.out.println("______________________________________________");
		wordToSearch = ir.readALineFromKeyboard();
		return wordToSearch;
}

}