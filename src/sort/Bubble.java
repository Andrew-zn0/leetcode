package sort;

/**
 * @author Jay
 * @date 2019/5/22 23:22
 * @description 冒泡排序
 */
public class Bubble {
    public static void main(String[] args) {
        int[] a = {2, 4, 5, 6, 7, 3, 8};
        sort(a);
        show(a);
    }

    private static void sort(int[] a) {
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    static void show(int[] a) {
        for (int b : a) {
            System.out.print(b);
        }
    }
}
