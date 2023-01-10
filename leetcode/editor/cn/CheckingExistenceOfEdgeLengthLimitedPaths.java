  /**
An undirected graph of n nodes is defined by edgeList, where edgeList[i] = [ui, 
vi, disi] denotes an edge between nodes ui and vi with distance disi. Note that 
there may be multiple edges between two nodes. 

 Given an array queries, where queries[j] = [pj, qj, limitj], your task is to 
determine for each queries[j] whether there is a path between pj and qj such that 
each edge on the path has a distance strictly less than limitj . 

 Return a boolean array answer, where answer.length == queries.length and the jᵗ
ʰ value of answer is true if there is a path for queries[j] is true, and false 
otherwise. 

 
 Example 1: 
 
 
Input: n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],
[0,2,5]]
Output: [false,true]
Explanation: The above figure shows the given graph. Note that there are two 
overlapping edges between 0 and 1 with distances 2 and 16.
For the first query, between 0 and 1 there is no path where each distance is 
less than 2, thus we return false for this query.
For the second query, there is a path (0 -> 1 -> 2) of two edges with distances 
less than 5, thus we return true for this query.
 

 Example 2: 
 
 
Input: n = 5, edgeList = [[0,1,10],[1,2,5],[2,3,9],[3,4,13]], queries = [[0,4,14
],[1,4,13]]
Output: [true,false]
Exaplanation: The above figure shows the given graph.
 

 
 Constraints: 

 
 2 <= n <= 10⁵ 
 1 <= edgeList.length, queries.length <= 10⁵ 
 edgeList[i].length == 3 
 queries[j].length == 3 
 0 <= ui, vi, pj, qj <= n - 1 
 ui != vi 
 pj != qj 
 1 <= disi, limitj <= 10⁹ 
 There may be multiple edges between two nodes. 
 

 Related Topics 并查集 图 数组 排序 👍 116 👎 0

*/
  
  package editor.cn;

  import java.util.Arrays;

  public class CheckingExistenceOfEdgeLengthLimitedPaths{
      public static void main(String[] args) {
           Solution solution = new CheckingExistenceOfEdgeLengthLimitedPaths().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        /* 离线查询 + 并查集
        * 离线查询：给出所有查询问题，意味着可以不按照顺序依次求解问题。
        * 当按照顺序求解时，即以“在线查询思维解离线查询问题”
        *
        * 可以先对edgeList按照边长排序，queries按照limit排序。
        * 依次解决limit自小到大的问题，在edgeList中搜索所有edgeList小于limit的边构造
        * 并查集。再解决问题的同时，下一个非递减的limit也可继续再edgeList中查找新满足的，
        * 复用本次并查集，从而优化查询。
        * */

        // 对edgeList按变长排序
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);

        // 储存queries索引，方便结果输出
        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }

        // 对问题查询按limit排序
        Arrays.sort(index, (a, b) -> queries[a][2] - queries[b][2]);

        int[] uf = new int[n];
        // 初始化并查集
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }

        // 结果数组
        boolean[] res = new boolean[queries.length];

        // 用以标记上一次查询不满足limit的最小边，方便后续并查集新边的插入
        int k = 0;

        // 遍历排序后的queries数组，拿出limit去edgeList中merge
        for (int i : index) {
            while (k < edgeList.length && edgeList[k][2] < queries[i][2]) {
                merge(uf, edgeList[k][0], edgeList[k][1]);
                k++;
            }
            res[i] = find(uf, queries[i][0]) == find(uf, queries[i][1]);
        }
        return res;
    }

    public int find(int[] uf, int x){
        return uf[x] == x ? x : (x = find(uf, uf[x]));
    }

    public void merge(int[] uf, int x, int y){
        x = find(uf, uf[x]);
        y = find(uf, uf[y]);
        uf[y] = x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }