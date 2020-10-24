package leetcodeContests.contest184;

import java.util.HashMap;
import java.util.Map;

public class StringReplace {

	public String entityParser(String text) {
		Map<String, String> config = new HashMap<>();
		config.put("&quot;", "\"");
		config.put("&apos;", "'");
		config.put("&amp;", "&");
		config.put("&gt;", ">");
		config.put("&lt;", "<");
		config.put("&frasl;", "/");

		for (String key : config.keySet()) {
			text = text.replaceAll(key, config.get(key));
		}
		return text;
	}

	public static void main(String[] args) {
		String text = "&amp; is an HTML entity but &ambassador; is not.";
		System.out.println(new StringReplace().entityParser(text));
	}
}
