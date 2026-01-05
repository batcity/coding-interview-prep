// https://leetcode.com/problems/insert-interval/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] outputIntervals = new int[][intervals.length];

        int prevIntervalStart = intervals[0][0];
        int prevIntervalEnd = intervals[0][1];

        for(int[] interval: intervals) {  

            int newIntervalStart = newInterval[1];
            int newIntervalEnd = newInterval[1];
            boolean insertionInProgress = false;

            if(newIntervalStart < prevIntervalStart) {
                prevIntervalStart = newIntervalStart;
                insertionInProgress = true;
            }

            // what do I do here?
            if(newIntervalStart < prevIntervalEnd) {
                
            }

            if(newIntervalEnd > prevIntervalEnd) {
                prevIntervalEnd = newIntervalEnd;
            }

            if(!insertionInProgress) {

            }
        }
        
    }
}