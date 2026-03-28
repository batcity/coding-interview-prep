# https://leetcode.com/problems/single-number-ii/?envType=study-plan-v2&envId=top-interview-150

# Time complexity: O(n) where n is the list of numbers
# Space complexity: O(1)

class Solution:
    def singleNumber(self, nums: List[int]) -> int:

        result = 0

        for index in range (32):

            bit_sum = 0
            
            for num in nums:

                # print("bin representation of original number: ", num)
                # print(bin(num)[2:])

                # print("number after right shifting", index, " bits: ")
                right_shifted_number = num >> index
                # print(bin(right_shifted_number)[2:])

                # how do I get the ith bit in a number
                # fairly simple you "AND" everything with one - dang that's amazing

                # print("bit", index , "from the number:", num , " is:")
                bit = right_shifted_number & 1
                # print(bin(bit)[2:])

                bit_sum = bit_sum + bit

            result_bit = bit_sum % 3
            result_bit = result_bit << index
            result = result | result_bit
            # print("This is the bit that should be returned in the result: ", result_bit)

        # Convert from unsigned 32-bit to signed integer.
        # If the highest bit (sign bit) is set, the number is actually negative.
        # Subtracting 2^32 converts it to the correct negative value.
        # Example: 4294967292 → -4
        if result >= 2**31:
            result -= 2**32
        
        return result