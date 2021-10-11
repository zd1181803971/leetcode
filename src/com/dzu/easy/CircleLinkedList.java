package com.dzu.easy;

/**
 * @author by ZhaoDong
 * @Classname CircleLinkedList
 * @Description 141. 环形链表。。给定一个链表，判断链表中是否有环。
 * @Date 2021/10/11 22:57
 */
public class CircleLinkedList {
    public static void main(String[] args) {

    }

    /**
     * 通过快慢指针
     * 如果快指针走到头了那就是没环
     * 如果有环，慢指针最终有和快指针重合的时候
     * 方法二： 通过哈希表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode2 head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode2 slow = head;
        ListNode2 fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}


class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2(int x) {
        val = x;
        next = null;
    }
}

