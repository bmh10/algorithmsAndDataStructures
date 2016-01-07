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
        Node<K, V> newNode = super.insert(key, value);
        newNode.black = false;
        newNode.left = blackLeafSentinel;
        newNode.right = blackLeafSentinel;

        // TODO

        return null;
    }

    public void delete(Object key) {
        // TODO
    }
}
