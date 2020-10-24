package golmansachs.practice;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // integral part
        res.append(num / den);        
        num %= den;
        
        if (num == 0) {
            return res.toString();
        }
        
        // fractional part
        res.append(".");
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        while (num != 0) {
            map.put(num, res.length());

            num *= 10;
            res.append(num / den);
            num %= den;

            Integer remainderIndex = map.get(num);
            if (remainderIndex != null) {
                res.insert(remainderIndex, "(");
                res.append(")");
                break;
            }
        }
        return res.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(new FractionToDecimal().fractionToDecimal(2, 3));
	}
}
