package arrays_string;
import java.util.*;
public class BuyandSellStock {
	
	/*This is logic for when we have to consider multiple buy and sell stocks
	 *If we have to consider only 1 for max profit then we can simply modify this one 
	 *where we are doing ans = ans + (peak - valley) if we do ans = Math.max(ans , (peak-valley)) 
	 *that should do .*/
	public int maxProfit(int[] prices) {
		
		int i = 0 ; 
		int n = prices.length;
		if(n == 0)
			return 0;
		
		int peak = prices[0], valley  = prices[0];
		int ans = 0;
		while(i< n-1) {
			
			while(i< n-1 && prices[i] >= prices[i+1]) {
				i++;
			}
			valley = prices[i];
			while(i<n-1 && prices[i]<= prices[i+1]) {
				i++;
			}
			peak = prices[i];
			
			ans = ans+( peak - valley);
			
		}
		return ans;	
    }
	
		
}
