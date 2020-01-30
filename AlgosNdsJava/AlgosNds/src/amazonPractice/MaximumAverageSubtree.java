package amazonPractice;

//class TreeNodeS {
//	TreeNodeS left;
//	TreeNodeS right;
//	int data;
//	TreeNodeS(int data) {
//		this.data = data;
//	}
//}

/*
              1
            /   \
           2      3
          / \    / \
         4   5  6   7
*/
public class MaximumAverageSubtree {
	double maxAvgSubTree(NodeD root) {		
		return helper(root)[2];
	}
	
	private double[] helper(NodeD root) {
		if (root == null)
			return new double[]{0,0,0};
		// steps find sum, cnt, maxAvg of leftSub, rightSub		
		double[] left= helper(root.left), right = helper(root.right);
		double cnt = 1 + left[1] + right[1];
		double sum = root.data + left[0] + right[0];
		double childAvg = Math.max(left[2], right[2]);
		double maxAvg = sum/cnt;
		return new double[]{sum, cnt, Math.max(childAvg, maxAvg)};
//		double n = Math.max(left[2], right[2]);		
	}
	
	public static void main(String[] args) {
		NodeD root = new NodeD(1);
		root.left = new NodeD(2);
		root.right = new NodeD(3);
		root.left.left = new NodeD(4);
		root.left.right = new NodeD(5);
		root.right.left = new NodeD(6);
		root.right.right = new NodeD(7);
		System.out.println(new MaximumAverageSubtree().maxAvgSubTree(root));
	}
	
}
