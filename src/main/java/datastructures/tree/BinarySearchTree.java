package datastructures.tree;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class BinarySearchTree<K, V> {

    // Java's red-black tree impl (self-balancing binary search tree)
    //private TreeMap treeMap;

    private Node<K, V> root;


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

    public void delete() {
        // TODO
    }


    public V search(Object key) {
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
            else return curr.value;
        }

        return null;
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




    }
}
