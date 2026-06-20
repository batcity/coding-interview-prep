# https://leetcode.com/problems/simplify-path/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def simplifyPath(self, path: str) -> str:
        
        outputStack = []
        currOutput = ""

        for symbol in path:
            if symbol == '/':
                self.insert_symbol(currOutput, outputStack)
                currOutput = ""
                continue
            else:
                currOutput += symbol

        if currOutput: self.insert_symbol(currOutput, outputStack)

        return "/" + "/".join(outputStack)

    def insert_symbol(self, currOutput: str, outputStack: []):
        if currOutput != "":       
            if currOutput == ".":
                currOutput = ""
            elif currOutput == "..":
                currOutput = ""
                if outputStack: outputStack.pop()
            else: outputStack.append(currOutput)      
