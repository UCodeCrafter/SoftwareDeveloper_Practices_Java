package sorting_algos;

import java.util.Arrays;

public class InsertionSort {
	public static void insertionSort(int arr[]){
		int n=arr.length;
		for(int i=1; i<n; i++) {
			
			int curr = arr[i];
			int j=i-1;
			
			
			while(j>=0 && arr[j]<curr) {
				arr[j+1] = arr[j];
				j = j-1;
				
			}
			arr[j+1] =curr;
			
			
		}
		 
		
	}
	public static void main(String[] args) {
		int arr[] = new int[] {1,7,5,6,3,7,45,3,2,7};
		insertionSort(arr);
		
		Arrays.stream(arr).forEach(System.out::println);
		
	}

}
