// https://leetcode.com/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150

// Time complexity: O(N.K)
// Space Complexity: O(N · K) due to storing grouped strings and keys

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> wordsByCharCount= new HashMap<>();

        for(String str: strs) {
            String charCountMap = getCharCountMap(str);

            if(wordsByCharCount.containsKey(charCountMap)) {
                wordsByCharCount.get(charCountMap).add(str);
            } else {
                var newList = new ArrayList<>(List.of(str));
                wordsByCharCount.put(charCountMap, newList);
            }
        }

        return new ArrayList(wordsByCharCount.values());
    }

    private String getCharCountMap(String str) {

        int[] charCount = new int[26];
        int size = str.length();
        int curr = 0;

        while(curr < size) {
            char c = str.charAt(curr);
            int index = (int) c - 'a';
            charCount[index] = charCount[index] + 1;
            curr++;
        }

        return Arrays.toString(charCount);
    }
}