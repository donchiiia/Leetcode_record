package WeeklyRace293;

import java.util.*;

public class Q1 {
	public static void main(String[] args) {
		Solution solution = new Q1().new Solution();
		System.out.println(solution.removeAnagrams(new String[]{"a", "b", "a"}));
	}
	class Solution{
		public List<String> removeAnagrams(String[] words) {
			List<String> list = new LinkedList<>();
			Deque<String> strings = new ArrayDeque<>();
			int wordsLength = words.length;
			int[] pre = new int[26], now = new int[26];
			for (int i = wordsLength - 1; i > 0; i--) {
				if (words[i].length() != words[i - 1].length()) {
//					list.add(words[i]);
					strings.addFirst(words[i]);
					continue;
				}
				now = getInfo(words[i]);
				pre = getInfo(words[i - 1]);
				if (!Arrays.toString(now).equals(Arrays.toString(pre))) {
//					list.add(words[i]);
					strings.addFirst(words[i]);
				}
			}
			strings.addFirst(words[0]);
			return strings.stream().toList();
//			list.add(words[0]);
//			return list;
		}
		private int[] getInfo(String ss){
			int[] rec = new int[26];
			for (char c : ss.toCharArray()) {
				rec[c - 'a']++;
			}
			return rec;
		}
	}
}
