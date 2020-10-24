package leetcode.shirishFavsList;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFilee {

	List<String> words;

	public void test() {
		words = new ArrayList<>();
		try {
			URL url = getClass().getResource("PopularEnglishWords.txt");
			System.out.println(url);
			File myObj = new File(
					"/Users/sveerabattini/Documents/workspace/Algorithms-and-DataStructures/AlgosNdsJava/AlgosNds/bin/leetcode/shirishFavsList/PopularEnglishWords.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String word = myReader.nextLine();
				words.add(word);
			}
			myReader.close();

			System.out.println(words.toString().getBytes("UTF-8").length * 0.001);

		} catch (Exception ex) {
			System.out.println("An error occurred.");
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("a");
		new ReadFilee().test();
	}
}