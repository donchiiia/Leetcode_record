package editor.cn;

/**
Given a string queryIP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if 
IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type. 

 A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 
and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" 
are valid IPv4 addresses while "192.168.01.1", "192.168.1.00", and "192.168@1.1
" are invalid IPv4 addresses. 

 A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where: 

 
 1 <= xi.length <= 4 
 xi is a hexadecimal string which may contain digits, lowercase English letter (
'a' to 'f') and upper-case English letters ('A' to 'F'). 
 Leading zeros are allowed in xi. 
 

 For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8
A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334" 
and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses. 

 
 Example 1: 

 
Input: queryIP = "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".
 

 Example 2: 

 
Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".
 

 Example 3: 

 
Input: queryIP = "256.256.256.256"
Output: "Neither"
Explanation: This is neither a IPv4 address nor a IPv6 address.
 

 
 Constraints: 

 
 queryIP consists only of English letters, digits and the characters '.' and ':
'. 
 
 Related Topics 字符串 👍 166 👎 0

*/

public class ValidateIpAddress{
    public static void main(String[] args) {
        Solution solution = new ValidateIpAddress().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP == null) {
            return "Neither";
        }

        String regex0 = "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";
        String regexIPv4 = regex0 + "(\\." + regex0 + "){3}";
        String regex1 = "([\\da-fA-F]{1,4})";
        String regexIPv6 = regex1 + "(:" + regex1 + "){7}";

        String result = "Neither";
        if (queryIP.matches(regexIPv4)) {
            result = "IPv4";
        } else if (queryIP.matches(regexIPv6)) {
            result = "IPv6";
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }