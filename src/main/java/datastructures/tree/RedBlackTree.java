package datastructures.tree;


// Self-balancing binary search tree
// All operations: space avg+worst = O(log(n)) Space avg+worst = O(n)

// No data is stored in leaf nodes

// Properties:
// 1. All nodes are red or black
// 2. Root is black
// 3. All leaves are black (no data stored)
// 4. If node is red, both of children are black
// 5. Every path from a given node to any of its descendant leaves
//    contains the same number of black nodes. Uniform No. of black nodes from root to leaves = black-height of tree

// In general 'the path from the root to farthest leaf is no more than twice as long as the path from the root
// to the nearest leaf.'
public class RedBlackTree<K, V> extends BinarySearchTree<K, V> {

    private Node<K, V> blackLeafSentinel;

    public RedBlackTree() {
        super();
        blackLeafSentinel = new Node<K, V>(null, null);
        blackLeafSentinel.black = true;
    }

    public Node<K, V> insert(K key, V value) {
        Node<K, V> n = super.insert(key, value);
        n.black = false;
        n.left = blackLeafSentinel;
        n.right = blackLeafSentinel;
        repaint(n);
        return n;
    }

    private void repaint(Node n) {
        repaint_case1(n);
    }

    // Case 1 - current new node it at root
    private void repaint_case1(Node n) {
        if (n.parent == null) {
            n.black = true;
        } else {
            repaint_case2(n);
        }
    }

    // Case 2 - current node's parent is black
    private void repaint_case2(Node n) {
        if (n.parent.black) {
            return;
        } else {
            repaint_case3(n);
        }
    }

    // Case 3 - parent and uncle are red
    // N.B. Must be a grandparent as root is always black
    // Can assume parent is red from previous case
    private void repaint_case3(Node n) {
        Node u = getUncle(n);
        if (u != null && !u.black) {
            n.parent.black = true;
            getUncle(n).black = true;
            Node gp = getGrandparent(n);
            gp.black = false;
            repaint_case1(gp);
        } else {
            repaint_case4(n);
        }
    }

    // Case 4 - parent is red, uncle is black,
    // n is right child of parent and parent is left child of grandparent
    // (or mirror image)
    private void repaint_case4(Node n) {
        // Parent red, uncle black can be assumed from previous cases
        Node gp = getGrandparent(n);
        Node p = n.parent;

        if (n.equals(p.right) && p.equals(gp.left)) {
            rotateLeft(p);
        } else if (n.equals(p.left) && p.equals(gp.right)) {
            rotateRight(p);
        }

        repaint_case5(p);
    }

    // Case 5 - parent is red, uncle is black,
    // n is left child of parent and parent is left child of grandparent
    // (or mirror image)
    private void repaint_case5(Node n) {
        Node gp = getGrandparent(n);
        Node p = n.parent;

        p.black = true;
        gp.black = false;

        if (n.equals(p.left)) {
            rotateRight(gp);
        } else {
            rotateLeft(gp);
        }
    }

    // TODO: make generic for case 5 when there is no parent node
/*    private void rotateLeft(Node n) {
        Node p = n.parent;
        p.left = n.right;
        p.left.parent = p;

        n.right = p.left.left;
        n.right.parent = n;

        p.left.left = n;
        n.parent = p.left;

    }*/


    // TODO: needs testing
    private void rotateRight_noParent(Node n) {
        Node tmp = new Node(n.left);
        tmp.parent = n.parent;
        if (n.parent != null) {
            if (n.parent.left.equals(n)) {
                n.parent.left = tmp;
            } else {
                n.parent.right = tmp;
            }
        }

        n.left = n.left.right;
        n.left.parent = n;

        tmp.right = n;
        n.parent = tmp;
    }

/*    private void rotateRight(Node n) {
        Node p = n.parent;
        p.right = n.left;
        p.right.parent = p;

        n.left = p.right.right;
        n.left.parent = n;

        p.right.right = n;
        n.parent = p.right;
    }*/

    public void delete(Object key) {
        // TODO
    }

    private Node getGrandparent(Node n) {
        if (n == null || n.parent == null) return null;
        return n.parent.parent;
    }

    private Node getUncle(Node n) {
        Node gp = getGrandparent(n);
        if (gp == null) return null;
        if (gp.left != null && gp.left.equals(n.parent)) {
            return gp.right;
        } else {
            return gp.left;
        }
    }
}
