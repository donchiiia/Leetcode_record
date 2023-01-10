package editor.cn.WeeklyRace326;

public class Q1 {
	public static void main(String[] args) {
		Solution solution = new Q1().new Solution();
		System.out.println(solution.countDigits(1248));
	}

	class Solution {
		public int countDigits(int num) {
			int temp = num, res = 0;
			while (temp != 0){
				if (num % (temp % 10) == 0){
					res++;
				}
				temp /= 10;
			}
			return res;
		}
	}
}
