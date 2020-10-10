package arrays_string;

public class FactorialTrailingZero {
	
	
	
	public int trailingZero(int num) {
		
		int count = 0;
		
		while(num >0) {
			num = num /5; 
			count += num; 
			
		}
		return count;
		
	}
}
