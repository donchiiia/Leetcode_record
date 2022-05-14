import java.util.*;

/**
A gene string can be represented by an 8-character long string, with choices 
from 'A', 'C', 'G', and 'T'. 

 Suppose we need to investigate a mutation from a gene string start to a gene 
string end where one mutation is defined as one single character changed in the 
gene string. 

 
 For example, "AACCGGTT" --> "AACCGGTA" is one mutation. 
 

 There is also a gene bank bank that records all the valid gene mutations. A 
gene must be in bank to make it a valid gene string. 

 Given the two gene strings start and end and the gene bank bank, return the 
minimum number of mutations needed to mutate from start to end. If there is no 
such a mutation, return -1. 

 Note that the starting point is assumed to be valid, so it might not be 
included in the bank. 

 
 Example 1: 

 
Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1
 

 Example 2: 

 
Input: start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA",
"AAACGGTA"]
Output: 2
 

 Example 3: 

 
Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC",
"AACCCCCC"]
Output: 3
 

 
 Constraints: 

 
 start.length == 8 
 end.length == 8 
 0 <= bank.length <= 10 
 bank[i].length == 8 
 start, end, and bank[i] consist of only the characters ['A', 'C', 'G', 'T']. 
 
 Related Topics 广度优先搜索 哈希表 字符串 👍 173 👎 0

*/
  
  public class MinimumGeneticMutation{
      public static void main(String[] args) {
           Solution solution = new MinimumGeneticMutation().new Solution();
          System.out.println(solution.minMutation("AAAAACCC", "AACCCCCC", new String[]{
                  "AAAACCCC", "AAACCCCC", "AACCCCCC"
          }));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static char[] letters = new char[]{'A', 'G', 'C', 'T'};
    public int minMutation(String start, String end, String[] bank) {
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<String>(bank.length);
        ArrayDeque<String> queue = new ArrayDeque<>();
        int step = 0;

        set.addAll(List.of(bank));
        queue.offer(start);
        map.put(start, step);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String poll = queue.poll();
                char[] cs = poll.toCharArray();
                step = map.get(poll);
                for (int i = 0; i < poll.length(); i++) {
                    for (char letter : letters) {
                        if (cs[i] == letter) continue;
                        char[] clone = cs.clone();
                        clone[i] = letter;
                        String s = new String(clone);
                        if (!set.contains(s) || map.containsKey(s)) continue;
                        if (s.equals(end)) return step + 1;
                        map.put(s, step + 1);
                        queue.offer(s);
                    }
                }
            }
        }
        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }