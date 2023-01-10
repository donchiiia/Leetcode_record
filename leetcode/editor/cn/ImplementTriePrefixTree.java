/**
A trie (pronounced as "try") or prefix tree is a tree data structure used to 
efficiently store and retrieve keys in a dataset of strings. There are various 
applications of this data structure, such as autocomplete and spellchecker. 

 Implement the Trie class: 

 
 Trie() Initializes the trie object. 
 void insert(String word) Inserts the string word into the trie. 
 boolean search(String word) Returns true if the string word is in the trie (i.
e., was inserted before), and false otherwise. 
 boolean startsWith(String prefix) Returns true if there is a previously 
inserted string word that has the prefix prefix, and false otherwise. 
 

 
 Example 1: 

 
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

 
 Constraints: 

 
 1 <= word.length, prefix.length <= 2000 
 word and prefix consist only of lowercase English letters. 
 At most 3 * 10⁴ calls in total will be made to insert, search, and startsWith. 

 

 Related Topics 设计 字典树 哈希表 字符串 👍 1354 👎 0

*/

package editor.cn;
public class ImplementTriePrefixTree{
    public static void main(String[] args) {
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    private Trie[] child;
    private boolean isEnd;
    public Trie() {
        child = new Trie[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (node.child[c - 'a'] == null) node.child[c - 'a'] = new Trie();
            node = node.child[c - 'a'];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            node = node.child[c - 'a'];
            if (node == null) return false;
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            node = node.child[c - 'a'];
            if (node == null) return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}