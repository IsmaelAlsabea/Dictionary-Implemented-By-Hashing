package dataStructurePackage;

import java.util.List;
import java.util.Map;

import dataStructurePackage.nodeHandlingPackage.INode;
import dataStructurePackage.nodeHandlingPackage.SimpleNodeHandler;
import driverPackage.dataStructureHandlingPackage.IDS;

public class DoubleHashing extends theHashingDS implements IDS {

	SimpleNodeHandler nodeHandler;
	
	public DoubleHashing(String path) {
		super(path);
		nodeHandler= new SimpleNodeHandler();
		nodeArray = nodeHandler.createNodeArray(getTableSize());
		populateTheDs();
	}
	
	@Override
	protected void insert(INode x) {
		
		int key = hashingFunction(nodeHandler.retrieveWhatToHash(x));
		if (nodeArray[key] == null) {
			nodeArray[key] = x;
	//		System.out.println("Found null Position");
			return;
		}
	//	System.out.println("collision happened at position " + key + " trying the next position ");
		key = hashingFunction2(nodeHandler.retrieveWhatToHash(x));
		if (nodeArray[key] == null) {
			nodeArray[key] = x;
	//		System.out.println("Found null Position on the second hash");
			return;
		}
		// if both first and second hash functions made a collision, then probe.
		while (true) {
			if (nodeArray[++key] == null)
				nodeArray[key] = x;
			return;
		}
	}

	@Override
	public INode retrieve(String theWord) {
		
		return nodeArray[determineKeyOfNode(theWord)];
	}

	protected int determineKeyOfNode(String theWord) {
		
		int key = hashingFunction(theWord);
		String matchingStringFromHashing1=null;
		
		matchingStringFromHashing1=nodeHandler.retrieveWhatToHash(nodeArray[key], noSuchElementMessage);
				
		if (matchingStringFromHashing1.equals(noSuchElementMessage))
			return elementNotFoundFlag;
		
		if (matchingStringFromHashing1.equals(theWord))
			return key;
		
		
		int key2= hashingFunction2(theWord);
		
		String matchingStringFromHashing2 =null;
		
		matchingStringFromHashing2= nodeHandler.retrieveWhatToHash(nodeArray[key2], noSuchElementMessage);
	
		if (matchingStringFromHashing2.equals(noSuchElementMessage))
			return elementNotFoundFlag;
		
		if (matchingStringFromHashing2.equals(theWord))
			return key2;
		
		/*
		 * if first hash function and second hash function resulted in collision, then we have to probe to find the node.
		 */
		int keyForProbing=key;
		String matchingStringFromProbing = null;
		
		for (int i=0;i< nodeArray.length;i++) {
			
			matchingStringFromProbing=nodeHandler.retrieveWhatToHash(nodeArray[keyForProbing], noSuchElementMessage);
			
			if (matchingStringFromProbing.equals(noSuchElementMessage))
				break;
					
			if (matchingStringFromProbing.equals(theWord))
				return keyForProbing;	
			
			keyForProbing = (keyForProbing + 1) % getTableSize();
		}
		
		/*
		 * if we are here then, the node was not in the array 
		 */
		return elementNotFoundFlag;
	}
	
	/*
	 * taken from the site below
	 * https://github.com/ArashPartow/hash/blob/master/GeneralHashFunctions_-_Java/GeneralHashFunctionLibrary.java
	 *  writer Arash Partow
	 */
	private int hashingFunction2(String str) { // DJBHASH
		long hash = 5381;
		for (int i = 0; i < str.length(); i++) {
			hash = ((hash << 5) + hash) + str.charAt(i);
		}
		if (hash < 0)
			hash *= -1;
		hash = hash % getTableSize();
		return (int) hash;
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
