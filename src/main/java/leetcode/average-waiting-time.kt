package leetcode

import kotlin.math.abs


class Sol31 {
    fun averageWaitingTime(customers: Array<IntArray>): Double {
        var lastTime = customers[0][0]
        println("lastTime = ${lastTime}")
        val mutableListOf = mutableListOf<Int>()
        for (customer in customers) {
            val arrivalTime = customer[0]
            val productionTime = customer[1]
            if (lastTime > arrivalTime) {
                lastTime += productionTime
            } else {
                lastTime=arrivalTime
            }
            mutableListOf.add(abs(lastTime - arrivalTime))
        }
        val average = mutableListOf.average()
        return average
    }
}
//요리 종료시간 - 도착시간 = 대기 시간
// 큐를 이용하면될듯
// 유저 한명 빼고 마지막 요리종료시간 + 요리 걸리는 시간 = 요리 종료시간