package rebuildTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations_46 {
	public static void main(String[] args) {
		Solution sol = new Permutations_46().new Solution();
		System.out.println(sol.permute(new int[]{1, 2, 3, 4}));
	}
	class Solution {
		List<List<Integer>> lists = new ArrayList<>();
		LinkedList<Integer> path = new LinkedList<>();
		boolean[] rec = null;

		public List<List<Integer>> permute(int[] nums) {
			rec = new boolean[nums.length];
			backTracking(nums, 0);
			return lists;
		}

		private void backTracking(int[] nums, int startIndex) {
			if (path.size() == nums.length) {
				lists.add(new ArrayList<>(path));
				return;
			}
			for (int i = 0; i <= nums.length - 1; i++) {
				if (!rec[i]) {
					path.add(nums[i]);
					rec[i] = true;
					backTracking(nums, i);
					rec[i] = false;
					path.removeLast();
				}
			}
		}
	}
}
