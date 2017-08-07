package Week3;

import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        
        int size = values.length;
        double ValPerWeight[] = new double[size];
     
        for(int i = 0; i < size; i++) {
        	double one = values[i];
        	double two = weights[i];
        	ValPerWeight[i] = (((one)/(two)));
        	int c = i;
        	while(i > 0) {
        		if(ValPerWeight[i] > ValPerWeight[i-1]) { //find the max value per weight 
        			double temp = ValPerWeight[i-1];      //change the order, first is biggest i.e descending
        			int temp1 = values[i-1];
        			int temp2 = weights[i-1];
        			ValPerWeight[i-1] = ValPerWeight[i];
        			values[i-1] = values[i];
        			weights[i-1] = weights[i];
        			ValPerWeight[i] = temp;
        			values[i] = temp1;
        			weights[i] = temp2;
        		}
        		i--;
        	}
        	i = c;
        }
        for(int j = 0; j < size; j++){
        	if(capacity == 0) {
        		return value;
        	}
        	while(weights[j] > 0 && capacity != 0) {
        		double a = Math.min(weights[j],capacity);
        		value = (value + (a*(ValPerWeight[j])));
        		weights[j] = (int) (weights[j] - a);
        		capacity = (int) (capacity - a);
        	}
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.printf("%.4f",getOptimalValue(capacity, values, weights));
    }
} 
