package leetcode.shirishFavsList;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	private static final Map<Character, Integer> romanToNumeral;
	static {
		Map<Character, Integer> romanMap = new HashMap<>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
		romanToNumeral = Collections.unmodifiableMap(romanMap);
	}
	
//	static List<Character> specials = Arrays.asList('I', 'X', 'C');
//	static List<Integer> specialVals = Arrays.asList(4,9,40,90,400,900);
	
//	static int romanToInt(String x) {
//		int sum = 0;
//		int i = 0;
//		while (i<x.length()){
//			char current = x.charAt(i);
//			if (i<x.length()-1) {
//				int val = calValue(current, x.charAt(i+1));
//				sum = sum + val;
//				if (specialVals.contains(val))
//					i=i+2;
//				else
//					i++;				
//			}else if(i==x.length()-1) {
//				sum = sum + myMap.get(current);
//				i++;
//			}
//		}
//		return sum;
//	}
	
//	static int calValue(char a, char b) {
//		switch(a){
//		case 1: a = 'I';
//		  if (b == 'V')
//			  return 4;
//		  if (b == 'X')
//			  return 9;
//		case 2: a = 'X';
//		  if (b == 'L')
//			  return 40;
//		  if (b == 'C')
//			  return 90;
//		case 3: a = 'C';
//		  if (b == 'D')
//			  return 400;
//		  if (b == 'M')
//			  return 900; 
//		default:
//			return myMap.get(a);		
//		}
//	}
	
	static int romanToInt(String s) {
		int i=s.length() - 1, num = 0;
		while(i >= 0){
			int romI = romanToNumeral.get(s.charAt(i));
			if(i-1 >= 0){
				int romIMinus1 = romanToNumeral.get(s.charAt(i-1));
				if(romIMinus1 < romI){
					num += (romI - romIMinus1);
					i -= 2;//move two steps
				}else{
					num += romI;
					i--;
				}
			}else{
				num += romI;
				i--;
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}

}
