package LCCup;

public class Q2 {
	public static void main(String[] args) {
		Solution solution = new Q2().new Solution();
		System.out.println(solution.perfectMenu(
				new int[]{3, 2, 4, 1, 2},
				new int[][]{{1, 1, 0, 1, 2}, {2, 1, 4, 0, 0}, {3, 2, 4, 1, 0}},
				new int[][]{{3, 0}, {2, 0}, {7, 0}}, 5));
	}
	class Solution {
		public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
			int cookLen = cookbooks.length;
			int maxEnjoy = 0, Mx = 0;
			Mx = dfs(materials, 0, cookbooks, attribute, limit, maxEnjoy, cookLen, 0, Mx);
			return Mx;
		}

		private int dfs(int[] materials, int start, int[][] cookbooks, int[][] attribute, int limit, int maxEnjoy, int cookLen, int less, int Mx) {
			for (int material : materials) {
				if (material < 0 && less >= limit){
					if (Mx > maxEnjoy) Mx = maxEnjoy;
					return Mx;
				}
				else if (material < 0 && less < limit) return -1;
			}
			for (int i = start; i < cookLen; i++) {
				int mm = maxEnjoy;
				int tag = 0;
				for (int k = 0; k < cookbooks[i].length; k++) {
					materials[k] -= cookbooks[i][k];
					if (materials[k] < 0) tag = 1;
				}
				if (tag == 0) {
					maxEnjoy += attribute[i][0];
					less += attribute[i][1];
					mm = maxEnjoy;
					if (less >= limit) Mx = Math.max(Mx, mm);
					Mx = dfs(materials, i + 1, cookbooks, attribute, limit, maxEnjoy, cookLen, less, Mx);
					less -= attribute[i][1];
					maxEnjoy -= attribute[i][0];
				}
				for (int k = 0; k < cookbooks[i].length; k++) {
					materials[k] += cookbooks[i][k];
				}
				if (less >= limit) Mx = Math.max(Mx, mm);
				else Mx = -1;
			}
			return Mx;
		}
	}
}
