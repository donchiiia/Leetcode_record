package WeeklyRace295;

import com.sun.nio.file.SensitivityWatchEventModifier;

public class Q2 {
	public static void main(String[] args) {
		Solution solution = new Q2().new Solution();
		System.out.println(solution.discountPrices("$76111 ab $6 $", 48));
	}
	class Solution {
		public String discountPrices(String sentence, int discount) {
			String[] s = sentence.split(" ");
			StringBuffer b = new StringBuffer();
			for (int i = 0; i < s.length; i++) {
				if (s[i].charAt(0) == '$' && isnum(s[i].substring(1))) {
					double res = Long.parseLong(s[i].substring(1, s[i].length())) * (1 - discount / 100.0);
					b.append("$" + String.format("%.2f", res) + " ");
				}
				else b.append(s[i] + " ");
			}
			b.deleteCharAt(b.length() - 1);
			return b.toString();
		}
		private boolean isnum(String s) {
			if (s.length() == 0) return false;
			for (int j = 0; j < s.toCharArray().length; j++) {
				if (s.charAt(j) < '0' || s.charAt(j) > '9') return false;
			}
			return true;
		}
	}
}
