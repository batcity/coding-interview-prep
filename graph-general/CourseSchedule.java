// https://leetcode.com/problems/course-schedule/?envType=study-plan-v2&envId=top-interview-150
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Building the adjacency List for the graph
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        adjacencyList = buildAdjacencyList(prerequisites);

        HashSet<Integer> visitedNodes = new HashSet<>();
        
        // dfs through each edge
        for(Map.Entry<Integer, List<Integer>> edge: adjacencyList.entrySet()) {

            Integer edgeStart = edge.getKey();
            if(visitedNodes.contains(edgeStart)) {
                continue;
            } else {
                boolean hasLoop = dfs(edgeStart, adjacencyList, visitedNodes);

                if(hasLoop) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private HashMap<Integer, List<Integer>> buildAdjacencyList(int[][] prerequisites) {
        
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        
        for(int[] edge: prerequisites) {
            if(adjacencyList.containsKey(edge[0])) {
                adjacencyList.get(edge[0]).add(edge[1]);
            } else {
                adjacencyList.put(edge[0], new ArrayList<>(List.of(edge[1])));
            }
        }
        
        return adjacencyList;
    }
    
    private boolean dfs(int node, HashMap<Integer, List<Integer>> adjacencyList,  HashSet<Integer> visitedNodes) {
        
        if(visitedNodes.contains(node)) {
            return true;
        }
        
        if(adjacencyList.containsKey(node)) {
            visitedNodes.add(node);
            for(Integer element: adjacencyList.get(node)) {
                if(dfs(element, adjacencyList, visitedNodes) == true) {
                    return true;
                }
            }
        }
        
        return false;
    }
}