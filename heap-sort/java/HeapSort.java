public class HeapSort {
	public static void main(String[] args) {
		int[] data = {3, 2, 9, 5, 7, 1, 4, 6, 0, 8};
		System.out.print("before heap Sort: ");
		printArray(data);
		System.out.println();
		heapSort(data);
		System.out.print("after heap Sort: ");
		printArray(data);
	}

	public static void heapSort(int[] data) {
		for (int i = data.length / 2; i >= 0; i--) {
			keepMaxHeap(data, i, data.length - 1);
		}

		for (int i = data.length - 1; i >= 0; i--) {
			swap(data, i, 0);
			keepMaxHeap(data, 0, i - 1);
		}
	}

	public static void keepMaxHeap(int[] data, int i, int heapSize) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int max = i;
		if(left <= heapSize && data[left] > data[max]) {
			max = left;
		}
		if(right <= heapSize && data[right] > data[max]) {
			max = right;
		}
		if(max != i) {
			swap(data, i, max);
			keepMaxHeap(data, max, heapSize);
		}
	}

	public static void swap(int[] data, int p, int q) {
		int temp = data[p];
		data[p] = data[q];
		data[q] = temp;
	}

	public static void printArray(int[] data) {
		for(int i : data) {
			System.out.print(i + " ");
		}
	}
}