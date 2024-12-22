package com.sample;

public class Solution {

	public static void main(String[] args) {

		int[] nums = { 1, 7, 3, 6, 5, 6 };

		System.out.println(pivotIndex(nums));
	}

	public static int pivotIndex(int[] nums) {

		// [1],7,3,6,5,6 => for 1 => 0, (7+3+6+5+6)
		// 1,[7],3,6,5,6 => for 7 => 1, (3+6+5+6)
		// 1,7,[3],6,5,6 => for 3 => (1+7), (6+5+6)
		// 1,7,3,[6],5,6 => for 6 => (1+7+3), (5+6) => so 6 ie. nums[3] where i is '3'break;

		
		//better sol
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			total = total + nums[i];
		}
		int leftSum=0;
        for(int i=0;i<nums.length;i++){
            if(leftSum==total-nums[i]-leftSum){
                return i;
            }
            leftSum=leftSum+nums[i];
        }
        return -1;
		 
		
		//Took 200ms
		/*int k = 0;
		int leftSum = 0;

		int n = nums.length;

		while (k < n) {
			int rightSum = 0;

			if (k != 0) {
				leftSum += nums[k - 1];
			}
			if (k != n) {
				for (int i = k + 1; i < n; i++) { // Start from k+1
					rightSum += nums[i];
				}
			} else {
				rightSum += 0;
			}
			//System.out.println(nums[k] + " => " + leftSum + " | " + rightSum);
			if (leftSum == rightSum) {
				return k;
			}
			k++;
		}
		return -1;*/
	}
}
