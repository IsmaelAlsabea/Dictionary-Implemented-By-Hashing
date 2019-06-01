package dataStructurePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dataStructurePackage.helperClassesPackage.DataHandler;
import dataStructurePackage.helperClassesPackage.PrimeNumberCreator;
import dataStructurePackage.nodeHandlingPackage.INode;


public abstract class theHashingDS {
	private int tableSize;
	protected DataHandler dataHandler;
	protected INode[] nodeArray;
	protected final String noSuchElementMessage= "word has no definition in System";
	protected final int elementNotFoundFlag= -3;
	theHashingDS(String path) {
		dataHandler = new DataHandler(path);
		setTableSize(dataHandler.getAllData().size());
	}
	
	public int getTableSize() {
		return tableSize;
	}

	private void setTableSize(int numberOfAllEntries) {
		PrimeNumberCreator pnc= new PrimeNumberCreator();
		/*
		 * reason for * 3 is, the loading factor should be 0.5. Therefore, hash table size
		 * should be at least double. that is why I tripled it.
		 */
		int hashMapSize = pnc.sieveOfAtkin(numberOfAllEntries * 3);
		tableSize= hashMapSize;
	}
	
	// taken from
	// (https://stackoverflow.com/questions/2624192/good-hash-function-for-strings)
	// writer is "Leif Anderson"
	protected int hashingFunction(String str) {
		long hash = 7;
		for (int i = 0; i < str.length(); i++) {
			hash = hash * 31 + str.charAt(i);
		}
		if (hash< 0)
			hash *=-1;
		return (int) (hash % tableSize);
	}
	
	protected enum DataLabeler{ WORD, TYPE, DEFINITION }

	protected List<Map <DataLabeler, String> > dataSeparator(List<String> allData) {	
		String line = null, definition = null, type = null, theWord = null;	
		List < Map<DataLabeler , String> > dataList= new ArrayList<>();
		
		for (int i = 0; i < allData.size(); i++) {
			line = allData.get(i);
			theWord = line.substring(0, line.indexOf('|'));
			line = line.replace(theWord + "|", "");
			type = line.substring(0, line.indexOf('|'));
			line = line.replace(type + "|", "");
			definition = line;	
			Map<DataLabeler,String> separatedInfo= new HashMap<DataLabeler, String>();
			
			separatedInfo.put(DataLabeler.WORD, theWord);
			separatedInfo.put(DataLabeler.TYPE, type);
			separatedInfo.put(DataLabeler.DEFINITION, definition);
			
			dataList.add(separatedInfo);
		}
		return dataList;
	}
	
	protected abstract int determineKeyOfNode(String theWord);
	
	protected abstract void populateTheDs();
	
	protected abstract void insert(INode node);
	
}
