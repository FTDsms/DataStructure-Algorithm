package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 箱子排序
 */
public class BinSort {

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
     * 求最大值
     * @param array
     * @return
     */
    private int max(int[] array) {
        int max = array[0];
        for (int i=0; i<array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * 求最小值
     * @param array
     * @return
     */
    private int min(int[] array) {
        int min = array[0];
        for (int i=0; i<array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * 非比较排序
     * 将n个数，分成m个桶，桶之间元素递增，然后对桶内的元素进行排序，最后输出所有元素
     * 可用于最大值最小值相差较大的数据情况，但要求数据分布必须均匀，否则可能导致数据都集中到一个桶中
     * @param array
     */
    private void binSort(int[] array) {
        int max = max(array);
        int min = min(array);
        // 桶数
        int bucketNum = (max-min)/array.length +1;
        List<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i=0; i<bucketNum; ++i) {
            bucketArr.add(new ArrayList<Integer>());
        }
        // 将每个元素放入桶
        for (int i=0; i<array.length; ++i) {
            int num = (array[i] - min) / array.length;
            bucketArr.get(num).add(array[i]);
        }
        // 对每个桶进行排序
        for (int i=0; i<bucketArr.size(); ++i) {
            Collections.sort(bucketArr.get(i));
        }
        System.out.println(bucketArr.toString());

        int[] t = new int[array.length];
        int index = 0;
        for (ArrayList<Integer> list : bucketArr) {
            for (Integer aList : list) {
                if (aList != null) {
                    t[index] = aList;
                    index++;
                }
            }
        }
        print(t);
    }

    public static void main(String[] args) {
        BinSort sort = new BinSort();
//        int[] array = {1, 9, 8, 7, 6, 5, 2, 4, 3};
        int[] array = {98, 67, 2, 110, 233, 3, 986, 789, 1120, 10004, 10039, 1024};
        sort.binSort(array);
    }

}
