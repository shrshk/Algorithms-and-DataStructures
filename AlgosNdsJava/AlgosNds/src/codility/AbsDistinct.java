package codility;

import java.util.stream.IntStream;

public class AbsDistinct {
	static int absDist(int[] arr) {
		return (int) IntStream.of(arr).map(x -> Math.abs(x)).distinct().count();
	}
	public static void main(String[] args) {
		System.out.println(absDist(new int[]{-5, -3, -1, 0, 3, 6}));
	}
}
