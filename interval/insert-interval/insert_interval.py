# https://leetcode.com/problems/insert-interval/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:

        output = []
        interval_start = newInterval[0]
        interval_end = newInterval[1]
        hit_new_interval = False

        if len(intervals)==0:
            return [newInterval]

        for interval in intervals:
            if interval[1] < interval_start:
                output.append(interval)
            elif interval[0] > interval_end:
                if hit_new_interval:
                    output.append([interval_start, interval_end])
                    hit_new_interval = False

                output.append(interval)
            else:
                interval_start = min(interval_start, interval[0])
                interval_end = max(interval_end, interval[1])
                hit_new_interval = True

        if hit_new_interval:
            output.append([interval_start, interval_end])

        return output