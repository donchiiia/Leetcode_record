/**
A valid IP address consists of exactly four integers separated by single dots. 
Each integer is between 0 and 255 (inclusive) and cannot have leading zeros. 

 
 For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.2
55.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 
 

 Given a string s containing only digits, return all possible valid IP 
addresses that can be formed by inserting dots into s. You are not allowed to reorder or 
remove any digits in s. You may return the valid IP addresses in any order. 

 
 Example 1: 

 
Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
 

 Example 2: 

 
Input: s = "0000"
Output: ["0.0.0.0"]
 

 Example 3: 

 
Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 

 
 Constraints: 

 
 1 <= s.length <= 20 
 s consists of digits only. 
 

 Related Topics 字符串 回溯 👍 1111 👎 0

*/

package editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses{
    public static void main(String[] args) {
//        Solution solution = new Solution();

    }
    class Solution {
        List<String> res;
        List<String> temp;
        String s;
        public List<String> restoreIpAddresses(String s) {
            int n = s.length();
            this.s = s;
            res = new ArrayList<>();
            temp = new ArrayList<>();
            if (n < 4 || n > 12) return res;
            dfs(0);
            return res;
        }
        private void dfs(int start){
            if (start == s.length() && temp.size() == 4) {
                String str = temp.get(0);
                for (int i = 1; i <= 3; i++) {
                    str = str + "." + temp.get(i);
                }
                res.add(str);
                return;
            }
            if (start != s.length() && temp.size() == 4) return;
            for (int len = 1; len <= 3; len++) {
                if (start + len - 1 >= s.length()) return;
                if (len != 1 && s.charAt(start) == '0') return;
                String substring = s.substring(start, start + len);
                if (len == 3 && Integer.parseInt(substring) > 255) return;
                temp.add(substring);
                dfs(start + len);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

//leetcode submit region begin(Prohibit modification and deletion)

//leetcode submit region end(Prohibit modification and deletion)
