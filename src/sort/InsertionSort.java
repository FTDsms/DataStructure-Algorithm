package sort;

/**
 * 选择排序
 */
public class InsertionSort {

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

    /**
     * 如果第j个大于j+1，则向后移，直至找到一个小的插入该位置
     * @param array
     */
    private void insertionSort(int[] array) {
        for (int i=1; i<array.length; ++i) {
            int temp = array[i];
            int j;
            for (j=i-1; j>=0 && array[j] > temp; --j) {
                array[j+1] = array[j];
            }
            array[j+1] = temp;
            print(array);
        }
    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] array = {1, 9, 8, 7, 6, 5, 2, 4, 3};
        sort.insertionSort(array);
    }

}
