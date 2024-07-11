class Solution {
    fun averageWaitingTime(customers: Array<IntArray>): Double {
        var lastTime = customers[0][0]
        
        val mutableListOf = mutableListOf<Int>()
        for (customer in customers) {
            val arrivalTime = customer[0]
            val productionTime = customer[1]
            if (lastTime >= arrivalTime) {
                lastTime += productionTime
            } else {
                lastTime = arrivalTime + productionTime
            }
            val data =abs(lastTime - arrivalTime)
            mutableListOf.add(data)
        }
        val average = mutableListOf.average()
        return average
    }
}
//요리 종료시간 - 도착시간 = 대기 시간
//마지막 요리시간 + 요리 걸리는 시간 = 요리 종료시간 