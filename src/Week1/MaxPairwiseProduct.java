package Week1;
	import java.util.*;
	import java.io.*;
	import java.lang.Long;
	public class MaxPairwiseProduct {
	    static long getMaxPairwiseProduct(int[] numbers) {
	        //long result = 0;
	        int n = numbers.length;
	        int max1 = -1;
	        for(int i = 0; i < n; i++) {
	        	if((max1 == -1) || (numbers[i] > numbers[max1])) {
	        	max1 = i;
	        	}
	        }
	        int max2 = -1;
	        for(int j = 0; j < n; j++) {
	        	if((numbers[j] != numbers[max1]) && ((max2 == -1) || (numbers[j] > numbers[max2]))) {
	        	max2 = j;
	        	}
	        }
	        /*for (int i = 0; i < n; ++i) {
	            for (int j = i + 1; j < n; ++j) {
	                if (numbers[i] * numbers[j] > result) {
	                    result = numbers[i] * numbers[j];
	                }
	            }
	        }*/
	        //result = numbers[max1] * numbers[max2];
	        long n1 = Long.valueOf(numbers[max1]);
	        long n2 = Long.valueOf(numbers[max2]);
	        //return (Long.valueOf((numbers[max1] * numbers[max2])));
	        return (n1*n2);
	    }
	    
	    static long getMaxPairwiseProductSlow(int[] numbers) {
	        long result = 0;
	        int n = numbers.length;
	        for (int i = 0; i < n; ++i) {
	            for (int j = i + 1; j < n; ++j) {
	                if (((long)numbers[i] * (long)numbers[j]) > result) {
	                    result = (long)numbers[i] * (long)numbers[j];
	                }
	            }
	        }
	        return result;
	    }

	    public static void main(String[] args) {
	        FastScanner scanner = new FastScanner(System.in);
	        int n = scanner.nextInt();
	        int[] numbers = new int[n];
	        for (int i = 0; i < n; i++) {
	            numbers[i] = scanner.nextInt();
	        }
	        System.out.println(getMaxPairwiseProduct(numbers));
	        System.out.println(getMaxPairwiseProductSlow(numbers));
	        //int[] numbers1 = {100000, 90000};
	        //System.out.println(getMaxPairwiseProduct(numbers1));
	    }

	    static class FastScanner {
	        BufferedReader br;
	        StringTokenizer st;

	        FastScanner(InputStream stream) {
	            try {
	                br = new BufferedReader(new InputStreamReader(stream));
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        String next() {
	            while (st == null || !st.hasMoreTokens()) {
	                try {
	                    st = new StringTokenizer(br.readLine());
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            return st.nextToken();
	        }

	        int nextInt() {
	            return Integer.parseInt(next());
	        }
	    }

	}