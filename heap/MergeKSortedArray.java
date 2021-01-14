package heap;
import java.util.*;
public class MergeKSortedArray {
	
	
	public static void main(String args[]) {
		Scanner sr = new Scanner (System.in);
		int n = sr.nextInt();
		int m = sr.nextInt();
		int arr[][] = new int [n][m];
		
		for(int i  = 0 ; i<n ; i++) {
			for(int j = 0; j<m ; j++) {
				arr[i][j] = sr.nextInt();
				
			}
		}
		
		ArrayList<Integer> ans = mergeKSortedArray(arr);
		System.out.println(ans);
	}
	public static ArrayList<Integer> mergeKSortedArray(int arr[][]){
		PriorityQueue<help>pq = new PriorityQueue<help>();
		
		for(int ar[] : arr) {
			pq.add(new help(ar, 0));
		}
		ArrayList<Integer> ans = new ArrayList<>();
		
		while(!pq.isEmpty()) {
			help temp = pq.remove();
			ans.add(temp.arr[temp.index]);
			if(temp.index < temp.arr.length-1) {
				pq.add(new help(temp.arr, temp.index+1));
			}
		}
		return ans;
	}
}
class help implements Comparable<help>{
	
	int arr[];
	int index;
	
	public help(int arr[] , int index) {
		this.arr = arr;
		this.index = index ; 
	}
	
	public int compareTo(help o) {
		return this.arr[this.index]-o.arr[o.index]; 
	}
	
	
}