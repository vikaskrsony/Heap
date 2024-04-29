Nearly sorted
/*
Given an array of n elements, where each element is at most k away from its target position, you need to sort the array optimally.

Example 1:

Input:
n = 7, k = 3
arr[] = {6,5,3,2,8,10,9}
Output: 2 3 5 6 8 9 10
Explanation: The sorted array will be
2 3 5 6 8 9 10
*/

  class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        ArrayList<Integer> al = new ArrayList<>();
       PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < arr.length ; i++){
            pq.add(arr[i]);
            if(pq.size() > k){
                al.add(pq.poll());
            }
        }
        while(pq.size() > 0){
            al.add(pq.poll());
        }
        return al;
    }
}
