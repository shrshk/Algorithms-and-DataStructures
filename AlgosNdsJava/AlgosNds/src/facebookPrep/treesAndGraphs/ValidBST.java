package facebookPrep.treesAndGraphs;

import java.util.Stack;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root!=null || !stack.isEmpty()) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre!=null && root.val<=pre.val) return false;
            pre = root;
            root = root.right;            
        }
        return true;
    }
	public static void main(String[] args) {
		
	}
}
