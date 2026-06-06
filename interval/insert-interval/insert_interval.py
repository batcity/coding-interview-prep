# https://leetcode.com/problems/insert-interval/?envType=study-plan-v2&envId=top-interview-150
# Time Complexity: O(n) where n is the number of intervals
# Space Complexity: O(n) where n is the number of intervals

class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        output = []
        i = 0
        n = len(intervals)
        
        # Phase 1: Add all intervals that come strictly BEFORE newInterval
        while i < n and intervals[i][1] < newInterval[0]:
            output.append(intervals[i])
            i += 1
            
        # Phase 2: Merge all overlapping intervals with newInterval
        while i < n and intervals[i][0] <= newInterval[1]:
            newInterval[0] = min(newInterval[0], intervals[i][0])
            newInterval[1] = max(newInterval[1], intervals[i][1])
            i += 1
        
        # Insert the safely merged newInterval
        output.append(newInterval)
        
        # Phase 3: Add all intervals that come strictly AFTER newInterval
        output.extend(intervals[i:])
            
        return output