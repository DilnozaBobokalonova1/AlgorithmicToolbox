package Week3;

import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        
        int maxDigit = Integer.parseInt(a[0]);
        maxDigit = maxDigit(maxDigit);
        int size = 0;
        for(int i = 0; i < a.length; i++) {
        	size+= a[i].length();
        }
      
        int numOfInts = a.length;
        while(size > 0){
        	int index = 0;
        	maxDigit = Integer.parseInt(a[0]);
        	maxDigit = maxDigit(maxDigit);
        	for(int i = 1; i < numOfInts && !(a[i].isEmpty()); i++) {
        		
        		int anotherDigit = Integer.parseInt(a[i]);
        		if(maxDigit <= maxDigit(anotherDigit)) {
        			maxDigit = maxDigit(anotherDigit);
        			index = i;
        		}
        	}
        	
        	result = result + "" + maxDigit;
        	outerloop:
        	
        		
        		for(int j = 0; j < a[index].length(); j++) {
        			String charDigit = Character.toString(a[index].charAt(j));
        			
        			if(Integer.parseInt(charDigit) == maxDigit) {
        				a[index] = a[index].replace(a[index].charAt(j), ' ');
        				a[index] = a[index].replaceAll("\\s","");
        				break outerloop;
        			}
        		}
        		if(a[index].isEmpty()) { 
        			for(int i = index; i < a.length - 1; i++) {
        				a[i] = a[i+1];
        			}
        			
        		}
        	
        	size--;
        }
      
        return result;
    }
 
    public static int maxDigit(int digit) {
    	String theMax = Integer.toString(digit);
    	int[] theDigits = new int[theMax.length()]; //the array length will be the length of the string of the integer
    	digit = theMax.charAt(0) - '0';
    	for(int i = 0; i < theMax.length(); i++) {
    		theDigits[i] = theMax.charAt(i) - '0'; //turning the char to int
    		if(digit < theDigits[i]) {
    			digit = theDigits[i];
    		}
    	}
    	return digit;
    }
    public static boolean isGreaterThanOrEqual(int digit, int maxDigit) {
    	boolean isGreaterThanOrEqual = false;
    	String theMax = Integer.toString(maxDigit);
    	int[] theDigits = new int[theMax.length()]; //the array length will be the length of the string of the integer
    	for(int i = 0; i < theMax.length(); i++) {
    		theDigits[i] = theMax.charAt(i) - '0'; //turning the char to int
    		if(digit >= theDigits[i]) {
    			isGreaterThanOrEqual = true;
    		}
    	}
     	return isGreaterThanOrEqual;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

