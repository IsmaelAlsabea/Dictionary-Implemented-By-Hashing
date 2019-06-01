package userInterfacePackage;

import java.util.InputMismatchException;
import java.util.Scanner;

class InputReader {

	Scanner reader;
	protected InputReader(){
		/*
		 * You should never close a scanner with a system.in.
		 * https://dzone.com/articles/if-youre-using-javas-scanner-class-for-keyboard-in
		 */
		reader= new Scanner (System.in);
	}
	
	protected String readALineFromKeyboard() {
		String str = "";
		
		while (true) {
			str = reader.nextLine();
			if (!str.equals(""))
				break;
		}
		return str;
	}

	protected int readAnInt() {
		int x = -1;
		
		while (true) {
			try {
			x = reader.nextInt();
			if (x != -1)
				break;
			} catch(InputMismatchException e){
				System.out.println("Please input a number between 1 and 4");
				reader.nextLine();
			} catch (Exception e) {
				e.toString();
				System.out.println("Unhandled problem");
			}
		}
		return x;
	}

}
