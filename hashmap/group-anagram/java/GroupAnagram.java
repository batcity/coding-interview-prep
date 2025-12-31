// https://leetcode.com/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> wordsByCharCount= new HashMap<>();
        List<List<String>> outputList = new ArrayList<>();

        for(String str: strs) {
            String charCountMap = getCharCountMap(str);
            // System.out.println(charCountMap);

            if(wordsByCharCount.containsKey(charCountMap)) {
                wordsByCharCount.get(charCountMap).add(str);
                // System.out.println("this map exists");
            } else {
                wordsByCharCount.put(charCountMap, new ArrayList<>(List.of(str)));
            }
        }

        for(String charCountMap : wordsByCharCount.keySet()) {
            outputList.add(wordsByCharCount.get(charCountMap));
        }

        return outputList;
    }

    private String getCharCountMap(String str) {

        int[] charCount = new int[26];

        for(char c: str.toCharArray()) {
            int index = (int) c - 'a';
            charCount[index] = charCount[index] + 1;
        }

        return Arrays.toString(charCount);
    }

}