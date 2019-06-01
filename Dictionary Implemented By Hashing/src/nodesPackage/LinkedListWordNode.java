package nodesPackage;

import dataStructurePackage.nodeHandlingPackage.INode;

public class LinkedListWordNode extends BaseWordNode implements INode { //used with separate chaining method
		public LinkedListWordNode next;
		
		public LinkedListWordNode(String theWord, String type, String definition) {
			super(theWord, type, definition);
		}

	}

