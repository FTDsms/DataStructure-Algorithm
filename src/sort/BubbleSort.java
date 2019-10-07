package sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

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
     * 两两作比较，如果前面大于后面则交换，每次将最大的一个交换到最后
     * @param array
     */
    private void bubbleSort(int[] array) {
        for (int i=array.length-1; i>0; --i) {
            for (int j=0; j<i; ++j) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    print(array);
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] array = {1, 9, 8, 7, 6, 5, 2, 4, 3};
        sort.bubbleSort(array);
    }

}
