import java.util.*;

class RobotInAGrid {

    boolean pathFound = false;
    static ArrayList<Cell> pathArray = new ArrayList<Cell>();

    public ArrayList<Cell> uniquePaths(int m, int n,ArrayList<Cell> blockedCells) {

        m = m-1;
        n = n-1;

        numUniquePaths(m,n,blockedCells);

        return pathArray;
    }

    public void numUniquePaths(int m,int n, ArrayList<Cell> blockedCells){


        if(blockedCells.contains(new Cell(m,n))) return;

        if(m<0 || n<0) return;

        if(m==0 && n==0){
            pathArray.add(new Cell(m,n));
            pathFound = true;
            return;
        }

        numUniquePaths(m,n-1,blockedCells);

        if(pathFound){
          pathArray.add(new Cell(m,n));
          return;
        }

        numUniquePaths(m-1,n,blockedCells);

        if(pathFound) pathArray.add(new Cell(m,n));

        return;
    }

    public class Cell{

      int x;
      int y;

      public Cell(int m, int n){
        this.x = m;
        this.y = n;
      }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x &&
                    y == cell.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args){

      ArrayList<Cell> finalPathArray = new ArrayList<Cell>();
      ArrayList<Cell> blockedCells = new ArrayList<Cell>();
      Cell blockedCell = new RobotInAGrid().new Cell(2,0);
      blockedCells.add(blockedCell);

      RobotInAGrid rb = new RobotInAGrid();
      finalPathArray = rb.uniquePaths(3,3,blockedCells);

      for(Cell cell:finalPathArray){
        System.out.println(cell.x + " " + cell.y);
      }

    }

}
