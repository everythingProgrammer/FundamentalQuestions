package arrays_string;

public class MostWater {
	
	public static int maxArea(int height[]) {
		int ans = 0 , l = 0 , r = height.length -1; 
		
		while(l<r) {
			ans = Math.max(ans , Math.min(height[l],height[r])* (r-l));
			
			if(height[l] < height[r]) {
				l++;
			}else {
				r--;
			}
		}
		return ans;
	}
	public static void main(String args[]) {
		int height[] = {0 , 1 , 0 , 2 , 1,  0,  1,  3 , 2 , 1 , 2 , 1};//?? not sure how 14
		System.out.println(maxArea(height));
	}
}
