// https://leetcode.com/problems/insert-interval/?envType=study-plan-v2&envId=top-interview-150

// Time complexity: O(n) where n is the number of intervals
// Space complexity: O(n) where n is the number of intervals
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> outputIntervals = new ArrayList<>();
        boolean inserted = false;
        int newIntervalStart = newInterval[0];
        int newIntervalEnd = newInterval[1];

        for(int[] interval: intervals) {

            int currentIntervalStart = interval[0];
            int currentIntervalEnd = interval[1];

            if(currentIntervalEnd < newIntervalStart) {
                outputIntervals.add(interval);
            } else if(currentIntervalStart > newIntervalEnd) {
                
                if(!inserted) {
                    outputIntervals.add(new int[]{newIntervalStart, newIntervalEnd});
                    inserted = true;
                }

                outputIntervals.add(interval);
            } else {
                newIntervalStart = Math.min(newIntervalStart, currentIntervalStart);
                newIntervalEnd = Math.max(newIntervalEnd, currentIntervalEnd);
            }

        }

        if(!inserted) {
            outputIntervals.add(new int[]{newIntervalStart, newIntervalEnd});
        }

        return outputIntervals.toArray(new int[outputIntervals.size()][]);
    }
}