package arrays_string;


/*product of array except self */

public class ProductOfArrayExceptSelf {
	
    public static   int[] productExceptSelf(int[] nums) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        
        int product[] = new int[nums.length];
        left[0] = 1;
        right[right.length -1] = 1;
        for(int i = 1 ; i< nums.length ; i++) {
        	left[i] = left[i-1]* nums[i-1];
        }
        for(int i = right.length -2; i>=0; i--) {
        	right[i] = right[i+1] * nums[i+1];
        }
        for(int i = 0  ; i< nums.length ; i++) {
        	product[i] = right[i]*left[i];
        }
        return product;
    }
    public static void main(String args[]) {
    	int arr[] = {1,2,3,4};
    	productExceptSelf(arr);
    }
}
