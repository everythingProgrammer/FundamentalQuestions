package DynamicS;

import java.util.Arrays;

public class NumberOfPaths {
	
	
	
	private static int uniquePathsRecursive(int m , int n) {
		if(m ==1 && n == 1)
			return 1;
		
		if(m == 1 || n == 1)
			return 1;
		
		return uniquePathsRecursive(m-1, n) + uniquePathsRecursive(m, n-1);
	}
	
	/*Does not work till now*/
	public static int uniquePathsTD(int n , int m , int dp[][]) {
		if(n == 0 && m == 0) {
			return dp[n][m] = 1;
		}
		if(n== 0 || m == 0)
			return 1;
		if(dp[n][m] != 0) {
			return dp[n-1][m-1];
		}
		
		return dp[n][m] = uniquePathsTD(n-1, m , dp)+ uniquePathsTD(n, m-1, dp);
	}
	
	
	private static int uniquePathsBU(int m , int n) {
		int dp[][] = new int[m][n];
		
		for(int row[] : dp)
			Arrays.fill(row,0);
		
		/*first fill all the base cases i.e. cases along i = 0 and j = 0 */
		for(int i= 0 ; i< m ; i++) {
			dp[i][0] = 1;
		}
		for(int i = 0 ; i< n ; i++) {
			dp[0][i] = 1;
		}
		
		for(int i = 1 ; i< m ; i++) {
			for(int j = 1 ;  j<n ; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
			}
		}
		
		return dp[m-1][n-1];
	}


	public static void main(String args[]) {
		int arr[][] = new int[3][3];
		System.out.println(uniquePathsRecursive(1,1));
		System.out.println(uniquePathsBU(1,1));
		System.out.println(uniquePathsTD(1,1,arr));
	}
}
