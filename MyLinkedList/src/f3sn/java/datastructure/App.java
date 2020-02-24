package f3sn.java.datastructure;

public class App {

    public static void main(String[] args) {
        IList<Integer> linkedlist = new MyDoublyLinkedListTail<>();

        for (int i = 0; i < 5; i++)
            linkedlist.addFirst(i);

        for (int l = 10; l < 15; l++)
            linkedlist.addLast(l);

       System.out.println("removeFirst 4 : " + linkedlist.removeFirst());
       System.out.println("removeFirst 3 : " + linkedlist.removeFirst());
       System.out.println("removeFirst 2 : " + linkedlist.removeFirst());
       System.out.println("re");
        System.out.println("removeLast 14 : " + linkedlist.removeLast());
        System.out.println("removeLast 13 : " + linkedlist.removeLast());
        System.out.println("removeLast 12 : " + linkedlist.removeLast());
        System.out.println("re");
        System.out.println("contains 10 : " + linkedlist.contains(10));
        System.out.println("peekFirst 1 : " + linkedlist.peekFirst());
        System.out.println("peekFirst 1 : " + linkedlist.peekFirst());
        System.out.println("peekLast 11 : " + linkedlist.peekLast());
        System.out.println("peekLast 11 : " + linkedlist.peekLast());
        System.out.println("re");
        System.out.println("remove 0 : " + linkedlist.remove(0));
        System.out.println("remove 1 : " + linkedlist.remove(1));
        System.out.println("remove 11 : " + linkedlist.remove(11));
        System.out.println("re");
        System.out.println("peekFirst 10 : " + linkedlist.peekFirst());
        System.out.println("peekLast 10 : " + linkedlist.peekLast());
        System.out.println("re");
    }

}
