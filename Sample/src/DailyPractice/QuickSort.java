package DailyPractice;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 10, 4, 7, 2, 1 };
		quickSort(arr, 0, arr.length - 1);
		for (int num : arr) {
			System.out.println(num);
		}

	}

	private static void quickSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if (low < high) {
			int par = quick(arr, low, high);
			quickSort(arr, low, par - 1);
			quickSort(arr, par + 1, high);
		}

	}

	private static int quick(int[] arr, int low, int high) {
		int pivot = arr[low];
		int start = low;
		int end = high;
		
		while(start < end) {
			while(arr[start] <= pivot) {
				start++;
			}
			while(arr[end] > pivot) {
				end--;
			}
			if(start<end) {
				swap(arr,start,end);
			}
		}
		swap(arr,low,end);
		return end;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
