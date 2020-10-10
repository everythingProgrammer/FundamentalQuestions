package arrays_string;

public class WordDistance {
	
	public static int wordDistance(String words[], String word1 , String word2) {
		int ans = Integer.MAX_VALUE;
		int w1 = -1 , w2 = -1; 
		
		for(int i = 0 ; i< words.length ; i++) {
			if(words[i].equalsIgnoreCase(word1)) {
				w1 = i; 
				if(w2 != -1) {
					if( w1-w2 < ans) {
						ans = w1-w2;
					}
				}	
			}
			if( words[i].equalsIgnoreCase(word2)) {
				w2 = i;
				if(w1 != -1) {
					if( w2-w1 < ans ) {
						ans = w2-w1;
					}
				}
			}
		}
		
		
		return ans;
	}


	
	public static void main(String args[]) {
		String words[] = {"kartik","bhaiya","teaches","Coding","to","Kartik","Everyone"};
		String word1 = "Coding";
		String word2 = "kartik";
		System.out.println(wordDistance(words, word1, word2));
	}

}
