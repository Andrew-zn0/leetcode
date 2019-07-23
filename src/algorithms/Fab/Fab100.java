package algorithms.Fab;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Jay
 * @description 斐波那契数列
 * @date Created in 2019/7/23 19:26
 */
public class Fab100 {
    static Map map = new HashMap();

    static BigInteger f(int n) {
        if (map.get(n) != null) {
            return (BigInteger) map.get(n);
        }
        BigInteger x = f(n - 1).add(f(n - 2));
        map.put(n, x);
        return x;
    }

    public static void main(String[] args) {

        map.put(1, BigInteger.ONE);
        map.put(2, BigInteger.ONE);
        //  System.out.println(f(1000));

        // System.out.println(recFib(50));
        System.out.println(recFib1(50));

        //System.out.println(Long.MAX_VALUE);
    }

    /**
     * 递归实现
     * <p>
     * 时间复杂度太高,大数据会出问题
     *
     * @param i
     * @return
     */
    public static long recFib(long i) {
        long result = 0;
        if (i <= 0) {
            return 0;
        }
        if (i == 1 || i == 2) {
            result = 1;
        } else {
            result = recFib(i - 1) + recFib(i - 2);
        }
        return result;
    }

    /**
     * 动态规划,大数据也会出现问题
     *
     * @param i
     * @return
     */
    public static long recFib1(long i) {
        int[] arr = new int[(int) i];
        //  long[] arr = new long[(int) i];
        arr[0] = 1;
        arr[1] = 1;
        if (i <= 0) {
            return 0;
        }
        if (i == 1 || i == 2) {
            return 1;
        } else {
            int j;
            for (j = 2; j < i; j++) {
                arr[j] = arr[j - 1] + arr[j - 2];
            }
            return arr[(int) (i - 1)];
        }
    }

}
