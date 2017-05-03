package zrj.study.util.data.tree;


/**
 * 树-常用方法
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/3
 */
public class Trees {

    /**
     * 深度优先
     * @param node 根节点
     * @param action 遍历回调
     */
    public static void DepthFirstTravel(TreeNode node, Action action) {
        if (null != node) {
            action.action(node);
            DepthFirstTravel(node.getFirstChild(), action);
            DepthFirstTravel(node.getSibling(), action);
        }
    }

    /**
     * 广度优先
     * @param node 根节点
     * @param action 遍历回调
     */
    public static void breadthFirstTravel(TreeNode node, Action action) {
        if (null != node) {
            action.action(node);
            breadthFirstTravel(node.getSibling(), action);
            breadthFirstTravel(node.getFirstChild(), action);
        }
    }

    public static interface Action {
        void action(TreeNode node);
    }

}
