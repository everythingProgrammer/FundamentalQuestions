package trees;
import java.util.*;


public class Tree {
	
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      
	      /*For connecting nodes on same level*/
	      TreeNode next;
	      
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }

	      TreeNode(int val, TreeNode left, TreeNode right) {
	    	  this.val = val;
		          this.left = left;
		          this.right = right;
	      }
	  }
	TreeNode root = null;
	
	/*Level Order Traversal*/
	public void levelOrder(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode rv = queue.removeFirst();
			System.out.println(rv.val+" ");
			if(rv.left != null) {
				queue.add(rv.left);
				
			}
			if(rv.right != null) {
				queue.add(rv.right);
			}
			
		}
		System.out.println("END");
	}
	
	public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        if(root == null)
            return lst;
        List<Integer> levellist = new ArrayList<>();
        LinkedList<TreeNode> queue =  new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode rv = queue.removeFirst();
            
            if(rv== null){
                lst.add(levellist);
                levellist = new ArrayList<>();
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                continue;
            }
            levellist.add(rv.val);
            if(rv.left!= null)
                queue.add(rv.left);
            if(rv.right!= null)
                queue.add(rv.right);
        }
        return lst;
    }
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        if(root == null)
            return lst;
        List<Integer> levellist = new ArrayList<>();
        LinkedList<TreeNode> queue =  new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode rv = queue.removeFirst();
            
            if(rv== null){
                lst.add(levellist);
                levellist = new ArrayList<>();
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                continue;
            }
            levellist.add(rv.val);
            if(rv.left!= null)
                queue.add(rv.left);
            if(rv.right!= null)
                queue.add(rv.right);
        }
        Collections.reverse(lst);
        return lst;
	}
	
	/*   https://leetcode.com/problems/average-of-levels-in-binary-tree/submissions/*/
	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avg = new ArrayList<Double>();
        double a = 0.0;
        int count = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode rv = queue.removeFirst();
            if(rv == null){
                avg.add(a/count);
                a=0.0;
                count = 0;
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                continue;
            }
            a+=rv.val;
            count++;
            if(rv.left!= null)
                queue.add(rv.left);
            if(rv.right!= null)
                queue.add(rv.right);
        }
        
        return avg;
        
    }
	
	 public int maxLevelSum(TreeNode root) {
	        List<Double> avg = new ArrayList<Double>();
	        int sum = 0;
	        int maxsum = Integer.MIN_VALUE;
	        int level = 1;
	        int maxlevel = 0;
	        LinkedList<TreeNode> queue = new LinkedList<>();
	        queue.add(root);
	        queue.add(null);
	        while(!queue.isEmpty()){
	            TreeNode rv = queue.removeFirst();
	            if(rv == null){
	                if(sum>maxsum){
	                    maxsum = sum;
	                    maxlevel = level;
	                }
	                level++;
	                sum = 0;
	                if(!queue.isEmpty()){
	                    queue.add(null);
	                }
	                continue;
	            }
	            sum+=rv.val;
	            
	            if(rv.left!= null)
	                queue.add(rv.left);
	            if(rv.right!= null)
	                queue.add(rv.right);
	        }
	        
	        return maxlevel;
	        
	        
	    }
	
	
	 /*Same Tree*/
	 public boolean isSameTree(TreeNode p, TreeNode q) {
		    // p and q are both null
		    if (p == null && q == null) return true;
		    // one of p and q is null
		    if (q == null || p == null) return false;
		    if (p.val != q.val) return false;
		    return isSameTree(p.right, q.right) &&
		            isSameTree(p.left, q.left);
		  }
	 
	 
	/*Symmetric Tree */
	public boolean isSymmetric(TreeNode root) {
		if( root == null)
			return true;
		return isSymmetric(root.left , root.right);
		
	}
	private boolean isSymmetric(TreeNode LST , TreeNode RST) {
		if(LST == null || RST == null) {
			return LST == RST;
		}
		
		if(LST.val == RST.val) {
			
			if(isSymmetric(LST.left , RST.right) && isSymmetric(LST.right , RST.left))
				return true;
			else 
				return false;
		}
		return false;
		
	}
	
	
	
	/*has path sum*/
	public boolean hasPathSum(TreeNode node, int sum) {
		
		return hasPathSum(node, sum , 0);
	}
	
	private boolean hasPathSum(TreeNode node, int sum , int cs) {
		if(node == null) {
			return false;
		}
		else if(node.left == null && node.right == null) 
			
			if(cs + node.val == sum)
				return true;
			else  return false;
			
		return hasPathSum(node.left , sum, cs+node.val) || hasPathSum(node.right , sum , cs+node.val);
	}
	
	
	
	/*Construct Binary Tree form Inorder and PostOrder Traversal */
	/*Not complete yet*/
	public static int index = 0;
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        
		if(inorder.length == 0) {
        	return null;
        }
        
        index = inorder.length -1;
        
       return buildTree(inorder , postorder , 0 , inorder.length -1);
    }
	
	public TreeNode buildTree(int[] inorder , int [] postorder , int si,  int ei) {
		
		if(si>ei) {
			return null;
		}
		int data = postorder[index];
		index --;
		
		TreeNode root = new TreeNode(data);
		int k = -1 ;
		for(int i = si ; i<= ei; i++) {
			if(data == inorder[i]) {
				k = i; 
				break;
			}
		}
		
		
		// recursive calls 
		root.right = buildTree(inorder , postorder, k+1, ei);
		root.left = buildTree(inorder , postorder, si, k-1);
		return root;
	}

	
	/*Construct Binary Tree from PreOrder Traversal and Inorder Traversal ezy.*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*Connect Nodes at the same level */
	
	public TreeNode connect(TreeNode root) {
		if( root == null) {
			return null;
		}
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			TreeNode node = q.poll(); 
			if(node != null) {
				if(node.left != null)
					q.add(node.left);
				if(node.right != null)
					q.add(node.right);
				
				node.next = q.peek();
				
			}
			else {
				if(! q.isEmpty())
					q.add(null);
			}
		}
		
		return root;
	}
	
	
	
	
	/*Connect Nodes  ZigZag manner*/
	
	public List<List<Integer>> zigzagLevelOrder( TreeNode root){
		
		if(root == null) {
			return new ArrayList<>();
		}
		
		Queue<TreeNode> q = new LinkedList<>();
		
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> l = new ArrayList<>();
		
		q.add(root);
		q.add(null);
		int level = 0 ; // to determine even or odd level is there.
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			
			/*If Node == null then we just need to empty l into ans according to left to right or right to left*/
			
			if(node == null) {
				/*print accordingly */
				
				if(level %2 ==0) {
					ans.add(l);
				}
				else {
					Collections.reverse(l);
					ans.add(l);
				}
				level ++;
				
				if(!q.isEmpty())
					q.add(null);
//				l.clear(); cannot use clear since it will clear the memory in heap and ArrayList will be empty.
				l = new ArrayList<Integer>();
			}
			/*else add node data and left and right to l*/
			else {
				l.add(node.val);
				if(node.left != null)
					q.add(node.left );
				if(node.right != null)
					q.add(node.right );
				
			}
			
			
		}
		return ans;
	}

	
	/*add node at given depth */
	public  TreeNode add_one_row_to_tree(TreeNode root , int v, int d) {
		if(d == 1) {
			TreeNode newRoot = new TreeNode(v);
			newRoot.val  = v;
			newRoot.left = root;
			return newRoot;
		}
		addNode(root, 1, v, d);
		return root;
	}
	private  void addNode(TreeNode root, int depth , int v , int d) {
		// Base Case
		if( root == null) {
			return ;
		}
		if( depth == d-1) {
			 TreeNode left = new TreeNode();
			 left.val = v;
			 TreeNode right = new TreeNode();
			 right.val = v;
			 
			 /*Now we will directly attach the left and right subtree of the node to these new nodes
			  * without storing them into new Nodes ...*/
			 
			 left.left = root.left ; 
			 left.right = null;
			 right.right = root.right;
			 right .left = null;
			 /*Now attach left to left of root node and right to right of root node*/
			 root.left = left;
			 root.right = right;
			 
			 /*after performing this operation we can return */
			 return; 
		}
		else {
			/*This means we haven't reached where we want to be ....*/
			addNode(root.left , depth +1 , v, d);
			addNode(root.right , depth +1 , v, d);
		}
		
	}

	/*Largest value in each row.*/
	public List<Integer> largerstValue(TreeNode root){
		Queue<TreeNode>  q = new LinkedList<>();
		List<Integer>  ans = new ArrayList<>();
		if(root == null) {
			return ans;
		}
		int max_value= Integer.MIN_VALUE;
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			
			TreeNode n = q.poll();
			if(n == null) {
				ans.add(max_value);
				max_value = Integer.MIN_VALUE;
				
				if(!q.isEmpty()) {
					q.add(null);
				}
			}
			else {
				max_value = Math.max(max_value, n.val);
				
				if(n.left != null)
					q.add(n.left);
				
				if(n.right != null)
					q.add(n.right);
			}
		}
		return ans ;
	}

	
	
	
	/*Root to Leaf sum = k*/
	public static List<List<Integer>> ans;
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		ans = new ArrayList<>();
		
		pathSum(root, sum, 0 , new ArrayList<Integer>() );
		return ans;
	}
	
	public void pathSum(TreeNode root, int sum , int curr_sum , List<Integer> curr_path){
	if(root == null)
		return;
	
	
	curr_path.add(root.val);
	curr_sum = curr_sum +root.val;
		
	
	if(root.right == null && root.left == null) {
		if(curr_sum == sum ) {
			ans.add(new ArrayList<>(curr_path));
			 
		}
	}
	
	 
	 pathSum(root.left , sum, curr_sum , curr_path);
	 pathSum(root.right, sum, curr_sum , curr_path);
	 
	 /*now before going to previous nodes we also need to remove current value*/
	 
	 curr_path.remove(curr_path.size()-1);
	 
	 return;
		
	}
	
	
	
	/*Count Complete Tree Nodes*/
	/*in O(log N) ^2 time complexity*/
	public int countNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int d = depth(root);
		
		if(d == 0) /*If tree has only one node */
		{
			return 1;
		}
		int left = 1;		//minimum number of nodes 
		int right = (int) Math.pow(2,d); //maximum number of nodes 
		int n_d= 0 ; // number of complete nodes.
		
		while(left <= right) {
			int pivot = (left+ right)/2;
			if(check(root, pivot, d)) {
				left = pivot+1;
				n_d = pivot;
			}else {
				right = pivot-1;
				
			}
				
		}
		
		return ((int) Math.pow(2, d) -1) + n_d;
    }
	public static int depth(TreeNode root) {
		int count = 0;
		while(root.left !=null) {
			root = root.left;
			count++;
		}
		return count;
	}

	public static boolean check(TreeNode nn , int idx, int d) {
		int l = 1;
		int r = (int)Math.pow(2,d);
		int pivot = 0;
		for(int i = 0; i< d; i++) {
			pivot = (l+r)/2;
			if(idx <= pivot) {
				nn= nn.left;
				r=pivot;
			}
			else {
				nn= nn.right;
				l = pivot +1;
			}
		}
		if(nn == null) {
			return false;
		}else {
			return true;
		}
	}
	
	
	/*Count Complete Tree Nodes in O(N) time complexity from geeksforgeeks*/
	
	/*but geeksforgeeks solution in quite accurate I would say*/
	
	/*Right Side view of a binary tree*/
	public ArrayList<Integer>  rightSideView(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>();
		if(root == null) {
			return ans;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);;
		while(!q.isEmpty()) {
			TreeNode n = q.poll();
			if(n == null) {
				if(!q.isEmpty()) {
					q.add(null);
				}
			}
			else {
					if(n.left != null) {
						q.add(n.left);
					}
					if(n.right != null) {
						q.add(n.right);
					}
					if(q.peek() == null) {
						ans.add(n.val);
					}
				}
			}
		 return ans;
			
	}
		
	
	/*Binary Tree Maximum Sum Path algorithm*/
	static int max;
	 public int maxPathSum(TreeNode root) {
		 max =  Integer.MIN_VALUE;
		 maximumSum(root);
		 return max;
	 }
	public int maximumSum(TreeNode root) {
		if(root == null)
            return 0;
        
        int left =  maximumSum(root.left );
        int right= maximumSum(root.right);
        
		 
        int max_sub = Math.max(root.val,root.val + Math.max(left, right));
        
        int maximum = Math.max(max_sub, root.val + left +right);
        
        if(max < maximum) {
        	max = maximum;
        }
        
        
        return  max_sub;
		
	}

	/*Find Kth Smallest in Tree*/
	/*in O(1) space complexity*/
	static int smallest = Integer.MIN_VALUE;
	public int kthSmallest(TreeNode root, int k) {
		 
		smallestHelper(root, k);
		//return smallest;
		/*using second function */
		
		ArrayList<Integer> arr = new ArrayList<>();
		inorder(arr, root);
		return arr.get(k);
		
	}
	private int smallestHelper(TreeNode root , int k) {
		if(root == null)
			return k ;
		k = smallestHelper(root.left, k);
		k--;
		if(k == 0)
			smallest = k;
		k =smallestHelper(root.right , k);
		
		return k; 
	}
	
	
	/*in O(N) space complexity*/
	public void inorder(List<Integer> l , TreeNode root) {
		if(root == null)
			return;
		inorder(l, root.left);
		l.add(root.val);
		inorder(l, root.right);
		return;
	}
	
	
	
	
	/*Inorder Successor 
	 *Using O(N) time complexity and O(1) space complexity.*/
	static boolean flag = false;
	public int inorderSuccessor(TreeNode n) {
		return successorValue(this.root,  n).val;
	}
	
	private TreeNode successorValue(TreeNode root, TreeNode n) {
		
		if(root == null) {
			return null;
		}
		TreeNode left = successorValue(root.left, n);
		if(left != null) {
			return left;
		}
		
		if(flag) {
			flag = false;
			return root;
		}
		
		if(root == n) {
			flag  = true;
			return null;
		}
		
		TreeNode right = successorValue(root.right, n);
		
		if(right !=null) {
			return right;
		}
		
		return null;	
	}
	
	
	
	/*Left side view of tree.*/
	/*working implementation in BinaryTree in DataStructure Class*/
	public ArrayList<Integer> leftSideView(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>();

		if(root == null){
			return ans;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		ans.add(root.val);

	while(!q.isEmpty()){
			TreeNode n= q.poll();
			if(n == null){
				if(!q.isEmpty()){
					q.add(null);
					TreeNode ne = q.peek();
					if(ne!= null)
						ans.add(ne.val);
				}
			}
			else{
				if(n.left != null){
					q.add(n.left);
				}
				if(n.right != null){
					q.add(n.right);
				}
				
			}
		}
	return ans;
	}

	/*Unique Binary Search Trees
	 * https://leetcode.com/problems/unique-binary-search-trees/
	 * Count unique binary search trees that can be formed using n nodes*/
	public int numTrees(int n) {
        int dp[] = new int[n+1];
        if(n == 1)
            return 1;
        if( n == 2)
            return 2;
        int j = 0;
        dp[0]=1;
        dp[1]=1;

        
        for(int i= 2; i<n+1; i++){
            for(j = 0 ; j<i ; j++){
                dp[i]+= dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }

	
	
	/*Invert Binary Tree : https://leetcode.com/problems/invert-binary-tree/solution/
	 * Recursive approach 
	 * basically just create new nodes left and right and place them at left and right
	 * so the for leaf nodes nothing happens but for node above leaf the leaves gets interchanged*/
	
	public TreeNode invertBinaryTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		TreeNode right = invertBinaryTree(root.right);
		TreeNode left = invertBinaryTree(root.left);
		root.right  = left;
		root.left = right; 
		return root;
	}
	
	/*Invert Binary Tree - Iterative approach */
	public TreeNode invertBinaryTree( TreeNode root, int b) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode rv = queue.removeFirst();
			TreeNode temp = rv.left;
			rv.left = rv.right;
			rv.right = temp;
			if(rv.left != null) {
				queue.add(rv.left);
			}
			if(rv.right != null) {
				queue.add(rv.right);
			}
			
		}
		
		
		
		return root;
	}

	
	/*Balanced Binary Tree 
	 * Recursive approach*/
	 public boolean isBalanced(TreeNode root) {
	        if(root == null){
	            return true;
	        }
	        
	        int l = maxHeight(root.left);
	        int r = maxHeight(root.right);
	        
	        if(Math.abs(l-r)<= 1 && isBalanced(root.left) && isBalanced(root.right)){
	            return true;
	        }
	        return false;
	        
	        
	    }
	    public static int maxHeight(TreeNode root){
	        if(root == null){
	            return 0;
	        }
	        return 1+ Math.max(maxHeight(root.left), maxHeight(root.right));
	    }
	/*Everywhere where height is being calculated we can make an optimization where we can use 
	 * a class height. 
	 * */
	 
	  public void diagonalPrint() {
		  HashMap<Integer, Vector<Integer>> diagonalPrint = new HashMap<>();
		  diagonalPrintUtil(root,0 , diagonalPrint);
		  
		  System.out.println(diagonalPrint);
	  }
	    
	  public void diagonalPrintUtil(TreeNode root, int d, HashMap<Integer , Vector<Integer>> diagonalPrint) {
		 if(root == null)
			 return;
		 Vector<Integer> k = diagonalPrint.get(d);
		 if(k == null) {
			 k = new Vector<>();
			 k.add(root.val);
		 }
		 else {
			 k.add(root.val);
		 }
		 
		 diagonalPrint.put(d, k);
		 
		 diagonalPrintUtil(root.right, d, diagonalPrint);
		 diagonalPrintUtil(root.left, d+1 , diagonalPrint);
		 
		 
	  }

	  
	  /*Check if given graph is tree or not 
	   * 
	   * A given undirected graph is a tree if - 
	   * 	
	   * 	*a there are no cycles in graph 
	   * 	*b the graph is connected*/
	  /*Link*/
	  /*   https://www.geeksforgeeks.org/check-given-graph-tree/#:~:text=Since%20the%20graph%20is%20undirected,graph%20is%20connected%2C%20otherwise%20not.
	  */
	   
}
	

