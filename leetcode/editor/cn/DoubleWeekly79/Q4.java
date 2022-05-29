package DoubleWeekly79;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Q4 {
	public static void main(String[] args) {

	}
	class BookMyShow {
		int totalCount = 0;
		int nowRow = 0, nowCol = 0;
		int n = 0, m = 0;
		int[][] seats = null;
		public BookMyShow(int _n, int _m) {
			n = _n;
			m = _m;
			seats = new int[n][m + 1];
			for (int i = 0; i < n; i++) {
				seats[i][m] = 0;
			}
			totalCount = n * m;
		}

		public int[] gather(int k, int maxRow) {
			int[] res = new int[2];
			if (k > m || maxRow < nowRow) return res;
			if (m - nowCol >= k) {
				res[0] = nowRow;
				res[1] = nowCol;
				nowCol += k;
			} else if (nowRow + 1 <= maxRow) {
				nowRow++;
				nowCol = 0;
				res[0] = nowRow;
				res[1] = nowCol;
			}
			seats[nowRow][m] += k;
			totalCount -= k;
			return res;
		}

		public boolean scatter(int k, int maxRow) {
			if (k > totalCount || maxRow < nowRow) return false;
			for (int i = 0; k > 0 || i < seats.length; i++) {
				if (i <= nowRow) {
					k -= (m - seats[i][m]);
					seats[i][m] = m;
				} else {
					nowRow = i--;
				}
			}
			return true;
		}
	}
}
