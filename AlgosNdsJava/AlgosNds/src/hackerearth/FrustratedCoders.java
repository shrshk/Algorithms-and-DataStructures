package hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
//import for Scanner and other utility classes
import java.util.*;
*/
 
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.util.*;
class FrustratedCoders {
    public static void main(String args[] ) throws Exception {
 
        int n=6;
        // int[] a;
        // Scanner in = new Scanner(System.in);
        // n = 6;
        int[] a = new int[]{ 1, 2, 2, 4, 4, 7};
        Stack s = new Stack(n);
        Arrays.sort(a);
        int k =a[n-1];
        int ki = n-1; //  1 2 2 4 4 7       7 4 2 1
        for(int i = n-1; i >= 0; i--){
            if(s.isEmpty()){
                s.push(a[i]);
            }
            else if(k > a[i]){
                ki--;
                k = a[ki];
                
            }
            else if(k == a[i]){
                s.push(a[i]);
            }
        }
        int sum = 0;
        while(!s.isEmpty()){
            sum = sum + s.pop();
            System.out.println(s.pop());
        }
        System.out.println(sum);
        
    }
 
}
 
class Stack{
    private int[] arr;
    private int top = -1;
    
    public Stack(int n){
        arr = new int[n];
    }
    
    public void push(int a){
        
        if(top != arr.length){
            top++;
            arr[top] = a;
        }
        else{
            System.out.println("stack full");
        }
    }
    
    public int pop(){
        if(top != -1){
            int element = arr[top];
            top--;
            return element;
        }
        else{
            System.out.println("Stack Empty");
            return -1;
        }
    }
    
    public boolean isEmpty(){
        return top == -1;
    }
    
    public int top(){
        return top;
    }
    
    public int peek() {
    	if(isEmpty())
    		System.out.println(" Stack is empty ");
    	return arr[top];
    }
}