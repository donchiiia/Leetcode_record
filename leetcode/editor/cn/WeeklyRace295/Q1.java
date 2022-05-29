package WeeklyRace295;

public class Q1 {
	public static void main(String[] args) {
		Solution solution = new Q1().new Solution();
		System.out.println(solution.rearrangeCharacters("abcba", "abc"));
	}
	class Solution {
		public int rearrangeCharacters(String s, String target) {
			int[] ssource = new int[26], tsource = new int[26];
			for (char c : s.toCharArray()) {
				ssource[c - 'a']++;
			}
			for (char c : target.toCharArray()) {
				tsource[c - 'a']++;
			}
			int ans = 0;
			while (true) {
				for (int i = 0; i < tsource.length; i++) {
					ssource[i] -= tsource[i];
					if (ssource[i] < 0) return ans;
				}
				ans++;
			}
		}
	}
}
