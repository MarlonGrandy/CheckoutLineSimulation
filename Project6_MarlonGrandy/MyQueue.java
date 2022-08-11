
/*
Marlon Grandy
Lab 6
File name MyQueye.java
Class use: Makes a queue out of a dopubly linked list and makes an iteratopr for the queue 
*/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue<T> implements Iterable<T> {
    private Node head; // reference to head node
    private Node tail; // reference to tail node
    private int size; // size of the queue

    public MyQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean offer(T item) {
        // Inserts item into this queue if possible. Returns true if successful.
        Node n = new Node(item);
        if (size == 0) {
            this.tail = n;
            this.head = n;
            size++;
            return true;
        } else {
            n.setPrev(tail);
            tail.setNext(n);
            tail = n;
            size++;
            return true;
        }
    }

    public T peek() {
        // Returns, but does not remove, the head of this queue, or returns null if this
        // queue is empty.
        if (size == 0) {
            return null;
        } else {
            return head.getData();
        }
    }

    public T poll() {
        // Returns and removes the head of this queue, or returns null if this queue is
        // empty.
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            T data = head.getData();
            head = null;
            tail = null;
            size--;
            return data;
        } else {
            size--;
            head = head.getNext();
            T data = head.getPrev().getData();
            head.setPrev(null);
            return data;
        }
    }

    public Node getHead() { // getter for queue head
        return head;
    }

    public Node getTail() { // getter for queue tail
        return tail;
    }

    public int getSize() { // getter for queue size
        return size;
    }

    public void setHead(Node n) { // setter for queue head
        head = n;
    }

    public void setTail(Node n) { // setter for queue tail
        tail = n;
    }

    class Node {
        private Node next; // next pointer
        private Node prev; // previous node pointer
        private T data; // data within the Node

        public Node(T item) { // a constructor that initializes next to null and the container field to item.
            this.next = null;
            this.prev = null;
            this.data = item;
        }

        public T getData() { // returns the value of the container field.
            return data;
        }

        public void setNext(Node n) { // sets next to the given node.
            next = n;
        }

        public void setPrev(Node n) { // sets prev to the given node.
            prev = n;
        }

        public Node getNext() { // getter for next node
            return next;
        }

        public Node getPrev() { // getter for prev node
            return prev;
        }


    }

    private class QueueIterator implements Iterator<T> {
        Node next;

        public QueueIterator(Node head) {
            this.next = head;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T info = next.getData();
            next = next.getNext();
            return info;
        }
    }

    @Override
    public Iterator<T> iterator() {// return a new LLIterator with head passed to the constructor
        return new QueueIterator(this.head);
    }

    public static void main(String[] args) { // method tested for queue class
        MyQueue<Integer> q = new MyQueue<Integer>();
        // offer method test
        q.offer(10);
        q.offer(5);
        q.offer(1);
        System.out.println("The tail node data is:" + q.tail.getData());

        // peek method test
        System.out.println("Peek:" + q.peek());

        // poll test
        System.out.println("The head is:" + q.peek());
        q.poll();
        System.out.println("The head is:" + q.peek());
        q.poll();
        System.out.println("The head is:" + q.peek());
        q.poll();
        System.out.println("The head is:" + q.peek());

        // iterator test
        MyQueue<Integer> list = new MyQueue<Integer>();

        // add ten numbers to the list, in order
        for (int i = 0; i < 5; i++) {
            list.offer(i);
        }
        System.out.println("There are " + list.getSize() + " lights");

        // execute a foreach loop
        for (Integer num : list) {
            System.out.println("value: " + num);
        }

    }

}
