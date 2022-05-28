package WeeklyRace293;

import javax.naming.NoPermissionException;
import java.util.LinkedList;

public class Q4 {
	public static void main(String[] args) {
		CountIntervals obj = new Q4().new CountIntervals();
		obj.add(2, 3);
		obj.add(7, 10);
		System.out.println(obj.count());
		obj.add(5, 8);
		System.out.println(obj.count());
	}
	class CountIntervals {
		LinkedList<int[]> list = null;
		public CountIntervals() {
			list = new LinkedList<>();
		}

		public void add(int left, int right) {
			list.add(new int[]{left, right});
			helper();
		}
		private void helper(){
			int[] temp = list.peek();
			for (int i = 0; i < list.size() - 1; i++) {
				int[] now = list.get(i);
				if (temp[1] < now[0] || temp[0] > now[1]) continue;
				else if (temp[0] >= now[0] && temp[1] <= now[1]) {
					list.remove(list.size() - 1);
					break;
				} else if (temp[0] <= now[0] && temp[1] >= now[1]) {
					list.remove(i);
					break;
				} else if (temp[0] < now[0] && temp[1] >= now[0] && temp[1] <= now[1]) {

				} /*else if (temp[])*/
			}
		}

		public int count() {
			int res = 0;
			for (int i = 0; i < list.size(); i++) {
				res += list.get(i)[1] - list.get(i)[0];
			}
			return res;
		}
	}
}
