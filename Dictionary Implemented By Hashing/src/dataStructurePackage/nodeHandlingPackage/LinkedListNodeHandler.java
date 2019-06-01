/**
 * 
 */
package dataStructurePackage.nodeHandlingPackage;

import nodesPackage.LinkedListWordNode;

public class LinkedListNodeHandler {

	public INode createNode(String theWord, String type, String definition) {
		INode x = new LinkedListWordNode(theWord, type,definition);
		return x;
	}
	
	public INode createDummyNode(String message) {
		INode x = new LinkedListWordNode(message, " "," ");
		return x;
	}

	public String retrieveWhatToHash(INode x) {
		LinkedListWordNode j= (LinkedListWordNode) x;
		return j.theWord;
	}
	
	/*
	 * the only way for it to return the no such element message, is if the hashing leads to a null value.
	 * only then it will return the no such element message
	 */
	public String retrieveWhatToHash(INode x, String noSuchElementFound) {
		LinkedListWordNode j=(LinkedListWordNode) x;
		String str=null;
		try {
		 str=j.theWord;
		} catch(NullPointerException e) {
			str=noSuchElementFound;
		}
		return str;
	}
	
	public void setWhatToHash(INode x, String word) {
		LinkedListWordNode j=(LinkedListWordNode) x;
		j.theWord=word;
	}
	
	public INode[] createNodeArray(int size) {
		LinkedListWordNode[] x= new LinkedListWordNode[size];
		return x;
	}

	public LinkedListWordNode getNext(INode x) {
		LinkedListWordNode j= (LinkedListWordNode) x;
		return j.next;
	}

	public void setNext(INode x, INode newNode) {
		LinkedListWordNode j= (LinkedListWordNode) x;
		j.next= (LinkedListWordNode) newNode;
	}
	
}
