package arrays_string;
import java.util.*;

public class FrequencyTwo {
	
	
	public static ArrayList<Integer> calculate(int arr[]){
		ArrayList<Integer> elements = new ArrayList<Integer>();
		
		for(int i =0; i<arr.length ; i++) {
			
			int val = arr[i];
			if(val <0 )
				val= val*-1;
			/*
			 * we can do val = val -1 to map 1 with 0th index 
			 * 								 2 with 1st index
			 * 								 3 with 2nd index and so on
			 * 
			 * */
			val = val-1;
			if(arr[val] <0)
			{
				elements.add(val+1);
			}
			else
			{
				arr[val] = arr[val] * -1;
			}
		}
		return elements;
		
	}
	
	
	
	
	public static void main(String args[]) {
		int arr[] = {1,5,2,3,8,5,2,8};
		System.out.print(calculate(arr));
	}
}
