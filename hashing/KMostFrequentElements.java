package hashing;
import java.util.*;
public class KMostFrequentElements {
	
	public ArrayList<Integer> kMostFrequent( int a[] , int k){
		ArrayList<Integer>  ans = new ArrayList<>();
		
		HashMap<Integer, Integer> m = new HashMap<>();
		
		/*Element and its frequency is in HashMap now */
		
		for(int i : a) {
			m.put(i, m.containsKey(i)? 1+m.get(i) : 1  );
		}
		
		/*Now we want to create a array of list */
		ArrayList<Integer> freq[] = new ArrayList[a.length];
		
		/* We cannot use this here since this won't allow us to add/remove based on index.*/
//	    ArrayList<ArrayList<Integer> > aList = new ArrayList<ArrayList<Integer>>(a.length);
		
		
		for(int i = 0; i<a.length ; i++) {
			freq[i] = new ArrayList<>();
		}
		
		/*freq[m.get(key)]   - gives us the frequency of that key  i.e. integer in array and since 0 based array substract 1 from it*/
		for(int key : m.keySet()) {
			freq[m.get(key) -1].add(key);
		}
		/*now we'll pop elements from the last one by one so we start from i = a.length -1*/
		for(int i = a.length -1 ; i>=0; i--) {
			while(!freq[i].isEmpty() && k>0 ) {
				ans.add(freq[i].remove(0));
				k--;
			}
		}
		return ans;
	}
}
