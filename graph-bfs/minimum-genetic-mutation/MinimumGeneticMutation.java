// https://leetcode.com/problems/minimum-genetic-mutation/?envType=study-plan-v2&envId=top-interview-150
// Time complexity: (4 ^ N) * N where N is the number of characters in the given startGene
// Space complexity: (4 ^ N) * N where N is the number of characters in the given startGene

// TODO: looks like time and space complexity is off and BFS might be a better solution to this problem, so optimize this

class Solution {

    int minGeneticMutations = Integer.MAX_VALUE;

    public int minMutation(String startGene, String endGene, String[] bank) {

        HashSet<String> bankSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for(String gene: bank) bankSet.add(gene);

        var startGeneArray = startGene.toCharArray();
        var endGeneArray = endGene.toCharArray();
        findMinMutation(startGeneArray, endGeneArray, bankSet, visited, 0);

        if(minGeneticMutations<Integer.MAX_VALUE) return minGeneticMutations;

        return -1;
    }

    private void findMinMutation(char[] startGeneArray, char[] endGeneArray, HashSet<String> bankSet, HashSet<String> visited, int depth) {

        String currStartGene = String.valueOf(startGeneArray);
        if(depth>0 && !bankSet.contains(currStartGene)) return;

        if(Arrays.equals(startGeneArray, endGeneArray)) {
            if(depth < minGeneticMutations) minGeneticMutations = depth;
            return;
        }
        
        if(visited.contains(currStartGene)) return;
        visited.add(currStartGene);

        int index = 0;
        char[] charSet = {'A', 'C', 'G', 'T'};

        while(index < startGeneArray.length) {

            for(char letter: charSet) {
                char temp = startGeneArray[index];
                startGeneArray[index] = letter;
                findMinMutation(startGeneArray, endGeneArray, bankSet, visited, depth+1);
                startGeneArray[index] = temp;
            }

            index++;
        }
    }
}