package minKElements;

public class HeapSort {

	/**
	 * 堆的定义：堆是亦可完全二叉树，每个节点的值都大于（小于）或等于其左右孩子节点的值为大顶堆（小顶堆）
	 * 堆排序算法：首先建立最大堆，因为最大元素在根A[0]，所以将其与最后一个元素交换 然后去除最后一个节点，重新调整最大堆，循环此过程
	 * 平均情况：O(nlogn)
	 * 最好情况：O(nlogn) 最坏情况：O(nlogn) 辅助空间：O(1) 稳定性：不稳定
	 */

	// 堆排序
	public static void heapSort(int[] data) {
		int heapSize = data.length;
		// 建立最大堆
		buildMaxHeap(data, heapSize);
		// 从最后一个元素开始循环
		for (int i = data.length - 1; i > 0; i--) {
			// 每次建立完大顶堆后,0号元素为最大值
			// 交换最大元素与最后一个元素
			swap(data, i, 0);
			// 交换后只需以新的0号节点为根节点建立大顶堆即可
			keepMaxHeapify(data, 0, --heapSize);
		}

	}

	// 给定一个数组，建立最大堆
	private static void buildMaxHeap(int[] a, int heapSize) {
		// 对数中每一个不是叶节点的节点调用
		// 根据完全二叉树性质，考虑下标从0开始，双亲节点数=(heapSize/2)取整
		for (int i = heapSize / 2; i >= 0; i--) {
			keepMaxHeapify(a, i, heapSize);
			// keepMaxHeapifyNoRecurisive(a, i, heapSize);
		}
	}

	// 保持最大堆性质，使以i为根的子树为最大堆（采用递归方法）
	private static void keepMaxHeapify(int[] a, int i, int heapSize) {
		int left = left(i);
		int right = right(i);

		int largest = i;
		if (left < heapSize && a[left] > a[i]) {
			largest = left;
		}
		if (right < heapSize && a[right] > a[largest]) {
			largest = right;
		}

		if (largest != i) {
			swap(a, largest, i);
			keepMaxHeapify(a, largest, heapSize);
		}
	}

	// 非递归方法保持最大堆性质
	private void keepMaxHeapifyNoRecurisive(int[] a, int i, int heapSize) {
		int largest = i;

		while (largest < heapSize) {
			int left = left(i);
			int right = right(i);
			if (left < heapSize && a[left] > a[i]) {
				largest = left;
			}
			if (right < heapSize && a[right] > a[largest]) {
				largest = right;
			}

			if (largest == i)
				break;
			swap(a, largest, i);
			i = largest;
		}
	}

	/**
	 * 完全二叉树的性质：若一颗完全二叉树按层序从1开始编号 如果i=1，则节点i是根节点，无双亲 如果i>1，则节点i的双亲节点为i/2取整
	 */

	// 父节点（考虑java中下标从0开始，根据完全二叉树的性质，父节点=(i/2)取整）
	private static int parent(int i) {
		return (i - 1) / 2;
		// return (i - 1) >> 1; // 二进制计算法
	}

	// 左孩子（考虑序号下标从0开始，完全二叉树的性质，左孩子节点=(i*2)+1）
	private static int left(int i) {
		return i * 2 + 1;
		// return (i << 1) + 1;
	}

	// 右孩子 （考虑序号下标从0开始，由完全二叉树的性质，右孩子节点=(i+1)*2）
	private static int right(int i) {
		return (i + 1) * 2;
		// return (i + 1) << 1;
	}

	// 交换元素
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
