package programmers.impl

import kotlin.math.ceil


fun main() {
    println("02".toInt())
    val solution = 주차요금계산2().solution(
        intArrayOf(180, 5000, 10, 600),
        arrayOf(
            "05:34 5961 IN",
            "06:00 0000 IN",
            "06:34 0000 OUT",
            "07:59 5961 OUT",
            "07:59 0148 IN",
            "18:59 0000 IN",
            "19:09 0148 OUT",
            "22:59 5961 IN",
            "23:00 5961 OUT"
        )
    )
}

class 주차요금계산2 {

    fun solution(fees: IntArray, records: Array<String>): IntArray {

        val baseTime = fees[0]
        val baseRate = fees[1]
        val unitTime = fees[2]
        val unitFee = fees[3]
        val LAST_TIME = 1439
        val map = mutableMapOf<String, VehicleDetails>()

        for (record in records) {
            val split = record.split(" ")
            val time = split[0].split(":")
            val hour = time[0].toInt() * 60
            val min = time[1].toInt()
            val convertTime = hour + min

            val carNumber = split[1]
            val parkingStatus = split[2]
            if (map.containsKey(carNumber)) {
                val car = map[carNumber]
                car?.changeCar(parkingStatus, convertTime)
            } else {
                map[carNumber] = VehicleDetails(parkingStatus = true, prevTime = convertTime)
            }
        }
        for (mutableEntry in map) {
            val car = mutableEntry.value
            if (car.parkingStatus) {
                car.changeCar("OUT", LAST_TIME)
            }
            if (car.parkingTime <= baseTime) {
                car.billingPrice = baseRate
                continue
            }
            val billingPrice = baseRate + ceil(((car.parkingTime - baseTime).toDouble() / unitTime)) * unitFee
            car.billingPrice = billingPrice.toInt()
        }

        return map.toSortedMap()
            .map { i -> i.value }
            .map { i -> i.billingPrice }
            .toIntArray()
    }


    data class VehicleDetails(
        var parkingTime: Int = 0,
        var parkingStatus: Boolean,
        var prevTime: Int = 0,
        var billingPrice: Int = 0
    ) {
        fun changeCar(status: String, currentTime: Int) {
            if (status == "IN") {
                this.prevTime = currentTime;
                this.parkingStatus = true
            } else {
                this.parkingTime += currentTime - this.prevTime
                this.parkingStatus = false
                this.prevTime = currentTime
            }
        }

    }


}