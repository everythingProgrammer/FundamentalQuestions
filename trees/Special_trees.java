package trees;
/*maximum binary tree 2*/

public class Special_trees {
	
	 class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
	
	
	public   TreeNode constructMaxBinaryTree(int arr[]) {
		return constructMaxBinaryTree(arr, 0, arr.length);
	}
	
	
	private   TreeNode constructMaxBinaryTree(int arr[] , int l , int r) {
		if(l>=r) {
			return null;
		}
		
		int max_i = max(arr, l , r);
		
		TreeNode root = new TreeNode(arr[max_i]);
		root.left = constructMaxBinaryTree(arr,l , max_i);
		root.right = constructMaxBinaryTree(arr, max_i +1 , r);
		
		return root;
		
	}
	
	public  int max(int arr[] ,int l , int r)
	{
		int max = arr[l];
		for(int i = l ; i< r; i++) {
			if(arr[max] < arr[i]) {
				max = i;
			}
		}
		return max;
	}
	
	
	public static void main(String args[]) {	
		Special_trees obj2 = new Special_trees();
		int arr[] = {3,2,1,6,0,5};
		TreeNode newNode = obj2.constructMaxBinaryTree(arr);
		
		
	}
	
}
