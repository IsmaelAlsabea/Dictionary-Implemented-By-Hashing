package dataStructurePackage;
import java.util.List;
import java.util.Map;

import dataStructurePackage.nodeHandlingPackage.INode;
import dataStructurePackage.nodeHandlingPackage.LinkedListNodeHandler;
import driverPackage.dataStructureHandlingPackage.IDS;


public class SeparateChaining extends theHashingDS implements IDS{
	
	LinkedListNodeHandler nodeHandler;
	
	public SeparateChaining(String path) {
		super(path);
		nodeHandler= new LinkedListNodeHandler();
		nodeArray = nodeHandler.createNodeArray(getTableSize());
		populateTheDs();
	}
	
	@Override
	protected void insert(INode x) {
		
			int key= hashingFunction(nodeHandler.retrieveWhatToHash(x));
			if (nodeArray[key]==null)
			{
	//			System.out.println("found null node");
				nodeArray[key]= x;
			}
			else
				{
	//			System.out.println("collision happened at position "+key+" trying the next position ");
				/*
				 * when there is a node that the key is pointing to in the array, let us call the node X 
				 * insert the new node where X was first and put X as the next node in the new node's linkedList, 
				 * (since every node is a linked list) doing this will save time from iterating over X
				 */
				INode temp= nodeArray[key];
				nodeArray[key]= x;
				nodeHandler.setNext(x, temp);
				}
	}
	
	@Override
	public INode retrieve(String theWord) {
		int key= determineKeyOfNode(theWord);
		INode node= nodeArray[key];	
		String matchingStringFromArray=null;
		//worst case (all nodes are saved as a linked list in one slot in the data structure array)
		for (int i=0; i< nodeArray.length;i++){ 
			matchingStringFromArray=nodeHandler.retrieveWhatToHash(node, noSuchElementMessage);
			if (matchingStringFromArray.equals(theWord))
				return node;
			if (matchingStringFromArray.equals(noSuchElementMessage))
				break;
			node=nodeHandler.getNext(node);
		}
		INode dummyNode= nodeHandler.createDummyNode(noSuchElementMessage);
		return dummyNode;
	}
	
	@Override
	protected int determineKeyOfNode(String theWord) {
		return hashingFunction(theWord);
	}

	@Override
	protected void populateTheDs() {
		List<Map<DataLabeler, String>> separatedData= dataSeparator(dataHandler.getAllData());
		
		for (int i=0; i< separatedData.size();i++) {
		INode x= nodeHandler.createNode(separatedData.get(i).get(DataLabeler.WORD),
					separatedData.get(i).get(DataLabeler.TYPE),separatedData.get(i).get(DataLabeler.DEFINITION));
		insert(x);
		}
	}

}
