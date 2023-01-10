package editor.cn.WeeklyRace326;

public class Q3 {
	public static void main(String[] args) {
		Solution solution = new Q3().new Solution();
		System.out.println(solution.minimumPartition("165462", 60));
	}

	class Solution{
		public int minimumPartition(String s, int k) {
			char[] array = s.toCharArray();
			int res = 0, x = 1;
			for (char c : array) {
				int temp = c - '0';
				if (temp > k) return -1;
				x = x * 10 + temp;
				if (x > k){
					res++;
					x = temp;
				}
			}
			return res;
		}
	}
}
