// https://leetcode.com/problems/minimum-genetic-mutation/?envType=study-plan-v2&envId=top-interview-150

class Solution {

    int minGeneticMutations = Integer.MAX_VALUE;

    public int minMutation(String startGene, String endGene, String[] bank) {

        HashSet<String> bankSet = new HashSet<>();
        for(String gene: bank) bankSet.add(gene);

        var startGeneArray = startGene.toCharArray();
        var endGeneArray = endGene.toCharArray();
        findMinMutation(startGeneArray, endGeneArray, bankSet, 0);

        if(minGeneticMutations<Integer.MAX_VALUE) return minGeneticMutations;

        return -1;
    }

    void findMinMutation(char[] startGeneArray, char[] endGeneArray, HashSet<String> bankSet, int depth) {

        System.out.println("curent startGeneArray is: " + Arrays.toString(startGeneArray) + " and depth is " + depth);

        if(depth>0 && !bankSet.contains(Arrays.toString(startGeneArray))) return;

        if(Arrays.equals(startGeneArray, endGeneArray)) {
            System.out.println("does this happen");
            if(depth < minGeneticMutations) minGeneticMutations = depth;
            return;
        }

        int index = 0;
        char[] charSet = {'A', 'C', 'G', 'T'};

        while(index < startGeneArray.length) {

            for(char letter: charSet) {
                char temp = startGeneArray[index];
                startGeneArray[index] = letter;
                findMinMutation(startGeneArray, endGeneArray, bankSet, depth+1);
                startGeneArray[index] = temp;
            }

            index++;
        }
    }
}