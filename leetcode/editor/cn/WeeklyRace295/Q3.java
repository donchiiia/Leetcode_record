package WeeklyRace295;

import javax.print.attribute.standard.MediaSize;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Q3 {
	public static void main(String[] args) {
		Solution solution = new Q3().new Solution();
		System.out.println(solution.totalSteps(new int[]{7, 14, 4, 14, 13, 2, 6, 13}));
	}
	class Solution {
		public int totalSteps(int[] nums) {
			int max = 0;
			Deque<Integer> list = new LinkedList<>();
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] > nums[i + 1]) list.add(i);
			}
			int tag = nums.length;
			while (!list.isEmpty()) {
				int rem = list.peekLast();
				for (int i = list.pollLast(), j = i + 1; i < tag - 1 && j < tag; i++, j++) {
					if (nums[i] > nums[j]) {
						max = Math.max(max, j - i);
						i--;
					} else i = j - 1;
				}
				tag = rem + 1;
			}
			return max;
		}
	}
}
