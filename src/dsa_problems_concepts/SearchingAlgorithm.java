package dsa_problems_concepts;

import java.util.Arrays;

public class SearchingAlgorithm {


    public static void main(String[] args){
        System.out.println("In main method");
        int[] array = new int[]{2, 5,6,8,9,23,34,45,56,67,78,90};
        int left = 0;
        int right = array.length;
        int target = 34;
        //Binary Search
        int index = binarySearchUsingRecursion(array, left, right, target);
        System.out.println(target + " is at index : "+ index);

//        int index2 = binarySearchUsingIterative(array, target);
    }



    private static int binarySearchUsingRecursion(int[] array, int left, int right, int target) {
        int mid = left + (right - left)/2;
        if(array[mid] == target) return mid;
        if(array[mid] < target){
            binarySearchUsingRecursion(array, mid+1, right, target);
        }
        if(array[mid] > target){
            binarySearchUsingRecursion(array, left, mid, target);
        }
        return -1;
    }

//    private static int binarySearchUsingIterative(int[] array,  int target) {
//    int left = 0;
//    int right = array.length -1;
//
//
////    while(left < right){
////        int mid = left + (right - left)/2;
////
//////        if()
////    }
////    }


}
