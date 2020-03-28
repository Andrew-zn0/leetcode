package leetcodeexercise.normal;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Jay
 * @description
 * @date Created in 2020/3/28 4:54 下午
 */
public class Solution48Test {

    @Test
    public void test() {

        int[][] arr = {{1, 2},
                {1, 2}};

        rotate(arr);

        System.out.println(Arrays.toString(arr));

    }

    /**
     * 俩次反转
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 列行互换
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // 反转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    /**
     * 一次旋转
     *
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2 + n % 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int[] tmp = new int[4];
                int row = i;
                int col = j;
                for (int k = 0; k < 4; k++) {
                    tmp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
                for (int k = 0; k < 4; k++) {
                    matrix[row][col] = tmp[(k + 3) % 4];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
            }
        }
    }





}
