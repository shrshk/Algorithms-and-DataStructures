package leetcode;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		this.val = x;
	}
}

public class AddTwoNumbers {
	
	public ListNode addTwoNumbersBestSolution(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        
        while(c1!=null || c2!=null) {
            sum = sum/10;
            if (c1!=null) {
                sum+=c1.val;
                c1 = c1.next;
            }
            
            if (c2!=null) {
                sum+=c2.val;
                c2 = c2.next;
            }
            
            d.next = new ListNode(sum%10);
            d = d.next;
            
            if (sum/10==1) {
                d.next = new ListNode(1);
            }
        }
        
        return sentinel.next;
        
    }
	
	static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;	        
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}
	
	public static void main(String[] args) {
		ListNode two = new ListNode(2);
		ListNode four = new ListNode(4);
		ListNode three = new ListNode(3);
		
		two.next = four;
		four.next = three;		
		
		ListNode five = new ListNode(5);
		ListNode six  = new ListNode(6);
		ListNode fourSecond = new ListNode(4);
		
		five.next = six;
		six.next = fourSecond;
		
		ListNode nine = new ListNode(9);
		ListNode current = nine;
		//System.out.println(current.val);
		for(int i=1;i<10;i++) {
			ListNode newNode = new ListNode(9);
			current.next = newNode;
			current = current.next;
			//System.out.println(current.val);
		}
		 //System.out.println(new BigInteger("9342342342342342342342342342342342342342342342342342342342342"));
		ListNode oneEight = new ListNode(1);
		oneEight.next = new ListNode(8);
		
		ListNode zero = new ListNode(0);
		
		
		addTwoNumbers(oneEight, zero);
		
	}
}

// Crap code but works
/*
 * import java.math.BigInteger;
 * String num1 = "";
		String num2 = "";
		while (l1.next!=null) {
			num1 = num1+Integer.toString(l1.val);			
			l1 = l1.next;			
		}
		
		while (l2.next!=null) {
			num2 = num2+Integer.toString(l2.val);
			l2 = l2.next;
		}
		
		num1 = num1+Integer.toString(l1.val);
		num2 = num2+Integer.toString(l2.val);
		
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();
		
		System.out.println("num1" + " " + num1);
		
		System.out.println("num2" + " " + num2);
		System.out.println(new BigInteger(num1));
		BigInteger sum = new BigInteger(num1).add(new BigInteger(num2));		
		
		String result = String.valueOf(sum);
		
		System.out.println(result);
		
		result = new StringBuilder(result).reverse().toString();
		
		System.out.println(result);
		
		ListNode l3 = new ListNode(Character.getNumericValue(result.charAt(0)));
		
		ListNode current = l3;
		// 708 7->0
		for (int i=1;i<result.length();i++) {
			System.out.println(current.val);
			ListNode newNode = new ListNode(Character.getNumericValue(result.charAt(i)));
			current.next = newNode;			
			current = current.next;			
		}
		System.out.println(current.val);
		return l3;
 * 
 * 
 * */
