package zrj.study.util.data.tree;

/**
 * 二叉树节点
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/3
 */
public class BitTreeNode<E> {

    private E e;

    private BitTreeNode<E> lchild;

    private BitTreeNode<E> rchild;

    public BitTreeNode(E e) {
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public BitTreeNode<E> getLchild() {
        return lchild;
    }

    public void setLchild(BitTreeNode<E> lchild) {
        this.lchild = lchild;
    }

    public BitTreeNode<E> getRchild() {
        return rchild;
    }

    public void setRchild(BitTreeNode<E> rchild) {
        this.rchild = rchild;
    }
}
