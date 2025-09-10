import java.util.*;

public class MyArrayListTester{

  public static void main(String args[]){

    MyArrayList myArrayList = new MyArrayList(3);

    assert myArrayList.isEmpty()==true;

    assert myArrayList.size()==0;
    assert myArrayList.capacity()==3;

    myArrayList.push(10);
    assert myArrayList.size()==1;

    myArrayList.push(20);
    myArrayList.push(30);
    myArrayList.push(40);
    assert myArrayList.size()==4;

    assert myArrayList.capacity()==6;
    assert myArrayList.get(0)==10;
    assert myArrayList.find(30)==2;

    myArrayList.insert(2,50);
    assert myArrayList.find(30)==3;
    assert myArrayList.size()==5;

    myArrayList.pop();
    assert myArrayList.size()==4;
    assert myArrayList.find(40)==-1;

    myArrayList.prepend(5);
    assert myArrayList.get(0)==5;
    assert myArrayList.size()==5;

    myArrayList.delete(0);
    assert myArrayList.get(0)==10;
    assert myArrayList.get(1)==20;
    assert myArrayList.get(2)==50;
    assert myArrayList.get(3)==30;
    assert myArrayList.size()==4;

    myArrayList.pop();
    myArrayList.pop();
    myArrayList.pop();
    myArrayList.pop();
    assert myArrayList.capacity()==1;
  }
}
