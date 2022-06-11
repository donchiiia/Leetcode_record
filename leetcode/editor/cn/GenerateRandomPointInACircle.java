import java.util.Random;

/**
Given the radius and the position of the center of a circle, implement the 
function randPoint which generates a uniform random point inside the circle. 

 Implement the Solution class: 

 
 Solution(double radius, double x_center, double y_center) initializes the 
object with the radius of the circle radius and the position of the center (x_center,
 y_center). 
 randPoint() returns a random point inside the circle. A point on the 
circumference of the circle is considered to be in the circle. The answer is returned as 
an array [x, y]. 
 

 
 Example 1: 

 
Input
["Solution", "randPoint", "randPoint", "randPoint"]
[[1.0, 0.0, 0.0], [], [], []]
Output
[null, [-0.02493, -0.38077], [0.82314, 0.38945], [0.36572, 0.17248]]

Explanation
Solution solution = new Solution(1.0, 0.0, 0.0);
solution.randPoint(); // return [-0.02493, -0.38077]
solution.randPoint(); // return [0.82314, 0.38945]
solution.randPoint(); // return [0.36572, 0.17248]
 

 
 Constraints: 

 
 0 < radius <= 10⁸ 
 -10⁷ <= x_center, y_center <= 10⁷ 
 At most 3 * 10⁴ calls will be made to randPoint. 
 
 Related Topics 几何 数学 拒绝采样 随机化 👍 91 👎 0

*/

public class GenerateRandomPointInACircle{
    public static void main(String[] args) {
//        Solution solution = new GenerateRandomPointInACircle().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private final double xc;
    private final double yc;
    private final double r;
    public Solution(double radius, double x_center, double y_center) {
        xc = x_center;
        yc = y_center;
        r = radius;
    }
    
    public double[] randPoint() {
        Random random = new Random();
        while (true) {
            double xrandom = random.nextDouble() * 2 * r - r;
            double yrandom = random.nextDouble() * 2 * r - r;
            if (Math.sqrt(xrandom * xrandom + yrandom * yrandom) < r) {
                return new double[]{xrandom + xc, yrandom + yc};
            }
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
//leetcode submit region end(Prohibit modification and deletion)

  }