package zrj.study.test.acm;

/**
 * 19. Remove Nth Node From End of List
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/4
 */
public class Test21 {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode node1 = new ListNode(20);
        ListNode node2 = new ListNode(30);
        ListNode node3 = new ListNode(40);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
//        print(test(head, 4));
        print(answer(head, 3));
    }

    // 答案 ...6666666666666666666666
    public static ListNode answer(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


    private static void print(ListNode node) {
        do {
            System.out.printf("%s -> ", node.val);
        } while ((node = node.next) != null);
    }

    private static ListNode test(ListNode head, int n) {

        if (removeNthFromEnd(head, n) == n + 1) {
            return head.next;
        }

        return head;
    }

    private static int removeNthFromEnd(ListNode node, int n) {
        if (node.next == null) {
            return 2;
        }

        int NthFromEnd = removeNthFromEnd(node.next, n);
        if (NthFromEnd == n + 1) {
            node.next = node.next.next;
        }

        return NthFromEnd + 1;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

