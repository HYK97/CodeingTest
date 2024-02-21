fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M) = br.readLine().split(" ").map(String::toInt)
    val check = IntArray(M)

    fun backtracking(index: Int,count: Int) {
        if (count == M) {
            for (i in check) {
                print("${i} ")
            }
            println()
            return
        }
        for (i in index until N) {
            check[count] = i + 1
            backtracking(i + 1, count + 1)
            check[count] = 0
        }

    }
    backtracking(0,0)

}