package linkedList;

public class Node {

	private int data;
	private Node nextNode;

	public Node(int data) {
		// TODO Auto-generated constructor stub
		this.data=data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
