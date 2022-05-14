package WeeklyRace287;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Q1 {
	public static void main(String[] args) {
		Solution test = new Q1().new Solution();
		System.out.println(test.findWinners(new int[][]{{1,1000}}));
	}
	class Solution {
		public List<List<Integer>> findWinners(int[][] matches) {
			HashMap<Integer, Integer> winNums = new HashMap<>();
			HashMap<Integer, Integer> contestNums = new HashMap<>();
			ArrayList<List<Integer>> res = new ArrayList<>(2);
			LinkedList<Integer> rec0 = new LinkedList<>();
			LinkedList<Integer> rec1 = new LinkedList<>();
			int max = 0;

			for (int i = 0; i < matches.length; i++) {
				winNums.merge(matches[i][0], 1, Integer::sum);
				contestNums.merge(matches[i][0], 1, Integer::sum);
				contestNums.merge(matches[i][1], 1, Integer::sum);
				int maxt = matches[i][0] > matches[i][1] ? matches[i][0] : matches[i][1];
				max = max > maxt ? max : maxt;
			}
			for (int i = 1; i <= max; i++) {
				if (winNums.containsKey(i) && winNums.get(i) == contestNums.get(i)) rec0.add(i);
				if ((!winNums.containsKey(i) && contestNums.containsKey(i) && contestNums.get(i) == 1) || (winNums.containsKey(i) &&
						contestNums.get(i) == winNums.get(i) + 1)) rec1.add(i);
			}
			res.add(rec0);
			res.add(rec1);
			return res;
		}
	}
}
