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

    public Node<AnyType> find (AnyType x, Node<AnyType> t){
        while (t != null){
            if (x.compareTo(t.getData()) < 0)
                t = t.getLeft();
            else if (x.compareTo(t.getData()) > 0)
                t = t.getRight();
            else
                return t; // Match
        }
        return null; // Not found
    }

    public Node<AnyType> findMin (Node<AnyType> t){
        if (t != null)
            while (t.getLeft() != null)
                t = t.getLeft();
        return t;
    }

    public Node<AnyType> insert (AnyType x, Node<AnyType> t) throws Exception {
        if (t == null)
            t = new Node<AnyType>(x);
        else if (x.compareTo(t.getData()) < 0)
            t.setLeft(insert(x, t.getLeft()));
        else if (x.compareTo(t.getData()) > 0)
            t.setRight(insert (x, t.getRight()));
        else
            throw new Exception (x.toString()); // Duplicate
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

    public Node<AnyType> remove (AnyType x, Node<AnyType> t) throws Exception {
        if (t == null)
            throw new Exception (x.toString()); // Duplicate
        if (x.compareTo(t.getData()) < 0)
            t.setLeft(remove(x, t.getLeft()));
        else if (x.compareTo(t.getData()) > 0)
            t.setRight(remove(x, t.getLeft()));
        else if (t.getLeft() != null && t.getRight() != null){ //Two children
            t.setData(findMin(t.getRight()).getData());
            t.setRight(removeMin(t.getRight()));
        }
        else
            t = (t.getLeft() != null) ? t.getLeft() : t.getRight();
        return t;
    }
/*
    public void add(AnyType x) {
        if (isEmpty()) root = new Node<>(x);
        else if (x.compareTo(root.getData()) < 0) {
            if (root.getLeft() == null) {
                root.setLeft(new Node<>(x));
            } else {
                add(x, root.getLeft());
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(new Node<>(x));
            } else {
                add(x, root.getRight());
            }
        }
    }

    private void add(AnyType x, Node<AnyType> node) {
        if (x.compareTo(node.getData()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node<>(x));
            } else {
                add(x, node.getLeft());
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node<>(x));
            } else {
                add(x, node.getRight());
            }
        }
    }

    public void delete(AnyType x) throws Exception {
        if (x.equals(root.getData())) {
            if (root.getLeft() == null && root.getRight() == null) root = null;
            else if (root.getRight() == null) root = root.getLeft();
            else if (root.getLeft() == null) root = root.getRight();
            else {
                Node<AnyType> aux = root.getLeft();
                root = root.getRight();
                Node<AnyType> aux2 = root.getLeft();
                if (aux2 != null) {
                    while (aux2.getLeft() != null) {
                        aux2 = aux2.getLeft();
                    }
                    aux2.setLeft(aux);
                } else root.setLeft(aux);
            }

        } else if (x.compareTo(root.getData()) < 0 && root.getLeft() != null)
            root.setLeft(delete(x, root.getLeft()));
        else if (x.compareTo(root.getData()) > 0 && root.getRight() != null)
            root.setRight(delete(x, root.getRight()));
        else throw new Exception("El elemento no esta en el arbol.");
    }

    private Node<AnyType> delete(AnyType x, Node<AnyType> node) throws Exception {
        if (x.equals(node.getData())) {
            if (node.getLeft() == null && node.getRight() == null) node = null;
            else if (node.getRight() == null) node = node.getLeft();
            else if (node.getLeft() == null) node = node.getRight();
            else {
                Node<AnyType> aux = node.getLeft();
                node = node.getRight();
                Node<AnyType> aux2 = node.getLeft();
                if (aux2 != null) {
                    while (aux2.getLeft() != null) {
                        aux2 = aux2.getLeft();
                    }
                    aux2.setLeft(aux);
                } else node.setLeft(aux);
            }
        } else if (x.compareTo(root.getData()) < 0 && node.getLeft() != null)
            node.setLeft(delete(x, node.getLeft()));
        else if (x.compareTo(root.getData()) > 0 && node.getRight() != null)
            node.setRight(delete(x, node.getRight()));
        else throw new Exception("El elemento no esta en el arbol.");
        return node;
    }

    public Integer depth() {
        int depthl = 0;
        if (root.getLeft() != null) {
            depth(root.getLeft(), depthl + 1);
        }
        if (root.getRight() != null) {
            depth(root.getRight(), depthl + 1);
        }
        return depthl;
    }

    private Integer depth(Node<AnyType> node, Integer depthl) {
        if (node.getLeft() != null) {
            depth(node.getLeft(), depthl + 1);
        }
        if (node.getRight() != null) {
            depth(node.getRight(), depthl + 1);
        } else {
            if (depth < depthl) depth = depthl;
        }
        return depthl;
    }

    public AnyType search(AnyType x) throws Exception {
        if (x.equals(root.getData())) return root.getData();
        else if (x.compareTo(root.getData()) < 0 && root.getLeft() != null) return search(x, root.getLeft());
        else if (x.compareTo(root.getData()) > 0 && root.getRight() != null) return search(x, root.getRight());
        else throw new Exception("El elemento no esta en el arbol.");
    }

    private AnyType search(AnyType x, Node<AnyType> node) throws Exception {
        if (x.equals(node.getData())) return node.getData();
        else if (x.compareTo(root.getData()) < 0 && node.getLeft() != null) return search(x, node.getLeft());
        else if (x.compareTo(root.getData()) > 0 && node.getRight() != null) return search(x, node.getRight());
        else throw new Exception("El elemento no esta en el arbol.");
    }
*/

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
        System.out.println("Arbol de menor a mayor:");
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
