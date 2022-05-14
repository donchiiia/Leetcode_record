package WeeklyRace287;

public class Q2 {
	public static void main(String[] args) {
		Solution test = new Q2(). new Solution();
		System.out.println(test.convertTime("02:30", "04:35"));
	}
	class Solution {
		public int convertTime(String current, String correct) {
			String[] cur = current.split(":");
			String[] cor = correct.split(":");
			int[] curt = new int[2], cort = new int[2];
			curt[0] = Integer.parseInt(cur[0]);
			curt[1] = Integer.parseInt(cur[1]);
			cort[0] = Integer.parseInt(cor[0]);
			cort[1] = Integer.parseInt(cor[1]);

			int count = 0, curtim = curt[0] * 60 + curt[1],cortim = cort[0] * 60 + cort[1];
			while (curtim < cortim){
				if (curtim + 60 <= cortim) curtim += 60;
				else if (curtim + 15 <= cortim) curtim += 15;
				else if (curtim + 5 <= cortim) curtim += 5;
				else if (curtim + 1 <= cortim) curtim += 1;
 				count++;
			}
			return count;
		}
	}
}
