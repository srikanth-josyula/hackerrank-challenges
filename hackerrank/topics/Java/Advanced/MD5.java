package com.java.hackerrank.dashboard.advance;

import java.security.MessageDigest;
import java.util.Scanner;

/**
 * MD5 (Message-Digest algorithm 5) is a widely-used cryptographic hash function
 * with a -bit hash value. Here are some common uses for MD5:
 * 
 * To store a one-way hash of a password. To provide some assurance that a
 * transferred file has arrived intact. MD5 is one in a series of message digest
 * algorithms designed by Professor Ronald Rivest of MIT (Rivest, 1994);
 * however, the security of MD5 has been severely compromised, most infamously
 * by the Flame malware in 2012. The CMU Software Engineering Institute
 * essentially considers MD5 to be "cryptographically broken and unsuitable for
 * further use".
 * 
 * Given an alphanumeric string, , denoting a password, compute and print its
 * MD5 encryption value.
 * 
 * Sample Input 0
 * HelloWorld 
 * 
 * Sample Output 0
 * 68e109f0f40ca72a15e05cc22786f8e6
 **/
public class MD5 {
	private static String convertByteToHex(byte[] byteData) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			System.out.println(convertByteToHex(md.digest(word.getBytes())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
