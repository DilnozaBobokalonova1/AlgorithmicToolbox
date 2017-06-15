package Week2;

import java.math.BigInteger;
import java.util.*;

public class FibonacciHuge {
    /*private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }
    */
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
	/*
    private static long calc_fib(long n) {
    	int length = (int)(n+1);
	    long Fib[] = new long[length];
	    Fib[0] = 0;
	  
	    if( n >= 1 ) {
	    	Fib[1] = 1;
	    	for (int i = 2; i <= n; i++)
	    		
	    		Fib[i] = Fib[i-1] + (Fib[i-2]);
	    }
	    return Fib[(int) n];
	  }

    private static long getFibonacciHugeSmart(long n, long m, long period) {
    	if(n <= 1) {
    		return n;
    	}
    	
    	//long remainder = (n % period);
    	//BigInteger bd = new BigInteger("0");
    	//long bd = ((calc_fib(remainder)).remainder(BigInteger.valueOf(m))).longValue();
    	//long rem = remainder % m;
    	//BigInteger m1 = BigInteger.valueOf(m);
    		
    		long remainder = (n % period);
    		long sec = calc_fib(remainder) % m;
    		
    		//return getFibonacciHugeSmart(remainder, m, period);
    		return sec;
    	
   
    }
    private static long getPisanoPeriod(long m) {
    	long a = 0;
    	long b = 1;
    	long c = a+b;
    	for(long i = 0; i < (m*m); i++) {
    		c = (a+b) % m;
    		a = b;
    		b = c;
    		if((a == 0) && (b == 1)) {
    			long ans = i+1;
    			return ans;
    		}
    	}
    	return 0;
    }
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
    	//long period = getPisanoPeriod(m);
        System.out.println(getFibonacciHugePisano(n, m));
    }
}
/*
 * 
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }
    
    private static BigInteger calc_fib(int n) {
    	int length = (int) (n+1);
	    BigInteger[] Fib = new BigInteger[length];
	    Fib[0] = BigInteger.ZERO;
	  
	    if( n >= 1 ) {
	    	Fib[1] = BigInteger.ONE;
	    	for (int i = 2; i <= n; i++)
	    		
	    		Fib[i] = Fib[i-1].add(Fib[i-2]);
	    }
	    return Fib[n];
	  }

    private static BigInteger getFibonacciHugeSmart(long n, long m) {
    	long period = getPisanoPeriod(m);
    	int remainder = (int) (n % period);
    	BigInteger bd = new BigInteger("0");
    	bd = calc_fib(remainder);
    	
    	BigInteger m1 = BigInteger.valueOf(m);
    	
    	return bd.remainder(m1);
    }
    
    private static long getPisanoPeriod(long m) {
    	long a = 0;
    	long b = 1;
    	long c = a+b;
    	for(long i = 0; i < (m*m); i++) {
    		c = (a+b) % m;
    		a = b;
    		b = c;
    		if((a == 0) && (b == 1)) {
    			long ans = i+1;
    			return ans;
    		}
    	}
    	return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeSmart(n,m));
    }
}
*/
