package me.tony.puzzle.leetcode.luckyNumbers

/**
 * @author tony.zhuby
 */

//给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
//
// 幸运数是指矩阵中满足同时下列两个条件的元素：
//
//
// 在同一行的所有元素中最小
// 在同一列的所有元素中最大
//
//
//
//
// 示例 1：
//
// 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
//输出：[15]
//解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
//
//
// 示例 2：
//
// 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
//输出：[12]
//解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
//
//
// 示例 3：
//
// 输入：matrix = [[7,8],[1,2]]
//输出：[7]
//
//
//
//
// 提示：
//
//
// m == mat.length
// n == mat[i].length
// 1 <= n, m <= 50
// 1 <= matrix[i][j] <= 10^5
// 矩阵中的所有元素都是不同的
//
// Related Topics 数组 矩阵 👍 91 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
        val ret = mutableListOf<Int>()

        fun rowMin(array: IntArray): Pair<Int, Int> {
            var index = 0
            var num = array[index]
            for (i in 1 until array.size) {
                if (num > array[i]) {
                    num = array[i]
                    index = i
                }
            }
            return index to num
        }

        val columnMaxIndexes = mutableMapOf<Int, Int>()
        fun columnMax(matrix: Array<IntArray>, columnIndex: Int, rowIndex: Int, num: Int): Boolean {
            if (columnMaxIndexes[rowIndex] != null) {
                return false
            }
            for (i in matrix.indices) {
                if (i == columnIndex)
                    continue
                if (matrix[i][rowIndex] > num) {
                    return false
                }
            }
            columnMaxIndexes[rowIndex] = columnIndex
            return true
        }

        matrix.forEachIndexed { columnIndex, row ->
            val candidate = rowMin(row)
            if (columnMax(matrix, columnIndex, candidate.first, candidate.second)) {
                ret += candidate.second
            }
        }

        return ret
    }
}
//leetcode submit region end(Prohibit modification and deletion)
