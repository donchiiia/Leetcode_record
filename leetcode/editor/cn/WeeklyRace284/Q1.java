package WeeklyRace284;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Solution solution = new Q1().new Solution();
        int[] nums = {1}, nums1 = {3, 4, 9, 1, 3, 9, 5};
        int key = 1, k = 1, key1 = 9, k1 = 1;
        System.out.println(solution.findKDistantIndices(nums, key, k));
        System.out.println(solution.findKDistantIndices(nums1, key1, k1));
    }
    class Solution {
        public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
            ArrayList<Integer> lists = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            int length = nums.length;

            if (length == 1) set.add(0);
            else
                for (int i = 0; i <= length - 1; i++) {
                    if (nums[i] == key) {
                        int n = i - k;
                        while (i + k >= n && n <= length - 1) {
                            if (n >= 0) {
                                set.add(n);
                            }
                            n++;
                        }
                    } else {
                        continue;
                    }
                }
            lists.addAll(set);
            Collections.sort(lists);
            return lists;
        }
    }
}

