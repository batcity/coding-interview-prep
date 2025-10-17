/*
Psuedocode:

Input: Graph G(V, E) with weights on edges
Output: Minimum Spanning Tree (MST)

1. Initialize:
   MST = empty set of edges
   TreeVertices = { }         // Vertices included in MST - A vertex is a point or node in a graph where edges meet
   FringeVertices = { }       // Vertices not yet in MST but connected to TreeVertices

2. Choose an arbitrary starting vertex v0:
   Add v0 to TreeVertices

3. While TreeVertices does not include all vertices:
   
   a. For each vertex v not in TreeVertices:
      If there is at least one edge from any vertex u in TreeVertices to v:
          Add v to FringeVertices

   b. Find all edges connecting any TreeVertex to any FringeVertex.

   c. Select the edge (u, v) with the minimum weight, where
      u ∈ TreeVertices and v ∈ FringeVertices

   d. Add edge (u, v) to MST

   e. Add v to TreeVertices
      Remove v from FringeVertices (optional, for clarity)

4. Return MST
 */

import java.util.*;

public class PrimMst {
    public static void main(String[] args) {
    
      int graph[][] = new int[][] { 
                        { 0, 2, 0, 6, 0, 0 },  // Vertex 0
                        { 2, 0, 3, 8, 5, 0 },  // Vertex 1
                        { 0, 3, 0, 0, 7, 0 },  // Vertex 2
                        { 6, 8, 0, 0, 9, 0 },  // Vertex 3
                        { 0, 5, 7, 9, 0, 0 },  // Vertex 4
                        { 0, 0, 0, 0, 0, 0 }   // Vertex 5 (no edges)
                    };

      // get the MST represented as a list of edges
      primMST(graph);
    }

    static List<Edge> primMST(int[][] graph) {

      Set<Integer> treeVertices = new HashSet<>();
      Set<Integer> fringeVertices = new HashSet<>();
      int vertexCount = graph.length;
      int[] vertices = java.util.stream.IntStream.range(0, vertexCount).toArray();
      // java.util.Arrays.stream(vertices).forEach(System.out::println);
      List<Edge> MST = new ArrayList<>();

      treeVertices.add(0);

      while(treeVertices.size()!=vertexCount) {
        break;
      }

      return MST;
    }
}

class Edge {
    int from;
    int to;
    int weight;

    Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}