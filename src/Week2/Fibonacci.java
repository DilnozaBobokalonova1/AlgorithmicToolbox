package Week2;

import java.util.Scanner;

public class Fibonacci {

	  private static long calc_fib(int n) {
	    long Fib[] = new long[n+1];
		//if (n <=1 )
	    /*if (n == 0) {
			Fib[n] = 0;
		}
		if(n == 1) {
			Fib[0] = 0;
			Fib[n] = 1;
		}
		*/
	    Fib[0] = 0;
	    if( n >= 1 ) {
	    	Fib[1] = 1;
	    	for (int i = 2; i <= n; i++)
	    		Fib[i] = Fib[i-1] + Fib[i-2];
	    }
	    return Fib[n];
	  }

	  public static void main(String args[]) {
	//	System.out.println("Please enter an integer:");
	    Scanner in = new Scanner(System.in);
	    int n = in.nextInt();

	    System.out.println(calc_fib(n));
	  }
}


