package zrj.study.test.acm;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/4
 */
public class Test23 {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode node1 = new ListNode(20);
        ListNode node2 = new ListNode(30);
        ListNode node3 = new ListNode(40);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode head1 = new ListNode(11);
        ListNode node12 = new ListNode(19);
        ListNode node22 = new ListNode(25);
        ListNode node32 = new ListNode(44);
        head1.next = node12;
        node12.next = node22;
        node22.next = node32;

        print(test(head, head1));
    }

    private static ListNode test(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                curr.next = l2;
                break;
            }
            if (l2 == null) {
                curr.next = l1;
                break;
            }

            if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
            }

            curr = curr.next;
        }

        return head.next;
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
