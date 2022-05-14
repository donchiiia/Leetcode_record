---
### 解决思路
- 对于此题，全排列可以形象地以满二叉树的叶子节点来考虑。其中根节点为空结点，往下一层根据给定数组的长度`nums.length`
  有相应多个子节点。每个结点代表着数组中对应的一个数字，以该结点为根结点构建的树，再往下一层就是nums数组剩余部分形成的子结点。
  ……以此往复直至叶子结点（使用完nums中所有的元素）。从每个结点到以该结点为根节点的树的叶子结点的路径就是遍历结果，整棵树
  构造而成的各个路径作为元素的集合就是题目所求全排列。
- 我们可以考虑使用dfs（深度优先搜索）来依次访问所有路径，从而得到对应的全排列。dfs是显式树形结构回溯算法的体现。
- 当我们使用完数组nums中的一个元素时要标记其已经被使用了，避免后续操作再次使用它，可以考虑使用一个标记数组used来记录，避免
  从头遍历nums带来的时间开销，将判断的复杂度降低为O(1)
- 由于路径path是动态变化的，我们完全可以全程只使用一个变量来记录，降低空间的使用率，只当其到达叶子结点时将对应的path加入要返回
  lists中。
---
### 具体实现
```java
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
```