package leetcode.example;

/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 难度中等
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author luxin
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode result = listNode;
        int jin = 0, tmp;
        while (l1 != null || l2 != null) {
            int x = 0, y = 0;
            tmp = x + y + jin;
            if (l1 == null) {
                x = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                y = l1.val;
                l1 = l1.next;
            } else {
                tmp += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            jin = tmp >= 10 ? 1 : 0;
            ListNode tmpNode = new ListNode(tmp >= 10 ? tmp % 10 : tmp);
            listNode.next = tmpNode;
            listNode = tmpNode;
        }
        if (jin == 1) {
            listNode.next = new ListNode(1);
        }
        return result.next;
    }

    /**
     * 定义单链表
     * 逆序存储
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            ListNode listNode = next;
            while (listNode != null) {
                sb.append(" -> ").append(listNode.val);
                listNode = listNode.next;
            }
            return sb.toString();
        }

        public static ListNode create(int value) {
            int start = 10;
            ListNode listNode = new ListNode(value % start);
            ListNode result = listNode;
            int tmp = value / start;
            while (tmp > 0) {
                ListNode tmpNode = new ListNode(tmp % start);
                listNode.next = tmpNode;
                listNode = tmpNode;
                start *= 10;
                tmp = value / start;
            }
            return result;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.create(243);
        ListNode l2 = ListNode.create(564);

        System.out.println(new AddTwoNumbers().addTwoNumbers(l1, l2));
    }

}
