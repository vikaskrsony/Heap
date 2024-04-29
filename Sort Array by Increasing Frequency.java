Sort Array by Increasing Frequency
/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.
Example 1:
Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
 
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
                if(this.ele > p.ele) return -1;
                return 1;
            }
        }
    }
    public int[] frequencySort(int[] nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int ele : nums){
            hm.put(ele, hm.getOrDefault(ele, 0) + 1);
        }
        for(int keys : hm.keySet()){
            pq.add(new Pair(keys, hm.get(keys)));
        }
        int i = 0;
        while(pq.size() > 0){
            Pair pair = pq.poll();
            int ele = pair.ele;
            int freq = pair.freq;
            while(freq --> 0){
                nums[i++] = ele;
            }
        }
        return nums;
    }
}
