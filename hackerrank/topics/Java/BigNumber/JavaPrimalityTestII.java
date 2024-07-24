/**
 * A prime number is a natural number greater than 1 whose only positive
 * divisors are 1 and itself. For example, the first six prime numbers are
 * 2,3,5,7,11, and 13. Given a large integer, , use the Java BigInteger class'
 * isProbablePrime method to determine and print whether it's prime or not
 * prime.
 * 
 * Input Format A single line containing an integer, n (the number to be
 * checked). Constraints: n contains at most 100 digits.
 * 
 * Output Format If n is a prime number, print prime; otherwise, print not
 * prime.
 * 
 **/
public class Solution {
   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        in.close();
        if (n.isProbablePrime(1)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }
}
