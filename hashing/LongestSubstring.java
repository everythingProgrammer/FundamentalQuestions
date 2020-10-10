package hashing;
import java.util.*;
public class LongestSubstring {
	
	/*Longest Substring without repetition*/
	public   int lengthOfLongestSubstring(String s) {
		HashMap<Character , Integer> map = new HashMap<>();
		int ans = 0;
		int j =0;
		for(int i = 0 ; i< s.length(); i++) {
			char ch = 	s.charAt(i);
			if(map.containsKey(ch)) {
				j = Math.max(map.get(ch) +1, j); /* this will ignore any elements having previous occurrences... */
			}
			ans = Math.max(ans , i-j+1); /*index starts with 0 and length -1 will be with j-i that's why*/
			map.put(ch, i); /*to put current character in map*/
		}
		return ans;
	}
	
	
	/*from geeks for geeks*/
	
	static final int NO_OF_CHARS = 256;
	
	public int lengthofLongestSubstring2(String str) {
		 int n = str.length(); 
		  
	        int res = 0; // result 
	  
	        // last index of all characters is initialized 
	        // as -1 
	        int [] lastIndex = new int[NO_OF_CHARS]; 
	        Arrays.fill(lastIndex, -1); 
	  
	        // Initialize start of current window 
	        int i = 0; 
	  
	        // Move end of current window 
	        for (int j = 0; j < n; j++) { 
	  
	            // Find the last index of str[j] 
	            // Update i (starting index of current window) 
	            // as maximum of current value of i and last 
	            // index plus 1 
	            i = Math.max(i, lastIndex[str.charAt(j)] + 1); 
	  
	            // Update result if we get a larger window 
	            res = Math.max(res, j - i + 1); 
	  
	            // Update last index of j. 
	            lastIndex[str.charAt(j)] = j; 
	        } 
	        return res; 
	}
}
