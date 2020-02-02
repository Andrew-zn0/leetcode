package datastructure;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Jay
 * @description 方法测试
 * @date Created in 2019/5/22 17:47
 */
public class Test {
    public static void main(String[] args) {
        int[] a = {2, 5};
        int[] b = {1, 7};
        int[] c = merge(a, b);
        for (int num:c){
            System.out.print(num);
        }
    }


    public static int[] merge(int[] a, int[] b) {
        int pa = 0, pb = 0, pc = 0;
        int m = a.length;
        int n = b.length;
        int[] c = new int[m + n];
        while (pa < m && pb < n) {
            if (a[pa] < b[pb]) {
                c[pc++] = a[pa++];
            } else {
                c[pc++] = b[pb++];
            }
        }
        if (pa < m) {
            while (pa < m) {
                c[pc++] = a[pa++];
            }
        } else {
            while (pb < n) {
                c[pc++] = b[pb++];
            }
        }
        return c;
    }
}
