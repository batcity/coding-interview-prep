# https://leetcode.com/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150

from collections import Counter

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        for word in strs:
            self.calculate_character_count(word)

    def calculate_character_count(self, word: str):
        # this won't work because the order of the character counts are different
        print(Counter(word))