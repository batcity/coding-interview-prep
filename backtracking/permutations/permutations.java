// https://leetcode.com/problems/permutations/description/?envType=study-plan-v2&envId=top-interview-150
import java.util.*;

class Solution {

    private List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, new ArrayList<Integer>());
        return output;
    }

    private void permute(int[] nums, List<Integer> currentList) {

        if(currentList.size()==nums.length) {
            output.add(currentList);
            return;
        }

        for(int i=0; i<nums.length; i++) {

            int currentElement = nums[i];
            if(currentList.contains(currentElement)) {
                continue;
            }

            List<Integer> copiedList = new ArrayList<>();
            copiedList.addAll(currentList);
            copiedList.add(currentElement);
            permute(nums, copiedList);
        }
    }
}