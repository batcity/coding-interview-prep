import java.util.*;

public class MyMergeSort {

  private void sort(int[] arr,int[] aux, int low, int high)
  {

    if(low>=high){
      return;
    }

    int mid = (high + low)/2;

    sort(arr,aux,low,mid);
    sort(arr,aux,mid+1,high);
    merge(arr,aux,low,mid,high);

    return;
  }


  private void merge(int[] arr, int[] aux, int low, int mid, int high){

    assert isSorted(arr,low,mid);
    assert isSorted(arr,mid+1,high);

    // copy original array into aux array
    for(int i=0;i<arr.length;i++){
      aux[i] = arr[i];
    }

    int i = low;
    int j = mid+1;

    for(int k = low; k<=high;k++){

      if(i>mid){
        arr[k] = aux[j++];
      }else if(j>high){
        arr[k] = aux[i++];
      }
      else if(aux[i]<aux[j]){
        arr[k] = aux[i++];
      }else{
        arr[k] = aux[j++];
      }
    }

    assert isSorted(arr,low,high);
  }

  public void sort(int[] arr){

    int[] aux = new int[arr.length];
    sort(arr,aux,0,arr.length-1);
    return;
  }

  public static void printArr(int[] arr){

    for(int elem:arr){
      System.out.println(elem);
    }
  }

  public static boolean isSorted(int[] arr, int low, int high){

    for(int i=low;i<high;i++){
      if(arr[i+1]<arr[i])  return false;
    }

    return true;
  }

  public static void main(String args[]){

    MyMergeSort mergeSort = new MyMergeSort();
    int[] arr = {9,8,7,6,5,4,3,2,1};

    System.out.println("Before sorting elements in the array are");
    printArr(arr);

    mergeSort.sort(arr);

    System.out.println("After sorting elements in the array are");
    printArr(arr);

    assert isSorted(arr,0,arr.length-1);
  }

}
