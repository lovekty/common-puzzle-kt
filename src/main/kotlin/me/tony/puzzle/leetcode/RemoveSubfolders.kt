package me.tony.puzzle.leetcode

class RemoveSubfolders {
    fun removeSubfolders(folder: Array<String>): List<String> {
        val ret = mutableListOf<String>()
        folder.sort()
        for (f in folder) {
            if (ret.isEmpty()) ret += f
            else if (!ret.last().isParentPath(f)) ret += f
        }
        return ret
    }

    private fun String.isParentPath(other: String): Boolean {
        return other.length > this.length && other.startsWith(this) && other[this.length] == '/'
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                RemoveSubfolders().removeSubfolders(
                    arrayOf(
                        "/aa/ab/ac/ae",
                        "/aa/ab/af/ag",
                        "/ap/aq/ar/as",
                        "/ap/aq/ar",
                        "/ap/ax/ay/az",
                        "/ap",
                        "/ap/aq/ar/at",
                        "/aa/ab/af/ah",
                        "/aa/ai/aj/ak",
                        "/aa/ai/am/ao"
                    )
                )
            )
        }
    }
}