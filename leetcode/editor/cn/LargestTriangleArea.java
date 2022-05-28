/**
Given an array of points on the X-Y plane points where points[i] = [xi, yi], 
return the area of the largest triangle that can be formed by any three different 
points. Answers within 10⁻⁵ of the actual answer will be accepted. 

 
 Example 1: 

 
Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
Output: 2.00000
Explanation: The five points are shown in the above figure. The red triangle is 
the largest.
 

 Example 2: 

 
Input: points = [[1,0],[0,0],[0,1]]
Output: 0.50000
 

 
 Constraints: 

 
 3 <= points.length <= 50 
 -50 <= xi, yi <= 50 
 All the given points are unique. 
 
 Related Topics 几何 数组 数学 👍 127 👎 0

*/

public class LargestTriangleArea{
    public static void main(String[] args) {
        Solution solution = new LargestTriangleArea().new Solution();
        System.out.println(solution.largestTriangleArea(new int[][]{
                {0, 0},
                {0, 1},
                {1, 0},
                {0, 1},
                {2, 0}
        }));
    }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double largestTriangleArea(int[][] points) {
        double sum = 0, x1, x2, y1, y2;
        int n = points.length;
        for(int i=0;i<n-2;i++)
        {
            for(int j=i+1;j<n-1;j++)
            {
                x1=points[j][0]-points[i][0];
                y1=points[j][1]-points[i][1];
                //第二个向量的终点
                for(int k=j+1;k<n;k++)
                {
                    x2=points[k][0]-points[i][0];
                    y2=points[k][1]-points[i][1];
                    //行列式计算面积
                    sum = Math.max(sum, myabs(x1 * y2 - x2 * y1));
                }
            }
        }

        return sum / 2;
    }
    private double myabs(double s){
        return s >= 0 ? s : -s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }