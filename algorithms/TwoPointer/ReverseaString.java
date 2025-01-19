public class ReverseString {
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            // Swap characters
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            // Move pointers
            left++;
            right--;
        }
        
        return new String(chars);
    }
    
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseString(s)); // Output: "olleh"
    }
}
