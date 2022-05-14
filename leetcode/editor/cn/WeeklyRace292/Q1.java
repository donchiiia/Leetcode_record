package WeeklyRace292;

public class Q1 {
	public static void main(String[] args) {
		Solutin solutin = new Q1().new Solutin();
		System.out.println(solutin.largestGoodInteger("2300019"));
	}
	class Solutin{
		public String largestGoodInteger(String num) {
			int max = Integer.MIN_VALUE;
			for (int i = 0, j = 2; i < num.length() - 2; i++) {
				int temp = -1;
				if ((temp = subStringtoInt(num.substring(i, i + 3))) == -1) continue;
				max = Math.max(max, temp);
			}
			return max < 0 ? null : (max == 0 ? "000" : Integer.toString(max));
		}

		private int subStringtoInt(String substring) {
			char[] ar = substring.toCharArray();
			if (ar[0] == ar[1] && ar[1] == ar[2]) {
				return (ar[0] - '0') * 111;
			}
			else return -1;
		}
	}
}
