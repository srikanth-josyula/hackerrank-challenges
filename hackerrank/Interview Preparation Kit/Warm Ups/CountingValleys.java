package com.java.hackerrank.interviewprepkit.warmups;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * An avid hiker keeps meticulous records of their hikes. During the last hike
 * that took exactly steps, for every step it was noted if it was an uphill, U,
 * or a downhill, D step. Hikes always start and end at sea level, and each step
 * up or down represents a unit change in altitude. We define the following
 * terms:
 * 
 * A mountain is a sequence of consecutive steps above sea level, starting with
 * a step up from sea level and ending with a step down to sea level. A valley
 * is a sequence of consecutive steps below sea level, starting with a step down
 * from sea level and ending with a step up to sea level. Given the sequence of
 * up and down steps during a hike, find and print the number of valleys walked
 * through.
 * 
 * Example
 * 12
 * DDUUDDUDUUUD
 * _    _      /\_
 *  \  / \    /  
 *   \/   \/\/
 * 
 * OUTPUT 2
 **/
public class CountingValleys {

	public static int countingValleys(int steps, String path) {
		// Write your code here
		int position = 0;
		int valleyCount = 0;
		boolean belowsea = false;

		for (int i = 0; i < steps; i++) {

			char step = path.charAt(i);

			if (step == 'D') {
				position--;
			} else {
				position++;
			}

			if (position >= 0) {
				belowsea = false;
			}
			if (!belowsea && position < 0) {
				valleyCount++;
				belowsea = true;
			}

		}
		return valleyCount;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int steps = Integer.parseInt(bufferedReader.readLine().trim());

		String path = bufferedReader.readLine();

		int result = countingValleys(steps, path);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
