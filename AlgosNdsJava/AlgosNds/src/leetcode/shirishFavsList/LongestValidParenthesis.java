package leetcode.shirishFavsList;

import java.util.Stack;

public class LongestValidParenthesis {
	 public static int longestValidParentheses(String s) {
	        Stack<Integer> st=new Stack<>();
	        int maxans=0;
	        st.push(-1);
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i)=='('){
	                st.push(i);
	            }
	            else{
	                st.pop();
	                if(st.empty()){
	                    st.push(i);
	                }else{
	                    maxans = Math.max(maxans, i - st.peek());
	                }
	            }
	        }
	        return maxans;
	    }
	 
	 public static void main(String[] args) {
		System.out.println(longestValidParentheses(")()())"));
	}
}
