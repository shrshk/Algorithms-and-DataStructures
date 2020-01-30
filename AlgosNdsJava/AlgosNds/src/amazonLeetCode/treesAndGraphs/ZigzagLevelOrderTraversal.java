package amazonLeetCode.treesAndGraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // even level left to right
        // odd level right to left
		List<List<Integer>> res = new ArrayList<>();		
		if (root == null)
			return res;
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
//		res.add(new ArrayList<>());
		while (!q.isEmpty()) {
			int size = q.size();
			int currentLevel = res.size();
			res.add(currentLevel, new ArrayList<>());			
 			for (int i=0; i<size; i++) {
				TreeNode current = q.poll();
				res.get(currentLevel).add(current.val);
				if (current.left!=null)
					q.add(current.left);
				if (current.right!=null)
					q.add(current.right);				
			}
 			if (currentLevel == 1 || currentLevel%2!=0) {
 				Collections.reverse(res.get(currentLevel));
 			}
		}
		
		return res;
        
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);
		System.out.println(new ZigzagLevelOrderTraversal().zigzagLevelOrder(root));
	}
}
