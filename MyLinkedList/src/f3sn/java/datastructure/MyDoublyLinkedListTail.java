package f3sn.java.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedListTail<E> implements IList<E>, Iterable<E>{

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<E>{
        Node<E> index;

        public MyIterator() {
            this.index = head;
        }

        @Override
        public boolean hasNext() {
            return (null != index);
        }

        @Override
        public E next() {
            if(!hasNext())
                throw new NoSuchElementException();
            E dataIndex = index.data;
            index = index.next;
            return dataIndex;
        }
    }

    class Node<E>{
        E data;
        Node<E> next;
        Node<E> previous;

        public Node(E data) {
            this.data = data;
            next= previous = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    public MyDoublyLinkedListTail() {
        this.head = this.tail =null;
        this.currentSize=0;
    }

    public void addFirst(E objE){
        Node<E> node = new Node<E>(objE);
        if(null == head){
            head = tail = node;
        }else
        {
            node.next = head;
            head.previous = node;
            head = node;
        }
        currentSize++;
    }

    public void addLast(E objE){
        Node<E> node = new Node<E>(objE);
        if(null == head){
            addFirst(objE);
        }else{
            tail.next = node;
            node.previous = tail;
            tail=node;
            currentSize++;
        }
    }

    public E removeFirst(){
        E data = null;
        if(null != head){
            data = head.data;
            head = head.next;
            currentSize--;
        }
        return data;
    }

    public E removeLast(){
        E data = null;
        if(null != head){
            if(head==tail)
                return removeFirst();
            data = tail.data;
            tail = tail.previous;
            tail.next = null;
            currentSize--;
        }
        return data;
    }

    public E remove(E objE){
        E data = null;
        Node<E> previousNode = null;
        Node<E> currentNode = head;
        while (null != currentNode) {
            if(((Comparable<E>)currentNode.data).compareTo(objE)== 0) {
                if(head == currentNode)
                    return removeFirst();
                if(tail == currentNode)
                    return removeLast();
                data = currentNode.data;
                previousNode.next = currentNode.next;
                currentNode.next.previous = previousNode;
                currentNode.next=null;
                currentNode.previous=null;
                currentSize--;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return data;
    }

    public boolean contains(E objE){
        boolean contained = false;
        Node<E> currentNode = head;
        while (null != currentNode) {
            if(((Comparable<E>)currentNode.data).compareTo(objE)== 0) {
                contained =  true;
            }
            currentNode = currentNode.next;
        }
        return contained;
    }

    public E peekFirst(){
        if(null==head)
            return null;
        return head.data;
    }

    public E peekLast(){
        if(null==tail)
            return null;
        return tail.data;
    }

    public int getCurrentSize() {
        return currentSize;
    }
}
