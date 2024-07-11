package Assignment;

public class Trie {

	   // Definition for a Trie node.
    private class TrieNode {
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26]; // For lowercase letters a-z
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    // Initialize the Trie object.
    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        System.out.println("Inserting a word : "+word);
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }

    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    // Helper method to search for a prefix or whole word in the trie.
    private TrieNode searchPrefix(String prefix) {
    
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        
        trie.insert("apple");
        System.out.println();
        
        System.out.println("Search for word: apple ");
        System.out.println(trie.search("apple")); // Output: true
        System.out.println();
        
        System.out.println("Search for word: app ");
        System.out.println(trie.search("app")); // Output: false
        System.out.println();
        
    	System.out.println("Searching for word starts with: app");
        System.out.println(trie.startsWith("app")); // Output: true
        System.out.println();

        trie.insert("app");
        System.out.println();
        
        System.out.println("Search for word: app ");
        System.out.println(trie.search("app")); // Output: true
    }

}
