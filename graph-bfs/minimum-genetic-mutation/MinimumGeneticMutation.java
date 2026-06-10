// https://leetcode.com/problems/minimum-genetic-mutation/?envType=study-plan-v2&envId=top-interview-150
// Time complexity: O(B * L^2) where B is the number of elements in the bank and L is the length of the gene string
// Space complexity: O(B * L) where B is the number of elements in the bank and L is the length of the gene string

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int minMutation(String startGene, String endGene, String[] bank) {

        HashSet<String> unvistedBankSet = new HashSet<>(List.of(bank));
        return findMinMutation(startGene, endGene, unvistedBankSet);
    }

    private int findMinMutation(String startGene, String endGene, HashSet<String> unvistedBankSet) {

        int depth = 0;
        Queue<String> currQueue = new LinkedList<>(List.of(startGene));
        char[] charSet = {'A', 'C', 'G', 'T'};

        unvistedBankSet.remove(startGene);

        while(!currQueue.isEmpty()) {

            int levelSize = currQueue.size();

            for(int i=0; i<levelSize; i++) {

                String currGene = currQueue.poll();
                if(currGene.equals(endGene)) return depth;
                char[] currGeneArray = currGene.toCharArray();

                for(int index=0; index < currGeneArray.length; index++) {

                    for(char letter: charSet) {
                        char temp = currGeneArray[index];
                        currGeneArray[index] = letter;
                        String currStartGene = String.valueOf(currGeneArray);
                        if (unvistedBankSet.contains(currStartGene)) {
                            currQueue.add(currStartGene);
                            unvistedBankSet.remove(currStartGene);
                        }
                        currGeneArray[index] = temp;
                    }
                }
            }

            depth++;
        }

        return -1;
    }
}