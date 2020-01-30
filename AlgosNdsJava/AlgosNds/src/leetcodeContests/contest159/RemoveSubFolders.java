package leetcodeContests.contest159;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveSubFolders {
	private class TrieNode {
		HashMap<String, TrieNode> children = new HashMap<>();
		String word = null;
	}

	private List<String> parentFolders = new ArrayList<>();

	void getResults(TrieNode root) {
		for (Map.Entry<String, TrieNode> entry : root.children.entrySet()) {
			if (entry.getValue().word != null) {
				parentFolders.add(entry.getValue().word);
			} else {
				getResults(entry.getValue());
			}
		}
	}

	public List<String> removeSubfoldersTrie(String[] folders) {
		TrieNode root = new TrieNode();
		for (String folder : folders) {
			String[] parts = folder.substring(1).split("/");
			TrieNode curr = root;
			for (String part : parts) {
				if (!curr.children.containsKey(part)) {
					curr.children.put(part, new TrieNode());
				}
				curr = curr.children.get(part);
			}
			curr.word = folder;
		}

		parentFolders.clear();
		getResults(root);
		return parentFolders;
	}

	public List<String> removeSubfolders(String[] folder) {
		List<String> res = new ArrayList<>();
		Arrays.sort(folder);
		res.add(folder[0]);
		for (int i = 1; i < folder.length; i++) {
			// check if current string starts with the one stored in the result
			// also check if the char at the length of the string stored is /
			// for below case
			// "/a/b/c","/a/b/ca"
			boolean startsWith = folder[i].startsWith(res.get(res.size() - 1));
			boolean slash = startsWith && folder[i].charAt(res.get(res.size() - 1).length()) == '/';
			if (slash)
				continue;
			res.add(folder[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		String[] folder = new String[] { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };
		System.out.println(new RemoveSubFolders().removeSubfolders(folder).toString());
		// System.out.println(new RemoveSubFolders().containsOther("/a/b/ca",
		// "/a/b/c"));

		// ["/a/b/c","/a/b/ca","/a/b/d"]
		// "/ah/al/am","/ah/al"
		//

	}
}

// -----------scrapWork-------------------------
// public List<String> removeSubfolders(String[] folder) {
// Arrays.sort(folder);
// List<String> ans = new ArrayList<>();
// ans.add(folder[0]);
// for(int i = 1; i< folder.length; i++){
// if(!(folder[i].startsWith(ans.get(ans.size()-1)) &&
// folder[i].charAt(ans.get(ans.size()-1).length()) == '/'))
// ans.add(folder[i]);
// }
// return ans;
// }

// public List<String> removeSubfolders(String[] folder) {
// List<String> result = new ArrayList<>();
//
// for (int i = 0; i < folder.length; i++) {
// if (!parentExists(folder[i], i, folder)) {
// result.add(folder[i]);
// }
// }
//
// return result;
// }

// private boolean parentExists(String current, int i, String[] folder) {
// String temp1 = new String(current);
// String[] x1 = temp1.split("/");
// for (int j = 0; j < folder.length && j != i; j++) {
// // String temp2 = new String(folder[j]);
// // if (temp2.length()>=x1.length)
// // return false;
// // String[] x2 = temp2.split("/");
// // for (int k=0; k<x1.length && k< x2.length; k++) {
// // if (!x1[k].equals(x2[k])) {
// // return false;
// // }
// // }
// String temp2 = new String(folder[j]);
// String[] x2 = temp2.split("/");
// if (x2.length >= x1.length)
// return false;
// for (int k = 0; k < x1.length && k < x2.length; k++) {
// if (!x1[k].equals(x2[k])) {
// return false;
// }
// }
// }
// return true;
// }
//
// private boolean containsOther(String second, String first) {
// String temp1 = new String(first);
// String temp2 = new String(second);
// String[] x1 = temp1.split("/");
// String[] x2 = temp2.split("/");
// if (x2.length <= x1.length)
// return false;
//
// return true;
// }
