package algorithms.sort;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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
            //selectSort(a, 0, a.length - 1);
            //heapSort(a, 0, a.length - 1);
            //mergeSort(a, 0, a.length - 1);
            //countSort(a, 0, a.length - 1);
            bucketSort(a, 0, a.length - 1);
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
     * <p>
     * 树型选择排序
     * <p>
     * 基本思想:
     * <p>
     * 先把待排序的n个元素两两进行比较，
     * 取出较小者，若轮空则直接进入下一轮比较；然后在⎡n/2⎤个较小者中，采用同样的方法进行
     * 比较，再选出较小者；如此反复，直到选出关键字最小的元素为止。这个过程可以使用一颗
     * 具有n个结点的完全二叉树来表示，最终选出的关键字最小的元素就是这棵二叉树的根结点。
     * <p>
     * 在输出关键字最小的元素后，为选 出次小关键字，可以将最小关键字元素所对应的叶
     * 子结点的关键字设置为∞，然后从该叶子结点起逆行向上，将所经过的结点与
     * 其兄弟进行比较，修改从该叶子结点到根结点上各结点的值，则根结点的值即
     * 为次小关键字.
     * <p>
     * 时间效率:Ο(n log n)
     * <p>
     * 空间效率:n-1
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

    /**
     * 元素筛选过程
     *
     * @param arr
     * @param index
     * @param length
     */
    private void heapAdjust(int[] arr, int index, int length) {
        // 左子节点下标
        int leftChild = 2 * index + 1;
        // 右子节点下标
        int rightChild = 2 * index + 2;
        // 要调整的节点下标
        int present = index;

        // 下沉左边
        if (leftChild < length && arr[leftChild] > arr[present]) {
            present = leftChild;
        }
        // 下沉右边
        if (rightChild < length && arr[rightChild] > arr[present]) {
            present = rightChild;
        }
        // 如果下标不相等 证明调换过了
        if (present != index) {
            // 交换值
            int temp = arr[index];
            arr[index] = arr[present];
            arr[present] = temp;
            // 继续下沉
            heapAdjust(arr, present, length);
        }

    }

    /**
     * 堆排序
     * <p>
     * 大顶堆
     * <p>
     * 基本思想:
     * <p>
     * 设有 n 个元素，欲将其按关键字排序。可以首先将这 n 个元素按关键字建成堆，将堆顶
     * 元素输出，得到 n 个元素中关键字最大（或最小）的元素。然后，再将剩下的 n-1 个元素重
     * 新建成堆，再输出堆顶元素，得到 n 个元素中关键字次大（或次小）的元素
     * <p>
     * 执行过程:
     * <p>
     * 设有一个具有 m 个元素的堆，输出堆顶元素后，剩下 m-1 个元素。具体的调整方法是：
     * 首先，将堆底元素（最后一个元素）送入堆顶，此时堆被破坏，其原因仅是根结点不满足堆
     * 的性质，而根结点的左右子树仍是堆。然后，将根结点与左、右子女中较大（或较小）的进
     * 行交换。若与左孩子交换，则左子树堆被破坏，且仅左子树的根结点不满足堆的性质；若与
     * 右孩子交换，则右子树堆被破坏，且仅右子树的根结点不满足堆的性质。继续对不满足堆性
     * 质的子树进行上述交换操作，直到叶子结点，则堆被重建。
     * <p>
     * 空间效率:1
     * <p>
     * 时间效率: Ο(n log n)
     * <p>
     * 堆构建比较次数:
     * s = 2^( i - 1 )  *  ( k - i )
     * i:当前层数
     * k:总深度
     * k-i 当前层最坏情况比较次数,及每次元素沉到最底层所需比较次数
     *
     * @param r
     * @param low
     * @param high
     */
    private void heapSort(int[] r, int low, int high) {
        // 初始化建堆
        for (int i = r.length / 2; i >= 0; i--) {
            heapAdjust(r, i, high + 1);
        }
        // 不断输出堆顶元素并调整 r[0..i-1]为新堆
        for (int i = high; i > 0; i--) {
            // 交换堆顶与堆底元素
            int temp = r[0];
            r[0] = r[i];
            r[i] = temp;
            // 调整
            heapAdjust(r, 0, i - 1);
        }
    }

    /**
     * 归并排序(分治法)
     * <p>
     * 基本思想：
     * <p>
     * 基于合并操作，即合并两个已经有序的序列是容易的，不论这两
     * 个序列是顺序存储还是链式存储，合并操作都可以在 Ο(m+n)时间内完成（假设两个有序表
     * 的长度分别为 m 和 n）。
     * <p>
     * 操作步骤：
     * <p>
     * 1.划分：将待排序的序列划分为大小相等（或大致相等）的两个子序列；
     * 2.治理：当子序列的规模大于 1 时，递归排序子序列，如果子序列规模为 1 则成为有序序列；
     * 3.组合：将两个有序的子序列合并为一个有序序列。
     * <p>
     * 时间效率：Ο(n log n)。
     * <p>
     * 空间效率：Θ(n)
     * <p>
     * 任何一个基于比较操作的排序方法，在最坏情况下所需要进
     * 行的比较次数至少为 n log n 次，即算法的时间复杂度下界为 Ω(n long n)。
     *
     * @param r
     * @param low
     * @param high
     */
    private void mergeSort(int[] r, int low, int high) {

        if (low < high) {
            mergeSort(r, low, (high + low) / 2);
            mergeSort(r, (high + low) / 2 + 1, high);
            merge(r, low, (high + low) / 2, high);
        }
    }

    /**
     * 输入：数据元素数组 a，a 待合并的两个有序区间[p..q]以及[q+1..r]
     * 输出：将两个有序区间合并为一个有序区间
     *
     * @param r
     * @param p
     * @param q
     * @param a
     */
    private void merge(int[] a, int p, int q, int r) {
        int[] b = new int[r - p + 1];
        int s = p;
        int t = q + 1;
        int k = 0;
        while (s <= q && t <= r) {
            if (a[s] < a[t]) {
                b[k++] = a[s++];
            } else {
                b[k++] = a[t++];
            }
        }
        while (s <= q) {
            b[k++] = a[s++];
        }
        while (t <= r) {
            b[k++] = a[t++];
        }
        for (int i = 0; i < b.length; i++) {
            a[p + i] = b[i];
        }
    }

    /**
     * 计数排序
     * <p>
     * 时间效率: O(n)
     * <p>
     * 空间效率:最大元素值大小
     * <p>
     * 算法过程:
     * 1.找到元素中最大元素max
     * 2.开辟数组arr[max]
     * 3.将元素对应下标入组,然后遍历取出
     * <p>
     * 由于空间浪费较大
     * 计数排序只适用于正整数并且取值范围相差不大的数组排序使用，它的排序的速度是非常可观的。
     *
     * @param r
     * @param low
     * @param high
     */
    private void countSort(int[] r, int low, int high) {
        // 找出最大值
        int max = r[0];
        for (int i = 1; i <= high; i++) {
            if (r[i] > max) {
                max = r[i];
            }
        }
        // 初始化数组
        int[] countArr = new int[max + 1];
        // 计数
        for (int i = 0; i <= high; i++) {
            countArr[r[i]]++;
            r[i] = 0;
        }
        // 排序
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                r[index++] = i;
                countArr[i]--;
            }
        }
    }

    /**
     * 桶排序
     * <p>
     * 基本思想:
     * 桶排序可以看成是计数排序的升级版，它将要排的数据分到多个有序的桶里，
     * 每个桶里的数据再单独排序，再把每个桶的数据依次取出，即可完成排序。
     * <p>
     * 操作步骤:
     * 1.找出元素最大值最小值之差.
     * 2.根据差值建立等大小的桶,将差值分成若干桶
     * 3.每个元素进去对应区间桶
     * 4.桶内排序,然后拿出
     * <p>
     * 由于计数占用空间太大,桶排序则将max大数据空间变为max/n大小.
     *
     * @param arr
     * @param low
     * @param high
     */
    private void bucketSort(int[] arr, int low, int high) {
        int max = arr[0];
        int min = arr[0];
        int length = high + 1;
        for (int i = 1; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        // 最大值和最小值的差
        int diff = max - min;
        // 桶列表
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            bucketList.add(new ArrayList<>());
        }
        // 每个桶的存数区间
        float section = (float) diff / (float) (length - 1);
        // 数据入桶
        for (int i = 0; i < length; i++) {
            // 当前数除以区间得出存放桶的位置 减1后得出桶的下标
            int num = (int) (arr[i] / section) - 1;
            if (num < 0) {
                num = 0;
            }
            bucketList.get(num).add(arr[i]);
        }
        // 桶内排序
        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }
        //写入原数组
        int index = 0;
        for (List<Integer> arrayList : bucketList) {
            for (int value : arrayList) {
                arr[index] = value;
                index++;
            }
        }
    }
}
