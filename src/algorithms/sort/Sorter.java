package algorithms.sort;


import org.junit.Test;


/**
 * @author Jay
 * @description 排序方法
 * @date Created in 2019/6/28 16:22
 */
public class Sorter {

    private void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void test() {
        int[] a = {7, 3, 4, 13, 1, 75, 4, 5, 10, 98};
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {

            //insertSort(a, 0, a.length - 1);
            //myInsertSort(a, 0, a.length - 1);
            //binInsertSort(a, 0, a.length - 1);
            //shellSort(a, 0, a.length - 1);
            //bubbleSort(a, 0, a.length - 1);
            //quickSort(a, 0, a.length - 1);
            selectSort(a, 0, a.length - 1);
        }
        print(a);
        long l = System.currentTimeMillis();
        System.out.println("排序时间:" + (l - start));
    }

    /**
     * 直接插入排序
     * <p>
     * 排序思想:
     * 逐个考察每个待排序元素，将每一个新元素插入到前面已
     * 经排好序的序列中适当的位置上，使得新序列仍然是一个有序序列
     * <p>
     * 仅有一个元素的序列总是有序的，
     * 因此，对 n 个记录的序列，可从第二个元素开始直到第 n 个元素，
     * 逐个向有序序列中执行插入操作，从而得到 n 个元素按关键字有序的序列。
     * <p>
     * 在含有 j-1 个元素的有序序列中插入一个元素的方法是：从第 j-1 个元素开
     * 始依次向前搜索应当插入的位置，并且在搜索插入位置的同时可以后移元素，
     * 这样当找到适当的插入位置时即可直接插入元素
     * <p>
     * 空间效率：O(1)
     * 仅使用一个辅存单元。
     * <p>
     * 时间效率：O(n 2 ) 稳定排序
     * 假设待排序的元素个数为 n，则向有序表中逐个插入记录的操作进行了 n-1
     * 趟，每趟操作分为比较关键码和移动记录，而比较的次数和移动记录的次数取决于待排序列
     * 按关键码的初始排列。
     * <p>
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

    private void myInsertSort(int[] r, int low, int high) {

        for (int i = low + 1; i <= high; i++) {
            int temp = r[i];
            // 插入位置
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (r[j] > temp) {
                    r[j + 1] = r[j];
                } else {
                    break;
                }
            }
            r[j + 1] = temp;
        }
    }

    /**
     * 折半插入
     * <p>
     * 排序思路
     * <p>
     * 直接插入排序的基本操作是向有序序列中插入一个元素，插入位置的确定是通过对有序
     * 序列中元素按关键字逐个比较得到的。既然是在有序序列中确定插入位置，则可以不断二分
     * 有序序列来确定插入位置，即搜索插入位置的方法可以使用折半查找实现
     * <p>
     * 数据量加大后比直接插入移动时间没有减少,减少寻找插入位置时间
     * <p>
     * 时间效率：O(n 2 ) 稳定排序
     * 空间效率：O(1)
     *
     * @param r
     * @param low
     * @param high
     */
    private void binInsertSort(int[] r, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            // 保存带插入元素
            int temp = r[i];
            // 设置初始区间
            int hi = i - 1;
            int lo = low;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (temp < r[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            for (int j = i - 1; j > hi; j--) {
                r[j + 1] = r[j];
            }
            // 插入元素
            r[hi + 1] = temp;
        }
    }

    /**
     * 希尔排序
     * <p>
     * 基本思想:
     * 首先将待排序的元素分为多个子序列，使得每个子序列的元素
     * 个数相对较少，对各个子序列分别进行直接插入排序，待整个待排序序列“基本有序”后，再
     * 对所有元素进行一次直接插入排序
     * <p>
     * 排序过程:
     * 1.选择一个步长序列t 1 ，t 2 ，…，t k ，其中t i >t j （i<j），t k =1；
     * 2.按步长序列个数 k，对待排序元素序列进行 k 趟排序；
     * 3.每趟排序，根据对应的步长t i ，将待排序列分割成t i 个子序列，分别对各子序列
     * 进行直接插入排序。
     * <p>
     * 在选择步长序列时应当注意：应使步长序列中的步长值
     * 互质，并且最后一个步长值必须等于 1
     * <p>
     * 时间复杂度: Ο(n 3/2 )
     *
     * @param r
     * @param low
     * @param high
     */
    private void shellSort(int[] r, int low, int high) {
        // 步长
        int gap = 1;
        while (gap < high + 1) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < high + 1; i++) {
                int temp = r[i];
                int j = i - gap;

                // 跨区间排序
                while (j >= 0 && r[j] > temp) {
                    r[j + gap] = r[j];
                    j -= gap;
                }
                r[j + gap] = temp;
            }
            gap = gap / 3;
        }
    }

    /**
     * 冒泡排序
     * <p>
     * 空间效率：
     * 仅使用一个辅存单元
     * <p>
     * 时间效率：Ο(n 2 )
     * 假设待排序的元素个数为 n，则总共要进行 n-1 趟排序，对 j 个元素的子序
     * 列进行一趟起泡排序需要进行 j-1 次关键字比较
     * <p>
     * 改进思想:
     * 由于i每次排序,都会有一个元素为正确位置,则j排序次数减1,
     *
     * @param r
     * @param low
     * @param high
     */
    private void bubbleSort(int[] r, int low, int high) {
        int n = high - low + 1;
        for (int i = 0; i < n - 1; i++) {
            // 改进排序
            // for (int j = 0; j < high-i; j++) {
            for (int j = 0; j < n - 1; j++) {
                int temp;
                if (r[j] < r[j + 1]) {
                    temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 快速排序
     * <p>
     * 基本思想:
     * 通过一个枢轴（pivot）元素将 n 个元素的序列分为左、右两个子序列 Ll 和 Lr，其中子序列 Ll
     * 中的元素均比枢轴元素小，而子序列 Lr 中的元素均比枢轴元素大，然后对左、右子序列分
     * 别进行快速排序，在将左、右子序列排好序后，则整个序列有序，而对左右子序列的排序过
     * 程直到子序列中只包含一个元素时结束
     * <p>
     * 时间效率: T(n) = Θ(n log n)
     * <p>
     * 空间效率:
     * 堆栈的最大深度为 log n，但是，在最坏的情况
     * 下，堆栈的最大深度为 n。
     *
     * @param r
     * @param low
     * @param high
     */
    private void quickSort(int[] r, int low, int high) {
        if (low < high) {
            int pa = partition(r, low, high);
            quickSort(r, low, pa - 1);
            quickSort(r, pa + 1, high);
        }

    }

    /**
     * 递归
     *
     * @param r
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] r, int low, int high) {
        // 作为枢轴元素
        int pivot = r[low];
        // 从两端交替向内扫描
        while (low < high) {
            while (low < high && r[high] >= pivot) {
                high--;
            }
            // 将比pivot小的元素移向低端
            r[low] = r[high];
            while (low < high && r[low] <= pivot) {
                low++;
            }
            // 将比pivot大的元素移向高端
            r[high] = r[low];
        }
        // 设置枢轴
        r[low] = pivot;
        // 返回枢轴元素位置
        return low;
    }

    /**
     * 简单选择排序、
     * <p>
     * 基本思想：
     * <p>
     * 第一趟，从 n 个元素中找出关键字最小的元素
     * 与第一个元素交换；第二趟，在从第二个元素开始的 n-1 个元素中再选出关键字最小的元素
     * 与第二个元素交换；如此，第 k 趟，则从第 k 个元素开始的 n-k+1 个元素中选出关键字最小
     * 的元素与第 k 个元素交换。
     * <p>
     * 空间效率：1
     * <p>
     * 时间效率：Ο(n 2 )。
     * <p>
     * 改进思想：
     * 简单选择排序的主要操作是元素间的比较
     * 操作，因此改进简单选择排序应从减少元素比较次数出发。在简单选择排序中，首先从 n
     * 个元素的序列中选择关键字最小的元素需要 n-1 次比较，在 n-1 个元素中选择关键字最小的
     * 元素需要 n-2 次比较……，在此过程中每次选择关键字最小的元素都没有利用以前比较操作
     * 得到的结果。欲降低比较操作的次数，则需要把以前比较的结果记录下来，由此得到一种改
     * 进的选择类排序算法，即树型选择排序
     *
     * @param r
     * @param low
     * @param high
     */
    private void selectSort(int[] r, int low, int high) {
        for (int k = low; k < high - 1; k++) {
            int min = k;

            for (int i = min + 1; i <= high; i++) {
                if (r[i] < r[min]) {
                    min = i;
                }
            }
            if (k != min) {
                // 关键字最小的元素与元素 r[k]交换
                int temp = r[k];
                r[k] = r[min];
                r[min] = temp;
            }
        }
    }



}
