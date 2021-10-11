package com.dzu.easy;

/**
 * @author by ZhaoDong
 * @Classname MergeLinkedList
 * @Description 21. 合并两个有序链表
 * @Date 2021/10/10 22:13
 */
public class MergeLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        ListNode listNode = new MergeLinkedList().mergeTwoLists(l1, l4);
        System.out.println(listNode);
    }

    /**
     * 新建一个链表，然后对比两个有序链表的值，值小的 放在新链表的后面
     * 然后两个有序链表依次自向前移动
     * 最终会剩下一个大数
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode(-1);
        ListNode perv = tempHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                perv.next = l1;
                l1 = l1.next;
            } else {
                perv.next = l2;
                l2 = l2.next;
            }
            perv = perv.next;
        }
        perv.next = l1 == null ? l2 : l1;

        return tempHead.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

