// https://leetcode.com/problems/single-number-ii/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int singleNumber(int[] nums) {

        int result = 0;

        for(int i=0;i<32;i++) {

            int bitSum = 0;

            // get the ith bit from each number
            // then add them up
            for(int num: nums) {
                // String bits = String.format("%32s",
                //         Integer.toBinaryString(num)).replace(' ', '0');
                // System.out.println("the 32 bit representation of number: " + num + " is: " + bits);

                // how to get the ith bit in a number
                // 1. Shift the desired bit to the least significant position -> this is the rightmost bit in the
                // binary representation of a number - example: for binary 001 -> 1 is the least significant bit
                // this is acheived by the num >> i command -> you're essentially shifting the bits in the number num by
                // i positions, in case the number is positive the new bits that are added to the left are 0, otherwise they are
                // 1
                // 2. Use the AND operator with 1 (which is 0...001) to isolate that bit
                int bit = (num >> i) & 1;

                // System.out.println("ith bit for this number is: " + String.format("%32s",
                //         Integer.toBinaryString(bit)).replace(' ', '0'));

                bitSum = bitSum + bit;
            }

            int finalBit = bitSum % 3;

            // set the ith bit as finalBit
            // essentially shift finalBit left by i positions, then add it up to the original result
            result = result | (finalBit << i);
        }

        return result;
    }
}