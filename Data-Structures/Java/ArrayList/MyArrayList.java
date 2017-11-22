import java.util.*;

class MyArrayList{

  private int size = 0;
  private int capacity;
  private int[] elementArray;

  public MyArrayList(int capacity)
  {
    this.capacity = capacity;
    this.elementArray = new int[capacity];
  }

  public int size()
  {
    return size;
  }

  public int capacity(){
    return capacity;
  }

  public boolean isEmpty(){

    if(size==0){
      return true;
    }

    return false;
  }

  public int get(int index)
  {

    if(index>=size){
      throw new ArrayIndexOutOfBoundsException();
    }

    return elementArray[index];
  }

  public void push(int item)
  {
    elementArray[size] = item;
    size++;

    if(size==capacity){
      resize(capacity*2);
    }

    return;
  }

  public void insert(int index, int item){
    size++;

    if(size==capacity)
    {
      resize(capacity*2);
    }

    for(int i=size;i>index;i--){
      elementArray[i] = elementArray[i-1];
    }

    elementArray[index] = item;
  }

  public int pop(){
    int temp = elementArray[size-1];
    elementArray[size-1] = 0;
    size--;

    if(size<=capacity/4){
      resize(capacity/2);
    }

    return temp;
  }

  public void prepend(int item){
    insert(0,item);
    return;
  }

  public void delete(int index){

    if(index<size){

      for(int i=index;i<size-1;i++){
        elementArray[i] = elementArray[i+1];
      }
      elementArray[size-1] = 0;
      size--;
    }else{
      return;
    }

    if(size<=capacity/4){
      resize(capacity/2);
    }
  }

  public int find(int item){

    for(int i=0;i<size;i++){

      if(elementArray[i] == item){
        return i;
      }
    }

    return -1;
  }

  private void resize(int newCapacity){

    int[] tempArray = new int[newCapacity];

    for(int i=0;i<size;i++){
      tempArray[i] = elementArray[i];
    }

    elementArray = tempArray;
    capacity = newCapacity;
  }

}
