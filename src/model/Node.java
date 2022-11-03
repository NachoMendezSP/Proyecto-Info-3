package model;

public class Node<AnyType extends Comparable<AnyType>> {
    private AnyType data;
    private Node<AnyType> left;
    private Node<AnyType> right;
    private int height = 1; // AVL

    public Node() {
    }
    public Node(AnyType  data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public AnyType getData() {
        return this.data;
    }

    public void setData(AnyType data) {
        this.data = data;
    }

    public Node<AnyType> getLeft() {
        return this.left;
    }

    public void setLeft(Node<AnyType> left) {
        this.left = left;
    }

    public Node<AnyType> getRight() {
        return this.right;
    }

    public void setRight(Node<AnyType> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
