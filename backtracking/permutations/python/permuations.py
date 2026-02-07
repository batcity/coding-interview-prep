# https://leetcode.com/problems/permutations/?envType=study-plan-v2&envId=top-interview-150
# Time Complexity: O(n · n!) — there are n! permutations, and copying each permutation costs O(n)
# Space Complexity: O(n · n!) for storing all permutations
# Auxiliary Space: O(n) for recursion depth and current path

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        currentDict = {}
        outputList = list()

        self.findPermutations(nums, currentDict, outputList)

        return outputList


    def findPermutations(self, nums: List[int], currentDict: Dict[int], outputList: List[List[int]]):

        if len(currentDict) is len(nums):
            outputList.append(list(currentDict))
            return

        for element in nums:
            if element not in currentDict:
                currentDict[element] = None
                self.findPermutations(nums, currentDict, outputList)
                currentDict.pop(element, None)
