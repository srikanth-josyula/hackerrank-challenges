package com.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

		//int[][] grid = { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } };

		int[][] grid = { { 3, 1, 2, 2 }, { 1, 4, 4, 5 }, { 2, 4, 2, 2 }, { 2, 4, 2, 2 } };

		//int[][] grid = { { 3, 1, 2, 2 }, { 1, 4, 4, 4 }, { 2, 4, 2, 2 }, { 2, 5, 2, 2 } };

		System.out.println(equalPairs(grid));
	}

	public static int equalPairs(int[][] grid) {

		int counter = 0;

		//Took 18ms => Suggestion DONT USE CREATE LIST or OBJECTS INSIDE LOOPS
		List<int[]> colList = new ArrayList<>();
		List<int[]> rowList = new ArrayList<>();
		
		for (int rows = 0; rows < grid.length; rows++) {
			int[] colArry = new int[grid[rows].length];
			for (int columns = 0; columns < grid[rows].length; columns++) {
				colArry[columns] = (grid[columns][rows]);
			}
			colList.add(colArry);
		}

		for (int[] row : grid) {
			rowList.add(row);
		}

		for(int[] row: rowList) {
			for(int[] col: colList) {
				//System.out.println(Arrays.toString(row)+" is equal to "+Arrays.toString(col) +" are "+Arrays.equals(row, col));
				if(Arrays.equals(row, col)) {
					counter++;
				}
			}
			
		}
		
		// Took 132 ms
		/*List<List<Integer>> rowList = new ArrayList<>();
		List<List<Integer>> colList = new ArrayList<>();
		for (int rows = 0; rows < grid.length; rows++) {
			List<Integer> rowListInternal = new ArrayList<>();
			List<Integer> colListInternal = new ArrayList<>();
			for (int columns = 0; columns < grid[rows].length; columns++) {
				rowListInternal.add(grid[rows][columns]);
				colListInternal.add(grid[columns][rows]);
				
			}
		     rowList.add(rowListInternal);
			 colList.add(colListInternal);
		}
		
		System.out.println(rowList);
		System.out.println(colList);
		
		
		for(List<Integer> row: rowList) {
			for(List<Integer> col: colList) {
				if(row.equals(col)) {
					//System.out.println("Row "+row+" is same as Column "+col);
					counter++;
				}
			}
		}*/
		
		return counter;
	}
}
