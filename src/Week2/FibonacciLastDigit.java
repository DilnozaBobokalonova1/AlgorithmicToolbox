package Week2;
import java.util.*;
public class FibonacciLastDigit {
	private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }
    private static int getFibonacciLastDigitSmart(int n) {
    	int Fib[] = new int[n+1];
    	if (n <= 1) {
    		return n;
    	}
    	Fib[0] = 0;
    	Fib[1] = 1;
    	for(int i = 2; i <= n; i++) {
    		Fib[i] = (Fib[i-1] + Fib[i-2]) % 10;
    	}
    	return Fib[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitSmart(n);
        System.out.println(c);
    }

}
