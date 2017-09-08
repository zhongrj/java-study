package zrj.study.test.acm;

/**
 * 23. Merge k Sorted Lists
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/9/4
 */
public class Test25 {
    public static void main(String[] args) {
//        print(test(new ListNode[]{new ListNode(0), new ListNode(1), new ListNode(1), new ListNode(-1), new ListNode(4), new ListNode(-123), new ListNode(13), new ListNode(121), new ListNode(11)}));

//        ListNode[] minHeap = initMinHeap(new ListNode[]{new ListNode(0), new ListNode(1), new ListNode(1), new ListNode(-1), new ListNode(4), new ListNode(-123), new ListNode(13), new ListNode(121), new ListNode(11)});
//        printMinHeap(minHeap);
//        replaceMinHeap(minHeap, new ListNode(8), minHeap.length);
//        printMinHeap(minHeap);

//        print(answer(new ListNode[]{new ListNode(0), new ListNode(1), new ListNode(1), new ListNode(-1), new ListNode(4), new ListNode(-123), new ListNode(13), new ListNode(121), new ListNode(11)}));
//        print(answer(new ListNode[]{new ListNode(1)}));
        print(answer(new ListNode[]{null, null}));
    }

    // 答案2 归并...
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start + 1 == end)
            return mergeLists(lists[start], lists[end]);
        int m = start + (end - start) / 2;
        return mergeLists(mergeKLists(lists, start, m), mergeKLists(lists, m + 1, end));
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0), prev = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return res.next;
    }

    // 答案 TODO 不错
    private static ListNode answer(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        ListNode[] minHeap = initMinHeap(lists);

        while (minHeap[0] != null) {
            ListNode min = minHeap[0];
            curr.next = min;
            curr = curr.next;

            min = min.next;
            replaceMinHeap(minHeap, min, minHeap.length - 1);
//            System.out.println("插入: " + (min == null ? "null" : min.val));
//            printMinHeap(minHeap);
//            System.out.println();
        }

        return dummy.next;
    }

    // 初始化最小堆
    private static ListNode[] initMinHeap(ListNode[] lists) {
        ListNode[] result = new ListNode[lists.length];

        for (int i = 0, j = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                j++;
                continue;
            }
            insertMinHeap(result, lists[i], i - j);
        }

        return result;
    }

    // 交换堆顶元素
    private static void replaceMinHeap(ListNode[] minHeap, ListNode node, int end) {
        minHeap[0] = node;
        if (end == 0) {
            return;
        }
        int index = 0;
        // 下沉
        while (index <= (end - 1) / 2) {
            int temp = index;
            int child = index * 2 + 1;

            if (child < end && (minHeap[child] == null || minHeap[child + 1] != null && minHeap[child].val > minHeap[child + 1].val)) {
                child++;
            }
            if (minHeap[index] == null && minHeap[child] != null || minHeap[index] != null && minHeap[child] != null && minHeap[index].val > minHeap[child].val) {
                swap(minHeap, index, child);
                temp = child;
            }
            if (temp == index) {
                break;
            }
            index = temp;
        }
    }

    // 插入最小堆
    private static void insertMinHeap(ListNode[] minHeap, ListNode node, int index) {
        minHeap[index] = node;
        // 上浮
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (minHeap[parent].val <= minHeap[index].val) {
                break;
            }
            swap(minHeap, index, parent);
            index = parent;
        }
    }

    private static <T> void swap(T[] array, int i1, int i2) {
        T temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }


    // 复杂度太高
    private static ListNode test(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int index;
        while ((index = getMinIndex(lists)) != -1) {
            curr.next = lists[index];
            lists[index] = lists[index].next;
            curr = curr.next;
        }

        return dummy.next;
    }

    private static int getMinIndex(ListNode[] lists) {
        int temp = -1;
        for (int i = 0; i < lists.length; i++) {
            if (null != lists[i]) {
                if (temp == -1) {
                    temp = i;
                } else if (lists[temp].val > lists[i].val) {
                    temp = i;
                }
            }
        }
        return temp;
    }


    private static void printMinHeap(ListNode[] minHeap) {
        for (int i = 0, j = 1; i < minHeap.length; i++) {
            if (i == Math.pow(2, j) - 1) {
                j++;
                System.out.println();
            }
            System.out.printf("%s ", minHeap[i] == null ? "null" : minHeap[i].val);
        }
        System.out.println();
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
