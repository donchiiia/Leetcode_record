import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
Given an array nums of distinct integers, return all the possible permutations. 
You can return the answer in any order. 

 
 Example 1: 
 Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 Example 2: 
 Input: nums = [0,1]
Output: [[0,1],[1,0]]
 Example 3: 
 Input: nums = [1]
Output: [[1]]
 
 
 Constraints: 

 
 1 <= nums.length <= 6 
 -10 <= nums[i] <= 10 
 All the integers of nums are unique. 
 
 Related Topics 数组 回溯 👍 1834 👎 0

*/
  
  public class Permutations{
      public static void main(String[] args) {
           Solution solution = new Permutations().new Solution();
          int[] nums = {1,2,3};
          System.out.println(solution.permute(nums));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;

        if (length == 0) {
            return lists;
        }
        //回溯算法要求记录每次尝试的路径path，并且对于原数组使用布尔数组进行是否使用的判断
        boolean[] used = new boolean[length];
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(nums, 0, length, path, used, lists);
        return lists;
    }

      private void dfs(int[] nums, int depth, int length, ArrayDeque<Integer> path, boolean[] used, ArrayList<List<Integer>> lists) {
          if (depth == length) {
              //path保存的是深度优先搜索的路径，但java中为值引用，因此path只是整个过程中唯一一份的引用
              //如果是lists.add(path),最后递归返回至根节点时，path会被清空，所得结果就是一堆空列表
              lists.add(new ArrayList<>(path));
              return;
          }
          for (int i = 0; i <= length - 1; i++) {
              //used数组记录了nums中哪些元素被使用了
              if (!used[i]) {
                  path.addLast(nums[i]);
                  //将未使用的元素加入path后，将其标志数组used对应位置改成true
                  used[i] = true;
                  dfs(nums, depth + 1, length, path, used, lists);
                  //回溯算法的核心在于回溯访问之前要将相应的状态归位
                  used[i] = false;
                  path.removeLast();
              }
          }
      }
  }
//leetcode submit region end(Prohibit modification and deletion)

  }