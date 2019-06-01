package dataStructurePackage;


import java.util.List;
import java.util.Map;

import dataStructurePackage.nodeHandlingPackage.INode;
import dataStructurePackage.nodeHandlingPackage.SimpleNodeHandler;
import driverPackage.dataStructureHandlingPackage.IDS;


public class LinearProbing extends theHashingDS implements IDS {
	
	SimpleNodeHandler nodeHandler;

	public LinearProbing(String path) {
		super(path);
		nodeHandler= new SimpleNodeHandler();
		nodeArray = nodeHandler.createNodeArray(getTableSize());
		populateTheDs();
	}

	@Override
	protected void insert(INode x) {
		
		int key = hashingFunction(nodeHandler.retrieveWhatToHash(x));
		while (true) {
			if (nodeArray[key] == null) {
				nodeArray[key] = x;
		//		System.out.println("Found null Position");
				break;
			}  else {
		//		System.out.println("collision happened at position " + key + " trying the next position ");
				key = (key + 1) % getTableSize();
			}
		}
	}

	@Override
	public INode retrieve(String theWord) {
		
		int key= determineKeyOfNode(theWord);
		if (key==elementNotFoundFlag) {
			INode node= nodeHandler.createDummyNode(noSuchElementMessage);
			return node;
		}
		
		return nodeArray[key];
	}

	protected int determineKeyOfNode(String theWord) {
		
		int key = hashingFunction(theWord);
		String matchingStringFromArray=null;
		for (int i=0; i< nodeArray.length;i++) {
			
			matchingStringFromArray=nodeHandler.retrieveWhatToHash(nodeArray[key], noSuchElementMessage);
			
			if (matchingStringFromArray.equals(noSuchElementMessage))
				break;
			
			if (matchingStringFromArray.equals(theWord))
				return key;
			
			key = (key + 1) % getTableSize();
		}
		/*
		 * if we are here then, the node was not in the array 
		 */
		
		return elementNotFoundFlag;
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