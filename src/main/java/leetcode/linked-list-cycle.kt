


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Sol30 {
    fun hasCycle(head: ListNode?): Boolean {
        val hashSet = HashSet<ListNode>()
        var current: ListNode? = head
        while (true) {
            if (current == null) {
                return false
            }
            if (hashSet.contains(current)) {
                return true
            }
            hashSet.add(current)
            current=current.next
        }
    }
}