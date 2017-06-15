
package Week2;

import java.util.*;

public class LCM{
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }
  private static long gcd_smart(int a, int b) {
	 //ong current_gcd = 1;
	  if(b == 0) {
		  return a;
	  }
	  int a_2 = a % b;
	  return gcd_smart(b, a_2);
  }
  private static long lcm_smart(int a, int b) {
	  long gcd = gcd_smart(a,b);
	  long multiple1 = a/gcd_smart(a,b);
	  long result = multiple1*b;
	  return result;
	
  }
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_smart(a, b));
  }
}

