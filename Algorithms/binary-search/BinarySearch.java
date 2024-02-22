import java.util.*;

class BinarySearch {

  static List<Integer> input = new ArrayList<Integer>(Arrays.asList(1,2,3,4));

  public static void main(String args[]){
    System.out.println("Checking if 3 is in list: " + input);
    System.out.println(binarySearch(input, 3, 0, 3));
    System.out.println("Checking if 6 is in list: " + input);
    System.out.println(binarySearch(input, 6, 0, 3));
  }

  private static int binarySearch(List<Integer> inputList, int target, int start, int end) {

    if(end <= start) {

      if(inputList.get(start) == target) {
        return start;
      }

      return -1;
    }

    int mid = start + (end - start)/2;
    int currentVal = inputList.get(mid);

    if(currentVal == target) {
      return mid;
    } else if(currentVal > target) {
      return binarySearch(inputList, target, start, mid-1);
    } else {
      return binarySearch(inputList, target, mid+1, end);
    }
  }
}
