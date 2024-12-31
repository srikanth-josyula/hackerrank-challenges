import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

	public static void main(String[] args) {

		String str1 = "lissen";
		String str2 = "silent";

		System.out.println(stringAnagram(str1,str2));
	}

	public static Boolean stringAnagram(String str1, String str2) {
		
		
		/** Approach One **/
		Map<Character,Integer> map = new HashMap<>();
		for(Character c : str1.toCharArray()) {
			if(!map.containsKey(c)) {
				map.put(c, 1);
			}else {
				map.put(c, map.get(c)+1);
			}
		}
		// Count frequency of each character in string s2
		for(Character c : str2.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)-1);
			}
		}
		for (Entry<Character, Integer> check : map.entrySet()) {
            if (check.getValue() != 0) {
                return false;
            }
        }
		return true;
		/** Approach One END **/
		
		/** Approach Two **/
		char[] s1Array = str1.toCharArray();
        char[] s2Array = str2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        return Arrays.equals(s1Array, s2Array);
        /** Approach Two END**/
		
        
        
        /** Approach Three**/
        int[] freq = new int[26];

        // Count frequency of each character in string s1
        for (int i = 0; i < str1.length(); i++)
            freq[str1.charAt(i) - 'a']++;

        // Count frequency of each character in string s2
        for (int i = 0; i < str2.length(); i++)
            freq[str2.charAt(i) - 'a']--;

        // Check if all frequencies are zero
        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
		/** Approach Three END**/
        
	}
}
