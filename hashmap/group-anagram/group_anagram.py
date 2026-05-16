# https://leetcode.com/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150
# time complexity: O(N * K) where N is the number of words and k is the number of characters in the words

from collections import Counter

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        words_by_character_counts = {}

        for word in strs:
            curr_char_count = self.calculate_character_count(word)
            if curr_char_count in words_by_character_counts:
                words_by_character_counts.get(curr_char_count).append(word)
            else:
                words_by_character_counts[curr_char_count] = []
                words_by_character_counts[curr_char_count].append(word)

        return list(words_by_character_counts.values())

    def calculate_character_count(self, word: str):
        lst = [0] * 26
        
        for letter in word:
            index = ord(letter) - ord('a')
            lst[index] += 1

        return tuple(lst)