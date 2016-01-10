package strings;

public class StringReverseWordByWord {
	
	public static void main(String[] args) {
		String original[] = "reverse me shirish".split("");
		String finalStr = "";
		for(int i=original.length-1;i>=0;i--){
			finalStr = finalStr + original[i];
			
		}
		System.out.println(finalStr);
		
	}

}
