package com.wangwei.tree;

/**
 * @auther wangwei
 * @date 2019-06-14 17:29
 * 二分搜索树实现
 */
public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left, right;
        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;

    private int size;

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }


    /*
     *向二叉树中添加元素
     */

    public void add(E e){
//        if (root == null){
//            root = new Node(e);
//            size++;
//            return;
//        }else {
//            add(root, e);
//        }
        root = add(root, e);
    }

    /*向以node为根的二分搜索树中插入元素E,递归算法*/
    private Node add(Node node, E e){
        if (node == null){
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);

        if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }


    /*判断是否包含某个元素*/
    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node node, E e){
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    /*以root为根节点的前序遍历*/
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /*以root为根节点的中序遍历*/
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res){
        if (node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");

        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);
    }


    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    //    /***
//     * 向以node为根的二分搜索树中插入元素E,递归算法
//     * @param node
//     * @param e
//     */
//    private void add(Node node, E e){
//        if (e.compareTo(node.e) == 0){
//            return;
//        }else if (e.compareTo(node.e) < 0 && node.left == null){
//            node.left = new Node(e);
//            size++;
//            return;
//        }else if (e.compareTo(node.e) > 0 && node.right == null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0)
//            add(node.left, e);
//        else
//            add(node.right, e);
//    }
}
