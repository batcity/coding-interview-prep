// https://leetcode.com/problems/course-schedule/?envType=study-plan-v2&envId=top-interview-150
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // New algorithm based on graphs:
        // 1. make a hashmap of all the edges
        // 2. for loop from o to n
        // 3. add node to visited nodes
        // 4. check hashmap and dfs through this
        // 5. as you dfs if a node's been visited already return false, otherwise add node to visited
        // 6. dfs through that node

        // Note: this seems tedious, i feel like fast pointer show pointer should work
        // yeah the idea is to detect cycles in the graph
        // in a linkedlist this is easy to achieve, how would I do this in a graph
        // okay maybe pick each node, then traverse it --> actually know I don't need every node -> I only need nodes
        // which have an edge starting from it -> ah yes!
        // fast pointer - 2 hops, slow pointer 1 hop -> if they meet -> then there's a circle - boom
        
        // Building a list of edges in the graph
        HashMap<Integer, Integer> edgeList = new HashMap<Integer, Integer>();
        edgeList = buildEdges(prerequisites);
        
        // don't think I need this
        // HashSet<Integer> visitedNodes = new HashSet<Integer>();
        
        // dfs through each node
        // for(int i=0; i<numCourses; i++) {
            
        //     if(visitedNodes.contains(i)) {
        //         continue;
        //     } else {
        //         boolean hasLoop = dfs(i, edgeList, visitedNodes);

        //         if(hasLoop) {
        //             return false;
        //         }
        //     }
        // }
        
        return true;
    }
    
    private HashMap<Integer, Integer> buildEdges(int[][] prerequisites) {
        
        HashMap<Integer, Integer> edgeList = new HashMap<Integer, Integer>();
        
        for(int[] edge: prerequisites) {
            edgeList.put(edge[0], edge[1]);
        }
        
        return edgeList;
    }
    
    // private boolean dfs(int node, HashMap<Integer, Integer> edgeList,  HashSet<Integer> visitedNodes) {
        
    //     if(visitedNodes.contains(node)) {
    //         return true;
    //     }
        
    //     if(edgeList.containsKey(node)) {
    //         visitedNodes.add(node);
    //         return dfs(edgeList.get(node), edgeList, visitedNodes);
    //     }
        
    //     return false;
    // }
}