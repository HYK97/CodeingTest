package programmers.impl

class 신규아이디추천 {
    fun solution(new_id: String): String {

        val first = new_id.lowercase();

        val second = first.replace(Regex("[^a-z0-9-_.]"), "")

        var third = second
        while (third.contains("..")) {
            third = third.replace("..", ".")
        }

        var fourth = third
        if (fourth.isNotEmpty() && fourth.first() == '.') {
            fourth = fourth.drop(1)
        }
        if (fourth.isNotEmpty() && fourth.last() == '.') {
            fourth = fourth.dropLast(1)
        }

        var fifth = fourth
        if (fifth.isEmpty()) {
            fifth = "a"
        }

        var sixth = fifth
        if (sixth.length >= 16) {
            sixth = sixth.slice(0..14)
        }
        if (sixth.last() == '.') {
            sixth = sixth.dropLast(1)
        }

        var seventh = sixth
        if (seventh.length <= 2) {
            val last = seventh.last().toString()
            val copyCount = 3 - seventh.length
            val repeat = last.repeat(copyCount)
            seventh += repeat;
        }

        return seventh
    }
}