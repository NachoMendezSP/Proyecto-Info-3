package model;

public class BinTree<AnyType extends Comparable<AnyType>> {

    private Node<AnyType> root;
    private Integer depth;

    public BinTree(){
        this.depth = 0;
    }

    public AnyType elementAt (Node<AnyType> t){
        return t == null ? null : t.getData();
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

    public Node<AnyType> findMin (Node<AnyType> t){
        if (t != null)
            while (t.getLeft() != null)
                t = t.getLeft();
        return t;
    }

    public Node<AnyType> insert (Node<AnyType> t, AnyType x) throws Exception {
        if (t == null)
            t = new Node<AnyType>(x);
        else if (x.compareTo(t.getData()) < 0)
            t.setLeft(insert(t.getLeft(), x));
        else if (x.compareTo(t.getData()) > 0)
            t.setRight(insert (t.getRight(), x));
        else
            System.out.println("El elemento ya se encuentra en el árbol.");
            // throw new Exception ("El elemento ya se encuentra en el árbol."); // Duplicate
        return t;
    }

    public Node<AnyType> removeMin (Node<AnyType> t) throws Exception {
        if (t == null)
            throw new Exception(); // Item Not Found
        else if (t.getLeft() != null){
            t.setRight(removeMin(t.getLeft()));
            return t;
        }
        else
            return t.getRight();
    }

    public Node<AnyType> remove (Node<AnyType> t, AnyType x) throws Exception {
        if (t == null)
            throw new Exception (x.toString()); // Duplicate
        if (x.compareTo(t.getData()) < 0)
            t.setLeft(remove(t.getLeft(), x));
        else if (x.compareTo(t.getData()) > 0)
            t.setRight(remove(t.getLeft(), x));
        else if (t.getLeft() != null && t.getRight() != null){ //Two children
            t.setData(findMin(t.getRight()).getData());
            t.setRight(removeMin(t.getRight()));
        }
        else
            t = (t.getLeft() != null) ? t.getLeft() : t.getRight();
        return t;
    }

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
        return root;
    }

    public Node<AnyType> nodeWithMimumValue(Node<AnyType> node) {
        Node<AnyType> current = node;
        while (current.getLeft() != null)
            current = current.getLeft();
        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    public Node<AnyType> getRoot() {
        return root;
    }

    public void setRoot(Node<AnyType> root) {
        this.root = root;
    }

    public void printInOrder() {
        System.out.println("Árbol de menor a mayor:");
        if (root.getLeft() != null) {
            printInOrder(root.getLeft());
        }

        System.out.print(root.getData() + "\t");

        if (root.getRight() != null) {
            printInOrder(root.getRight());
        }

        System.out.println();
    }

    public void printInOrder(Node<AnyType> node) {

        if (node.getLeft() != null) {
            printInOrder(node.getLeft());
        }

        System.out.print(node.getData() + "\t");

        if (node.getRight() != null) {
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
}
