package datastructures.tree;


import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<K, V> {

    // Java's red-black tree impl (self-balancing binary search tree)
    //private TreeMap treeMap;

    private Node<K, V> root;

    private boolean delete_useLeftSubstree = true;

    public BinarySearchTree() {}

    public BinarySearchTree(List<K> arr) {
        for (K key : arr) {
            insert(key, null);
        }
    }


    public void insert(K key, V value) {
        if (key == null) {
            return;
        }

        // Case where tree is empty
        if (root == null) {
            root = new Node<K, V>(key, value);
            return;
        }

        Comparable<? super K> keyToInsert = (Comparable<? super K>) key;
        Node<K, V> curr = root;
        Node<K, V> parent = root;
        int val = 0;
        while (curr != null) {
            parent = curr;
            val = keyToInsert.compareTo(curr.key);
            if (val < 0) curr = curr.left;
            else if (val > 0) curr = curr.right;
            // Case where key already present in tree
            else {
                curr.value = value;
                return;
            }
        }

        // Case where need to add new leaf node
        Node newNode = new Node<K, V>(key, value);
        if (val < 0) parent.left = newNode;
        else parent.right = newNode;
    }

    public void delete(Object key) {
        Node<K, V> node = getNode(key);

        // No child or single child
        if (node.left == null || node.right == null) {
            Node childToMoveUp = node.right == null ? node.left : node.right;
            if (node.parent == null) {
                assert node.equals(root);
                root = childToMoveUp;
            } else {
                if (node.parent.left.equals(node)) {
                    node.parent.left = childToMoveUp;
                } else if (node.parent.right.equals(node)) {
                    node.parent.right = childToMoveUp;
                }
            }

            return;
        }

        // 2 children
        Node<K, V> predecessorOrSuccessor = delete_useLeftSubstree ? findMax(node.left) : findMin(node.right);
        delete_useLeftSubstree = !delete_useLeftSubstree;
        node.key = predecessorOrSuccessor.key;
        node.value = predecessorOrSuccessor.value;
        delete(predecessorOrSuccessor);
    }

    private Node<K, V> findMin(Node<K, V> node) {
        Node<K, V> currentNode = node;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode;
    }

    private Node<K, V> findMax(Node<K, V> node) {
        Node<K, V> currentNode = node;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }

        return currentNode;
    }

    public V search(Object key) {
        Node<K, V> node = getNode(key);
        return node.value;
    }

    private Node<K, V> getNode(Object key) {
        if (key == null) {
            return null;
        }

        Comparable<? super K> cmp = (Comparable<? super K>) key;
        Node<K, V> curr = root;
        int val;
        while (curr != null) {
            val = cmp.compareTo(curr.key);
            if (val < 0) curr = curr.left;
            else if (val > 0) curr = curr.right;
            else return curr;
        }

        return null;
    }

    public List<K> flatten_depthFirst_inOrder() {
        return flatten_depthFirst_inOrder(root);
    }

    private List<K> flatten_depthFirst_inOrder(Node<K, V> node) {
        List<K> keys = new ArrayList<K>();
        if (node == null) {
            return keys;
        }
        keys.addAll(flatten_depthFirst_inOrder(node.left));
        keys.add(node.key);
        keys.addAll(flatten_depthFirst_inOrder(node.right));
        return keys;
    }

    // TODO: switch to threaded binary tree impl
    private class Node<K, V> {

        private K key;
        private V value;
        private Node<K,V> left;
        private Node<K,V> right;
        private Node<K,V> parent;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public boolean equals(Object o) {
            if (o == null || !(o instanceof Node)) {
                return false;
            }

            Node other = (Node) o;
            boolean sameKey = key == null ? other.key == null : key.equals(other.key);
            boolean sameValue = value == null ? other.value == null : value.equals(other.value);
            return sameKey && sameValue;
        }

        public int hashCode() {
            int keyHash = key == null ? 0 : key.hashCode();
            int valueHash = value == null ? 0 : value.hashCode();
            return keyHash ^ valueHash;
        }
    }
}
