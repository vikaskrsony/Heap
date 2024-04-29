Top K Frequent Elements
/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
*/
class Solution {
    class Pair implements Comparable<Pair>{
        int ele;
        int freq;
        Pair(int ele, int freq){
            this.ele = ele;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            if(this.freq > p.freq){
                return 1;
            }else if(this.freq < p.freq){
                return -1;
            }else{
                return p.ele - this.ele;
            }
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for(int keys : hm.keySet()){
            pq.add(new Pair(keys, hm.get(keys)));
        }
        int res[] = new int[k];
        int i = 0;
        while(k --> 0){
            res[i++] = pq.poll().ele;
        }
        return res;
    }
}
