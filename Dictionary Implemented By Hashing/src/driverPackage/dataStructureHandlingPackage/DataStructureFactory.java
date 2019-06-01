package driverPackage.dataStructureHandlingPackage;

import dataStructurePackage.DoubleHashing;
import dataStructurePackage.LinearProbing;
import dataStructurePackage.QuadraticProbing;
import dataStructurePackage.SeparateChaining;

public class DataStructureFactory {
	
	public DataStructureFactory() {}
	
	public static IDS instantiateTheDS (int type, String path) {
		
		IDS ds= null;
		
		switch (type) {	
			case 1:
				ds = new LinearProbing(path);
				break;
			case 2:
				ds = new QuadraticProbing(path);
				break;
			case 3:
				ds = new DoubleHashing(path);
				break;
			case 4:
				ds = new SeparateChaining(path);
				break;
			default:
				System.out.println("problem with choosing the collision method");
				return null;
		}
		return ds;
		
	}

}
