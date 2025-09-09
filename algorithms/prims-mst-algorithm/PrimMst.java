import java.util.*;
public class PrimMst {
    public static void main(String[] args) {
      
      MST t = new MST();
      int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                                    { 2, 0, 3, 8, 5 },
                                    { 0, 3, 0, 0, 7 },
                                    { 6, 8, 0, 0, 9 },
                                    { 0, 5, 7, 9, 0 } };
      // Print the solution
      t.primMST(graph);
  }
  
  public class MST {
    
    
  }
}
