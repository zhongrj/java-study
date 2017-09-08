package zrj.study.test.acm;

import java.util.List;

/**
 * 24. Swap Nodes in Pairs
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/5
 */
public class Test26 {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode node1 = new ListNode(20);
        ListNode node2 = new ListNode(30);
//        ListNode node3 = new ListNode(40);
        head.next = node1;
        node1.next = node2;
//        node2.next = node3;
        print(test(head));
    }


    // 哈哈 我知道循环更好,懒得写了
    private static ListNode test(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next = head.next;
        if (next == null) {
            return head;
        } else {
            head.next = test(next.next);
            next.next = head;
            return next;
        }
    }


    private static void print(ListNode node) {
        do {
            System.out.printf("%s -> ", node.val);
        } while ((node = node.next) != null);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
