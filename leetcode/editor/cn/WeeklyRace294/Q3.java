package WeeklyRace294;

import java.util.Arrays;
import java.util.concurrent.atomic.LongAccumulator;

public class Q3 {
	public static void main(String[] args) {
		Solution solution = new Q3().new Solution();
		System.out.println(solution.minimumLines(new int[][]{
				{72,98},{62,27},{32,7},{71,4},{25,19},{91,30},{52,73},{10,9},{99,71},{47,22},{19,30},{80,63},{18,15},
		{48,17},{77,16},{46,27},{66,87},{55,84},{65,38},{30,9},{50,42},{100,60},{75,73},{98,53},{22,80},{41,61},{37,47},
		{95,8},{51,81},{78,79},{57,95}}
));
	}
	class Solution{
		public int minimumLines(int[][] stockPrices) {
			if (stockPrices.length < 2) return 0;
			Arrays.sort(stockPrices, (a, b)->{return a[0] - b[0];});
			int res = 0;
			for (int i = 0; i < stockPrices.length - 2; i++) {
				int x1, x2, y1, y2;
				x1 = stockPrices[i + 1][0] - stockPrices[i][0];
				x2 = stockPrices[i + 2][0] - stockPrices[i + 1][0];
				y1 = stockPrices[i + 1][1] - stockPrices[i][1];
				y2 = stockPrices[i + 2][1] - stockPrices[i + 1][1];
				int gcd1 = gcd(x1, y1), gcd2 = gcd(x2, y2);
				if (x1 / gcd1 == x2 / gcd2 && y1 / gcd1 == y2 / gcd2 || x1 == x2 && x1 == 0 || y1 == y2 && y1 == 0) continue;
				else res++;
			}
			return res + 1;
		}

		private int gcd(int a, int b) {
			if (b == 0) return a;
			else return gcd(b, a % b);
		}
	}
}
