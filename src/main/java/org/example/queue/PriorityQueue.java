package org.example.queue;

import java.util.Arrays;
import java.util.Comparator;

public class PriorityQueue<T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 11;

    private Object[] array = new Object[DEFAULT_CAPACITY];
    private int size = 0;
    private final Comparator<? super T> comparator;

    public PriorityQueue() {
        comparator = null;
    }

    public PriorityQueue(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public void offer(T item) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length + array.length / 2);
        }
        array[size] = item;
        checkParentAndSwap(size);
        size++;
    }

    @SuppressWarnings("unchecked")
    private void checkParentAndSwap(int i) {
        if (i == 0) return;
        int parentIndex = (i + 1) / 2 - 1;
        T parent = (T) array[parentIndex];
        T current = (T) array[i];
        if (compare(parent, current) > 0) {
            array[parentIndex] = current;
            array[i] = parent;
            checkParentAndSwap(parentIndex);
        }
    }

    @SuppressWarnings("unchecked")
    public T poll() {
        if (size == 0) return null;
        T item = (T) array[0];
        array[0] = array[size - 1];
        array[size - 1] = null;
        size--;
        checkChildrenAndSwap(0);
        return item;
    }

    @SuppressWarnings("unchecked")
    public void checkChildrenAndSwap(int i) {
        int leftChildIndex = (i + 1) * 2 - 1;
        int rightChildIndex = (i + 1) * 2;

        if (leftChildIndex >= size) {
            return;
        }

        T leftChild = (T) array[leftChildIndex];
        T rightChild = (T) array[rightChildIndex];

        int minChildIndex;
        if (rightChildIndex >= size || compare(leftChild, rightChild) < 0) {
            minChildIndex = leftChildIndex;
        } else {
            minChildIndex = rightChildIndex;
        }

        T current = (T) array[i];
        T minChild = (T) array[minChildIndex];

        if (compare(minChild, current) < 0) {
            array[i] = minChild;
            array[minChildIndex] = current;
            checkChildrenAndSwap(minChildIndex);
        }
    }

    private int compare(T a, T b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        }
        return a.compareTo(b);
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        return (T) array[0];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
