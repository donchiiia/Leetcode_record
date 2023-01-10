/**
There is a bi-directional graph with n vertices, where each vertex is labeled 
from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D 
integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge 
between vertex ui and vertex vi. Every vertex pair is connected by at most one edge,
 and no vertex has an edge to itself. 

 You want to determine if there is a valid path that exists from vertex source 
to vertex destination. 

 Given edges and the integers n, source, and destination, return true if there 
is a valid path from source to destination, or false otherwise. 

 
 Example 1: 
 
 
Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2
 

 Example 2: 
 
 
Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination =
 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.
 

 
 Constraints: 

 
 1 <= n <= 2 * 10⁵ 
 0 <= edges.length <= 2 * 10⁵ 
 edges[i].length == 2 
 0 <= ui, vi <= n - 1 
 ui != vi 
 0 <= source, destination <= n - 1 
 There are no duplicate edges. 
 There are no self edges. 
 

 Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 66 👎 0

*/

package editor.cn;
public class FindIfPathExistsInGraph{
    public static void main(String[] args) {
        Solution solution = new FindIfPathExistsInGraph().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] piles = new int[n];
        for (int i = 0; i < n; i++) {
            piles[i] = i;
        }
        for (int[] edge : edges) {
            merge(piles, edge[0], edge[1]);
        }
        return find(piles, source) == find(piles, destination);
    }

    public void merge(int[] edges, int i, int j){
        i = find(edges, i);
        j = find(edges, j);
        edges[i] = j;
    }
    public int find(int[] edges, int i){
        return edges[i] == i ? i : (edges[i] = find(edges, edges[i]));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}