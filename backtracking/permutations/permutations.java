// https://leetcode.com/problems/permutations/description/?envType=study-plan-v2&envId=top-interview-150
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