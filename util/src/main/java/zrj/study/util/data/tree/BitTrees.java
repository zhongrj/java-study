package zrj.study.util.data.tree;

/**
 * 二叉树-常用方法
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/3
 */
public class BitTrees {


    /**
     * 先根
     *
     * @param node   根节点
     * @param action 遍历回调
     */
    public static void firstRootTravel(BitTreeNode node, Action action) {
        if (null != node) {
            firstRootTravel(node.getLchild(), action);
            firstRootTravel(node.getRchild(), action);
            firstRootTravel(node, action);
        }
    }

    /**
     * 中根
     *
     * @param node   根节点
     * @param action 遍历回调
     */
    public static void midRootTravel(BitTreeNode node, Action action) {
        if (null != node) {
            midRootTravel(node.getLchild(), action);
            midRootTravel(node, action);
            midRootTravel(node.getRchild(), action);
        }
    }

    /**
     * 后根
     *
     * @param node   根节点
     * @param action 遍历回调
     */
    public static void lastRootTravel(BitTreeNode node, Action action) {
        if (null != node) {
            lastRootTravel(node, action);
            lastRootTravel(node.getLchild(), action);
            lastRootTravel(node.getRchild(), action);
        }
    }


    public static interface Action {
        void action(BitTreeNode node);
    }
}
