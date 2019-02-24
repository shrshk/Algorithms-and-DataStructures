package redditquestions;

public class FreqIntegerArray {

	public static int retFreq(int[] arr){
		//int tempcount=0;
		int popular=arr[0];
		int count=1;
		for(int i=0;i<arr.length-1;i++){
			int temp=arr[i];
			int tempcount=0;
			for(int j=1;j<arr.length;j++){
				if(temp==arr[j]){					
					tempcount++;
				}
				if(tempcount>count){
					popular=temp;
					count=tempcount;
				}
				
			}
			
		}
		return popular;
	}
	public static void main(String[] args) {
		int[] x ={1,4,4,5,6};		
		System.out.println(retFreq(x));
		
	}
}
