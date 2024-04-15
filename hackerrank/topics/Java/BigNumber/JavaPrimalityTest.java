package com.java.hackerrank.dashboard.bignumber;

import java.util.Scanner;

public class PrimalityTest {

	   public static void main(String[] args) {  
	       Scanner s = new Scanner(System.in);  
	       System.out.print("Enter a number : ");  
	       int n = s.nextInt();  
	       if (isPrime(n)) {  
	           System.out.println("prime");  
	       } else {  
	           System.out.println("not prime");  
	       }  
	       s.close();
	   }  
	  
	   public static boolean isPrime(int n) {  
	       if (n <= 1) {  
	           return false;  
	       }  
	       for (int i = 2; i < Math.sqrt(n); i++) {  
	           if (n % i == 0) {  
	               return false;  
	           }  
	       }  
	       return true;  
	   } 
}
