import java.util.*;

public class FixedMultiStack{

  private Integer[] stackArray;
  private int totalSize;
  private int[] stackCounts = new int[4];

  // The constructor accepts the individual stack size
  public FixedMultiStack(int stackSize){
    this.totalSize = stackSize * 3;
    stackArray = new Integer[totalSize];
  }

  public void push (int value,int stackNum){

    if(isFull(stackNum)){
      //TODO: Maybe implement full stack exception
      throw new RuntimeException("stack is full");
    }

    int startIndex = (stackNum - 1) * totalSize/3;//totalSize - (totalSize/stackNum);
    int index = stackCounts[stackNum] + startIndex;
    // System.out.println("index pushed is" + index);
    stackArray[index] = value;
    stackCounts[stackNum] = stackCounts[stackNum]+1;
  }

  public int pop(int stackNum){

    if(isEmpty(stackNum)){
      //do nothing
      return 0;
    }

    //TODO: This block is repeated multiple times, create a reusable method for it.
    int startIndex = (stackNum - 1) * totalSize/3; //totalSize - (totalSize/stackNum);
    int index = stackCounts[stackNum] + startIndex - 1;
    // System.out.println("index popped is " + index);
    int value = stackArray[index];
    stackArray[index] = null;
    stackCounts[stackNum]--;
    return value;
  }

  public Integer peek(int stackNum){
    if(isEmpty(stackNum)){
      //do nothing
      // System.out.println("The stack is empty");
      return null;
    }

    int startIndex = (stackNum - 1) * totalSize/3;
    int index = stackCounts[stackNum] + startIndex - 1;
    return stackArray[index];

  }

  private boolean isFull(int stackNum){

    if(stackCounts[stackNum]==(totalSize)/3){
      return true;
    }

    return false;
  }

  private boolean isEmpty(int stackNum){

    if(stackCounts[stackNum]==0){
      return true;
    }

    return false;
  }


}
