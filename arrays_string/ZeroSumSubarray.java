package arrays_string;
/*Total number of subarrays having sum = 0*/
import java.util.*;

public class ZeroSumSubarray {

	
	public static int calcSubarrays(int a[]) {
		
	 
		
		
		HashMap<Integer, Integer> m = new HashMap<>();
		m.put(0,1);
		
		
		int p[] = new int[a.length];
		
		p[0] = a[0];
		if(m.containsKey(p[0]) )
			m.put(p[0], m.get(p[0]) +1 );
		else
			m.put(p[0], 1);
		
		
		
		/*int prefixSum[] = new int [arr.length];
		prefixSum[0] = arr[0];
		HashMap<Integer, Integer> m = new HashMap<>();
		m.put(0,1); // added 0 automatically
		
		if(m.containsKey(arr[0]))
			m.put(arr[0], m.get(arr[0])+1);
		*/
		
		
		for(int i = 1 ; i< a.length ; i++) {
			p[i] = p[i-1]+a[i];
			if(m.containsKey(p[i]))
			{
				m.put(p[i] , m.get(p[i])+1 );
				
			}
			
			else
				m.put(p[i] , 1);
		}
		
		
		int c = 0;
		for(int key : m.keySet()) {
			int val = m.get(key);
			if(val>1) {
				System.out.println( key +"  "+val);
				c+= (val*(val-1)) /2;
			}
		}
		return c;
	}
	
	public static void main(String args[]) {
		int arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7};
		System.out.println(calcSubarrays(arr));
	}
	
}
