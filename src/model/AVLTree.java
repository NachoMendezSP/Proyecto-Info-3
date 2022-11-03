package model;

public class AVLTree<AnyType extends Comparable<AnyType>> {

    private Node<AnyType> root;

    public AVLTree<AnyType> add(AnyType data) {
        root = add(data, root);
        return this;
    }

    private Node<AnyType> add(AnyType data, Node<AnyType> node) {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(add(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(add(data, node.getRight()));
        } else {
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }

    public void delete(AnyType data) {
        root = delete(data, root);
    }

    private Node<AnyType> delete(AnyType data, Node<AnyType> node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(delete(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(delete(data, node.getRight()));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            node.setData(getMax(node.getLeft()));
            node.setLeft(delete(node.getData(), node.getLeft()));
        }
        updateHeight(node);
        return applyRotation(node);
    }

    public AnyType getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(root);
    }

    private AnyType getMax(Node<AnyType> node) {
        if (node.getRight() != null) {
            return getMax(node.getRight());
        }
        return node.getData();
    }

    public AnyType getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(root);
    }

    private AnyType getMin(Node<AnyType> node) {
        if (node.getLeft() != null) {
            return getMin(node.getLeft());
        }
        return node.getData();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    private Node<AnyType> applyRotation(Node<AnyType> node) {
        int balance = balance(node);
        if (balance > 1) {
            if (balance(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (balance(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }
        return node;
    }

    private Node<AnyType> rotateRight(Node<AnyType> node) {
        Node<AnyType> leftNode = node.getLeft();
        Node<AnyType> centerNode = leftNode.getRight();
        leftNode.setRight(node);
        node.setLeft(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    private Node<AnyType> rotateLeft(Node<AnyType> node) {
        Node<AnyType> rightNode = node.getRight();
        Node<AnyType> centerNode = rightNode.getLeft();
        rightNode.setLeft(node);
        node.setRight(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    private void updateHeight(Node<AnyType> node) {
        int maxHeight = Math.max(
                height(node.getLeft()),
                height(node.getRight())
        );
        node.setHeight(maxHeight + 1);
    }

    private int balance(Node<AnyType> node) {
        return node != null ? height(node.getLeft()) - height(node.getRight()) : 0;
    }

    private int height(Node<AnyType> node) {
        return node != null ? node.getHeight() : 0;
    }

    public void printInOrder() {

        if (root.getLeft() != null) {
            printInOrder(root.getLeft());
        }

        System.out.print(root.getData() + "\t");

        if (root.getRight() != null) {
            printInOrder(root.getRight());
        }

        System.out.println();
    }

    private void printInOrder(Node<AnyType> node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getData() + "\t");
            printInOrder(node.getRight());
        }
    }

    public String printTree(Node<AnyType> node) {
        return this.createShow(node, "", "", false);
    }

    private String createShow(Node<AnyType> node, String show, String level, boolean isLeft) {
        show = show + level;
        if (!level.equals("")) {
            show = show + "\b\b" + (isLeft ? "├" : "└") + "─";
        }

        if (node == null) {
            return show + "\n";
        } else {
            show = show + node.getData() + "\n";
            show = this.createShow(node.getLeft(), show, level + "│ ", true);
            show = this.createShow(node.getRight(), show, level + "  ", false);
            return show;
        }
    }

    public Node<AnyType> getRoot() {
        return root;
    }

    public void setRoot(Node<AnyType> root) {
        this.root = root;
    }
}