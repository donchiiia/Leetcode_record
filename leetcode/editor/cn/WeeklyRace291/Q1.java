package WeeklyRace291;

public class Q1 {
	public static void main(String[] args) {
		Solution solution = new Q1().new Solution();
		System.out.println(solution.removeDigit("133235", '3'));
	}
	class Solution {
		public String removeDigit(String number, char digit) {
			int total = 0;
			for (int i = 0; i < number.length(); i++) {
				if (number.charAt(i) == digit) total++;
			}
			StringBuffer res = new StringBuffer(number);

			for (int i = 0; i < number.length(); i++) {
				if (number.charAt(i) == digit) {
					if (total == 1 || i != number.length() - 1 && number.charAt(i) < number.charAt(i + 1)) {
						res.deleteCharAt(i);
						break;
					}
					total--;
				}
			}
			return res.toString();
		}
	}
}
