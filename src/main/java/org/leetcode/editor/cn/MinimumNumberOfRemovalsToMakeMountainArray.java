
package org.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 题目编号:1671
 * 题目标题:得到山形数组的最少删除次数
 * 2023-12-22 21:53:01
 */
//我们定义 arr 是 山形数组 当且仅当它满足： 
//
// 
// arr.length >= 3 
// 存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且： 
// 
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 
// 
// 
//
// 给你整数数组 nums ，请你返回将 nums 变成 山形状数组 的 最少 删除次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,1]
//输出：0
//解释：数组本身就是山形数组，所以我们不需要删除任何元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,1,1,5,6,2,3,1]
//输出：3
//解释：一种方法是将下标为 0，1 和 5 的元素删除，剩余元素为 [1,5,6,3,1] ，是山形数组。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// 1 <= nums[i] <= 10⁹ 
// 题目保证 nums 删除一些元素后一定能得到山形数组。 
// 
//
// Related Topics贪心 | 数组 | 二分查找 | 动态规划 
//
// 👍 110, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class MinimumNumberOfRemovalsToMakeMountainArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.minimumNumberOfRemovalsToMakeMountainArray());
        // TO TEST
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        // 表示前面的最长递增子序列长度
        int[] pre = getLISArray(nums);
        // 表示后面的最长递减子序列。为了复用可以反转数组后求前面的最长子序列
        int[] reverse = reverseArray(nums);
        int[] sufix = getLISArray(reverse);
        sufix = reverseArray(sufix);
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (pre[i] > 1 && sufix[i] > 1) {
                int length = pre[i] + sufix[i] - 1;
                int temp = nums.length - length;
                res = Math.min(res, temp);

            }
        }
        return res;
    }

    private int[] getLISArray(int[] nums) {
        int[] pre = new int[nums.length];
        Arrays.fill(pre, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    pre[i] = Math.max(pre[i], pre[j] + 1);
                }
            }
        }
        return pre;
    }

    private int[] reverseArray(int[] nums) {
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[nums.length - i - 1];
        }
        return array;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

