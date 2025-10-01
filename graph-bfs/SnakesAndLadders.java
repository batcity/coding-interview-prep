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
        int currentPosition = 0;

        LinkedList<Integer> nodeQueue = new LinkedList<>();
        Set<Integer> visitedNodes = new HashSet<>();
        nodeQueue.add(currentPosition);

        while(true) {

            LinkedList<Integer> tempQueue = new LinkedList<>();

            while(!nodeQueue.isEmpty()) {

                currentPosition = nodeQueue.remove();

                // System.out.println("currentPosition: " + currentPosition);
                // System.out.println("num_moves: " + num_moves);

                if(currentPosition == destination) {
                    return num_moves;
                }

                for(int i=1; i<7;i++) {
                    int newPosition = currentPosition + i;

                    if(newPosition > destination) {
                        break;
                    }

                    if (flattenedGraph[newPosition] != -1) {
                        newPosition = flattenedGraph[newPosition] - 1;
                    }

                    if (!visitedNodes.contains(newPosition)) {
                        visitedNodes.add(newPosition);   // mark when enqueuing
                        tempQueue.add(newPosition);
                    }
                }
            }

            if(tempQueue.isEmpty()) {
                break;
            }

            // System.out.println("do i make it here?");

            nodeQueue.addAll(tempQueue);
            num_moves++;
        }

        return -1;
    }
}