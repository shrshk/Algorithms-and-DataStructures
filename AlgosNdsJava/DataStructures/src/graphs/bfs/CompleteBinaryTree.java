package graphs.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

class NodeT {
	int data;
	NodeT left = null;
	NodeT right = null;
	NodeT(int data) {
		this.data = data;
	}
}

public class CompleteBinaryTree {
	
	public static boolean isComplete(NodeT root) {
		
		Queue<NodeT> q = new ArrayDeque<NodeT>();
		// if a non full node is detected and the next node is not leaf binary tree is not complete.
		// if a non full node has a right child binary tree is not complete.
		q.add(root);
		boolean flag = false; // use to mark a non full node
		while(!q.isEmpty()) {
			NodeT v = q.poll();
			// parent is not full and child has left or right node return false
			if (flag && (v.right!=null || v.left!=null))
				return false;
			// left is null but right is not return false
			if (v.left==null && v.right!=null)
				return false;
		    // left not null and it to the queue or mark non full node.
			if (v.left!=null) {
				q.add(v.left);
			}else {
				flag = true;
			}
			// if right not null and it to the queue or mark non full node.
			if (v.right!=null) {
				q.add(v.right);
			}else{
				flag = true;
			}				
					
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// level order traversal      
		/*             1
		 *            /\
		 *            2 3
		 *            /\ \
		 *            4 5 7
		 *            
		 * */
		NodeT root = new NodeT(1);
		root.left = new NodeT(2);
		root.right = new NodeT(3);
		root.left.left = new NodeT(4);
		root.left.right = new NodeT(5);
		root.right.right = new NodeT(7);
		
		System.out.println(isComplete(root));		
	}
}
