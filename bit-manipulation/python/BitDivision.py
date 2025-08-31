
# ref leetcode: https://leetcode.com/problems/divide-two-integers/

# Think about long division for binary, beautiful explanation of the algorithm: https://stackoverflow.com/questions/5386377/division-without-using


def BitDivision(dividend, divisor):

    quotient = 0;
    current = 1;

    while(dividend>divisor):
        divisor = divisor << 1;
        current = current << 1;

    divisor = divisor >> 1
    current = current >> 1

    while(divisor!=0):

        if(dividend>=divisor):
            dividend = dividend - divisor;
            quotient |= current

        divisor = divisor >> 1
        current = current >> 1

        print divisor;

    return quotient;


print BitDivision(1000,10)
