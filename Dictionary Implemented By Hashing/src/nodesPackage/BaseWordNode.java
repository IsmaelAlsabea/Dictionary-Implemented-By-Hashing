package nodesPackage;



public class BaseWordNode {
	
	public String theWord= null;
	public String type= null;
	public String definition= null;

public BaseWordNode(String theWord, String type, String definition) {
		this.theWord = theWord;
		this.type = type;
		this.definition = definition;
	}

	public void display() {
		System.out.println(theWord + "\n" + type + " \n" + definition + "\n");
	}
	
}
