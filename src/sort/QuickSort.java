package sort;

/**
 * 快速排序
 */
public class QuickSort {

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
     * 随机选一个数，小于此数的放在左边，大于此数的放在右边，递归调用快速排序
     * @param array
     */
    private void quickSort(int[] array, int left, int right) {
        int i, j, t, temp;
        // 递归结束条件
        if (left > right) {
            return;
        }
        temp = array[left];
        i = left;
        j = right;
        while (i != j) {
            // 顺序很重要，要先从右边开始找（最后交换基准时换过去的数要保证比基准小，因为基准选取数组第一个数，在小数堆中
            while (array[j] >= temp && i < j) {
                j--;
            }
            // 再找左边的
            while (array[i] <= temp && i < j) {
                i++;
            }
            // 交换两个数在数组中的位置
            if (i < j) {
                t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }
        // 最终将基准数归位
        array[left] = array[i];
        array[i] = temp;

        quickSort(array, left, i-1);
        quickSort(array, i+1, right);

        print(array);
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] array = {1, 9, 8, 7, 6, 5, 2, 4, 3};
        sort.quickSort(array, 0, array.length-1);
    }

}
