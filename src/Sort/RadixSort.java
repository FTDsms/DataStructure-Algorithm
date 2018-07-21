package Sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {

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
     * 求最大位数，确定排序次数
     * @param array
     * @return
     */
    private int maxLength(int[] array) {
        int max = array[0];
        for (int i=0; i<array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int times = 0;
        while (max > 0) {
            max = max / 10;
            times ++;
        }
        return times;
    }

    /**
     * 从低位到高位依次排序
     * @param array
     */
    private void radixSort(int[] array) {
        int d = maxLength(array);
        int[] temp = new int[array.length];
        int[] buckets = new int[10];
        int radix = 1;
        for (int i=1; i<=d; ++i) {
            Arrays.fill(buckets, 0); // 重置count数组
            System.arraycopy(array, 0, temp, 0, array.length);
            for (int j=0; j<array.length; ++j) {
                int subKey = (temp[j] / radix) % 10;
                buckets[subKey] ++;
            }
            for (int j=1; j<10; ++j) {
                buckets[j] = buckets[j] + buckets[j-1];
            }
            for (int m=array.length-1; m>=0; --m) {
                int subKey = (temp[m] / radix) % 10;
                array[--buckets[subKey]] = temp[m];
            }
            radix *= 10;
            print(array);
        }
    }

    public static void main(String[] args) {
        RadixSort sort = new RadixSort();
//        int[] array = {1, 9, 8, 7, 6, 5, 2, 4, 3};
        int[] array = {265, 301, 751, 129, 937, 863, 742, 694, 76, 438};
        sort.radixSort(array);
    }

}
