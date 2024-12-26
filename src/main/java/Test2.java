import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {

//    给出两个已经按照非递减顺序排列好的整数数组nums1和nums2，同时给定两个整数m和n，
//    分别代表nums1和nums2中的元素数量。
//    需要将nums2中的元素合并到nums1中，使得合并后的数组仍然保持非递减顺序排列。
//    注意：最终的合并结果不需要通过函数返回，而是需要保存在数组nums1中。
//    为此，nums1的初始长度设置为m + n，其中前m个元素表示需要合并的部分，剩余的n个元素为0，可以忽略不计。
//    nums2的长度为n。
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
            while (j >= 0) {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {

                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {9, 5, 6};
        merge(a, 3, b, 3);

        System.out.println(Arrays.toString(a));
    }


}
