package zrj.study.test.acm;

/**
 * 25. Reverse Nodes in k-Group
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/5
 */
public class Test27 {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode node1 = new ListNode(20);
        ListNode node2 = new ListNode(30);
        ListNode node3 = new ListNode(40);
        ListNode node4 = new ListNode(50);
        ListNode node5 = new ListNode(60);
        ListNode node6 = new ListNode(70);
        ListNode node7 = new ListNode(80);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);

        print(test2(head, 2));
    }


    private static ListNode test2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode[] list = new ListNode[k];

        int i = 0;
        while (true) {

            if (head == null) {
                if (i != 0) {
                    curr.next = list[0];
                }
                break;
            }

            list[i++] = head;
            head = head.next;

            if (i == k) {
                for (int j = k - 1; j >= 0; j--) {
                    curr.next = list[j];
                    curr = curr.next;
                }
                curr.next = null;
                i = 0;
            }
        }

        return dummy.next;
    }


    // 需求不明确........................................................最后不满k的部分不反转...fuck....有毒.....
    private static ListNode test(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0),
                preTail = null,
                nextTail = null,
                next = null;
        int i = 0;
        while (head != null) {
            ListNode curr;

            if (i == 0) {
                curr = head.next;
                nextTail = head;
                if (curr == null) {
                    if (preTail == null) {
                        dummy.next = head;
                    } else {
                        preTail.next = head;
                    }
                    break;
                }
                next = curr.next;
                curr.next = head;
            } else {
                curr = next;
                if (curr == null) {
                    if (preTail == null) {
                        dummy.next = head;
                    } else {
                        preTail.next = head;
                    }
                    break;
                }
                next = next.next;
                curr.next = head;
            }

            if (i == k - 2) {
                if (preTail == null) {
                    dummy.next = curr;
                } else {
                    preTail.next = curr;
                }
                preTail = nextTail;
                head = next;
                i = 0;
            } else {
                head = curr;
                i++;
            }
        }

        nextTail.next = null;

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
