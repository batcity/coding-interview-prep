// Given an integer list, nums, find the maximum values in all the contiguous subarrays (windows) of size w.
import java.util.*;

class SlidingWindowMaximum {
	public static int[] findMaxSlidingWindow(int[] nums, int w) {

    int start = 0;
    int end = 0;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    int[] output = new int[nums.length + 1 - w];
    int outputIndex = 0;

    while(end < w - 1) {
      maxHeap.add(nums[end]);
      end++;
    }

    while(end < nums.length) {
      int current = nums[end];
      maxHeap.add(current);
      output[outputIndex] = maxHeap.peek();
      int prev = nums[start];
      maxHeap.remove(prev);
      start++;
      end++;
      outputIndex++;
    }

		return output;
	}
}
