// leetcode: https://leetcode.com/problems/snakes-and-ladders/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;

        // step 1: flatten the board so I don't have to think about which direction to move
        // when I start BFS
        int destination = (n * n) - 1;

        int[] flattenedGraph = new int[n * n];

        int index = n-1;
        int flattenedGraphIndex = 0;
        boolean flip = false;

        while(index > -1) {

            if(flip) {
                for(int k=n-1; k>-1; k--) {
                    // System.out.println("modifying: " + index + "," + k);
                    flattenedGraph[flattenedGraphIndex] = board[index][k];
                    flattenedGraphIndex++;
                }

                flip = false;
            } else {
                for(int c=0; c<n; c++) {
                    // System.out.println("modifying: " + index + "," + c);
                    flattenedGraph[flattenedGraphIndex] = board[index][c];
                    flattenedGraphIndex++;
                }

                flip = true;
            }
               
            index--;
        }

        // Arrays.stream(flattenedGraph).forEach(x -> System.out.println(x));
        // step 2: Do BFS graph traversal to figure out the least Dice rolls
        int leastDiceRolls = bfs(flattenedGraph, destination);
        
        return leastDiceRolls;
    }


    int bfs(int[] flattenedGraph, int destination) {
        int num_moves = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);

        while (!queue.isEmpty()) {

            int size = queue.size();  // number of nodes at this BFS level

            for (int s = 0; s < size; s++) {
                int current = queue.poll();

                if (current == destination) {
                    return num_moves;
                }

                for (int dice = 1; dice <= 6; dice++) {
                    int next = current + dice;
                    if (next > destination) break;

                    if (flattenedGraph[next] != -1) {
                        next = flattenedGraph[next] - 1;
                    }

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }

            num_moves++; // increment after processing one BFS level
        }

        return -1;
    }

}