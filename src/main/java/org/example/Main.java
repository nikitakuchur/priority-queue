package org.example;

import org.example.queue.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        heap.offer(10);
        heap.offer(34);
        heap.offer(89);
        heap.offer(4);
        heap.offer(6);

        System.out.println("Hello world!");
    }
}