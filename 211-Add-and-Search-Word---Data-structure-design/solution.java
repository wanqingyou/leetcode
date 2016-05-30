public class WordDictionary {
    
    private Trie trieRoot;

    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        TrieNode() {
            this.isWord = false;
            children = new TrieNode[26];
        }
    }
    
    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
    
        public void addWord(String word) {
           TrieNode node = root, child = null;
           for (char c: word.toCharArray()) {
               child = node.children[c-'a'];
               if (child == null) {
                   child = new TrieNode();
                   node.children[c-'a'] = child;
               }
               node = child;
           }
           node.isWord = true;
        }
    
        public boolean search(String word) {
            return dfs(root, word);
        }
    
        private boolean dfs(TrieNode root, String word) {
            if ((!word.isEmpty() && word.charAt(0) != '.' && root.children[word.charAt(0)-'a'] == null) || (word.isEmpty() && !root.isWord)) {
                return false;
            }
            if (word.length() == 0 && root.isWord) {
                return true;
            } 
            boolean ret = false;
            char c = word.charAt(0);
            if (c == '.') {
                for (TrieNode node: root.children) {
                    if (node != null) {
                        ret = ret || dfs(node, word.substring(1));
                    }
                }
            } else {
                ret = dfs(root.children[c-'a'], word.substring(1));
            }
            return ret;
        }
    
    }
    
    WordDictionary() {
        trieRoot = new Trie();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        trieRoot.addWord(word);
    }
    
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return trieRoot.search(word);
    }
}
//http://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");