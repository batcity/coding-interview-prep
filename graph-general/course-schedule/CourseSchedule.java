// https://leetcode.com/problems/course-schedule/?envType=study-plan-v2&envId=top-interview-150
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        // visited states for each node: 0 = unvisited, 1 = visiting, 2 = done
        int[] state = new int[numCourses];

        // build adjacencyList
        for(int[] prerequisite: prerequisites) {
            adjacencyList.computeIfAbsent(prerequisite[1], v -> new ArrayList<>()).add(prerequisite[0]);
        }
        
        // dfs through each prerequisite
        for(int node: adjacencyList.keySet()) {

            boolean hasCycle = hasCycle(node, adjacencyList, state);

            if(hasCycle) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean hasCycle(int node, HashMap<Integer, List<Integer>> adjacencyList,  int[] state) {

        if(state[node]==1) {
            return true;
        }

        if(state[node]==2) {
            return false;
        }

        // mark node as visiting in this cycle...
        state[node] = 1;
        
        if(adjacencyList.containsKey(node)) {
            for(Integer next: adjacencyList.get(node)) {
                if(hasCycle(next, adjacencyList, state)) {
                    return true;
                }
            }
        }

        // mark node as visited
        state[node] = 2;
        
        return false;
    }
}