import java.util.*;

public class FixedMultiStack{

  Integer[] stackArray;
  int stackSize;
  int[] stackCounts = new int[4];

  public FixedMultiStack(int stackSize){
    this.stackSize = stackSize;
    stackArray = new Integer[stackSize];
  }

  public void push (int value,int stackNum){

    if(isFull(stackNum)){
      throw new RuntimeException("stack is full");
    }

    int startIndex = (stackNum - 1) * stackSize/3;//stackSize - (stackSize/stackNum);
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

    int startIndex = (stackNum - 1) * stackSize/3; //stackSize - (stackSize/stackNum);
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

    int startIndex = (stackNum - 1) * stackSize/3;
    int index = stackCounts[stackNum] + startIndex - 1;
    return stackArray[index];

  }

  private boolean isFull(int stackNum){

    if(stackCounts[stackNum]==(stackSize)/3){
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
