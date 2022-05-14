package WeeklyRace291;

import java.util.HashMap;

public class Q2 {
	public static void main(String[] args) {
		Solution solution = new Q2().new Solution();
		System.out.println(solution.minimumCardPickup(new int[]{1,0,5,3}));
	}
	class Solution {
		public int minimumCardPickup(int[] cards) {
			int minDis = Integer.MAX_VALUE;
			HashMap<Integer, Integer> res = new HashMap<>();
			for (int i = 0; i < cards.length; i++) {
				if (res.keySet().contains(cards[i])) {
					minDis = Math.min(minDis, i - res.get(cards[i]));
				}
				res.put(cards[i], i);
			}
			return minDis == Integer.MAX_VALUE ? -1 : minDis + 1;
		}
	}
}
