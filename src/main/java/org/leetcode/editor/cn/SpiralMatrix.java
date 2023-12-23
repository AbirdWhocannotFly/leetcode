
package org.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目编号:54
 * 题目标题:螺旋矩阵
 * 2023-12-17 21:11:12
 */
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 1560, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.spiralMatrix());
        // TO TEST
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        while (top <= bottom && right >= left) {
            int[] nums = matrix[top];
            for (int i = left; i <= right; i++) {
                res.add(nums[i]);
            }
            top++;
            if (right >= left && top <= bottom) {
                for (int i = top; i <= bottom; i++) {
                    int[] nums1 = matrix[i];
                    res.add(nums1[right]);
                }
                right--;
            }
            if (right >= left && top <= bottom) {
                int[] nums1 = matrix[bottom];
                for (int i = right; i >= left; i--) {
                    res.add(nums1[i]);
                }
                bottom--;
            }
            if (right >= left && top <= bottom) {
                for (int i = bottom; i >= top; i--) {
                    int[] nums1 = matrix[i];
                    res.add(nums1[left]);
                }
                left++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

