package com.testing;

public class Solution {

	public static void main(String[] args) {

		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

		System.out.println(maxArea(height));
	}

	public static int maxArea(int[] height) {
		int area = 0;

		//If you simulate the problem, it will be O(n^2) which is not efficient.
		/*for (int i = 0; i < height.length; i++) {
			for (int j = i+1; j < height.length; j++) {
				//System.out.println(height[i] +" to "+ height[j]+" => length = "+(j-i)+" & height = "+Math.min(height[i], height[j])+" area = "+((j-i)*Math.min(height[i], height[j])));
				if(((j-i)*Math.min(height[i], height[j]))>area) {
					area = ((j-i)*Math.min(height[i], height[j]));
				}
			}
		}*/
		
		
		//TWO Pointer Technique
		int left  = 0, right = height.length - 1;
		while (left < right) {
			
			//System.out.println("width  = "+right+" - "+left+" = "+(right-left));
			//System.out.println("height = min("+height[left]+" , "+height[right]+") = "+Math.min(height[left],height[right]));
			
			
			//0,1,2,3,4,5,6,7,8 (= index)
			//[1,8,6,2,5,4,8,3,7]
			//   L             R
			
			area = Math.max(area, (right - left) * Math.min(height[left], height[right]));
			
			if(height[left] < height[right]) {
				 left++; // Move left pointer to the right
			}else {
				right--; // Move right pointer to left
			}
			
        }
		return area;
	}
}
