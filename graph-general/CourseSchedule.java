// https://leetcode.com/problems/course-schedule/?envType=study-plan-v2&envId=top-interview-150
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Building the adjacency List for the graph
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        adjacencyList = buildAdjacencyList(prerequisites);

        HashSet<List<Integer>> visitedEdges = new HashSet<>();
        
        // dfs through each prerequisite
        for(int[] prerequisite: prerequisites) {

            int edgeStart = prerequisite[0];
            int edgeEnd = prerequisite[1];
            if(visitedEdges.contains(Arrays.asList(edgeStart, edgeEnd))) {
                continue;
            } else {
                HashSet<List<Integer>> tempVisitedEdges = new HashSet<>();
                System.out.println("going to dfs through " + edgeStart + "," + edgeEnd);
                boolean hasLoop = dfs(edgeStart, edgeEnd, adjacencyList, tempVisitedEdges);

                if(hasLoop) {
                    return false;
                }

                visitedEdges.addAll(tempVisitedEdges);
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
    
    private boolean dfs(int edgeStart, int edgeEnd, HashMap<Integer, List<Integer>> adjacencyList,  HashSet<List<Integer>> visitedEdges) {
        
        if(visitedEdges.contains(Arrays.asList(edgeStart, edgeEnd))) {
            System.out.println("visited " + Arrays.asList(edgeStart, edgeEnd) + " twice in this iteration");
            return true;
        }
        
        visitedEdges.add(Arrays.asList(edgeStart, edgeEnd));
        
        if(adjacencyList.containsKey(edgeEnd)) {
            for(Integer newEdgeEnd: adjacencyList.get(edgeEnd)) {
                if(dfs(edgeEnd, newEdgeEnd, adjacencyList, visitedEdges) == true) {
                    return true;
                }
            }
        }
        
        return false;
    }
}