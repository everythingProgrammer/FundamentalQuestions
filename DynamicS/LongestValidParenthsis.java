package DynamicS;
import java.util.*;
public class LongestValidParenthsis {
	
	public int longestValidParenthesis(String s) {
		int curr = 0 ; 
		int ans = 0;
		
		Stack<Integer> st = new Stack<Integer>();
		
		for(int i = 0 ; i<s.length() ; i++) {
			char cc = s.charAt(i);
			if(cc == '(') {
				st.push(curr);
				curr = 0;
			}
			else {
				if(st.empty()) {
					curr = 0;
				}
				else {
					curr = curr+st.peek() + 2;
					st.pop();
					ans = Math.max(ans, curr);
				}
			}
		}
		return ans;
	}
}
