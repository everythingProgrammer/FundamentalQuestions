/*Kafi complex hora tha ...*/

package arrays_string;

import java.util.Arrays;

public class AttendMeetings {
	public static class Interval{
		int start; 
		int end; 
		Interval(){
			start = 0; 
			end = 0; 
		}
		
		Interval(int s , int e){
			start = s; 
			end = e; 
		}
		
	
	}
	
	
	public static boolean canAttendMeetings(Interval []intervals) {
		//If there are no meetings , then return true.
		if(intervals == null || intervals.length == 0) {
			return true; 
		}
		
		// Sort the intervals on the basis of start time. 
		
		//Arrays.sort()
		
		return false;
		
	}
	
}
