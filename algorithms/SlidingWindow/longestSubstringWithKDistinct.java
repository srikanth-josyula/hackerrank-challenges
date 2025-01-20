import java.util.HashMap;

public class SlidingWindowExample {

    public static int longestSubstringWithKDistinct(String s, int k) {
        // Initialize variables
        HashMap<Character, Integer> charMap = new HashMap<>();
        int start = 0, maxLength = 0;
        
        // Expand the window with the 'end' pointer
        for (int end = 0; end < s.length(); end++) {
            // Add the character at 'end' to the map
            charMap.put(s.charAt(end), charMap.getOrDefault(s.charAt(end), 0) + 1);
            
            // Shrink the window from the left if we have more than 'k' distinct characters
            while (charMap.size() > k) {
                charMap.put(s.charAt(start), charMap.get(s.charAt(start)) - 1);
                if (charMap.get(s.charAt(start)) == 0) {
                    charMap.remove(s.charAt(start));
                }
                start++;  // Move the 'start' pointer to the right
            }
            
            // Update the max length of the window
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        
        // Output the result
        int result = longestSubstringWithKDistinct(s, k);
        System.out.println("Longest Substring with at most " + k + " distinct characters: " + result);
    }
}
