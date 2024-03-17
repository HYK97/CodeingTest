package programmers.impl

class 다단계칫솔판매 {
    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {

        val parent = HashMap<String, String>()
        val cache = HashMap<String, Int>()

        for (data in enroll.withIndex()) {
            val index = data.index
            val value = data.value
            parent[value] = referral[index]
            cache[value]=0
        }

        for (seller2 in seller.withIndex()) {
            //계산금액
            var sellerAmount = amount[seller2.index] * 100
            //현재 정산하는 유저이름
            var sellerName = seller2.value
            while (sellerName != "-" && sellerAmount != 0) {
                val distributionAmount = sellerAmount / 10

                cache[sellerName] = (cache.getOrDefault(sellerName,0) + sellerAmount - distributionAmount)

                sellerAmount= distributionAmount
                sellerName= parent[sellerName].toString()
            }
        }

        val list = ArrayList<Int>()
        for (name in enroll) {
            list.add(cache[name]!!)
        }

        return list.toIntArray()
    }
}