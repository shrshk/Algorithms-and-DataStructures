package golmansachs.practice;

public class StringCompress {
	public int compress(char[] chars) {
        int index=0, i=0,j=0, n=chars.length;
        int freq = 0;
        // a a b b
        while(i<n) {
            char ch = chars[i];
            //int j=i;
            while(j<n && chars[i]==chars[j]){
                j++;
            }
            freq = j-i;
            chars[index++] = ch;
            if(freq==1){
                
            }else if(freq<10){
                chars[index++] = (char)(freq + '0');
            }else {
                String x = String.valueOf(freq);
                for (char c: x.toCharArray()) {
                    chars[index++] = c;
                }
            }
            i = j;
        }
        return index;
    }
}
