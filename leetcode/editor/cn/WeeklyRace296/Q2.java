package WeeklyRace296;

public class Q2 {
	public static void main(String[] args) {
		Solution solution = new Q2().new Solution();
		System.out.println(solution.partitionArray(new int[]{9,13,5,14,0}, 8));
	}
	class Solution {
		public int partitionArray(int[] nums, int k) {
			boolean[] judge = new boolean[nums.length];
			int hasChanged = 0;
			int len = nums.length;
			int ans = 0;
			while (hasChanged < len) {
				int tag = -1;
				int min = -1, max = -1;
				for (int i = 0; i < nums.length; i++) {
					if (tag < 0 && !judge[i]) {
						tag = nums[i];
						judge[i] = true;
						hasChanged++;
						ans++;
						min = max = tag;
						continue;
					}
					if (tag >= 0 && Math.abs(nums[i] - min) <= k && Math.abs(nums[i] - max) <= k) {
						int tmin = min, tmax = max;
						min = Math.min(min, nums[i]);
						max = Math.max(max, nums[i]);
						if (Math.abs(max - min) <= k) {
							judge[i] = true;
							hasChanged++;
						} else {
							min = tmin;
							max = max;
						}
					}
				}
			}
			return ans;
		}
	}
}
