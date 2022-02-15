package me.tony.puzzle.leetcode.lengthOfLongestSubstring

/**
 * @author tony.zhuby
 */

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 10⁴
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 字符串 滑动窗口 👍 6902 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0

        val map = mutableMapOf(s[0] to 0)

        var len = 1
        var start = 0
        var end = 0

        fun valid(index: Int?): Boolean {
            if (index != null) {
                return index < start
            }
            return true
        }

        for (i in 1 until s.length) {
            val c = s[i]
            if (valid(map[c])) {
                end = i
                len = kotlin.math.max(len, end - start + 1)
            } else {
                len = kotlin.math.max(len, end - start + 1)
                start = map[c]!! + 1
                end = i
            }
            map[c] = i
        }

        return len
    }
}
//leetcode submit region end(Prohibit modification and deletion)
