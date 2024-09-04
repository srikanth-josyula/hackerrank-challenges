import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       try{
       Scanner s = new Scanner(System.in);
       int x = s.nextInt();
       int y = s.nextInt();
            int z = x / y;
            System.out.println(z);
      } catch (InputMismatchException e) {
            System.out.println(e.getClass().getName());
        } catch (ArithmeticException e) {
            System.out.println(e.getClass().getName() + ": / by zero");
        }
    }
    
}
