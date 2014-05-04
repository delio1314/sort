package minKElements;

public class QuickSort {

	/**
	 * 快速排序：通过一趟排序将待排记录分割成独立的两部分，其中一部分的关键字比另一部分的关键字小
	 * 则可分别对这两部分记录继续进行这种排序，已达到整个序列有序的目的。 平均情况：O(nlogn) 最好情况：O(nlogn) 最坏情况：O(n^2)
	 * 辅助空间：O(logn)~O(n) 稳定性：不稳定
	 */

	public static void quickSort(int[] data) {
		quickSortRecursion(data, 0, data.length - 1);
	}

	// 对顺序表中的子序列做快速排序
	private static void quickSortRecursion(int[] data, int low, int high) {
		if (low < high) {
			int pivot = partition(data, low, high);
			quickSortRecursion(data, low, pivot - 1);
			quickSortRecursion(data, pivot + 1, high);
		}
	}

	// 交换顺序表中子表的记录，返回枢轴所在位置，交换后
	private static int partition(int[] data, int low, int high) {
		int pivotkey = data[low];
		while (low < high) {
			while (low < high && data[high] >= pivotkey) {
				high--;
			}
			// 将比枢轴小的数交换到低端
			swap(data, low, high);
			while (low < high && data[low] <= pivotkey) {
				low++;
			}
			// 将比枢轴大的数交换到高端
			swap(data, low, high);
		}
		return low;
	}

	// 交换元素
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
