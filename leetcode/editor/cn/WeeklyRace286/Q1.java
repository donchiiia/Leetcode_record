package WeeklyRace286;

import org.xml.sax.ext.EntityResolver2;

import java.util.*;

/*
* 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：

answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
注意：列表中的整数可以按 任意 顺序返回。
*/
public class Q1 {
	public static void main(String[] args) {
		Q1 q = new Q1();
		List<List<Integer>> res = new ArrayList<>();
		res = q.findDifference(new int[]{1, 2, 3, 3}, new int[]{1,1,2,2});
		for (List k : res) {
			System.out.println(Arrays.toString(k.toArray()));
		}
	}
	public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		List<List<Integer>> res = new ArrayList<>(2);
		Set<Integer> res1 = new LinkedHashSet<Integer>(), res2 = new LinkedHashSet<Integer>();

		for (int i = 0; i < Math.max(nums1.length, nums2.length); i++) {
			if (i<nums1.length) res1.add(nums1[i]);
			if (i< nums2.length) res2.add(nums2[i]);
		}
		for (int j : nums2) {
			if (res1.contains(j)) {
				res1.remove(j);
				res2.remove(j);
				continue;
			}
		}
		res.add(new ArrayList<>(res1));
		res.add(new ArrayList<>(res2));
		return res;
	}
}
