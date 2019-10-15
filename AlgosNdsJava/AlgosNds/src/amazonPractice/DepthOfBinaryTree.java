package amazonPractice;

import java.util.ArrayDeque;
import java.util.Queue;

/*
              1
            /   \
           2      3
          / \    / \
         4   5  6   7
 */

class NodeD {
	NodeD left;
	NodeD right;
	int data;

	NodeD(int data) {
		this.data = data;
	}

}

public class DepthOfBinaryTree {
	public int depthRecursive(NodeD root) {
		if (root == null)
			return 0;
		return 1 + Math.max(depthRecursive(root.left), depthRecursive(root.right));
	}

	public int depthIterative(NodeD root) {
		
		int height = 0;
		if (root == null)
			return height;
 
		Queue<NodeD> q = new ArrayDeque<>();

		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				NodeD current = q.poll();
				if (current.left != null)
					q.add(current.left);
				if (current.right != null)
					q.add(current.right);
			}
			
			height++;
			
		}

		return height;
	}

	public static void main(String[] args) {
		NodeD root = new NodeD(1);
		root.left = new NodeD(2);
		root.right = new NodeD(3);
		root.left.left = new NodeD(4);
		root.left.right = new NodeD(5);
		root.right.left = new NodeD(6);
		root.right.right = new NodeD(7);
		System.out.println(new DepthOfBinaryTree().depthRecursive(root));
		System.out.println(new DepthOfBinaryTree().depthIterative(root));
	}
}
