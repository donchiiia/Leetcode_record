package editor.cn;

import java.util.Arrays;

/**
An image is represented by an m x n integer grid image where image[i][j] 
represents the pixel value of the image. 

 You are also given three integers sr, sc, and newColor. You should perform a 
flood fill on the image starting from the pixel image[sr][sc]. 

 To perform a flood fill, consider the starting pixel, plus any pixels 
connected 4-directionally to the starting pixel of the same color as the starting pixel, 
plus any pixels connected 4-directionally to those pixels (also with the same 
color), and so on. Replace the color of all of the aforementioned pixels with 
newColor. 

 Return the modified image after performing the flood fill. 

 
 Example 1: 

 
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e.,
 the red pixel), all pixels connected by a path of the same color as the 
starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally 
connected to the starting pixel.
 

 Example 2: 

 
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]
 

 
 Constraints: 

 
 m == image.length 
 n == image[i].length 
 1 <= m, n <= 50 
 0 <= image[i][j], newColor < 2¹⁶ 
 0 <= sr < m 
 0 <= sc < n 
 
 Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 299 👎 0

*/
  
  public class FloodFill{
      public static void main(String[] args) {
           Solution solution = new FloodFill().new Solution();
          int[][] image = new int[][]{{0,0,0}, {0, 1,1}};
          solution.floodFill(image, 1, 1, 1);
          for (int[] s : image) {
              System.out.println(Arrays.toString(s));
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (sr >= 0 && sc >= 0 && sr < image.length && sc < image[0].length) {
            dfs(image, sr, sc, newColor, image[sr][sc]);
        }
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int newColor, int eq){
        if (sr >= 0 && sc >= 0 && sr < image.length && sc < image[0].length) {
            if (image[sr][sc] == eq && eq != newColor) {
                image[sr][sc] = newColor;
                dfs(image, sr - 1, sc, newColor, eq);
                dfs(image, sr + 1, sc, newColor, eq);
                dfs(image, sr, sc + 1, newColor, eq);
                dfs(image, sr, sc - 1, newColor, eq);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }