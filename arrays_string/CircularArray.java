/*		smj ni aaya abhi */


package arrays_string;

import java.util.Scanner;

public class CircularArray {
	
	public static int nextIndex(int arr[] , int i ) {
		
		return ((i+arr[i]+arr.length)% arr.length);
	}
	
	public static boolean circularArray(int arr[]) {
		
		
		
		
		return true;
	}
	
	
	public static void main(String args[]) {
		Scanner sr = new Scanner(System.in);
		
		int N  = sr.nextInt(); 
		int arr[] = new int [N];
		
		for(int i = 0 ; i< N ; i++) {
			arr[i] = sr.nextInt();
		}
		
		System.out.println(arr);
	}
}
