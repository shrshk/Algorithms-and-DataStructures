package redditquestions;

public class RotatedArray {

	public static boolean isRotatedArray(String s1, String s2){
		if((s1.length()==s2.length()) && (s1+s1).indexOf(s2)!=-1) {
			return true;
		}
		else{
			return false;
		}
	}
	public static void main(String[] args) {
		int[] x = {1,2,3,5,6,7,8};
		int[] y = {5,6,7,8,1,2,3};
		
		String s1 ="";
		String s2="";
		for(int i:x){
			s1=s1+i;
			
		}
		for(int j:y){
			s2=s2+j;
		}
		System.out.println("string1" + "" +"is"+s1);
		System.out.println("string2" + "" +"is"+s2);
		RotatedArray ra = new RotatedArray();
		System.out.println(ra.isRotatedArray(s1, s2));
		
		
	}
}
