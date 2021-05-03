package arrays_string;
/*By Nick White's video*/
public class LongestPallindroneSubstring {
	
	
	public static void main(String args[]) {
		printSubstring("babadaddda");
		
	}
	
	
	public static void printSubstring(String str) {
		int start = 0 , end  = 0;
		
		for(int i = 0 ; i< str.length() ; i++) {
			int len1 = expandFromMiddle(str, i, i);
			int len2 = expandFromMiddle(str, i , i+1);
			int maxlen = Math.max(len1, len2);
			
			if( maxlen > end-start) {
				start = i - ((maxlen - 1 )/2);	/*this maxlen -1 comes into action when we have palindrome of type abbbba here we'll get right starting point since
												 *	b is 2 and 5/2 = 2 and i will also be 2 .... */
				end = i+ (maxlen/ 2);
			}
			
		}
		System.out.println(str.substring(start , end+1));
		
		
	}
	
	public static int expandFromMiddle(String s, int left , int right) {
		if( s == null || left > right)
			return 0;
		
		while(left >=0 && right <s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left -1;
		
	}
	
}
