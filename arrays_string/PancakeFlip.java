package arrays_string;
/*Somewhat flip sort */
import java.util.*;
public class PancakeFlip {
	
	public static int find(int a[] , int n) {
		for(int i =0 ; i<a.length ; i++) {
			if(a[i] == n)
				return i;
		}
		return -1;
	}
	
	
	public static void flip(int a[] , int k) {
		for(int i = 0; i<k/2 ; i++) {
			int t = a[i];
			a[i] = a[k-i-1];
			a[k-i-1] = t;
		}
	}
	
	public static  List<Integer> pancakeSort(int a[]){
		List<Integer> list = new ArrayList<>();
		int n = a.length;
		
		while(n >0 ) {
			
			int idx = find(a,n);
			if(idx != n-1) {
				flip(a, idx+1);
				flip(a, n);
				System.out.println(n);
				for(int g: a) {
					System.out.print(g+" ");
				}
				System.out.println();
				
				list.add(idx+1);
				list.add(n);		
			}
			n--;
		}
		
		return list;
	}

	public static void main(String args[]) {
		int a[] = {2,3,1,7,4,6,5};
		pancakeSort(a);
	}
	
}
