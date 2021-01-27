package me.tony.puzzle.interview.yuanfudao

import kotlin.math.max
import kotlin.math.min

/**
 * @author tony.zhuby
 * @date 2021/1/27
 */

/**
 * 两个区间（闭区间）数组求交集. 数组内的区间有序，无交集，
 * A: [1, 6], [8, 11], [15, 30]
 * B: [2, 4], [7, 10]
 * Res: [2, 4], [8, 10]
 */

data class Range(val start: Int, val end: Int)

fun solution(a: Array<Range>, b: Array<Range>): Array<Range> {
    val aLeft = a[0].start
    val aRight = a[a.size - 1].end
    val bLeft = b[0].start
    val bRight = b[b.size - 1].end
    var aIndex = 0
    var bIndex = 0
    val result = mutableListOf<Range>()
    var start: Int? = null
    var end: Int? = null
    if (aLeft < bRight && bLeft < aRight) {
        for (current in max(aLeft, bLeft)..min(aRight, bRight) + 1) {
            if (current isIn a[aIndex] && current isIn b[bIndex]) {
                if (start == null) {
                    start = current
                }
                end = current
            } else {
                if (current > a[aIndex].end) {
                    aIndex += 1
                }
                if (current > b[bIndex].end) {
                    bIndex += 1
                }
                if (start != null && end != null) {
                    result += Range(start, end)
                    start = null
                    end = null
                }
            }
        }
    }

    return result.toTypedArray()
}

infix fun Int.isIn(range: Range): Boolean {
    return this >= range.start && this <= range.end
}

fun main(args: Array<String>) {
    solution(
        arrayOf(Range(1, 6), Range(8, 11), Range(15, 30)),
        arrayOf(Range(2, 4), Range(7, 10))
    ).forEach { print("$it ") }
}