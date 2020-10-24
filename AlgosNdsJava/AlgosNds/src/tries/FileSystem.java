package tries;

import java.util.HashMap;
import java.util.Map;

class Node {
	Map<String, Node> children;
	String path;
	String data;
	boolean isLeaf;

	Node(String path, String data) {
		children = new HashMap<>();
		isLeaf = false;
		this.path = path;
		this.data = data;
	}

	Node(String path) {
		children = new HashMap<>();
		isLeaf = false;
		this.path = path;
		this.data = null;
	}

	void mkdir(String path) throws Exception {
		Node current = this;
		String[] keys = path.split("/");
		for (int i = 0; i < keys.length; i++) {
			if (i == keys.length - 2 && current.children.get(keys[i]) == null)
				throw new Exception("no parent node exists");
			if (current.children.get(keys[i]) == null) {
				current.children.put(keys[i], new Node(path));
			}
			current = current.children.get(keys[i]);
		}
		current.isLeaf = false;
	}

	void writeFile(String path, String data) {
		Node current = this;
		String[] keys = path.split("/");
		for (int i = 0; i < keys.length; i++) {
			if (current.children.get(keys[i]) == null) {
				current.children.put(keys[i], new Node(path, data));
			}
			current = current.children.get(keys[i]);
		}

		current.data = data;
		current.isLeaf = true;
	}

	String readFile(String path) throws Exception {
		String[] keys = path.split("/");
		Node current = this;
		for (int i = 0; i < keys.length; i++) {
			current = current.children.get(keys[i]);
			if (current == null)
				throw new Exception("Not found");
		}

		if (!current.isLeaf)
			throw new Exception("No file found");

		return current.data;
	}

}

public class FileSystem {

	// mkdir new node()

	// isLeaf file

	// api/coinbase/v1/directories/{path}/files/{fileName}

	// {
	// data: ....
	// meta: ...
	// }

	// millions // path: /sdvbu/as

	// mkdir // POST

	// GET api/coinbase/v1/files/{path}

	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */

		// /foo/bar
		// /foo/bar/file.txt

		// directories // files
		// string-> direct{ List<files> } ->

		// {d1: Set<files>} {name: data:}

		// /foo/bar/file.txt
		// foo
		// / \
		// . bar
		// /
		// . file.txt
		// . O(V+E)

		// foo -> []

		Node node = new Node("/");
		node.mkdir("foo/bar");
		node.writeFile("foo/bar/file.txt", "someData");

	}
}
