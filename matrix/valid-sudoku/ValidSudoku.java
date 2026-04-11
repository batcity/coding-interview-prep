// solution for problem: https://leetcode.com/problems/valid-sudoku/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

class Solution {

    private HashMap<Integer, Set<Character>> rowHashSetMap = new HashMap<>();
    private HashMap<Integer, Set<Character>> columnHashSetMap = new HashMap<>();
    private ArrayList<int[]> startingPoints = new ArrayList<>();

    public boolean isValidSudoku(char[][] board) {

        startingPoints.add(new int[]{0, 0});
        startingPoints.add(new int[]{0, 3});
        startingPoints.add(new int[]{0, 6});
        startingPoints.add(new int[]{3, 0});
        startingPoints.add(new int[]{3, 3});
        startingPoints.add(new int[]{3, 6});
        startingPoints.add(new int[]{6, 0});
        startingPoints.add(new int[]{6, 3});
        startingPoints.add(new int[]{6, 6});

        for(int[] coordinate:startingPoints) {
            boolean currentVisit = visitSubGrid(coordinate[0], coordinate[1], board, rowHashSetMap, columnHashSetMap);
            if(!currentVisit) {
                return false;
            }
        }
        
        return true;
    }

    private boolean visitSubGrid(int xCoordinate, int yCoordinate, char[][] board, HashMap<Integer, Set<Character>> rowHashSetMap, HashMap<Integer, Set<Character>> columnHashSetMap) {

        Set<Character> gridSet = new HashSet<Character>();

        for(int x=xCoordinate; x<xCoordinate+3;x++) {
            for(int y=yCoordinate; y<yCoordinate+3; y++) {

                char currentElement = board[x][y];
                if(currentElement == '.') {
                    continue;
                }

                if(gridSet.contains(currentElement)) {
                    return false;
                }
                gridSet.add(currentElement);

                if(rowHashSetMap.containsKey(x)) {

                    Set<Character> rowSet = rowHashSetMap.get(x);
                    if(rowSet.contains(currentElement)) {
                        return false;
                    }

                    rowSet.add(currentElement);
                    rowHashSetMap.put(x, rowSet);
                } else {
                    Set<Character> rowSet = new HashSet<Character>();
                    rowSet.add(currentElement);
                    rowHashSetMap.put(x, rowSet);
                }

                if(columnHashSetMap.containsKey(y)) {

                    Set<Character> columnSet = columnHashSetMap.get(y);
                    if(columnSet.contains(currentElement)) {
                        return false;
                    }

                    columnSet.add(currentElement);
                    columnHashSetMap.put(y, columnSet);
                } else {
                    Set<Character> columnSet = new HashSet<Character>();
                    columnSet.add(currentElement);
                    columnHashSetMap.put(y, columnSet);
                }
            }
        }

        return true;
    }
}