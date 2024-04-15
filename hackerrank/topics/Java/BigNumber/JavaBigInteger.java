import java.math.BigInteger;
import java.util.Scanner;
/**
* Use the power of Java's BigInteger class and solve this problem.
* a and b are non-negative integers and can have maximum  digits. a+b and a*b
**/
  
public class JavaBigInteger {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);  
        String a = s.next();  
        String b = s.next();  
        
        BigInteger A  = new BigInteger(a);
        BigInteger B  = new BigInteger(b); 
        
        System.out.println(A.add(B));  
        System.out.println(A.multiply(B));  
        s.close();
    }
}
