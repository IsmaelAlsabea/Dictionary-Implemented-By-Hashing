package dataStructurePackage.nodeHandlingPackage;

import nodesPackage.RegularWordNode;

public class SimpleNodeHandler {
	
	public INode createNode(String theWord, String type, String definition) {
		INode x = new RegularWordNode(theWord, type,definition);
		return x;
	}
	
	public INode createDummyNode(String message) {
		INode x = new RegularWordNode(message, " "," ");
		return x;
	}
	
	public String retrieveWhatToHash(INode x) {
		RegularWordNode j=(RegularWordNode) x;
		 return j.theWord;
	}
	
	/*
	 * the only way for it to return the no such element message, is if the hashing leads to a null value.
	 * only then it will return the no such element message
	 */
	public String retrieveWhatToHash(INode x, String noSuchElementFound) {
		RegularWordNode j=(RegularWordNode) x;
		String str=null;
		try {
		 str=j.theWord;
		} catch(NullPointerException e) {
			str=noSuchElementFound;
		}
		return str;
	}
	
	public void setWhatToHash(INode x, String word) {
		RegularWordNode j=(RegularWordNode) x;
		j.theWord=word;
	}

	public INode[] createNodeArray(int size) {
		RegularWordNode[] x= new RegularWordNode [size];
		return x;
	}
}
