
package org.leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 题目编号:1094
 * 题目标题:拼车
 * 2023-12-02 22:22:53
 */
//车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向） 
//
// 给定整数 capacity 和一个数组 trips , trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有
// numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。 
//
// 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 4
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 5
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 10⁵ 
// 
//
// Related Topics数组 | 前缀和 | 排序 | 模拟 | 堆（优先队列） 
//
// 👍 340, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class CarPooling {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.carPooling());
        // TO TEST
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        boolean flag = true;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((arr1, arr2) -> arr1[2] - arr2[2]);
        Arrays.sort(trips, (arr1, arr2) -> arr1[1] - arr2[1]);
        int sum = 0;
        for (int i = 0; i < trips.length; i++) {
            int currNum = trips[i][0];
            int currFrom = trips[i][1];
            int currTo = trips[i][2];
            while (!priorityQueue.isEmpty()) {
                int[] trip = priorityQueue.peek();
                if (trip[2] <= currFrom) {
                    sum -= trip[0];
                    priorityQueue.poll();
                } else {
                    break;
                }
            }
            priorityQueue.offer(trips[i]);
            sum += currNum;
            if (sum > capacity) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

