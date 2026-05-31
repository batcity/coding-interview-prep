// https://leetcode.com/problems/minimum-genetic-mutation/?envType=study-plan-v2&envId=top-interview-150
// Time complexity: (4 ^ N) * N where N is the number of characters in the given startGene
// Space complexity: (4 ^ N) * N where N is the number of characters in the given startGene

// TODO: looks like time and space complexity is off, fix that. Also I'm currently working on the BFS solution for this

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int minGeneticMutations = Integer.MAX_VALUE;

    public int minMutation(String startGene, String endGene, String[] bank) {

        HashSet<String> bankSet = new HashSet<>();
        for(String gene: bank) bankSet.add(gene);

        var startGeneArray = startGene.toCharArray();
        var endGeneArray = endGene.toCharArray();
        return findMinMutation(startGeneArray, endGeneArray, bankSet);
    }

    private int findMinMutation(char[] startGeneArray, char[] endGeneArray, HashSet<String> bankSet) {

        int depth = 0;
        int currDepthQueueCount = 1;
        Queue<char[]> currQueue = new LinkedList<>();
        currQueue.add(startGeneArray);
        char[] charSet = {'A', 'C', 'G', 'T'};
        int index = 0;

        while(!currQueue.isEmpty()) {

            while(currDepthQueueCount>0) {

                char[] currGeneArray = currQueue.poll();

                if(Arrays.equals(currGeneArray, endGeneArray)) {
                    return depth;
                }
i
                for(char letter: charSet) {
                    char temp = startGeneArray[index];
                    currGeneArray[index] = letter;
                    String currStartGene = String.valueOf(startGeneArray);
                    if(bankSet.contains(currStartGene)) currQueue.add(currGeneArray);
                    currGeneArray[index] = temp;
                }

                currDepthQueueCount--;
            }

            currDepthQueueCount = index;
        }

        return -1;
    }
}