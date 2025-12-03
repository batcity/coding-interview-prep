// https://leetcode.com/problems/permutations/description/?envType=study-plan-v2&envId=top-interview-150
//
// Time complexity: O(n · n!)
// Explanation: There are n! permutations, and each time we reach one we copy
// a list of size n (O(n) work). Although the recursion explores additional
// partial paths (~e · n! total calls), the O(1) work in those is dominated by
// the O(n) cost done n! times, giving overall O(n · n!).
//
// Space complexity: O(n * n!)
// Explanation: There are n! permutations, and each permutation contains n elements,
// so storing all permutations requires n * n! space.
// Note: The recursion stack, visited[] array, and currentList use O(n) auxiliary space,
// which is negligible compared to n * n! and therefore omitted in the final complexity.
import java.util.*;

class Solution {

    private List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, new boolean[nums.length], new ArrayList<Integer>());
        return output;
    }

    private void permute(int[] nums, boolean[] visited, List<Integer> currentList) {

        if(currentList.size()==nums.length) {
            output.add(new ArrayList<>(currentList));
            return;
        }

        for(int i=0; i<nums.length; i++) {

            int currentElement = nums[i];
            if(visited[i]) {
                continue;
            }

            currentList.add(currentElement);
            visited[i] = true;

            permute(nums, visited, currentList);

            currentList.remove(currentList.size()-1);
            visited[i] = false;
        }
    }
}