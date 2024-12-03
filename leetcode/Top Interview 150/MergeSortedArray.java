public class Solution {

	public static void main(String[] args) {

		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int m = 3;

		int[] nums2 = { 2, 5, 6 };
		int n = 3;

		merge(nums1, m, nums2, n);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int i = m - 1; 
		int j = n - 1; 

		for (int k = m + n - 1; k >= 0; k--) {
			if (i >= 0 && (j < 0 || nums1[i] > nums2[j])) {
				nums1[k] = nums1[i];
				i--;
			} else if (j >= 0) {
				nums1[k] = nums2[j];
				j--;
			}
		}

		System.out.println(Arrays.toString(nums1));
	}
}
