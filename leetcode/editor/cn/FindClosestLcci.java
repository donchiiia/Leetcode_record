package editor.cn;

/**
You have a large text file containing words. Given any two different words, 
find the shortest distance (in terms of number of words) between them in the file. 
If the operation will be repeated many times for the same file (but different 
pairs of words), can you optimize your solution? 

 Example: 

 
Input: words = ["I","am","a","student","from","a","university","in","a","city"],
 word1 = "a", word2 = "student"
Output: 1 

 Note: 

 
 words.length <= 100000 
 Related Topics 数组 字符串 👍 82 👎 0

*/

public class FindClosestLcci{
    public static void main(String[] args) {
        Solution solution = new FindClosestLcci().new Solution();
        System.out.println(solution.findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"},
                "a", "student"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int start = Integer.MIN_VALUE;
        int end = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                start = i;
                min = Math.min(min, Math.abs(end - start));
            }
            if (words[i].equals(word2)) {
                end = i;
                min = Math.min(min, Math.abs(end - start));
            }
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }