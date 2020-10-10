package DynamicS;
/*bottom's up approach*/
public class BitonicSubsequence {
	
	public static int calculateMaxSubsequence(int arr[]) {
		int n = arr.length;
		int inc[] = new int[arr.length];
		inc[0] = 1;
		for(int i = 1; i<n ; i++) {
			for(int j = 0; j< i ; j++) {
				if(arr[i]> arr[j] && inc[i] < inc[j]) {
					inc[i] = inc[j]+1;
				}
			}
		}
		
		int dec[] = new int[n];
		dec[n-1] = 1;
		for(int i = n-2; i>= 0; i--) {
			for(int j = n-1; j>i ; j--) {
				if(arr[i]> arr[j] && dec[i] < dec[j]) {
					dec[i] = dec[j];
				}
			}
			dec[i]++;
		}
		
		/* So now we find the length of longest bitonic subsequence.*/
		int lbs = 1;
		for(int i = 0 ; i< n ; i++) {
			lbs = Math.max(lbs, inc[i] + dec[i] -1);
		}
		return lbs;
	}
	public static void main(String args[]) {
		
	}
}
