package com.watermelon.leetcode;

public class Num2 {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int jinwei = 0;
        ListNode head = null;
        ListNode currNode = null;
        while (l1 != null || l2 != null || jinwei == 1) {

            int a = 0;
            if (l1 != null) {
                a = l1.val;
            }

            int b = 0;
            if (l2 != null) {
                b = l2.val;
            }

            int sum = a + b;

            if (jinwei == 1) {
                sum = sum + 1;
                jinwei = jinwei - 1;
            }
            if (sum > 9) {
                jinwei = jinwei + 1;
                if (sum == 10) {
                    sum = 0;
                } else {
                    sum = sum - 10;
                }
            }

            if (head == null) {
                head = new ListNode(sum);
                currNode = head;
            } else {
                currNode.next = new ListNode(sum);
                currNode = currNode.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        //        l1.next = new ListNode(4);
        //        l1.next.next = new ListNode(3);
        //        l1.next.next.next = new ListNode(4);
        ListNode l2 = new ListNode(9);
        //        l2.next = new ListNode(6);
        //        l2.next.next = new ListNode(4);
        ListNode l3 = addTwoNumbers(l1, l2);
        while (l3 != null) {

            System.out.printf("%d\t", l3.val);

            l3 = l3.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

