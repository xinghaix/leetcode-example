package leetcode.example.linkedlist;

import java.util.concurrent.RecursiveAction;

/**
 * 单链表
 * @author luxin
 */
@SuppressWarnings("WeakerAccess")
public class SingleLinkedList {

    private int val;
    private SingleLinkedList next;

    public SingleLinkedList(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        SingleLinkedList linkedList = next;
        while (linkedList != null) {
            sb.append(" -> ").append(linkedList.val);
            linkedList = linkedList.next;
        }
        return sb.toString();
    }

    public static SingleLinkedList of(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        SingleLinkedList linkedList = new SingleLinkedList(0);
        SingleLinkedList result = linkedList;
        for (int value : values) {
            SingleLinkedList tmp = new SingleLinkedList(value);
            linkedList.next = tmp;
            linkedList = tmp;
        }
        return result.next;
    }

    /**
     * 反转单链表方法一
     * 通过后驱变前驱的方式
     * @param head 单链表
     * @return 反转顺序之后的单链表
     */
    public static SingleLinkedList reverseList1(SingleLinkedList head) {
        SingleLinkedList pre = null;

        while (head != null) {
            SingleLinkedList next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    /**
     * 反转单链表方法二
     * 通过递归的方式
     * @param head 单链表
     * @return 反转顺序之后的单链表
     */
    public static SingleLinkedList reverseList2(SingleLinkedList head) {
        if (head == null || head.next == null) {
            return head;
        }

        SingleLinkedList tmp = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return tmp;
    }

    public static void main(String[] args) {
        SingleLinkedList linkedList1 = of(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(linkedList1 + "\n" + reverseList1(linkedList1));
    }

}
