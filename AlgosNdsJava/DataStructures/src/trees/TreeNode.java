package trees;

public class TreeNode {

	private Integer Data;
	private TreeNode leftNode;
	private TreeNode rightNode;
	private boolean isDeleted;

	public TreeNode(int data) {
		// super();
		this.Data = data;
	}

	public TreeNode find(Integer data) {
		if (this.Data == data && !isDeleted) {
			return this;
		}
		if (this.Data < data && leftNode != null) {
			return leftNode.find(data);
		}
		if (rightNode != null) {
			return rightNode.find(data);
		}
		return null;

	}

	public void insert(Integer data) {
		if (data >= this.Data) {
			if (this.rightNode == null) {
				this.rightNode = new TreeNode(data);
			}
			this.rightNode.insert(data);
		} else {
			if (leftNode == null) {
				this.leftNode = new TreeNode(data);
			}
			this.leftNode.insert(data);
		}
	}

	public TreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public Integer getData() {
		return Data;
	}

	public void delete() {
		this.isDeleted = true;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public Integer smallest() {
		if (this.leftNode == null) {
			return this.getData();
		}
		return this.leftNode.smallest();
	}

	public Integer largest() {
		if (this.rightNode == null) {
			return this.getData();
		}
		return this.rightNode.largest();
	}

}
