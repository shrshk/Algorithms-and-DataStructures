package strings;

public class StringReverseInPlace {
	public static char[] stringReverseInPlace(char[] string){
		for(int i=0,j=string.length-1;i<string.length/2;i++,j--){
			char c = string[i];
			string[i]=string[j];
			string[j]=c;
		}
		return string;
		
	}
	public static void main(String[] args) {
		char[] string1 = {'s','h','i','r','i','s','h'};
		System.out.println(stringReverseInPlace(string1));
		StringBuffer s = new StringBuffer();
		String x = "ntr";
		s.append(x);
		System.out.println(s.reverse());
	}

}
