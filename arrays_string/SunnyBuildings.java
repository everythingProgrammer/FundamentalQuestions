package arrays_string;

public class SunnyBuildings {
	
	
	public static int countBuildings(int arr[])
	{
		int max = Integer.MIN_VALUE , count = 0 ; 
		for(int i = 0; i< arr.length ; i++) {
			if(arr[i] > max) {
				max = arr[i] ; 
				count++ ; 
			}
		
		}
		return count;
	}
	public static void main(String args[]) {
		int arr[] = {5,2,5,6,4,3,7};
		System.out.println(countBuildings(arr));
	}
	
	
}
