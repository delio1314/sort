package minKElements;

public class Sort {

	/**
	 * 本类列举了常见的排序算法 1、排序分类： （1）内排序（待排序所有记录全部放在内存中）
	 * （2）外排序（由于记录太多，不能同时放置在内存中，排序过程需要内外存之间的数据交换） 2、内排序的分类1 （1）插入排序类：直接插入排序，希尔排序
	 * （2）选择排序类：简单选择排序，堆排序 （3）交换排序类：冒泡排序，快速排序 （4）归并排序类：归并排序 3、内排序分类2
	 * （1）简单算法：冒泡排序，简单选择排序，直接插入排序 （2）改进算法：希尔排序，堆排序，归并排序，快速排序
	 * 如果待排序序列总是基本有序，使用冒泡或者直接插入排序性能高； 如果没有上述规律，堆排序或者归并排序是很好地选择。
	 */

	/**
	 * 冒泡排序：两两比较相邻记录关键字，如果反序则交换，知道没有反序记录为止 平均情况：O(n^2) 最好情况：O(n) 最坏情况：O(n^2)
	 * 辅助空间：O(1) 稳定性：稳定
	 */
	public static void bubbleSort(int[] data) {
		boolean ordered = false;
		// 从前往后遍历
		for (int i = 0; i < data.length && !ordered; i++) {
			ordered = true;
			// 从后往前遍历
			for (int j = data.length - 1; j > i; j--) {
				// 相邻比较交换顺序
				if (data[j - 1] > data[j]) {
					ordered = false;
					int temp = data[j - 1];
					data[j - 1] = data[j];
					data[j] = temp;
				}
			}
		}
	}

	/**
	 * 简单选择排序：通过n-i次关键字间比较，从n-i+1个记录中选出关键字最小的记录，并和第i个记录交换 平均情况：O(n^2)
	 * 最好情况：O(n^2) 最坏情况：O(n^2) 辅助空间：O(1) 稳定性：稳定
	 */
	public static void selectSort(int[] data) {
		// 从前往后遍历
		for (int i = 0; i < data.length; i++) {
			// 用一个变量记录最小值序号
			int min = i;
			for (int j = i + 1; j < data.length; j++) {
				// 更新最小值
				if (data[min] > data[j]) {
					min = j;
				}
			}
			// 把最小记录与相应位置交换
			int temp = data[i];
			data[i] = data[min];
			data[min] = temp;
		}
	}

	/**
	 * 直接插入排序：将一个记录插入到已排好序的有序表中，从而得到一个新的、记录数增1的有序表 平均情况：O(n^2) 最好情况：O(n)
	 * 最坏情况：O(n^2) 辅助空间：O(1) 稳定性：稳定
	 */
	public static void insertSort(int[] data) {
		// 从前往后遍历
		for (int i = 1; i < data.length; i++) {
			int temp = data[i];
			// 哨兵
			int j = i - 1;
			for (; j >= 0; j--) {
				// 将当前记录data[i]同前i-1个记录比较
				if (temp > data[j]) {
					// 若大于则跳出循环
					break;
				}
				// 若小于则记录后移
				data[j + 1] = data[j];
			}
			// 找到合适位置插入
			data[j + 1] = temp;
		}
	}

	/**
	 * 希尔排序（最小增量排序）：分组插入排序算法 先取一个小于n的整数d1作为一个增量，把表的全部记录分成d1个组，
	 * 所有距离为d1的倍数的记录放在同一个组中，在各组内进行直接插入排序 然后 取第二个增量d2(<d1),重复上述的分组和排序
	 * 直至所取的dt=1,即所有记录放在同一组中进行直接插入排序为止 平均情况：O(nlogn)~O(n^2) 最好情况：O(n^1.3)
	 * 最坏情况：O(n^2) 辅助空间：O(1) 稳定性：不稳定
	 */
	public static void shellSort(int[] data) {
		// 增量
		int gap = data.length / 2;
		int temp;
		while (gap > 0) {
			for (int i = 0; i < data.length; i++) {
				temp = data[i];
				int j = i - gap;
				// 对每组进行直接插入排序
				while (j >= 0 && temp < data[j]) {
					// 若小于则后移
					data[j + gap] = data[j];
					j = j - gap;
				}
				data[j + gap] = temp;
			}
			gap = gap / 2;
		}
	}

	/**
	 * 堆排序：见HeapSort类
	 */

	/**
	 * 归并排序：见MergeSort类
	 */
	
	/**
	 * 快速排序：见QuickSort类
	 */

	
}
