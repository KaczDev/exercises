package solutions.leetcode.arrays;

import solutions.Solution;

public class LC_641 implements Solution {
    @Override
    public void solve() {
        MyCircularDeque mcd = new MyCircularDeque(3);
        System.out.println(mcd.insertLast(1));
        System.out.println(mcd.insertLast(2));
        System.out.println(mcd.insertFront(3));
        System.out.println(mcd.insertFront(4));
        System.out.println(mcd.getRear());
        System.out.println(mcd.isFull());
        System.out.println(mcd.deleteLast());
        System.out.println(mcd.insertFront(4));
        System.out.println(mcd.getFront());

    }
    class MyCircularDeque {

        int[] array;
        int front;
        int rear;
        int size;
        int capacity;

        public MyCircularDeque(int k) {
            array = new int[k];
            size = 0;
            capacity = k;
            front = 0;
            rear = k - 1;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;
            front = (front - 1 + capacity) % capacity;
            array[front] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;
            rear = (rear + 1) % capacity;
            array[rear] = value;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;
            front = (front + 1) % capacity;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;
            rear = (rear - 1 + capacity) % capacity;
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) return -1;
            return array[front];
        }

        public int getRear() {
            if (isEmpty()) return -1;
            return array[rear];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }
}
