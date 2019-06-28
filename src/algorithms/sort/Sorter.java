package algorithms.sort;


import org.junit.Test;


/**
 * @author Jay
 * @description 排序方法
 * @date Created in 2019/6/28 16:22
 */
public class Sorter {


    @Test
    public void test() {
        int[] a = {7, 3, 4, 13, 1, 75, 4, 5, 10, 98};
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {

            insertSort(a, 0, a.length - 1);
        }
        print(a);
        long l = System.currentTimeMillis();
        System.out.println("排序时间:" + (l - start));
    }

    /**
     * 直接插入排序
     * <p>
     * 排序思想:
     *
     * @param r
     * @param low
     * @param high
     */
    private void insertSort(int[] r, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            if (r[i - 1] > r[i]) {
                int temp = r[i];
                r[i] = r[i - 1];
                int j = i - 2;
                for (; j >= low && temp < r[j]; j--) {
                    // 记录后移
                    r[j + 1] = r[j];
                }
                // 插入正确位置
                r[j + 1] = temp;
            }
        }
    }

    private void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
