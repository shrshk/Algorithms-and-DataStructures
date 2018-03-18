package redditquestions;

public class CodeFightsOct27 {
	int[] prefixSums(int[] a) {
		
		int[] b = new int[a.length];
		for (int i=0;i<a.length;i++) {
			
		}
		
		
		
	    return null;
	}

	public static void main(String[] args) {
		int[] seq = {2,3,4,3};
		evenNumbersBeforeFixed(seq, 3);
	}
	boolean isCorrectSentence(String inputString) {
	    char[] ch = inputString.toCharArray();
	    boolean isUppercase = Character.isUpperCase(ch[0]);
	    char lastChar = ch[ch.length-1];
	    if (isUppercase && lastChar == '.'){
	        return true;
	    }
	    return false;
	}
	boolean areSimilarNumbers(int a, int b, int divisor) {
		if(a%divisor==0 && b%divisor==0){
			return true;
		}else if(a%divisor!=0 && b%divisor!=0){
			
		}
	    return false;
	}
	String replaceFirstDigitRegExp(String input) {
		char[] ch = input.toCharArray();
		for (int i=0;i<ch.length;i++){
			if (Character.isDigit(ch[i])){
				ch[i] = '#';
				break;
			}
		}
		String text = String.valueOf(ch);
		
		 return text;
	}
	static int evenNumbersBeforeFixed(int[] sequence, int fixedElement) {
	    int index=sequence.length;
	    for (int i=0;i<sequence.length;i++){
	        if(sequence[i]==fixedElement){
	             index = i;
	        }
	    }
	    int count =0;
	    if (index==sequence.length) {
	        return -1;
	    } else {
	        for (int j=0;j<index;j++){
	            if(sequence[j]%2==0){
	                count++;
	            }
	        }
	    }
	    
	    return count;
	}

}



