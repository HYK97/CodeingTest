fun main() {
    Solution().solution(
        arrayOf("joy", "brad", "alessandro", "conan", "david"),
        arrayOf(
            "alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"
        )
    )
}

class Solution {
    // 기준은 이번달까지임
//많이준사람이 다음달에 선물을 하나 받음
//같거나 기록이 없으면 선물지수가 높은사람이 하나받음
//선물지수는 이번달까지 준선물 - 받은선물
//근데 선물지수도 같으면 안주고 받는걸로

//먼저 이름 선물지수 해시맵이 필요함
// 친구이름 선물지수
// 그리고 한개씩 받으니까 최종 몇개가 있는지
// 친구이름 받은선물개수가 필요함 or 최대 선물수
// 받은 사람들 + 개수를 새는 게 필요함

    //일단 데이터를 만든뒤에 한개씩 비교해야함
//데이터를 반대로 바꿔서 해시맵 저장 해시맵에 카운팅 -> 반대 데이터 현재 데이터 빼서 많은쪽이 한개 카운팅
//
//한줄 한줄이 테스트 케이스임 중복제거후에 해당 테스트케이스 확인
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val friendsMap = friends.map { it to 0 }.toMap().toMutableMap()
        val giftsLogMap = gifts.flatMap { str ->
            val (give, serve) = str.split(" ")
            listOf(
                str to 0,
                "$serve $give" to 0
            )
        }.toMap().toMutableMap()
        val startSet = gifts.toSet()
        val winner = friends.map { it to 0 }.toMap().toMutableMap()

        for (gift in gifts) {
            val (give, reserve) = gift.split(" ")
            giftsLogMap.computeIfPresent(gift) { _, value -> value + 1 }
            friendsMap.computeIfPresent(give) { _, value -> value + 1 }
            friendsMap.computeIfPresent(reserve) { _, value -> value - 1 }
        }
        for (mutableEntry in friendsMap) {
            println(mutableEntry)
        }
        println()
        for (mutableEntry in giftsLogMap) {
            println(mutableEntry)
        }
        println()
        for (mutableEntry in startSet) {
            println(mutableEntry)
        }
        //val resultSet = HashSet<String>()
        for (s in gifts) {
            val (give, reserve) = s.split(" ")
     /*       if (resultSet.contains("$reserve $give")||resultSet.contains("$give $reserve ")) {
                continue
            }
            resultSet.add(s)*/
            if (giftsLogMap[s]?.minus(giftsLogMap["$reserve $give"]!!)!! > 0) {
                winner.computeIfPresent(give) { _, value -> value + 1 }
            } else if (giftsLogMap[s] == giftsLogMap["$reserve $give"]) {
                if (friendsMap[give]!! > friendsMap[reserve]!!) {
                    winner.computeIfPresent(give) { _, value -> value + 1 }
                } else if (friendsMap[give]!! < friendsMap[reserve]!!) {
                    winner.computeIfPresent(reserve) { _, value -> value + 1 }
                } else {
                    continue
                }
            } else {
                winner.computeIfPresent(reserve) { _, value -> value + 1 }
            }
        }
        for (mutableEntry in winner) {
            println(mutableEntry)
        }
        var answer: Int = winner.maxByOrNull { it.value }?.value!!
        return answer
    }
}