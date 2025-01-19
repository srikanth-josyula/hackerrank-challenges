import java.util.Arrays;

public class TwoSum {
    public static int[] findTwoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        //Make sure we need to sort the array
        Arrays.sort(nums);
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++; // Move left pointer to increase sum
            } else {
                right--; // Move right pointer to decrease sum
            }
        }
        
        return new int[0]; // Return an empty array if no pair is found
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6};
        int target = 6;
        System.out.println(Arrays.toString(findTwoSum(nums, target))); // Output: [2, 4]
    }
}
