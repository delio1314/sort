package minKElements;

public class Main {

	/**
	 * 题目描述：5.查找最小的k个元素 题目：输入n个整数，输出其中最小的k个。
	 * 例如输入1，2，3，4，5，6，7和8这8个数字，则最小的4个数字为1，2，3和4。
	 */
	public static void main(String[] args) {
		int[] list = { 10, 8, 2, 4, 5, 9, 3, 1, 7, 6 };
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
		// Sort.bubbleSort(list);
		// Sort.selectSort(list);
		// Sort.insertSort(list);
		// Sort.shellSort(list);
		// HeapSort.heapSort(list);
		 MergeSort.mergeSort(list);
//		QuickSort.quickSort(list);
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

}
