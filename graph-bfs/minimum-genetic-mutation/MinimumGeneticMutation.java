// https://leetcode.com/problems/minimum-genetic-mutation/?envType=study-plan-v2&envId=top-interview-150
// Time complexity: (4 ^ N) * N where N is the number of characters in the given startGene
// Space complexity: (4 ^ N) * N where N is the number of characters in the given startGene

// TODO: looks like time and space complexity is off, fix that. Also make this code cleaner

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int minGeneticMutations = Integer.MAX_VALUE;

    public int minMutation(String startGene, String endGene, String[] bank) {

        HashSet<String> univistedBankSet = new HashSet<>(List.of(bank));
        return findMinMutation(startGene, endGene, univistedBankSet);
    }

    private int findMinMutation(String startGene, String endGene, HashSet<String> univistedBankSet) {

        int depth = 0;
        int currDepthQueueCount = 1;
        Queue<String> currQueue = new LinkedList<>(List.of(startGene));
        char[] charSet = {'A', 'C', 'G', 'T'};

        univistedBankSet.remove(startGene);

        while(!currQueue.isEmpty()) {

            while(currDepthQueueCount>0) {

                String currGene = currQueue.poll();
                if(currGene.equals(endGene)) return depth;
                char[] currGeneArray = currGene.toCharArray();

                int index = 0;

                while(index < currGeneArray.length) {

                    for(char letter: charSet) {
                        char temp = currGeneArray[index];
                        currGeneArray[index] = letter;
                        String currStartGene = String.valueOf(currGeneArray);
                        if (univistedBankSet.contains(currStartGene)) {
                            currQueue.add(currStartGene);
                            univistedBankSet.remove(currStartGene);
                        }
                        currGeneArray[index] = temp;
                    }

                    index++;
                }

                currDepthQueueCount--;
            }

            currDepthQueueCount = currQueue.size();
            depth++;
        }

        return -1;
    }
}