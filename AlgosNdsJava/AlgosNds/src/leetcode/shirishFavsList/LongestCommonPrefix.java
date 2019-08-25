package leetcode.shirishFavsList;

public class LongestCommonPrefix {
	static String longestCommonPrefix(String[] strs) {
//		String first = strs[0];
//		String result = "";
//		for (int i=0; i<first.length();i++) {
//			char c1 = first.charAt(i);
//			for (int j=1; j<strs.length;) {
//				char c2 = strs[j].charAt(i);
//				j++;
//				char c3 = strs[j].charAt(i);
//			}
//		}
		
// f -> 
		
		if(strs == null)
			return null;
		if(strs.length == 0)
			return "";
		if(strs.length == 1)
			return strs[0];
		
		int length = strs[0].length();
		for (int i=0; i<strs.length; i++) {
			length = Math.min(length, strs[i].length());
		}
		StringBuilder sb = new StringBuilder();
		for (int j=0; j<length; j++) {
			for (int k=0; k<strs.length-1; k++) {
				if (strs[k].charAt(j)!=strs[k+1].charAt(j)) {
					return sb.toString();
				}
			}
			sb.append(strs[0].charAt(j));
		}

		return sb.toString();
	}
	
	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(strs));
	}
}
