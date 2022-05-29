package DoubleWeekly79;

import jdk.javadoc.doclet.DocletEnvironment;

import java.util.HashMap;

public class Q2 {
	public static void main(String[] args) {
		Solution solution = new Q2().new Solution();
		System.out.println(solution.largestWordCount(new String[]{
				"Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"
		}, new String[]{
				"Alice","userTwo","userThree","Alice"
		}));
	}
	class Solution {
		public String largestWordCount(String[] messages, String[] senders) {
			int[] wordCount = new int[messages.length];
			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < messages.length; i++) {
				String[] s = messages[i].split(" ");
				wordCount[i] = s.length;
			}
			for (int i = 0; i < senders.length; i++) {
				map.merge(senders[i], wordCount[i], Integer::sum);
			}
			String res = null;
			int max = Integer.MIN_VALUE;
			for (String s : map.keySet()) {
				if (map.get(s) > max) {
					max = map.get(s);
					res = s;
				} else if (map.get(s) == max) {
					res = res.compareTo(s) < 0 ? s : res;
				}
			}
			return res;
		}
	}
}
