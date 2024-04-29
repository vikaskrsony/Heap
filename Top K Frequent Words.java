Top K Frequent Words
/*
Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

Example 1:
Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
*/

class Solution {
    class Pair implements Comparable<Pair>{
        String word;
        int freq;
        Pair(String word, int freq){
            this.word = word;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            if(this.freq > p.freq){
                return -1;
            }else if(this.freq < p.freq){
                return 1;
            }else{
                return this.word.compareTo(p.word);
            }
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<String, Integer> hm = new HashMap<>();
        for(String str : words){
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }
        for(String str : hm.keySet()){
            pq.add(new Pair(str, hm.get(str)));
        }
        List<String> al = new ArrayList<>();
        while(k --> 0){
            al.add(pq.poll().word);
        }
        return al;
    }
}
