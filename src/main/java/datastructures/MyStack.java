package datastructures;

import java.util.*;

public class MyStack<E> {

    // TODO: switch to my dynamic array impl

    // Deque (pronounced 'deck') is preferred to Java's stack and liked list implementation
    private Deque<E> data;

    public MyStack() {
        data = new ArrayDeque<E>();
    }

    public void push(E item) {
        data.addFirst(item);
    }

    public E pop() {
        return data.removeFirst();
    }

    public E peek() {
        return data.peekFirst();
    }

    public int size() {
        return data.size();
    }
}
