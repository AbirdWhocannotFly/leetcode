
package org.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目编号:274
 * 题目标题:H 指数
 * 2023-12-20 21:43:12
 */
//给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。 
//
// 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次
//数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。 
//
// 
//
// 示例 1： 
//
// 
//输入：citations = [3,0,6,1,5]
//输出：3 
//解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
//     由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。 
//
// 示例 2： 
//
// 
//输入：citations = [1,3,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == citations.length 
// 1 <= n <= 5000 
// 0 <= citations[i] <= 1000 
// 
//
// Related Topics数组 | 计数排序 | 排序 
//
// 👍 435, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class HIndex {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.hIndex());
        // TO TEST
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        for (int i = 0; i < citations.length; i++) {
            int temp = Math.min(citations[i],citations.length-i);
            res = Math.max(temp,res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

