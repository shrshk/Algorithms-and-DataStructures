package golmansachs.practice;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
	public List<String> removeComments(String[] source) {
        // steps
        // if mode is on detect the end and make the mode false
        // else check if single line comment and break
        // else add to stringBuilder
        // when mode is false and sb has something add to res.
        List<String> res = new ArrayList<>();
        boolean mode = false;
        StringBuilder sb = new StringBuilder();
        
        for (String s: source) {
            for (int i=0; i<s.length(); i++) {
                if (mode) {
                    if (s.charAt(i) == '*' && i<s.length()-1 && s.charAt(i+1) == '/') {
                        mode = false;
                        i++;
                    }
                } else {
                    if (s.charAt(i) == '/' && i<s.length()-1 && s.charAt(i+1) == '/')
                        break;
                    else if (s.charAt(i) == '/' && i<s.length()-1 && s.charAt(i+1) == '*') {
                        mode = true;
                        i++;
                    } else {
                        sb.append(s.charAt(i));
                    }
                }
            }
            if (!mode && sb.length()>0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        
        return res;
        
    }
	
	public static void main(String[] args) {
		System.out.println((1/3)-(1/2));
	}
}
