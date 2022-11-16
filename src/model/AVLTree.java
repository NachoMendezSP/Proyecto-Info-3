package model;

public class AVLTree<AnyType extends Comparable<AnyType>> {

    private Node<AnyType> root;

    public int height(Node<AnyType> N) {
        if (N == null)
            return 0;
        return N.getHeight();
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public Node<AnyType> rightRotate(Node<AnyType> y) {
        Node<AnyType> x = y.getLeft();
        Node<AnyType> T2 = x.getRight();
        x.setRight(y);
        y.setLeft(T2);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        return x;
    }

    public Node<AnyType> leftRotate(Node<AnyType> x) {
        Node<AnyType> y = x.getRight();
        Node<AnyType> T2 = y.getLeft();
        y.setLeft(x);
        x.setRight(T2);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        return y;
    }

    // Get balance factor of a node
    int getBalanceFactor(Node<AnyType> N) {
        if (N == null)
            return 0;
        return height(N.getLeft()) - height(N.getRight());
    }

    // Insert a node
    public Node<AnyType> insert(Node<AnyType> node, AnyType item) {

        // Find the position and insert the node
        if (node == null)
            return (new Node<AnyType>(item));
        if (item.compareTo(node.getData()) < 0)
            node.setLeft(insert(node.getLeft(), item));
        else if (item.compareTo(node.getData()) > 0)
            node.setRight(insert(node.getRight(), item));
        else
            return node;

        // Update the balance factor of each node
        // And, balance the tree
        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (item.compareTo(node.getLeft().getData()) < 0) {
                return rightRotate(node);
            } else if (item.compareTo(node.getLeft().getData()) > 0) {
                node.setLeft(leftRotate(node.getLeft()));
                return rightRotate(node);
            }
        }
        if (balanceFactor < -1) {
            if (item.compareTo(node.getRight().getData()) > 0) {
                return leftRotate(node);
            } else if (item.compareTo(node.getRight().getData()) < 0) {
                node.setRight(rightRotate(node.getRight()));
                return leftRotate(node);
            }
        }
        return node;
    }

    public Node<AnyType> nodeWithMimumValue(Node<AnyType> node) {
        Node<AnyType> current = node;
        while (current.getLeft() != null)
            current = current.getLeft();
        return current;
    }

    public boolean find (AnyType x, Node<AnyType> t){
        while (t != null){
            if (x.compareTo(t.getData()) < 0)
                t = t.getLeft();
            else if (x.compareTo(t.getData()) > 0)
                t = t.getRight();
            else
                return true; // Match
        }
        return false; // Not found
    }

    // Delete a node
    public Node<AnyType> delete(Node<AnyType> root, AnyType item) {

        // Find the node to be deleted and remove it
        if (root == null)
            return root;
        if (item.compareTo(root.getData()) < 0)
            root.setLeft(delete(root.getLeft(), item));
        else if (item.compareTo(root.getData()) > 0)
            root.setRight(delete(root.getRight(), item));
        else {
            if ((root.getLeft() == null) || (root.getRight() == null)) {
                Node<AnyType> temp = null;
                if (temp == root.getLeft())
                    temp = root.getRight();
                else
                    temp = root.getLeft();
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                Node<AnyType> temp = nodeWithMimumValue(root.getRight());
                root.setData(temp.getData());
                root.setRight(delete(root.getRight(), temp.getData()));
            }
        }
        if (root == null)
            return root;

        // Update the balance factor of each node and balance the tree
        root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);
        int balanceFactor = getBalanceFactor(root);
        if (balanceFactor > 1) {
            if (getBalanceFactor(root.getLeft()) >= 0) {
                return rightRotate(root);
            } else {
                root.setLeft(leftRotate(root.getLeft()));
                return rightRotate(root);
            }
        }
        if (balanceFactor < -1) {
            if (getBalanceFactor(root.getRight()) <= 0) {
                return leftRotate(root);
            } else {
                root.setRight(rightRotate(root.getRight()));
                return leftRotate(root);
            }
        }
        return root;
    }
    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    public void preOrder(Node<AnyType> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
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
        System.out.println("Árbol de menor a mayor:");
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