package trees;

public class BinarySearchTree {
	private TreeNode root;

	public void insert(Integer data) {
		if (root == null) {
			this.root = new TreeNode(data);
		}
		root.insert(data);
	}

	public TreeNode find(Integer data) {
		if (root != null) {
			return root.find(data);

		}
		return null;

	}

	public void delete(Integer data) {
		TreeNode todel = find(data);
		todel.delete();
	}

	public Integer smallest() {
		if (this.root != null)
			return root.smallest();
		return null;
	}
	public Integer largest(){
		if(this.root!=null)
			return root.largest();
		return null;
	}
public int numberOfLeafNodes(){
	int count=0;
	if(root==null){
		return count;
	}
	TreeNode current = this.root;
	while(current!=null && current.getLeftNode()!=null){
		current = current.getLeftNode();
		count++;
	}
	return count;
}
/*
public int closestNumber(int k){
	if(root==null){
		return 0;
		
	}
	TreeNode current = this.root;
	if(current.getData()==k){
		return current.getData();
	}
	if(k<current.getData()){
		while(current!=null){
			current =current.getLeftNode();
			
		}
	}
		
}
public int closestNumberHelper(int k, int m){
	if(root==null){
		return 0;
	}
	if(root.getData()==k){
		return root.getData();
	}
	
	
}*/
	// public void delete(Integer data){
	// TreeNode current = this.root;
	// TreeNode parent = this.root;
	// boolean isLeftNode = false;
	//
	// if(current==null){
	// return;
	// }
	// while(current!=null && current.getData()!=data){
	// parent = current;
	// if(data<current.getData()){
	// current = current.getLeftNode();
	// isLeftNode=true;
	// }else{
	// current = current.getRightNode();
	// isLeftNode=false;
	//
	// }
	// if(current==null)
	// return;
	//
	// while(current.getLeftNode()==null && current.getRightNode()==null){
	// if(current==root){
	// root=null;
	// }else{
	// if(isLeftNode){
	// parent.setLeftNode(null);
	// }
	// else{
	// parent.setRightNode(null);
	// }
	// }
	// }
	// }
	//
	//
	// }
	// public void delete(Integer data){
	// TreeNode current = this.root;
	// TreeNode parent = this.root;
	// boolean isLeftNode = false;
	//
	// if(current==null){
	// return;
	// }
	// while(current!=null && current.getData()!=data){
	// parent = current;
	// if(data<current.getData()){
	// current = current.getLeftNode();
	// isLeftNode = true;
	// }else{
	// current = current.getRightNode();
	// }
	// }
	// if(current==null){
	// return;
	// }
	// while(current.getLeftNode()==null && current.getRightNode()==null){
	// //when the data to be deleted is a leaf
	// if(current==root){
	// root=null;
	// }else{
	// if(isLeftNode){
	// parent.setLeftNode(null);
	// }
	// else{
	// parent.setRightNode(null);
	//
	// }
	// }
	//
	// if(current.getRightNode()==null){
	// if(current==root){
	// root=current.getLeftNode();
	// }else{
	// if(isLeftNode){
	// parent.setLeftNode(current.getLeftNode());
	// }else{
	// parent.setRightNode(current.getRightNode());
	// }
	//
	// }
	// }
	// if(current.getLeftNode()==null){
	// if(current==root){
	// root=current.getRightNode();
	// }else{
	// if(isLeftNode){
	// parent.setLeftNode(current.getRightNode());
	// }else{
	// parent.setRightNode(current.getRightNode());
	// }
	// }
	//
	// }
	//
	// }
	//
	//
	// }
	//

}
