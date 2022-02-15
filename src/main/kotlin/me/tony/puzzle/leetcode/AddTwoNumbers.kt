package me.tony.puzzle.leetcode.addtownumbers

/**
 * @author tony.zhuby
 */

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学 👍 7481 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var ret: ListNode? = null

        var adding = false
        var left = l1
        var right = l2
        var prev = ret

        fun check(node: ListNode?) {
            node?.let {
                if (it.`val` < 0 || it.`val` > 9) {
                    throw RuntimeException("bad value:${it.`val`}")
                }
            }
        }

        while (left != null || right != null) {
            check(left)
            check(right)
            val sum = (left?.`val` ?: 0) + (right?.`val` ?: 0) + if (adding) 1 else 0
            val current = if (sum > 9) ListNode(sum - 10) else ListNode(sum)
            adding = sum > 9
            prev?.next = current
            prev = current
            if (ret == null) ret = current
            left = left?.next
            right = right?.next
        }
        if (adding) prev?.next = ListNode(1)
        if (ret == null) ret = prev

        return ret
    }
}
//leetcode submit region end(Prohibit modification and deletion)
