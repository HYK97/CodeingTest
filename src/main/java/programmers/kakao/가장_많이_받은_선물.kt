import kotlin.math.max

class Solution {

    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val friendsArray = Array(friends.size) { 0 }
        val giftsArray = Array(friends.size) { Array(friends.size) { 0 } }

        for (gift in gifts) { // index of -> 속도 저하가 있으면 map을 이용해서 이름 : 인덱스 위치 저장
            val (giver, receiver) = gift.split(" ")
            friendsArray[friends.indexOf(giver)]++
            friendsArray[friends.indexOf(receiver)]--
            giftsArray[friends.indexOf(giver)][friends.indexOf(receiver)]++
        }

        var answer = 0
        for (i in friends.indices) {
            var num = 0;
            for (j in friends.indices) {
                if (i == j) { // 자기자신 제외
                    continue;
                }

                if (giftsArray[i][j] > giftsArray[j][i] || // = > giver 가 receiver 보다 크거나
                    (giftsArray[i][j] == giftsArray[j][i] && friendsArray[i] > friendsArray[j])
                //giver와 receiver와 선물개수가 같은경우에는 선물 지수가 높은사람만 number+
                ) {
                    num++;
                }
            }
            answer = max(num, answer)
        }
        println(answer)

        return answer
    }
}