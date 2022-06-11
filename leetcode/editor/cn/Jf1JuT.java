import java.util.*;

/**
English description is not available for the problem. Please switch to Chinese. 

 Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 数组 字符串 👍 42 👎 0

*/

public class Jf1JuT{
    public static void main(String[] args) {
        Solution solution = new Jf1JuT().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String alienOrder(String[] words) {
        boolean has[]=new boolean[26];//记录字母是否出现过
        char c[][]=new char[words.length][];
        for(int i=0;i<c.length;i++){
            c[i]=words[i].toCharArray();
            for(int j=0;j<c[i].length;j++){has[c[i][j]-'a']=true;}
        }
        List<Integer> son[]=new List[26];
        Set<Integer> father[]=new Set[26];
        for(int i=0;i<26;i++){
            son[i]=new ArrayList<>();
            father[i]=new HashSet<>();
        }
        //以下正反建图：
        for(int i=1;i<c.length;i++){
            int p=0;
            while(p<Math.min(c[i-1].length,c[i].length)&&c[i-1][p]==c[i][p]){p++;}
            if(p==c[i].length&&p<c[i-1].length){return "";}//后者为前者的真前缀，报警了啊
            if(p<c[i].length&&p<c[i-1].length){
                //此时遇到的首个不同字母，有关字母表顺序，主注意去重
                if(father[c[i][p]-'a'].add(c[i-1][p]-'a')){son[c[i-1][p]-'a'].add(c[i][p]-'a');}
            }
        }
        Queue<Integer> q=new LinkedList<>();
        StringBuilder ans=new StringBuilder();
        //先把没有父节点的字母收集起来，这些是字母中的前排
        for(int i=0;i<26;i++){
            if(has[i]&&father[i].size()==0){
                ans.append((char)(i+'a'));
                has[i]=false;
                q.add(i);
            }
        }
        //下边开始BFS：
        while(q.size()>0){
            int a=q.poll();
            for(int i=0;i<son[a].size();i++){
                int b=son[a].get(i);
                father[b].remove(a);
                if(father[b].size()==0){
                    ans.append((char)(b+'a'));
                    has[b]=false;
                    q.add(b);
                }
            }
        }
        //下边开始检查有无set不是空的，有的话说明存在环，顺便把无顺序关系的字母加进来
        for(int i=0;i<26;i++){
            if(father[i].size()>0){return "";}
            if(has[i]){ans.append((char)(i+'a'));}
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }