package f3sn.java.datastructure;

import f3sn.java.datastructure.IList;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements IList<E>, Iterable<E>{

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

        public Node(E data) {
            this.data = data;
            next= null;
        }
    }

    private Node<E> head;
    private int currentSize;

    public MyLinkedList() {
        this.head = null;
        this.currentSize=0;
    }

    public void addFirst(E objE){
        //Complexity constant
        Node<E> node = new Node<E>(objE);
        node.next = head;
        this.head=node;
        currentSize++;
    }

    public void addLast(E objE){
        //Complexity N
        Node<E> node = new Node<E>(objE);
        if(null != this.head) {
            Node<E> tail = head;
            while (null != tail.next)
                tail = tail.next;
            tail.next = node;
            currentSize++;
        }else
            addFirst(objE);
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
            if(null==head.next)
                return removeFirst();
            Node<E> previousTail = null;
            Node<E> currentTail = head;
            while (null != currentTail.next) {
                previousTail = currentTail;
                currentTail = currentTail.next;
            }
            data = currentTail.data;
            previousTail.next = currentTail.next;
            currentTail = previousTail;
            currentSize--;
        }
        return data;
    }


    public E remove(E objE){
        E data = null;
        Node<E> previousNode = null;
        Node<E> currentNode = head;
        Node<E> nodeToRemoved = new Node<E>(objE);
        while (null != currentNode) {
            if(((Comparable<E>)currentNode.data).compareTo(objE)== 0) {
                if(currentNode == head)
                    return removeFirst();
                if(currentNode.next == null)
                    return removeLast();
                data = currentNode.data;
                previousNode.next = currentNode.next;
                currentNode.next=null;
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
                break;
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
        Node<E> current = head;
        while (null != current.next)
            current = current.next;
        return current.data;
    }

    public int getCurrentSize() {
        return currentSize;
    }
}
