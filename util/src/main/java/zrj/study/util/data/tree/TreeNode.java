package zrj.study.util.data.tree;

/**
 * 树节点
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/3
 */
public class TreeNode<E> {

    private E e;

    private TreeNode firstChild;

    private TreeNode sibling;

    public TreeNode(E e) {
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public TreeNode getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(TreeNode firstChild) {
        this.firstChild = firstChild;
    }

    public TreeNode getSibling() {
        return sibling;
    }

    public void setSibling(TreeNode sibling) {
        this.sibling = sibling;
    }
}
