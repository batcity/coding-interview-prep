# https://leetcode.com/problems/simplify-path/?envType=study-plan-v2&envId=top-interview-150
# Time complexity: O(N)
# Space complexity: O(N)
# Where N is the number of characters in the path
class Solution:
    def simplifyPath(self, path: str) -> str:
        
        outputStack = []


        for portion in path.split("/"):
            if portion == "..":
                if outputStack:
                    outputStack.pop()
            elif portion not in ("", "."):
                outputStack.append(portion)

        return "/" + "/".join(outputStack)
