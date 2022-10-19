//692. Top K Frequent Words

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        
        for(String word : words){
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        
        Pair[] arr = new Pair[freqMap.size()];
        int idx = 0;
        
        for(String word : freqMap.keySet()){
            arr[idx++] = new Pair(word, freqMap.get(word));
        }
        Arrays.sort(arr);
        
        List<String> ans = new ArrayList<>();
        
        
        for(int i = 0; i < k; i++){
            ans.add(arr[i].word);
        }
        
        return ans;
    }
    
    class Pair implements Comparable<Pair> {
        String word;
        int freq;
        
        Pair(String word, int freq){
            this.word = word;
            this.freq = freq;
        }
        
        public int compareTo(Pair o){
            if(this.freq == o.freq){
                return (this.word).compareTo(o.word);
            }
            
            return o.freq - this.freq;
        }
    }
}
