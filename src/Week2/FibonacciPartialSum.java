package Week2;

import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        if (to <= 1)
            return to;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < from - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        long sum = current;

        for (long i = 0; i < to - from; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
    
    private static long calc_fib(long n) {
    	long Fib[] = new long[(int)n+1];
 	
 	    Fib[0] = 0;
 	    if( n >= 1 ) {
 	    	Fib[1] = 1;
 	    	for (int i = 2; i <= n; i++)
 	    		Fib[i] = Fib[i-1] + Fib[i-2];
 	    }
 	    return Fib[(int) n];
    }
    private static long getFibonacciPartialSumIntelligent(long from, long to) {
    	if(to <= 1) {
    		return to;
    	}
    	long from1 = from % 60;
    	long to1 = to % 60;
    	if(to1 <= 1) {
    		return to1;
    	}
    	if((to1 - from1) < 1) {
    		return calc_fib(to1) % 10;
    	}
    	long FibToFrom[] = new long[(int)(to1 - from1) + 1];
    	long FibFrom = calc_fib(from1);
    	long FibFromPrevious = calc_fib(from1 - 1);
    	long theSumArray[] = new long[(int)(to1 - from1) + 1];
    	FibToFrom[0] = FibFrom;
    	FibToFrom[1] = FibFrom + FibFromPrevious;
    	theSumArray[0] = FibToFrom[0];
    	theSumArray[1] = FibToFrom[1] + FibToFrom [0];
    	for(int i = 2; i <= (to1-from1); i++) {
    		FibToFrom[i] = (FibToFrom[i-1] + FibToFrom[i-2]);
    		theSumArray[i] +=(theSumArray[i-1]+FibToFrom[i]);
    	}
    	return (theSumArray[(int)(to1 - from1)] % 10);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumIntelligent(from, to));
    }
}

