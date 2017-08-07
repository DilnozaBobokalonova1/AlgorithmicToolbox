package Week3;

import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        boolean endReached = false;
        int k = n;
        int l = 1;
        while(!endReached) {
        	if(!(k <= 2 * l)) {
        		k -= l;
        		summands.add(l);
        		l++;
        	} else {
        		summands.add(k);
        		endReached = true;
        	}
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

