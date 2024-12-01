public class Solution {

	public static void main(String[] args) {

		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;

		System.out.println(removeElement(nums, val));
	}

	public static int removeElement(int[] nums, int val) {
		int k = 0;
		int n = nums.length;

		for (int i = 0; i < n; i++) {

			if (nums[i] != val) { // If the current element is not equal to val
				nums[k] = nums[i];  // Place it at the k-th position
				k++;                // Move the pointer forward
			}
		}
		return k;
	}
}
