package Sort;

/**
 * 归并排序
 */
public class MergeSort {

    /**
     * 打印数组
     * @param array
     */
    private void print(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i = low; // 左指针
        int j = mid + 1; // 右指针
        int count = 0;
        // 将较小的数移到新数组
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                temp[count++] = array[i++];
            } else {
                temp[count++] = array[j++];
            }
        }
        // 将左边剩余的数移入数组
        while (i <= mid) {
            temp[count++] = array[i++];
        }
        // 将右边剩余的数移入数组
        while (j <= high) {
            temp[count++] = array[j++];
        }
        for (int k=0; k<temp.length; ++k) {
            array[low+k] = temp[k];
        }
    }

    /**
     * 将两个有序表合并成一个新的有序表
     * @param array
     */
    private void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid); // left
            mergeSort(array, mid+1, high); // right
            merge(array, low, mid, high); // merge
        }
        print(array);
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] array = {1, 9, 8, 7, 6, 5, 2, 4, 3};
        sort.mergeSort(array, 0, array.length-1);
    }

}
