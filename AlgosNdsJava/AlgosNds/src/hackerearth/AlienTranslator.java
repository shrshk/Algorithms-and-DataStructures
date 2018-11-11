package hackerearth;

public class AlienTranslator {
	public String fromDefaultLanguage(String languageTokens) {
        String result = "";
        for (int i=0; i<languageTokens.length(); i++) {
        	char val = languageTokens.charAt(i);
        	int nextValue = (int)val + 3;
        	char c = (char)nextValue;
        	result+=c;
        }
        return result;
    }
	
    public String toDefaultLanguage(String languageTokens) {
        String result = "";
        for (int i=0; i<languageTokens.length(); i++) {
        	char val = languageTokens.charAt(i);
        	int nextValue = (int)val - 3;
        	char c = (char)nextValue;
        	result+=c;
        }
        return result;
    }
	
	public static void main(String[] args) {
		AlienTranslator aT = new AlienTranslator();
		System.out.println(aT.fromDefaultLanguage("java"));
		System.out.println(aT.toDefaultLanguage("mdyd"));
	}
}
/*SELECT AVG(s.TotalSale) as aa
FROM Sales s
GROUP BY InvoiceNo
ORDER BY aa DESC
LIMIT 1;*/