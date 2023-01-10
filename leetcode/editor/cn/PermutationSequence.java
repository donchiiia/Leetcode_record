package editor.cn;

import java.util.ArrayList;

/**
The set [1, 2, 3, ..., n] contains a total of n! unique permutations. 

 By listing and labeling all of the permutations in order, we get the following 
sequence for n = 3: 

 
 "123" 
 "132" 
 "213" 
 "231" 
 "312" 
 "321" 
 

 Given n and k, return the kᵗʰ permutation sequence. 

 
 Example 1: 
 Input: n = 3, k = 3
Output: "213"
 Example 2: 
 Input: n = 4, k = 9
Output: "2314"
 Example 3: 
 Input: n = 3, k = 1
Output: "123"
 
 
 Constraints: 

 
 1 <= n <= 9 
 1 <= k <= n! 
 
 Related Topics 递归 数学 👍 640 👎 0

*/
  
  public class PermutationSequence{
      public static void main(String[] args) {
           Solution solution = new PermutationSequence().new Solution();
	      System.out.println(solution.getPermutation(3, 1));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getPermutation(int n, int k) {
	    ArrayList<Integer> list = new ArrayList<>();
	    String aim = "";
	    int sum = 1;
        int index = 0, i;

        for (i = 1; i < n; i++) {
            sum *= i;
	        list.add(i);
        }
	    list.add(i--);
		while(i>=1) {
			while (sum < k) {
				index++;
				k -= sum;
			}
			sum /= (i--);
			aim += list.remove(index);
			index = 0;
		}
	    aim += list.remove(index);
		return aim;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }