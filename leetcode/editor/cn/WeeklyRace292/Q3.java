package WeeklyRace292;

public class Q3 {
	public static void main(String[] args) {
		Solution solution = new Q3().new Solution();
		System.out.println(solution.countTexts("222222222222222222222222222222222222"));
	}
	class Solution{
		int[] dial = new int[]{0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
		public int countTexts(String pressedKeys) {
			StringBuffer stringBuffer = new StringBuffer();
			long sum = 1;
			for (int i = 0; i < pressedKeys.length(); i++) {
				if (stringBuffer.isEmpty() || stringBuffer.charAt(stringBuffer.length() - 1) == pressedKeys.charAt(i)) {
					stringBuffer.append(pressedKeys.charAt(i));
					if (i != pressedKeys.length() - 1) continue;
				}
				if (i != pressedKeys.length() - 1) i--;
				sum *= helper(stringBuffer.toString());
				stringBuffer.delete(0, stringBuffer.length());
			}
			return (int)(sum % ((long) Math.pow(10, 9) + 7));
		}

		private int helper(String keys) {
			int temp = dial[keys.charAt(0) - '0'];
			int res = 0;
			for (int i = temp; i > 1; i--) {
				res += (Math.max(keys.length() - i + 1, 0));
			}
			return res + 1;
		}
	}
}
