
package org.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
*题目编号:46
*题目标题:全排列
*2023-12-17 20:42:55
*/
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 2772, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class Permutations{
	public static void main(String[] args) {
	Solution solution = new Solution();
	// System.out.println(solution.permutations());
	// TO TEST
}
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(nums, set, temp);
        return res;
    }

    private void backTrack(int[] nums, Set<Integer> set, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            temp.add(num);
            set.add(num);
            backTrack(nums, set, temp);
            temp.remove((Integer) num);
            set.remove((Integer)num);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

