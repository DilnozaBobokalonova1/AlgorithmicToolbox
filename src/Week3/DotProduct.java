package Week3;
import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        //write your code here
        long result = 0;
        
        for(int j = 1; j < a.length; j++) {
        	int size = j;
        	while(j > 0) {
        		if(a[j] > a[j-1]) {
        			int temp = a[j-1];
        			a[j-1] = a[j];
        			a[j] = temp;
        		}
        		if(b[j] > b[j-1]) {
        			int temp = b[j-1];
        			b[j-1] = b[j];
        			b[j] = temp;
        		}
        	j--;
        	}
        	j = size;
        	
        }
        for (int i = 0; i < a.length; i++) {
        	long ans1 = a[i];
        	long ans2 = b[i];
            result += (ans1 * ans2);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

