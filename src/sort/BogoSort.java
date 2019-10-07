package sort;

import java.util.Random;

/**
 * 猴子排序
 */
public class BogoSort {

	private void bogoSort(int[] n) {
	    while(!inOrder(n)) {
			shuffle(n);
		}
	}

    /**
     * 随机洗牌
     * @param n
     */
	private void shuffle(int[] n) {
		Random ran = new Random();
		for (int i = 0; i < n.length; i++) {
			int swapPosition = ran.nextInt(i + 1);
			int temp = n[i];
			n[i] = n[swapPosition];
			n[swapPosition] = temp;
		}
	}

    /**
     * 判断是否为正确序列
     * @param n
     * @return
     */
	private boolean inOrder(int[] n) {
	    for (int i = 0; i < n.length-1; i++) 
	    {
	        if (n[i] > n[i+1]) {
				return false;
			}
	    }
	    return true;
	}

	public static void main(String[] args) {
		BogoSort monkey = new BogoSort();
		int[] array = {1, 9, 8, 7, 6, 5, 2, 4, 3};
		monkey.bogoSort(array);
		for(int i : array) {
			System.out.print(i + " ");
		}
	}

}
