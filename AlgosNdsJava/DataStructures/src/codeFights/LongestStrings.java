package codeFights;

public class LongestStrings {
	
	public static String[] LongestStrings(String[] arr) {
		String [] result = {};
		int longest = 0;
		for (int i=0;i<arr.length;i++) {
			if (arr[i].length() > longest) {
				longest = arr[i].length();
			}
			if (i>0 && arr[i].length()<arr[i-1].length()) {
				result[i-1] = null;
			} else {
				// result[i] =
			}
			 
		}
		
		return result;
	}

	public static void main(String[] args) {
		String[] arr = {"aba", "aa", "ad", "vcd", "aba"};
		System.out.println(LongestStrings(arr));
	}

}

/*int longest = 0;
String [] result = {};
for (int i=0;i<arr.length;i++) {
	int length = arr[i].length();
	if (length > longest) {
		longest = length;				
	}			
}
for (int j=0; j<arr.length; j++) {
	if (arr[j].length() == longest) {
		result[j] = arr[j];
	}
	 
}*/