package nodesPackage;

import dataStructurePackage.nodeHandlingPackage.INode;

/**
 * class is made to avoid special case logic.
 */
public class RegularWordNode extends BaseWordNode implements INode {

	public RegularWordNode(String theWord, String type, String definition) {
		super(theWord, type, definition);
	}
}

