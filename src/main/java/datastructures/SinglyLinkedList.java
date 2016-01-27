package datastructures;

// Not necessarily orderedcd dow
public class SinglyLinkedList<K> {

    private Element<K> first;

    public void insert(K value) {
        if (first == null) {
            first = new Element<K>(value, null);
        }


    }


    private class Element<K> {
        private K value;
        private Element<K> next;

        Element(K value, Element<K> next) {
            this.value = value;
            this.next = next;
        }
    }
}
