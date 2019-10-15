package amazonPractice;

import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {
		
	}
	TreeNode(int x) {
		this.val = x;
	}
}

public class MinDiffBSTNodes {
	int min = Integer.MAX_VALUE;
	Integer pre = null;
	public int minDiffInBST(TreeNode root) {
	    check(root);
	    return min;
	}

	private void check(TreeNode node) {
	    if (node == null) return;
	    check(node.left);
	    if (pre != null)
	        min = Math.min(min, node.val - pre);
	    pre = node.val;
	    check(node.right);
	}
	
	// not working
    public int minDiffBFS(TreeNode root) {
    	int min = Integer.MAX_VALUE;
    	Queue<TreeNode> q = new ArrayDeque<>();
    	q.add(root);
    	while(!q.isEmpty()) {
    		TreeNode current = q.poll();
    		if (current.left!=null) {
    			q.add(current.left);
    			min = Math.min(min, current.val-current.left.val);
    		}    			
    		if (current.right!=null) {
    			q.add(current.right);
    			min = Math.min(min, current.right.val-current.val);
    		}    			
    		
    	}
    	
    	return min;    	
    }
    
	public static void main(String[] args) {
		TreeNode four = new TreeNode();
		four.val = 4;
		TreeNode two = new TreeNode();
		two.val = 2;
		TreeNode six = new TreeNode();
		six.val = 6;
		TreeNode one = new TreeNode();
		one.val = 1;
		TreeNode three = new TreeNode();
		three.val = 3;
		
		four.left = two;
		four.right = six;
		two.left = one;
		two.right = three;
		System.out.println(new MinDiffBSTNodes().minDiffInBST(four));
	}
}
