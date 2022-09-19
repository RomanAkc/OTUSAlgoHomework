package OTUSHomework;

public class SimpleBST {
    private static class Node {
        int value;
        Node left = null;
        Node right = null;
        Node parent;

        public Node(int x, Node parent) {
            this.value = x;
            this.parent = parent;
        }

        public void insert(int x) {
            if(x < value) { //value is less than value in node, try to insert to left tree
                if(left == null)
                    left = new Node(x, this);
                else
                    left.insert(x);
            } else if(x > value) { //value is greater than value in node, try to insert to right tree
                if(right == null)
                    right = new Node(x, this);
                else
                    right.insert(x);
            }
            //value already exists in tree, skip insert
        }

        public Node search(int x) {
            if(x == value)
                return this;

            //value is less than value in node, search in left tree
            if(x < value) {
                if(left == null)
                    return null;

                return left.search(x);
            }

            //value is greater than value in node, search in right tree
            if(right == null)
                return null;

            return right.search(x);
        }

        public void remove() {
            //1. Removable node has no children -> remove node (nullify parent left or right)
            if(left == null && right == null) {
                if(value > parent.value)
                    parent.right = null;
                else
                    parent.left = null;
                return;
            }

            //2. Removable node has one child -> remove node and change parent of child to parent of removed node
            if(left != null && right == null) {
                if(value > parent.value)
                    parent.right = left;
                else
                    parent.left = left;
                left.parent = parent;
                return;
            }

            if(left == null) {
                if(value > parent.value)
                    parent.right = right;
                else
                    parent.left = right;
                right.parent = parent;
                return;
            }

            //3. Removable node has two children -> find max in left subtree (or min in right subtree), exchange elements
            //and remove exchanged elements (there will be case 1 or 2)
            //if(min from right) { //find min in right tree
                Node min = findMin(right);
                int tmp = min.value;
                min.remove();
                value = tmp;
            /*} else { //find max in left tree
                Node max = findMax(left);
                int tmp = max.value;
                max.remove();
                value = tmp;
            }*/
        }

        private Node findMin(Node bst) {
            if(bst.left == null)
                return bst;

            return findMin(bst.left);
        }

        /*private Node findMax(Node bst) {
            if(bst.right == null)
                return bst;

            return findMin(bst.right);
        }*/
    }

    private Node node = null;

    public void insert(int x) {
        //empty tree, add new node
        if(node == null) {
            node = new Node(x, null);
            return;
        }

        node.insert(x);
    }

    public boolean search(int x) {
        //empty tree
        if(node == null)
            return false;

        return node.search(x) != null;
    }

    public void remove(int x) {
        //empty tree
        if(node == null)
            return;

        Node removable = node.search(x);
        if(removable == null)
            return;

        //remove top of tree -> special case, we can't check parents
        if(removable == node) {
            //one node in tree
            if(node.left == null && node.right == null)
                node = null;
            else if(node.left != null && node.right == null)
                node = node.left;
            else if(node.left == null)
                node = node.right;
            else
                node.remove();
            return;
        }

        removable.remove();
    }
}
