public class QuickSelect {

    public static void main(String[] args) {
        int[] data = {3, 2, 9, 5, 7, 1, 4, 6, 0, 8};
        System.out.print("array: ");
        printArray(data);
        int k = 2;
        System.out.println("k: " + k);
        System.out.println(quickSelect(data, 0, data.length - 1, k));
    }

    // 三数取中法选取枢纽元
    public static int medianOfThree(int[] data, int left, int right) {
        int center = (left + right) / 2;
        if (data[center] < data[left])
            swap(data, center, left);  // 保证左端最小
        if (data[right] < data[left])
            swap(data, left, right);  // 保证左端最小
        if (data[right] < data[center])
            swap(data, center, right);  // 保证右端最大
        swap(data, center, left); // 将pivot置于low
        return data[left];
    }

    public static Integer quickSelect(int[] data, int left, int right, int k) {
        if (right - left + 1 < k)
            return null;
        // int pivot = medianOfThree(data, left, right);
        int pivot = data[left];
        int i = left + 1;
        int j = right;
        for(;;) {
            while (data[i] < pivot && i + 1 < data.length)
                i++;
            while (data[j] > pivot && j - 1 > -1)
                j--;
            if (i < j)
                swap(data, i, j);
            else
                break;
        }
        swap(data, j, left);

        if (j - left + 1 == k)
            return data[j];
        else if (j - left + 1 > k)
            return quickSelect(data, left, j - 1, k);
        else 
            return quickSelect(data, j + 1, right, k - (j - left + 1));
    }

    // 交换元素
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void printArray(int[] data) {
        for(int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}