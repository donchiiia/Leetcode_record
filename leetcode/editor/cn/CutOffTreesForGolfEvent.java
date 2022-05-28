/**
/**
 You are asked to cut off all the trees in a forest for a golf event. The 
forest is represented as an m x n matrix. In this matrix: 

 
 0 means the cell cannot be walked through. 
 1 represents an empty cell that can be walked through. 
 A number greater than 1 represents a tree in a cell that can be walked through,
 and this number is the tree's height. 
 

 In one step, you can walk in any of the four directions: north, east, south, 
and west. If you are standing in a cell with a tree, you can choose whether to 
cut it off. 

 You must cut off the trees in order from shortest to tallest. When you cut off 
a tree, the value at its cell becomes 1 (an empty cell). 

 Starting from the point (0, 0), return the minimum steps you need to walk to 
cut off all the trees. If you cannot cut off all the trees, return -1. 

 You are guaranteed that no two trees have the same height, and there is at 
least one tree needs to be cut off. 

 
 Example 1: 

 
Input: forest = [[1,2,3],[0,0,4],[7,6,5]]
Output: 6
Explanation: Following the path above allows you to cut off the trees from 
shortest to tallest in 6 steps.
 

 Example 2: 

 
Input: forest = [[1,2,3],[0,0,0],[7,6,5]]
Output: -1
Explanation: The trees in the bottom row cannot be accessed as the middle row 
is blocked.
 

 Example 3: 

 
Input: forest = [[2,3,4],[0,0,5],[8,7,6]]
Output: 6
Explanation: You can follow the same path as Example 1 to cut off all the trees.

Note that you can cut off the first tree at (0, 0) before making any steps.
 

 
 Constraints: 

 
 m == forest.length 
 n == forest[i].length 
 1 <= m, n <= 50 
 0 <= forest[i][j] <= 10⁹ 
 
 Related Topics 广度优先搜索 数组 矩阵 堆（优先队列） 👍 135 👎 0 
*/

import org.w3c.dom.ls.LSInput;

import java.util.*;

public class CutOffTreesForGolfEvent{
    public static void main(String[] args) {
        Solution solution = new CutOffTreesForGolfEvent().new Solution();

    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int N = 50;
    int[][] rec = new int[N][N];
    int n, m;
    List<int[]> list = new ArrayList<>();
    public int cutOffTree(List<List<Integer>> forest) {
        n = forest.size();
        m = forest.get(0).size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rec[i][j] = forest.get(i).get(j);
                if (rec[i][j] > 1) list.add(new int[]{rec[i][j], i, j});
            }
        }
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        if (rec[0][0] == 0) return -1;
        int x = 0, y = 0, ans = 0;
        for (int[] row : list) {
            int nx = row[1], ny = row[2];
            int d = bfs(x, y, nx, ny);
            if (d == -1) return -1;
            ans += d;
            x = nx;
            y = ny;
        }
        return ans;
    }

    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int bfs(int x, int y, int nx, int ny){
        if (x == nx && y == ny) return 0;
        boolean[][] vis = new boolean[n][m];
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{x, y});
        vis[x][y] = true;
        int ans = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                int[] temp = deque.pollFirst();
                int x1 = temp[0], y1 = temp[1];
                for (int[] r : dir) {
                    int dx = x1 + r[0], dy = y1 + r[1];
                    if (dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
                    if (rec[dx][dy] == 0 || vis[dx][dy]) continue;
                    if (dx == nx && dy == ny) return ans + 1;
                    deque.addLast(new int[]{dx, dy});
                    vis[dx][dy] = true;
                }
            }
            ans++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }