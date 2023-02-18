package me.tony.puzzle.leetcode

import kotlin.math.min

class BalancedString {

    fun balancedString(s: String): Int {
        val sample = "QWER"
        if (s.isEmpty()) return 0
        val size = sample.groupBy { it }.mapValues { entry -> s.count { it == entry.key } }
        val max = s.length / sample.length
        if (size.all { it.value == max }) return 0
        val cnt = size.mapValues { 0 }.toMutableMap()
        var ret = s.length
        for (i in s.indices) {
            val tcnt = cnt.toMutableMap()
            for (j in s.length - 1 downTo i) {
                tcnt[s[j]] = tcnt[s[j]]!! + 1
                if (tcnt.any { it.value > max }) {
                    ret = min(ret, j - i + 1)
                    break
                }
            }
            cnt[s[i]] = cnt[s[i]]!! + 1
        }
        return ret
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(BalancedString().balancedString("WQWRQQQW"))
        }
    }
}