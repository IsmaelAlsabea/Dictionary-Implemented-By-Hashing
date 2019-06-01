package driverPackage;

import driverPackage.dataStructureHandlingPackage.DataStructureFactory;
import driverPackage.dataStructureHandlingPackage.IDS;
import driverPackage.userInterfaceHandlingPackage.IUserInterface;
import driverPackage.userInterfaceHandlingPackage.UserInterfaceFactory;

public class Main {

	public static void main(String args[]) {
		String path= "dictionary.txt";
		
		IUserInterface ui= UserInterfaceFactory.createUserInterface();
		
		while(true) {
			int chooseToUseProgramOrExit= ui.mainMenu();
			
			if (chooseToUseProgramOrExit==2) {
				System.out.println("Program Terminated");
				break;
			}
			int dataStructureType= ui.chooseDataStructureTypeMenu();
			IDS DS = DataStructureFactory.instantiateTheDS(dataStructureType,path);	
			String wordToSearch = ui.AskForWordMenu();
			DS.retrieve(wordToSearch.toLowerCase()).display();
		}
	}

}
