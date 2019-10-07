package sort;

/**
 * 选择排序
 */
public class SelectionSort {

    /**
     * 求数组前n个最大值的位置
     * @param array
     * @param n
     * @return
     */
    private int max(int[] array, int n) {
        int max = array[0];
        int m = 0;
        for (int i=0; i<n; ++i) {
            if (array[i] > max) {
                max = array[i];
                m = i;
            }
        }
        return m;
    }

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
     * 选出前i个最大值并与第i个交换
     * @param array
     */
    private void selectionSort(int[] array) {
        for (int i=array.length-1; i>0; --i) {
            int m = max(array, i+1);
            int temp = array[m];
            array[m] = array[i];
            array[i] = temp;
            print(array);
        }
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] array = {1, 9, 8, 7, 6, 5, 2, 4, 3};
        sort.selectionSort(array);
    }

}
