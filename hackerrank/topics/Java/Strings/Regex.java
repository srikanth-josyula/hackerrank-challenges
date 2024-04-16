package com.java.hackerrank.dashboard.strings;

import java.util.Scanner;

/**
 * Write a class called MyRegex which will contain a string pattern. You need to
 * write a regular expression and assign it to the pattern such that it can be
 * used to validate an IP address. Use the following definition of an IP
 * address:
 * 
 * IP address is a string in the form "A.B.C.D", where the value of A, B, C, and
 * D may range from 0 to 255 Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
 * 
 * \d represents digits in regular expressions, same as [0-9]
 * \\d{1, 2} catches any one or two-digit number
 * (0|1)\\d{2} catches any three-digit number starting with 0 or 1.
 * 2[0-4]\\d catches numbers between 200 and 249.
 * 25[0-5] catches numbers between 250 and 255.
 * 
 * Match the string with the Regex. In Java, this can be done using Pattern.matcher().
 * Return true if the string matches with the given regex, else return false.
 **/

public class Regex{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            new MyRegex();
			System.out.println(IP.matches(MyRegex.pattern));
        }
        in.close();

    }
}
class MyRegex {
    static String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
    public static String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;

}
