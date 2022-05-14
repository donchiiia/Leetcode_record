import java.util.HashMap;

/**
Given an array of points where points[i] = [xi, yi] represents a point on the X-
Y plane, return the maximum number of points that lie on the same straight line.
 

 
 Example 1: 

 
Input: points = [[1,1],[2,2],[3,3]]
Output: 3
 

 Example 2: 

 
Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
 

 
 Constraints: 

 
 1 <= points.length <= 300 
 points[i].length == 2 
 -10⁴ <= xi, yi <= 10⁴ 
 All the points are unique. 
 
 Related Topics 几何 数组 哈希表 数学 👍 402 👎 0

*/
  
  public class MaxPointsOnALine{
      public static void main(String[] args) {
           Solution solution = new MaxPointsOnALine().new Solution();
          System.out.println(solution.maxPoints(new int[][]{
                  {1, 1},
                  {2, 2},
                  {3, 3}
          }));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> set = new HashMap<>();
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                int dy = points[j][1] - points[i][1];
                int dx = points[j][0] - points[i][0];
                int div = gcd(dx, dy);
                String ori = (dy / div) + "/" + (dx / div);
                set.merge(ori, 1, Integer::sum);
                max = Math.max(max, set.get(ori));
            }
            ans = Math.max(ans, max + 1);
        }
        return ans;


/*        int n = points.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int[] x = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] y = points[j];
                int cnt = 2;
                for (int k = j + 1; k < n; k++) {
                    int[] p = points[k];
                    int s1 = (p[1] - y[1]) * (p[0] - x[0]);
                    int s2 = (p[1] - x[1]) * (p[0] - y[0]);
                    if (s1 == s2) cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;*/
    }
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }