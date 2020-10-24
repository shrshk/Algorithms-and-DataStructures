package amazonLeetCode.phonescreen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Row {
	int id;
	int[] row;

	Row(int id, int[] row) {
		this.id = id;
		this.row = row;
	}
}

public class SoldiersAndCivilians {
	public List<Integer> kWeakestRows(int[][] matrix, int k) {
		List<Integer> res = new ArrayList<>();
		Queue<Row> pq = new PriorityQueue<>(new Comparator<Row>() {
			@Override
			public int compare(Row r1, Row r2) {
				return count(r1.row) - count(r2.row);
			}
		});
		for (int i = 0; i < matrix.length; i++) {
			pq.add(new Row(i, matrix[i]));
		}

		while (k > 0) {
			res.add(pq.poll().id);
			k--;
		}

		return res;
	}

	private int count(int[] row) {
		int count = 0;
		for (int num : row) {
			if (num == 1)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 0, 0, 0, 0 } };
		System.out.println(new SoldiersAndCivilians().kWeakestRows(matrix, 2));
	}

}
