package driverPackage;

import driverPackage.dataStructureHandlingPackage.DataStructureFactory;
import driverPackage.dataStructureHandlingPackage.IDS;
import driverPackage.userInterfaceHandlingPackage.IUserInterface;
import driverPackage.userInterfaceHandlingPackage.UserInterfaceFactory;

public class Main {

	public static void main(String args[]) {
		String path= "dictionary.txt";
		
		IUserInterface ui= UserInterfaceFactory.createUserInterface();
		IDS DS = DataStructureFactory.instantiateTheDS(ui.chooseDataStructureTypeMenu(),path);	
		String wordToSearch = ui.AskForWordMenu();
		DS.retrieve(wordToSearch.toLowerCase()).display();
	}

}
