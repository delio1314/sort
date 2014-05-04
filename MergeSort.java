package minKElements;

public class MergeSort {
	/**
	 * 归并排序：初始序列n个记录，可以看成n个有序的子序列，每个子序列长度为1 两两归并得到[n/2]个长度为2或者1的子序列；
	 * 再两两归并，如此往复，直到得到一个长度为n的有序序列为止。 递归实现 平均情况：O(nlogn) 最好情况：O(nlogn)
	 * 最坏情况：O(nlogn) 辅助空间：O(n) 稳定性：稳定
	 */
	public static void mergeSort(int[] data) {
		mergeSortRecursion(data, 0, data.length - 1);
	}

	private static int number = 0;

	// 递归调用归并排序
	private static void mergeSortRecursion(int[] data, int left, int right) {
		if (left >= right)
			return;
		int mid = (left + right) / 2;
		// 二路归并排序里面有两个Sort，多路归并排序里面写多个Sort就可以了
		mergeSortRecursion(data, left, mid);
		mergeSortRecursion(data, mid + 1, right);
		merge(data, left, mid, right);
	}

	// 合并最后结果
	private static void merge(int[] a, int left, int mid, int right) {
		int[] tmp = new int[a.length];
		int r1 = mid + 1;
		// tIndex 记录tmp下标移动
		int tIndex = left;
		int cIndex = left;
		// 逐个归并
		while (left <= mid && r1 <= right) {
			if (a[left] <= a[r1]) {
				tmp[tIndex] = a[left];
				tIndex++;
				left++;
			} else {
				tmp[tIndex] = a[r1];
				tIndex++;
				r1++;
			}
		}
		// 将左边剩余的归并
		while (left <= mid) {
			tmp[tIndex] = a[left];
			tIndex++;
			left++;
		}
		// 将右边剩余的归并
		while (r1 <= right) {
			tmp[tIndex] = a[r1];
			tIndex++;
			r1++;
		}

		System.out.println("第" + (++number) + "趟排序: ");
		// 从临时数组拷贝到原数组
		for (; cIndex <= right; cIndex++) {
			a[cIndex] = tmp[cIndex];
			System.out.print(a[cIndex] + " ");
		}
		System.out.println();

	}
}
