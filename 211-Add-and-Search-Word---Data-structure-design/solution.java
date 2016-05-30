public class WordDictionary {
    List<String> data=new ArrayList<String>();

    // Adds a word into the data structure.
    public void addWord(String word) {
        if(!data.contains(word)){
            data.add(word);
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(!isPattern(word)){
            return data.contains(word);
        }else{
            for(String str:data){
               if(str.matches(word)){
                   return true;
               }
            }
            return false;
        }
    }
    
    private boolean isPattern(String str){
        if(str.indexOf(".")!=-1){
            return true;
        }else{
            return false;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");