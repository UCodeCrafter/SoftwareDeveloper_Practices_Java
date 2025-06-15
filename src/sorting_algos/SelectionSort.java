package sorting_algos;

import java.util.Arrays;

public class SelectionSort {
	
	public static void selectionSort(int arr[]) {	
		int n = arr.length;
		for(int i=0; i<n; i++) {
			int currIndex = i;
			for(int j=i+1; j<n; j++){
				if(arr[j]<arr[currIndex]) {
					currIndex = j;
				}
			}
			swap(arr, i, currIndex);
		}
	}
	private static void swap(int[] arr, int i, int currIndex) {
		int temp = arr[i];
		arr[i] = arr[currIndex];
		arr[currIndex] = temp;
		
	}
	public static void main(String[] args) {
		int arr[] = new int[] {1,9,2,9,3,0,4,6,8};
		selectionSort(arr);
		Arrays.stream(arr).forEach(System.out::println);
		
		
		
	}

}
