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
//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x) {
//		val = x;
//	}
//}
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // steps
        // list<node> before p
        // list<node> before qs
        // loop thru both arrays return the first element where arrays differ
        List<TreeNode> firstList = new ArrayList<>();
        List<TreeNode> secondList = new ArrayList<>();
        firstList  = buildNodeList(root, p, firstList);
        secondList = buildNodeList(root, q, secondList);  
        
        TreeNode res = lca(firstList, secondList);
        
        
        return res;
        
    }
    
    private List<TreeNode> buildNodeList(TreeNode root, TreeNode p, List<TreeNode> list) {
//        if (root == null) return list;
//        list.add(root);
//        if (p.val == root.val)
//            return list;
//        if (p.val < root.val)
//            buildNodeList(root.left, p, list);
//        if (p.val > root.val)
//            buildNodeList(root.right, p, list);
    	
    	  if (root == null) return list;
    	  list.add(root);
    	  if (root.val == p.val)
    		  return list;
    	  else {
    		  buildNodeList(root.left, p, list);    		  
    		  buildNodeList(root.right, p, list);  
    	  }  	
    	
        return list;    
    }
    
    private TreeNode lca(List<TreeNode> first, List<TreeNode> second) {
        int i=0;
        while (i<first.size() && i<second.size()) {
     	   System.out.println(first.get(i).val);
     	   System.out.println(second.get(i).val);
           if (first.get(i).val != second.get(i).val) {
        	   return first.get(i-1);
           }               
            i++;
        }
        return null;
    }
    
    public static void main(String[] args) {
    	// [6,2,8,0,4,7,9,null,null,3,5]
    	TreeNode root = new TreeNode(6);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(8);
    	root.left.left = new TreeNode(0);
    	root.left.right = new TreeNode(4);
    	root.right.left = new TreeNode(7);
    	root.right.right = new TreeNode(9);
    	root.left.right.left = new TreeNode(3);
    	root.left.right.right = new TreeNode(5);
    	System.out.println(new LowestCommonAncestor().lowestCommonAncestor(root, root.left, root.left.right));
	}
    
    
}
