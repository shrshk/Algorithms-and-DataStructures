package amazonPractice;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<TreeNode> firstPath = new ArrayList<>();
    private List<TreeNode> secondPath = new ArrayList<>();
    private List<TreeNode> findPath(TreeNode root, TreeNode n, List<TreeNode> path){
        if (root == null)
            return path;
        path.add(root);
        if (root.val == n.val)
            return path;
        if (root.left!=null && findPath(root.left, n, path)!=null)
            return path;
        if (root.right!=null && findPath(root.right, n, path)!=null)
            return path;
        
        // remove the node which is not in the path of current node.
        path.remove(path.size()-1);
        
        return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // steps
        // find path to p
        // find path to q
        // store paths in lists
        // return the node where lists differ.
        if (findPath(root, p, firstPath) == null || findPath(root, q, secondPath) == null)
            return null;
        int i=0;
        while(i<firstPath.size() && i<secondPath.size()) {
            if (firstPath.get(i).val!=secondPath.get(i).val) {
                break;
            }
            i++;
        }        
        
        return firstPath.get(i-1);
        
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		TreeNode lca = new Solution().lowestCommonAncestor(root, root.left.left, root.left.right);
		//Node lca = new LowestCommonAncestorBT().findLCA(root, new Node(10), new Node(11));
		int lcaVal = lca!=null ? lca.val : -1;

		System.out.println("LCA(4, 5): " + lcaVal );

	}
}