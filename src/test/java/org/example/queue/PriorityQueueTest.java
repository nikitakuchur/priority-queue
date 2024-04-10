package org.example.queue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @Test
    void offerTest() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.offer(59);
        queue.offer(42);
        queue.offer(4);
        queue.offer(80);
        queue.offer(32);
        queue.offer(23);
        queue.offer(6);
        queue.offer(2);
        queue.offer(85);

        assertFalse(queue.isEmpty());
        assertEquals(9, queue.getSize());
        assertEquals(2, queue.peek());
    }

    @Test
    void offerAndPollTest() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.offer(59);
        queue.offer(42);
        queue.offer(4);
        queue.offer(80);
        queue.offer(32);
        queue.offer(23);
        queue.offer(6);
        queue.offer(2);
        queue.offer(85);

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());
        assertNull(queue.peek());
        assertEquals(List.of(2, 4, 6, 23, 32, 42, 59, 80, 85), result);
    }

    @Test
    void customComparatorTest() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        queue.offer(59);
        queue.offer(42);
        queue.offer(4);
        queue.offer(80);
        queue.offer(32);
        queue.offer(23);
        queue.offer(6);
        queue.offer(2);
        queue.offer(85);

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());
        assertNull(queue.peek());
        assertEquals(List.of(85, 80, 59, 42, 32, 23, 6, 4, 2), result);
    }
}
