package arrays_string;
import java.util.*;

public class MajorityElement {
	
	static ArrayList<Integer> majorityElement(ArrayList<Integer> v){
		
		int element1 = v.get(0);
		int e1c = 1; 
		int element2 = 0; 
		int e2c = 0; 
		
		
		for(int i = 1; i<v.size(); i++) {
			if( element1 == v.get(i)) {
				e1c ++;
			}
			else if( element2 == v.get(i)) {
				e2c++;
			}
			else if(e1c == 0) {
				element1 = v.get(i);
				
				
			}
			else if( e2c == 0) {
				element2 = v.get(i);
			}
			else {
				e1c --; 
				e2c --;
			}
		}
		/*Now we have two possible majority elements in element1 and element2 */
		/*Iterate over  arraylist and see if element1&2 have count greater than N/3*/
		
		e1c = e2c = 0 ; 
		for(int i = 0 ; i < v.size(); i++) {
			
			if(v.get(i) == element1) {
				e1c++;
			}
			else if( v.get(i) == element2) {
				e2c++;
			}
			
		}
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if(e1c >= (v.size()/3)+1) {
			ans.add(element1);
		}
		if(e2c >= (v.size()/3)+ 1) {
			ans.add(element2);
		}
		
		return ans;
		
	}
	
	
	
	public static void main(String args[]) {
		System.out.println("\t\tBoore- Moore Majority Voting algorithm for N/3 ");
		
		ArrayList<Integer> input = new ArrayList<Integer>();
		Scanner sr = new Scanner(System.in) ;
		int n = sr.nextInt();
		
		for(int i = 0  ; i<n ; i++) {
			input.add(sr.nextInt());
		}
		
		ArrayList<Integer> ans = majorityElement(input);
		if(ans.size() != 0) {
			System.out.println(ans);
		}
		else {
			System.out.println("No Majority Elements ");
		}
	}

}
