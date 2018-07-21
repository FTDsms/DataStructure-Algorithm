package Sort;

/**
 * 希尔排序
 */
public class ShellSort {

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
     * 改良的插入排序，步长从大到小调整，第一次循环后面元素逐个和前面元素按间隔步长进行比较并交换，直至步长为1
     * @param array
     */
    private void shellSort(int[] array) {
        int d = array.length;
        do {
            d = d/2;
            for (int i = 0; i < d; i++)
            {
                for (int j = i + d; j < array.length; j = j + d)
                {
                    int temp = array[j];
                    int k;
                    for (k = j - d; k >= 0 && array[k] > temp; k = k - d)
                    {
                        array[k + d] = array[k];
                    }
                    array[k + d] = temp;
                }
            }
            print(array);
        } while (d > 1);
    }

    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        int[] array = {1, 9, 8, 7, 6, 5, 2, 4, 3};
        sort.shellSort(array);
    }

}
