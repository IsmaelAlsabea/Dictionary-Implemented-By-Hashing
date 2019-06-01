package dataStructurePackage.helperClassesPackage;

import java.util.Arrays;


/*
taken from geeks for geeks website
*/
public class PrimeNumberCreator {
	
	public int sieveOfAtkin (int limit) {
	
		boolean sieve[]= new boolean[limit]; 
		int n=0;
		
		Arrays.fill(sieve, false);
	  
	    /* Mark siev[n] is true if one  
	       of the following is true: 
	    a) n = (4*x*x)+(y*y) has odd number of  
	       solutions, i.e., there exist 
	       odd number of distinct pairs (x, y)  
	       that satisfy the equation and 
	        n % 12 = 1 or n % 12 = 5. 
	    b) n = (3*x*x)+(y*y) has odd number of  
	       solutions and n % 12 = 7 
	    c) n = (3*x*x)-(y*y) has odd number of  
	       solutions, x > y and n % 12 = 11 */
	    for (int x = 1; x * x < limit; x++) { 
	        for (int y = 1; y * y < limit; y++) { 
	              
	            // Main part of Sieve of Atkin 
	             n = (4 * x * x) + (y * y); 
	            if (n <= limit && (n % 12 == 1 || n % 12 == 5)) 
	                sieve[n] ^= true; 
	            
	            n = (3 * x * x) + (y * y); 
	            if (n <= limit && n % 12 == 7) 
	                sieve[n] ^= true; 
	            
	            n = (3 * x * x) - (y * y); 
	            if (x > y && n <= limit && n % 12 == 11) 
	                sieve[n] ^= true; 
	        } 
	    } 
	    
	 // Mark all multiples of squares as non-prime 
	    for (int r = 5; r * r < limit; r++) { 
	        if (sieve[r]) { 
	            for (int i = r * r; i < limit; i += r * r) 
	                sieve[i] = false; 
	        } 
	    } 
	    
	    for (int i=limit-1; i>limit/2; i--) 
	    	if (sieve[i]==true)
	    		return i;
	    
	    return limit;
	}	
	
}
