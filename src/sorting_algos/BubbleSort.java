package sorting_algos;

public class BubbleSort {
	
	public static void bubbleSort(int arr[]) {
		int n = arr.length;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
		}
		
	}
		
	public static void main(String[] args) {
		
		int arr[] = new int[]{3,6,4,8,3,9,1};
		bubbleSort(arr);
		
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
		
	}

}
