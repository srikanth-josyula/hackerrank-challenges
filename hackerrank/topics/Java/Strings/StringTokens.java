package com.java.hackerrank.dashboard.strings;

import java.util.Scanner;

/**
 * Given a string, , matching the regular expression [A-Za-z !,?._'@]+, split
 * the string into tokens. We define a token to be one or more consecutive
 * English alphabetic letters. Then, print the number of tokens, followed by
 * each token on a new line.
 * 
 * is composed of any of the following: English alphabetic letters, blank
 * spaces, exclamation points (!), commas (,), question marks (?), periods (.),
 * underscores (_), apostrophes ('), and at symbols (@).
 **/
public class StringTokens {

   public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        s = s.trim();
        // if length is 0
        if (s.length()>400000){
            return ;
        }else if (s.length()==0 || s == null){
            System.out.println(0);
            return ;
        }else{ 

        // It seems we need to remove some spaces
        
        String[] words = s.split("[!,?.*_'@\\ ]+");

        int count = words.length;
        System.out.println(count);

        for (String word : words)
            System.out.println(word);
        }
        scan.close();
    }
}
