package Sort;

/**
 * 堆排序
 */
public class HeapSort {

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
     * 构建最大堆
     * @param array
     */
    private void buildMaxHeap(int[] array) {
        // 从最后一个节点array.length-1的父节点(array.length-1-1)/2开始，直到根节点，反复调整堆
        for (int i=(array.length-2)/2; i>=0; --i) {
            adjustDownToUp(array, i, array.length);
        }
    }

    /**
     * 将元素array[k]自下往上逐步调整树结构
     * @param array
     * @param k
     * @param length
     */
    private void adjustDownToUp(int[] array, int k, int length) {
        int temp = array[k];
        for (int i=2*k+1; i<length-1; i=2*i+1) {
            // i为初始化节点k的左孩子，沿节点较大的子节点向下调整
            if (i < length && array[i] < array[i+1]) {
                // 取节点较大的子节点的下标，如果节点的右孩子>左孩子，则取右孩子节点的下标
                i++;
            }
            if (temp >= array[i]) {
                // 根节点>=左右子节点关键字较大者，调整结束
                break;
            }
            array[k] = array[i]; // 将左右子节点中较大值array[i]调整到父节点上
            k = i; // 修改k值，以便继续向下调整
        }
        array[k] = temp; // 被调整的节点的值放入最终位置
    }

    /**
     * 堆排序
     * @param array
     */
    private void heapSort(int[] array) {
        buildMaxHeap(array); // 初始建堆，array[0]为第一趟最大的元素
        for (int i=array.length-1; i>0; --i) {
            // 将堆订元素和堆底元素交换，即得到当前最大元素正确的排序位置
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjustDownToUp(array, 0, i); // 将剩余的元素整理成堆
        }
        print(array);
    }

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] array = {1, 9, 8, 7, 6, 5, 2, 4, 3};
        sort.heapSort(array);
    }

}
