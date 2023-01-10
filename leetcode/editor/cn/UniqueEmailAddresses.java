package editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
Every valid email consists of a local name and a domain name, separated by the 
'@' sign. Besides lowercase letters, the email may contain one or more '.' or '+
'. 

 
 For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.
com" is the domain name. 
 

 If you add periods '.' between some characters in the local name part of an 
email address, mail sent there will be forwarded to the same address without dots 
in the local name. Note that this rule does not apply to domain names. 

 
 For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the 
same email address. 
 

 If you add a plus '+' in the local name, everything after the first plus sign 
will be ignored. This allows certain emails to be filtered. Note that this rule 
does not apply to domain names. 

 
 For example, "m.y+name@email.com" will be forwarded to "my@email.com". 
 

 It is possible to use both of these rules at the same time. 

 Given an array of strings emails where we send one email to each emails[i], 
return the number of different addresses that actually receive mails. 

 
 Example 1: 

 
Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.
com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually 
receive mails.
 

 Example 2: 

 
Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
Output: 3
 

 
 Constraints: 

 
 1 <= emails.length <= 100 
 1 <= emails[i].length <= 100 
 emails[i] consist of lowercase English letters, '+', '.' and '@'. 
 Each emails[i] contains exactly one '@' character. 
 All local and domain names are non-empty. 
 Local names do not start with a '+' character. 
 Domain names end with the ".com" suffix. 
 
 Related Topics 数组 哈希表 字符串 👍 189 👎 0

*/

public class UniqueEmailAddresses{
    public static void main(String[] args) {
        Solution solution = new UniqueEmailAddresses().new Solution();
        System.out.println(solution.numUniqueEmails(new String[]{
                "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"
        }));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numUniqueEmails(String[] emails) {
        int ans = 0;
        Set set = new HashSet();
        for (String email : emails) {
            int len = email.length();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < len; i++) {
                char c = email.charAt(i);
                if (c == '+') {
                    while (email.charAt(i) != '@') {
                        i++;
                    }
                    i--;
                } else if (c == '.') {
                    continue;
                } else if (c == '@') {
                    stringBuffer.append(email, i, len);
                    break;
                } else {
                    stringBuffer.append(c);
                }
            }
            set.add(stringBuffer.toString());
        }
        return set.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }