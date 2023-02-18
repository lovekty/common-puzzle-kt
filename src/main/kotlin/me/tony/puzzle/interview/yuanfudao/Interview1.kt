package me.tony.puzzle.interview.yuanfudao

/**
 * @author tony.zhuby
 * @date 2021/1/27
 */

/**
 * 输入  单链表：1，2，3，4，5，6，7
 * 输出  单链表：1，3，5，7，2，4，6
 */

data class Node(val num: Int, var next: Node? = null)

fun solution(node: Node): Node {
    var left: Node? = null
    var right: Node? = null
    var leftHead: Node? = null
    var rightHead: Node? = null
    var current = node
    while (true) {
        if (current.num % 2 != 0) {
            left?.next = current
            left = current
            if (leftHead == null) {
                leftHead = current
            }
        } else {
            right?.next = current
            right = current
            if (rightHead == null) {
                rightHead = current
            }
        }
        if (current.next == null) {
            break
        }
        current = current.next!!
    }
    left?.next = null
    right?.next = null
    if (left != null && rightHead != null) {
        left.next = rightHead
    }
    return leftHead ?: rightHead!!
}

fun main() {
    var node = solution(Node(1, Node(2, Node(3, Node(4, Node(5, Node(6, Node(7))))))))
    while (true) {
        print("${node.num} ")
        if (node.next == null) {
            break
        }
        node = node.next!!
    }
}