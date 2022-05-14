import java.time.chrono.IsoChronology;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

/**
There are n cities. Some of them are connected, while some are not. If city a 
is connected directly with city b, and city b is connected directly with city c, 
then city a is connected indirectly with city c. 

 A province is a group of directly or indirectly connected cities and no other 
cities outside of the group. 

 You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the iᵗ
ʰ city and the jᵗʰ city are directly connected, and isConnected[i][j] = 0 
otherwise. 

 Return the total number of provinces. 

 
 Example 1: 

 
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
 

 Example 2: 

 
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

 
 Constraints: 

 
 1 <= n <= 200 
 n == isConnected.length 
 n == isConnected[i].length 
 isConnected[i][j] is 1 or 0. 
 isConnected[i][i] == 1 
 isConnected[i][j] == isConnected[j][i] 
 
 Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 761 👎 0

*/
  
  public class NumberOfProvinces{
      public static void main(String[] args) {
           Solution solution = new NumberOfProvinces().new Solution();
          System.out.println(solution.findCircleNum(new int[][]{
          {1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
          {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
          {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
          {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
          {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
          {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
          {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
          {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
          {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
          {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
          {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
          {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
          {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
          {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
          {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}

          }));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] rec = new int[isConnected.length];
        int count = 0;

        for (int i = 0; i < rec.length; i++) {
            rec[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    union(rec, i, j);
                }
            }
        }
        for (int i = 0; i < rec.length; i++) {
            if (rec[i] == i) count++;
        }
        return count;
    }
    private void union(int[] aim, int aimIndex, int index){
        aim[find(aim, index)] = find(aim, aimIndex);
    }
    private int find(int[] aim, int index){
        if (aim[index] != index){
            aim[index] = find(aim, aim[index]);
        }
        return aim[index];
    }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }
  /*    public int findCircleNum(int[][] isConnected) {
        int sum = isConnected.length, count = 0, tag = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[i][i] == 1) {
                isConnected[i][i] = -2;
                tag = 1;
            }
            for (int j = i; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1){
                    isConnected[j][i] = -2;
                    tag = 1;
                    rowSolver(isConnected, i, j);
                }
            }
            if (tag == 1) count++;
            tag = 0;
        }
        return count;
    }

    private void rowSolver(int[][] isConnected, int i, int j){
        if (i < 0 || i >= isConnected.length ||
            j < 0 || j >= isConnected[i].length ) return;
        isConnected[i][j] = -2;
        for (int k = 0; k < isConnected[j].length; k++) {
            if (isConnected[j][k] == 1) rowSolver(isConnected, j, k);
        }
    }*/