import java.util.*;
import java.lang.RuntimeException;

class StackWithMin{


  private class Node{
    int value;
    Node next;
    int currentMin;

    Node(int value){
      this.value = value;
    }
  }

  private Node top;

  public void push(int value){

    if(top==null){
      top = new Node(value);
      top.currentMin = value;
      return;
    }

    Node temp = top;
    Node newTop = new Node(value);
    newTop.next = temp;
    top = newTop;

    if(top.value<temp.currentMin){
      top.currentMin = value;
      return;
    }else{
      top.currentMin = temp.currentMin;
    }
  }

  public int getMin(){

    if(top==null){
      throw new RuntimeException("stack is empty");
    }

    return top.currentMin;
  }

  public int pop(){

    if(top==null){
      throw new RuntimeException("Stack is empty");
    }

    int popped = top.value;
    top = top.next;
    return popped;
  }

  public int peek(){

    if(top==null){
      throw new RuntimeException("Stack is empty");
    }

    return top.value;
  }
}
