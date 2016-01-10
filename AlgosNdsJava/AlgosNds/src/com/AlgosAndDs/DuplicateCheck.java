package com.AlgosAndDs;

public class DuplicateCheck {
	
	public boolean hasduplicate(String s){
		boolean[] charSet = new boolean[128];
		
		
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(charSet[c]) return true;
			charSet[c]=true;
			
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DuplicateCheck dc = new DuplicateCheck();
		//dc.hasduplicate("shirish");
		System.out.println(dc.hasduplicate("x"));

	}

}
