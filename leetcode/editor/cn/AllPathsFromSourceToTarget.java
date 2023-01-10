package editor.cn;

import java.util.*;

/**
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find 
all possible paths from node 0 to node n - 1 and return them in any order. 

 The graph is given as follows: graph[i] is a list of all nodes you can visit 
from node i (i.e., there is a directed edge from node i to node graph[i][j]). 

 
 Example 1: 

 
Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 

 Example 2: 

 
Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 

 
 Constraints: 

 
 n == graph.length 
 2 <= n <= 15 
 0 <= graph[i][j] < n 
 graph[i][j] != i (i.e., there will be no self-loops). 
 All the elements of graph[i] are unique. 
 The input graph is guaranteed to be a DAG. 
 
 Related Topics 深度优先搜索 广度优先搜索 图 回溯 👍 269 👎 0

*/
  
  public class AllPathsFromSourceToTarget{
      public static void main(String[] args) {
           Solution solution = new AllPathsFromSourceToTarget().new Solution();
          System.out.println(solution.allPathsSourceTarget(new int[][]{
                  {4,3,1},
                  {3,2,4},
                  {3},
                  {4},
                  {}
          }));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> lists = new LinkedList<>();

        travel(graph, 0, new ArrayList<Integer>(), lists);
        return lists;
    }

    private void travel(int[][] graph, int i, ArrayList<Integer> integers, List<List<Integer>> lists) {
        if (i == graph.length - 1) {
            integers.add(i);
            lists.add(new ArrayList<>(integers));
            integers.remove(integers.size() - 1);
            return;
        }
        integers.add(i);
        for (int k : graph[i]) {
            travel(graph, k, integers, lists);
        }
        integers.remove(integers.size() - 1);
    }

      }
//leetcode submit region end(Prohibit modification and deletion)

  }