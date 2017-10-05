import java.util.*;

class StackWithMinTester{


  public static void main(String args[]){

    StackWithMin myStack = new StackWithMin();

    myStack.push(3);
    myStack.push(2);
    myStack.push(1);


    assert myStack.getMin()==1;
    assert myStack.pop()==1;
    assert myStack.getMin()==2;
    assert myStack.pop()==2;
    assert myStack.getMin()==3;
    assert myStack.pop()==3;

    System.out.println("The tests passed successfully");


  }
}
