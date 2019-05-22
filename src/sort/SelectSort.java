
package sort;

/**
 * @author Jay
 * @description 简单选择排序
 * @date Created in 2019/5/22 15:46
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 6, 7};
        init(a);
        for (int b : a) {
            System.out.println(b);
        }
    }

    private static void init(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }
}
