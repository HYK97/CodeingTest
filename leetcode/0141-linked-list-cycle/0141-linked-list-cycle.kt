/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
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