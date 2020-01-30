package amazonLeetCode.phonescreen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}
public class LeafSimilarNodes {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		
		Queue<TreeNode> q1 = new ArrayDeque<>();
		Queue<TreeNode> q2 = new ArrayDeque<>();
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
			
		
		q1.add(root1);
		while(!q1.isEmpty()) {
			int size = q1.size();
			for (int i=0; i<size; i++) {
				TreeNode current = q1.poll();
				if (current.left==null && current.right==null) {
					list1.add(current.val);
					continue;
				}
				if (current.left!=null)
					q1.add(current.left);
				if (current.right!=null)
					q1.add(current.right);
			}
		}		
		
		q2.add(root2);
		while(!q2.isEmpty()) {
			int size = q2.size();
			for (int i=0; i<size; i++) {
				TreeNode current = q2.poll();
				if (current.left==null && current.right==null) {
					list2.add(current.val);
					continue;
				}
				if (current.left!=null)
					q2.add(current.left);
				if (current.right!=null)
					q2.add(current.right);
			}
		}
		
		
		
		return list1.equals(list2);
	}
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(5);
		root1.right = new TreeNode(1);
		
		TreeNode root2 = new TreeNode(4);
		root2.left = new TreeNode(5);
		root2.right = new TreeNode(2);
		System.out.println(new LeafSimilarNodes().leafSimilar(root1, root2));
	}
	
}
