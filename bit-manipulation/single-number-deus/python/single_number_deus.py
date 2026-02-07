# https://leetcode.com/problems/single-number-ii/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        
        for num in nums:
            print(bin(num)[2:])

            print(num >> 0)