// https://leetcode.com/problems/single-number-ii/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int singleNumber(int[] nums) {

        int result = 0;

        for(int i=0;i<32;i++) {

            int bitSum = 0;

            // get the ith bit from each number
            // then add them up
            for(int num: nums) {
                String bits = String.format("%32s",
                        Integer.toBinaryString(num)).replace(' ', '0');
                System.out.println("the 32 bit representation of number: " + num + " is: " + bits);

                // how to get the ith bit in a number
                // 1. Shift the desired bit to the least significant position (0)
                // 2. Use the AND operator with 1 (which is 0...001) to isolate that bit
                bit = (num >> i) & 1;
            }

        }

        return -1;
    }
}