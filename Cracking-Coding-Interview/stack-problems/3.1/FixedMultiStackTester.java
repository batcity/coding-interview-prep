import java.util.*;

public class FixedMultiStackTester{

  public static void main(String args[]){

    FixedMultiStack myMultiStack = new FixedMultiStack(9);

    myMultiStack.push(1,1);
    System.out.println("after adding to stack 1" + "\n"  +myMultiStack.peek(1));
    myMultiStack.pop(1);
    System.out.println("after removing in stack 1" + "\n"+ myMultiStack.peek(1));

    myMultiStack.push(1,1);
    myMultiStack.push(2,1);
    myMultiStack.push(3,1);

    assert myMultiStack.pop(1)==3:"pop failed";
    assert myMultiStack.pop(1)==2:"pop failed";
    assert myMultiStack.pop(1)==1:"pop failed";

    myMultiStack.push(4,2);
    System.out.println("after adding to stack 2" + "\n" + myMultiStack.peek(2));
    myMultiStack.pop(2);
    System.out.println("after removing in stack 2" + "\n" + myMultiStack.peek(2));

    myMultiStack.push(7,3);
    System.out.println("after adding to stack 3" + "\n" + myMultiStack.peek(3));
    myMultiStack.pop(3);
    System.out.println("after removing in stack 3" + "\n" + myMultiStack.peek(3));
  }
}
