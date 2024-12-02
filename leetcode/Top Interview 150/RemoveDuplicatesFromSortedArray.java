public class Solution {

	public static void main(String[] args) {

		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		System.out.println(removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {

		//move all unique elements to the beginning of the array, ensuring that duplicates are effectively removed in-place.

		int k = 0;
		int n = nums.length;

		for (int i = 1; i < n; i++) {
			if (nums[i] != nums[k]) {
                k++;
                nums[k] = nums[i];
            }
		}
		return k+1;
	}
}
