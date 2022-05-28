package WeeklyRace294;

public class Q1 {
	public static void main(String[] args) {
		Solution solution = new Q1().new Solution();
		System.out.println(solution.percentageLetter("foobar", 'o'));
	}
	class Solution{
		public int percentageLetter(String s, char letter) {
			int len = s.length();
			int num = 0;
			for (char c : s.toCharArray()) {
				if (c == letter) num++;
			}
			return (int) 100.0 * num / len;
		}
	}
}
