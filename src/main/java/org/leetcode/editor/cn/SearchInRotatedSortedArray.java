
package org.leetcode.editor.cn;

/**
 * 题目编号:33
 * 题目标题:搜索旋转排序数组
 * 2023-12-02 23:30:51
 */
//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics数组 | 二分查找 
//
// 👍 2803, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.searchInRotatedSortedArray());
        // TO TEST
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        int mid = (start + end) / 2;
        if (nums[start] < nums[mid]) {
            if (target <= nums[mid] && target >= nums[start]) {
                return search(nums, start, mid, target);
            } else {
                return search(nums, mid+1, end, target);
            }
        } else {
            if (target <= nums[end] && target >= nums[mid+1]) {
                return search(nums, mid+1, end, target);
            } else {
                return search(nums, start, mid, target);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

