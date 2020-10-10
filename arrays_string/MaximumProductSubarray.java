package arrays_string;

public class MaximumProductSubarray {
	
	
	
	public static int maxProduct(int arr[]) {
		if( arr.length == 1)
			return arr[0];
		int pp = 1;
		int np = 1;
		int max = Integer.MIN_VALUE;
		
		boolean hasZero = false, hasPos =false;
		boolean hasnegative = true;
		
		for(int i = 0; i< arr.length ; i++) {
			if(arr[i] < 0) {
				int temp = pp;
				hasnegative = !hasnegative;
				/*
				if(pp == 1) {
					pp =1;
					np = np*arr[i];
				}
				else if( pp > 1 && np < 0) {
					
					pp = np*arr[i];
					np = temp * arr[i];
				}
				else if( pp > 1 && np == 1) {
					np = pp*arr[i];
					pp = 1;
				}*/
				
				/*The above logic is represented easily by */
				pp = Math.max(1,  np*arr[i]);
				np = temp * arr[i];
				
			}
			if(arr[i] == 0) {
				hasZero = true;
				pp = np = 1; 
				
			}
			
			if(arr[i] > 0) {
				hasPos = true; 
				
				pp = pp* arr[i];
				if(np != 1) {
					np = np* arr[i];
				}
			}
//			System.out.println("pp "+pp+" np "+np);
			if( pp > max) {
				max = pp;
			}
		}
		/*a few special cases 
		 * if there is only one element in the array then return that element 
		 * 
		 *  
		 * if max is one and there was no positive element and there was a zero then max = 0*/
		
		if(max == 1) {
			if(hasPos) return max;
			if(hasnegative) return max;
			if(hasZero) return 0;
		}
		return max;
	}
	
	public static void main(String args[]) {
		int arr[] = {-1,-1,0};
		System.out.println(maxProduct(arr));
	}
}
