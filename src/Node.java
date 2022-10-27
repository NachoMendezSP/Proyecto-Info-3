public class Node {
    private Integer data;
    private Node left;
    private Node right;

    public Node(Integer data) {
        this.data = data;
    }

    public void add(Integer d) {
        if (d < this.data) {
            if (this.left != null) {
                this.left.add(d);
            } else {
                this.left = new Node(d);
            }
        } else if (this.right != null) {
            this.right.add(d);
        } else {
            this.right = new Node(d);
        }

    }

    public Integer find(Integer d) {
        if (d == this.data) {
            return this.data;
        } else if (d < this.data) {
            return this.left != null ? this.left.find(d) : null;
        } else {
            return this.right != null ? this.right.find(d) : null;
        }
    }

    public void printInOrderBinaryTree() {
        if (this.left != null) {
            this.left.printInOrderBinaryTree();
        }

        System.out.print(this.data + ", ");
        if (this.right != null) {
            this.right.printInOrderBinaryTree();
        }

    }

    public int depth(Node n) {
        if (n == null) {
            return 0;
        } else {
            int depthRight = this.depth(n.right);
            int depthLeft = this.depth(n.left);
            return depthLeft > depthRight ? 1 + depthLeft : 1 + depthRight;
        }
    }

    public String printTree(Node node) {
        return this.createShow(node, "", "", false);
    }

    private String createShow(Node node, String show, String level, boolean isLeft) {
        show = show + level;
        if (!level.equals("")) {
            show = show + "\b\b" + (isLeft ? "├" : "└") + "─";
        }

        if (node == null) {
            return show + "\n";
        } else {
            show = show + node.data + "\n";
            show = this.createShow(node.getLeft(), show, level + "│ ", true);
            show = this.createShow(node.getRight(), show, level + "  ", false);
            return show;
        }
    }

    public Node dtree(Integer el, Node node) {
        if (node == null) {
            return null;
        } else {
            if (el.compareTo(node.data) > 0) {
                node.right = this.dtree(el, node.right);
            } else if (el.compareTo(node.data) < 0) {
                node.left = this.dtree(el, node.left);
            } else {
                if (node.left == null) {
                    return node.right;
                }

                if (node.right == null) {
                    return node.left;
                }

                node.data = this.findMax(node.left).data;
                node.left = this.dtree(node.data, node.left);
            }

            return node;
        }
    }

    private Node findMax(Node node) {
        while(node.right != null) {
            node = node.right;
        }

        return node;
    }

    public Integer getData() {
        return this.data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
