package zrj.study.test.acm;

/**
 * 两个链表相加（要进位）
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/31
 */
public class Test4 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(6, new ListNode(8, new ListNode(9))));
        ListNode listNode1 = new ListNode(2, new ListNode(5, new ListNode(7)));

        print(listNode);
        print(listNode1);
        print(test(listNode, listNode1));

        print(answer(listNode, listNode1));
    }

    // 答案----------------------------------------------------------------------------------
    private static ListNode answer(ListNode listNode, ListNode listNode1) {
        ListNode result = new ListNode(0);
        int carry = 0;
        ListNode point = result;
        while (listNode != null || listNode1 != null) {
            if (listNode != null) {
                carry += listNode.val;
                listNode = listNode.next;
            }
            if (listNode1 != null) {
                carry += listNode1.val;
                listNode1 = listNode1.next;
            }

            point.next = new ListNode(carry % 10);
            carry /= 10;
            point = point.next;
        }

        if (carry == 1) {
            point.next = new ListNode(1);
        }
        return result.next;
    }
    // 答案----------------------------------------------------------------------------------

    private static ListNode test(ListNode listNode, ListNode listNode1) {
        ListNode result = add(new ListNode(0), listNode, listNode1, 0);
        return result;
    }

    private static ListNode add(ListNode result, ListNode listNode, ListNode listNode1, int flag) {

        if (listNode == null && listNode1 == null) {
            if (flag == 1) {
                result.next = new ListNode(1);
            }
            return result;
        }

        if (listNode == null || listNode1 == null) {
            if (flag == 1) {
                int sum = (listNode1 == null ? listNode.val : listNode1.val) + flag;
                result.next =
                        listNode1 == null ?
                                add(new ListNode(sum % 10), listNode.next, null, sum / 10)
                                :
                                add(new ListNode(sum % 10), null, listNode1.next, sum / 10);
                return result;
            } else {
                result.next = listNode == null ? listNode1 : listNode;
                return result;
            }
        }

        int sum = listNode.val + listNode1.val + flag;
        result.next = add(new ListNode(sum % 10), listNode.next, listNode1.next, sum / 10);
        return result;
    }

    private static void print(ListNode listNode) {
        while (listNode.val == 0) {
            listNode = listNode.next;
        }
        System.out.print(listNode.val);
        while ((listNode = listNode.next) != null) {
            System.out.printf(" -> %s", listNode.val);
        }
        System.out.println();
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this(val, null);
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
