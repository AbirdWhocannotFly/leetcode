
package org.leetcode.editor.cn;

/**
 * 题目编号:82
 * 题目标题:删除排序链表中的重复元素 II
 * 2023-12-03 22:26:12
 */
//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 1214, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.removeDuplicatesFromSortedListIi());
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        int currVal = -101;
        while (head != null ) {
            if (head.val == currVal) {
                pre.next = head.next;
                head = head.next;
                continue;
            }
            if (head.next != null) {
                if (head.next.val == head.val) {
                    currVal = head.val;
                    pre.next = head.next;
                    head = head.next;
                    continue;
                }
            }
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

