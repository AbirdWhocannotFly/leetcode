
package org.leetcode.editor.cn;
/**
*题目编号:486
*题目标题:预测赢家
*2023-11-29 22:30:09
*/
//给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。 
//
// 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。每一回合，玩家从数组的任意一端取一个数字（即，nums[0
//] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取
//时，游戏结束。 
//
// 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。你可以假设每个玩家的玩法都会使他的分
//数最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,2]
//输出：false
//解释：一开始，玩家 1 可以从 1 和 2 中进行选择。
//如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）
//可选。 
//所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
//因此，玩家 1 永远不会成为赢家，返回 false 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,5,233,7]
//输出：true
//解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
//最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 true，表示玩家 1 可以成为赢家。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 10⁷ 
// 
//
// Related Topics递归 | 数组 | 数学 | 动态规划 | 博弈 
//
// 👍 670, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class PredictTheWinner{
	public static void main(String[] args) {
	Solution solution = new Solution();
	// System.out.println(solution.predictTheWinner());
	// TO TEST
}
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean predictTheWinner(int[] nums) {
        Pair[][] pairs = new Pair[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                pairs[i][j] = new Pair();
            }
        }
        for (int i = 0; i < nums.length; i++) {
            pairs[i][i].first = nums[i];
        }
        for (int i = nums.length-2;i>=0;i--) {
            for (int j = i+1;j<nums.length;j++) {
                int selectLeft = nums[i] + pairs[i+1][j].second;
                int selectRight = nums[j] + pairs[i][j-1].second;
                pairs[i][j].first = Math.max(selectLeft,selectRight);
                if (selectLeft > selectRight) {
                    pairs[i][j].second = pairs[i+1][j].first;
                } else {
                    pairs[i][j].second = pairs[i][j-1].first;
                }
            }
        }
        return pairs[0][nums.length-1].first >=  pairs[0][nums.length-1].second;
    }

    class Pair{
        public int first;
        public int second;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

