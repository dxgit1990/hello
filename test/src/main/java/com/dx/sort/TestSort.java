package com.dx.sort;

/**
 * @author dx
 * @create 2020/4/11 10:46
 * @for new
 */
public class TestSort {
    public static void main(String[] args) {
        int[] nums = {16, 7, 9, 21, 5, 13, 32, 18, 41, 3};
//        insertSort(nums);
//        maopaoSort(nums);
//        selectSort(nums);
//        int[] nums = {5, 7, 9, 16, 21, 3, 13, 18, 32, 41};
        mergeSort(nums, 0, nums.length - 1);
        printNum(nums);
    }

    /**
     *
     * @param nums 排序数组
     * @param left  数组初始下标
     * @param right 数组结束下标 一般为 length-1
     */
    private static void mergeSort(int[] nums, int left, int right) {
        if (left == right) return;
        //分两半
        int mid = left + (right - left) / 2;
        //左边排序
        mergeSort(nums, left, mid);
        //右边排序
        mergeSort(nums, mid+1, right);
        merge(nums, left, mid+1, right);
    }

    /**
     * @param nums   合并的数组
     * @param lp     左指针位置
     * @param rp     右指针位置
     * @param rbound 右边界
     */
    private static void merge(int[] nums, int lp, int rp, int rbound) {
        int mid = rp - 1;
        int i = lp, j = rp, k = 0;
        int[] temp = new int[rbound - lp + 1];
        while (i <= mid && j <= rbound) {
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= rbound) temp[k++] = nums[j++];
//        printNum(temp);
        for (int l = 0; l < temp.length; l++) {
            nums[lp+l]=temp[l];
        }
    }


    private static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int mindex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[mindex]) {
                    mindex = j;
                }
            }
            changeNum(nums, i, mindex);
        }
        printNum(nums);
    }


    private static void maopaoSort(int[] nums) {
        //方法1
//        for (int i = nums.length-1; i > 0; i--) {
//            for (int j = 0; j < i; j++) {
//                if(nums[j]>nums[j+1]){
//
//                    changeNum(nums, j, j+1);
//                }
//            }
//        }
        //方法2
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    changeNum(nums, j, j + 1);
                }
            }

        }
        printNum(nums);
    }

    private static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //方法3
//            int temp = nums[i];
//            int j=i;
//            for (; j > 0 && nums[j - 1] > temp; j--) {
//                nums[j] = nums[j - 1];
//            }
//            nums[j] = temp;
            //方法2
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    changeNum(nums, j, j - 1);
                } else {
                    break;
                }
            }
            //方法1
//            for (int j = i - 1; j >= 0; j--) {
//                if (nums[j] > nums[j + 1]) {
//                    changeNum(nums, j+1, j);
//                } else {
//                    break;
//                }
//
//            }
        }
        printNum(nums);
    }

    private static void printNum(int[] nums) {
        for (int num : nums) {
            System.out.println("num = " + num);
        }
    }

    private static void changeNum(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
