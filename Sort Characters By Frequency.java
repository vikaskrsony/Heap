Sort Characters By Frequency
/*
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.
Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
*/

class Solution {
    class Pair implements Comparable<Pair>{
        char ch;
        int freq;
        Pair(char ch , int freq){
            this.ch = ch;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            if(this.freq > p.freq){
                return 1;
            }else if(this.freq < p.freq){
                return -1;
            }else{
                if(this.ch > p.ch) return -1;
                return 1;
            }
        }
    }
    public String frequencySort(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : s.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for(char keys : hm.keySet()){
            pq.add(new Pair(keys, hm.get(keys)));
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 0){
            Pair pair  = pq.poll();
            char ch = pair.ch;
            int freq = pair.freq;
            while(freq --> 0){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
