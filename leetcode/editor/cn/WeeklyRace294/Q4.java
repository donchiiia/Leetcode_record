package WeeklyRace294;

public class Q4 {
	public static void main(String[] args) {

	}
	class Solution {
		public int totalStrength(int[] strength) {
			long res = 0;
			for (int i : strength) {
				res += Math.pow(i, 2);
			}
			return 1;
		}
	}
}
