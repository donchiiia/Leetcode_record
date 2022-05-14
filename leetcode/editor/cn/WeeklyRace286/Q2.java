package WeeklyRace286;

public class Q2 {
	public static void main(String[] args) {
		System.out.println(new Q2().minDeletion(new int[]{1, 1, 2, 2, 3, 3, 3, 3}));
	}
	public int minDeletion(int[] nums) {
		int count = 0;
		if (nums.length == 0) return 0;
		for (int i = 0; i < nums.length - 1; ) {
			if (nums[i] != nums[i + 1]) {
				i += 2;
			} else {
				count++;
				i++;
			}
		}
		if ((nums.length - count) % 2 == 1) count++;
		return count;
	}
}
