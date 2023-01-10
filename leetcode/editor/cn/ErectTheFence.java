package editor.cn;

import java.util.Arrays;

/**
You are given an array trees where trees[i] = [xi, yi] represents the location 
of a tree in the garden. 

 You are asked to fence the entire garden using the minimum length of rope as 
it is expensive. The garden is well fenced only if all the trees are enclosed. 

 Return the coordinates of trees that are exactly located on the fence 
perimeter. 

 
 Example 1: 

 
Input: points = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[3,3],[2,4],[4,2]]
 

 Example 2: 

 
Input: points = [[1,2],[2,2],[4,2]]
Output: [[4,2],[2,2],[1,2]]
 

 
 Constraints: 

 
 1 <= points.length <= 3000 
 points[i].length == 2 
 0 <= xi, yi <= 100 
 All the given points are unique. 
 
 Related Topics 几何 数组 数学 👍 145 👎 0

*/
  
  public class ErectTheFence{
      public static void main(String[] args) {
           Solution solution = new ErectTheFence().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees, (a, b)->{
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        int n = trees.length, top = 0;
        int[] stk = new int[n + 10];
        boolean[] vis = new boolean[n + 10];

        //起点不进行标记,stk[1]=0
        stk[++top] = 0;

        for (int i = 1; i < n; i++) {
            int[] c = trees[i];
            //如果栈数组中有两个以上的点，也就是说闭包集合中已经存在边的记录
            while (top >= 2) {
                int[] a = trees[stk[top - 1]];
                int[] b = trees[stk[top]];
                //stk闭包是符合要求的，现在检查栈最上面两点所构成的线段与c构成的线段是否满足上闭包的要求
                //如果满足就将c加入栈，否则删除b继续测试，直至栈中无法构成边或满足要求
                if (getArea(a, b, c) < 0) vis[stk[top--]] = false;
                else break;
            }
            //将符合闭包的点加入记录栈数组
            stk[++top] = i;
            //标记该点为以访问，辅助下闭包的节点访问
            vis[i] = true;
        }
        int size = top;
        for (int i = n - 1; i >= 0; i--) {
            //跳过存在于上闭包中点的检查
            if (vis[i]) continue;
            int[] c = trees[i];
            while (top > size) {
                int[] a = trees[stk[top - 1]];
                int[] b = trees[stk[top]];
                if (getArea(a, b, c) < 0) vis[stk[top--]] = false;
                else break;
            }
            stk[++top] = i;
            vis[i] = true;
        }
        int[][] res = new int[top - 1][2];
        for (int i = 1; i < top; i++) {
            res[i - 1] = trees[stk[i]];
        }
        return res;
    }
    //向量的叉乘运算：a x b = |a|*|b|*sin(a,b夹角)
    //这意味着结果大于零：a，b夹角小于0
    private int cross(int[] a, int[] b){
        return a[0] * b[1] - a[1] * b[0];
    }
    private int[] sub(int[] a, int[] b){
        return new int[]{a[0] - b[0], a[1] - b[1]};
    }
    private int getArea(int[] a, int[] b, int[] c){
        return cross(sub(b, a), sub(c, a));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }