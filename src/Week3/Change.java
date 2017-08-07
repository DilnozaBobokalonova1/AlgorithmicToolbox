package Week3;

import java.util.Scanner;

	public class Change {
	    private static int getChange(int m) {
	        int counter = 0;
	        int Arr[] = new int [3];
	        Arr[0] = 10;
	        Arr[1] = 5;
	        Arr[2] = 1;
	        for(int i = 0; i < 3; i++) {
	        	while(m >= Arr[i]) {
	        		m = m - Arr[i];
	        		counter++;
	        	}
	        }
	        
	        return counter;
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int m = scanner.nextInt();
	        System.out.println(getChange(m));

	    }
	}
