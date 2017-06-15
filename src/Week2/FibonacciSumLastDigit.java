package Week2;

import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum;
    }
    private static long getFibonacciHugePisano(long n, long m) {
	    if (n <= 1)
	        return n;

	    long beforePrevious  = 0;
	    long previous = 1;
	    long a = -1;
	    long current = -1;

	    for (long i = 2; i <= n; i++) {
	        current = (beforePrevious + previous) % m;

	        if (a == 0 && current == 1) {
	            long period = (i + 1) - 2;
	            long reductionN = n % period;
	            return getFibonacciHugePisano(reductionN, m);

	        }
	        else {
	            a = current;
	            beforePrevious = previous;
	            previous = current;
	        }
	    }

	    return current;
	}
   /* private static long getFibonacciSumIntelligent(long n) {
    	if(n <= 1) {
    		return n;
    	}
    	long num1 = getFibonacciHugePisano(n,10);
    	long Fib[] = new long[(int)num1+1];
    	if(num1 <=1) {
    		return num1;
    	}
    	
    	Fib[0] = 0;
    	Fib[1] = 1;
    	//long sum = 1;
    	long theSumArray[] = new long[(int)num1+1];
    	theSumArray[0] = 0;
    	theSumArray[1] = 1;
    	for(int i = 2; i <= num1; i++) {
    		Fib[i] = (Fib[i-1] + Fib[i-2]) % 10;
    		theSumArray[i] +=(theSumArray[i-1]+Fib[i]) % 10;
    	}
    	return theSumArray[(int)num1] % 10;
    }
    */
    private static long getFibonacciSumIntelligent(long n) {
    	if(n <= 1) {
    		return n;
    	}
    	long m = n % 60;
    	if(m <= 1) {
    		return m;
    	}
    	long Fib[] = new long[(int)m+1];
    	
    	Fib[0] = 0;
    	Fib[1] = 1;
    	//long sum = 1;
    	long theSumArray[] = new long[(int)m+1];
    	//long theSum = 0;
    	theSumArray[0] = 0;
    	theSumArray[1] = 1;
    	for(int i = 2; i <= m; i++) {
    		Fib[i] = (Fib[i-1] + Fib[i-2]);
    		//theSum =(Fib[i-1]+Fib[i]);
    		theSumArray[i] +=(theSumArray[i-1]+Fib[i]);
    	}
    	return (theSumArray[(int)m] % 10);
    	//return (Fib[(int)m] % 10 -1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumIntelligent(n);
        System.out.println(s);
      //  System.out.println(getFibonacciSumNaive(10));
    }
}


