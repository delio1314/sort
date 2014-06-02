public class MergeSort {
    
    public static void main(String[] args) {
        int[] data = {3, 2, 9, 5, 7, 1, 4, 6, 0, 8};
        System.out.print("before merge Sort: ");
        printArray(data);
        mergeSort(data);
        System.out.print("after merge Sort: ");
        printArray(data);
    }

    public static void mergeSort(int[] data) {
        mergeSortRecursion(data, 0, data.length - 1);
    }

    public static void mergeSortRecursion(int[] data, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        mergeSortRecursion(data, left, mid);
        mergeSortRecursion(data, mid + 1, right);
        merge(data, left, mid, right);
    }

    public static void merge(int[] data, int left, int mid, int right) {
        int[] tempArray = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = mid + 1;
        int index = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            if (data[leftIndex] <= data[rightIndex]) {
                tempArray[index] = data[leftIndex];
                leftIndex++;
            } else {
                tempArray[index] = data[rightIndex];
                rightIndex++;
            }
            index++; 
        }
        while (leftIndex <= mid) {
            tempArray[index] = data[leftIndex];
            leftIndex++;
            index++;
        }
        while (rightIndex <= right) {
            tempArray[index] = data[rightIndex];
            rightIndex++;
            index++;
        }
        for(int i=left; i<=right; i++) {
            data[i] = tempArray[i-left];
        }
    }

    public static void printArray(int[] data) {
        for(int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
