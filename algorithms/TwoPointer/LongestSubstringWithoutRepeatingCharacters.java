import java.util.HashSet;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        
        while (end < s.length()) {
            char current = s.charAt(end);
            
            if (!set.contains(current)) {
                set.add(current);
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s)); // Output: 3 ("abc")
    }
}
