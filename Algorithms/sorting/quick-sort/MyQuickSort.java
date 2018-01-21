import java.util.*;

// note: does not work for duplicates yet.


class MyQuickSort {

    private static int partition(int[] list,int high, int low){

        int partitionElem = low;


        int i = low;
        int j = high+1;

        while(true){

            while(less(list[++i],list[partitionElem]))
                if(i == high) break;

            while(less(list[partitionElem],list[--j]))
                if(j == low) break;

            if(i>=j) break;

            exch(list,i,j);

        }

        exch(list,partitionElem,j);
        return j;
    }

    private static void exch(int[] list, int first, int second){
        int temp = list[first];
        list[first] = list[second];
        list[second] = temp;
    }

    private static boolean less(int first, int second){

        if(first<second){
            return true;

        }

        return false;
    }

    private static void sort(int[] list,int low, int high){

        if(high<=low){
            return;
        }

        int j = partition(list,high,low);

        sort(list,low,j);
        sort(list,j+1,high);
    }

    public static void main(String args[]){

        int[] listTwo = {1,9,6,4,5,8,3,7};

        System.out.println("before sorting");

        for(int elem:listTwo){
            System.out.println(elem);
        }


        System.out.println("after sorting");


        sort(listTwo,0,listTwo.length-1);
        for(int elem:listTwo){
            System.out.println(elem);
        }
    }
}