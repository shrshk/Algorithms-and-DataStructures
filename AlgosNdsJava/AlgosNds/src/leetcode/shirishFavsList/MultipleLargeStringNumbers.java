package leetcode.shirishFavsList;

public class MultipleLargeStringNumbers {
//	static int strToInt(String s){
//		int i=0;
//		int num=0;
//		boolean isNeg = false;
//		
//		if(s.charAt(i) == '-') {
//			isNeg = true;
//		}
//		
//		while (i<s.length()) {
//			num *= 10;
//			num += s.charAt(i++) - '0';			
//		}
//		if (isNeg)
//			num = -num;
//		return num;
//	}
	
	static String multiplyTwoStrings(String s1, String s2) {
		String num1 = new StringBuilder(s1).reverse().toString();
		String num2 = new StringBuilder(s2).reverse().toString();
		
		int[] result = new int[num1.length() + num2.length()];
		
		for (int i=0; i<num1.length(); i++){
			for (int j=0; j<num2.length(); j++) {
				result[i+j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			}
		}
		
		// 0   0 0  0 0 0
		// 18 15 12
		//    12 10 8
		//        6 5 4 0
		
		// 18 27 28 13 4 0
		
		// 8 7 8 3 4
		
		// 12 13                 31 12       21 31
		// 6 2+3  1
		
		StringBuilder sb = new StringBuilder();
		
		//calculate each digit
	    for(int i=0; i<result.length; i++){
	        int mod = result[i]%10; // 18%10 = 8 8
	        int carry = result[i]/10;
	        if(i+1<result.length){
	        	result[i+1] += carry;
	        }
	        sb.insert(0, mod);
	    }
		
		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}
		
		return sb.toString();
	}
	
//	static int multiplyStrings(String s1, String s2) {
//		int num1 = strToInt(s1);
//		int num2 = strToInt(s2);
//		return num1*num2;
//	}
	
	
	
	public static void main(String[] args) {
		System.out.println(multiplyTwoStrings("19", "18")); // 321 654 
	}
	
	
}

