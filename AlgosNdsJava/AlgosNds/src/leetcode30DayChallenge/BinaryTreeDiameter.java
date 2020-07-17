package leetcode30DayChallenge;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		this.val = x;
	}
}
public class BinaryTreeDiameter {	
//    public int diameterOfBinaryTree(TreeNode root) {
//    	int lH = height(root.left);
//    	int rH = height(root.right);
//    	diameter(root);
//    	diameter = Math.max(diameter, lH+rH+1);
//        return diameter;
//    }
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
    
    private int height(TreeNode root) {
    	if (root == null)
    		return 0;
		return 1 + Math.max(height(root.left), height(root.right));
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two =  new TreeNode(2);
		TreeNode three =  new TreeNode(3);
		TreeNode four =  new TreeNode(4);
		TreeNode five =  new TreeNode(5);
		
		root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;
		
		System.out.println(new BinaryTreeDiameter().diameterOfBinaryTree(root));
		
	}
    
	
	
	
}
