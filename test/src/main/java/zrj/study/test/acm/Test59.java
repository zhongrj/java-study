package zrj.study.test.acm;

/**
 * 61. Rotate List
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/20
 */
public class Test59 {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode node1 = new ListNode(20);
        ListNode node2 = new ListNode(30);
        ListNode node3 = new ListNode(40);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        print(test(new ListNode(1), 1));
    }

    private static ListNode test(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0), curr = null, next = head;
        int i = 1;
        while (next != null) {
            curr = next;
            next = curr.next;
            if (i++ == k) {
                if (next == null) {
                    return head;
                } else {
                    dummy.next = next;
                    curr.next = null;
                }
            }
        }
        if (i < k + 1) {
            return head;
        }
        curr.next = head;
        return dummy.next;
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
