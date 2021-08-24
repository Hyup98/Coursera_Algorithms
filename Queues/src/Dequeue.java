import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Dequeue<Item> implements Iterable<Item> {

    public class Node<Item> {
        private Item item;
        private Node next;

        public Node(Item item) {
            this.item = item;
            next = null;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public Item getItem() {
            return item;
        }
    }

    private Node<Item> first;

    // construct an empty deque
    public Dequeue() {
        first = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        if(first == null) {
            return true;
        }
        return false;
    }

    // return the number of items on the deque
    public int size() {
        Node<Item> tem = first;
        if(first == null) {
            return 0;
        }
        int count = 0;
        while(true) {
            if(tem.getNext() == null) {
                break;
            }
            count++;
            tem = tem.getNext();
        }
        return count;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if(item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        Node<Item> tem = new Node(item);
        if(first == null) {
            first = tem;
            return;
        }
        tem.setNext(first);
        first = tem;
    }

    // add the item to the back
    public void addLast(Item item) {
        if(item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        Node<Item> tem = new Node(item);
        if(first == null) {
            first = tem;
            return;
        }
        Node<Item> iter = first;
        while(true) {
            if(iter.getNext() == null) {
                break;
            }
            iter = iter.getNext();
        }
        iter.setNext(tem);
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if(first == null) {
            throw new java.util.NoSuchElementException();
        }
        Item tem = first.getItem();
        first = first.getNext();
        return tem;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if(first == null) {
            throw new java.util.NoSuchElementException();
        }
        Node<Item> iter = first;
        while(true) {
            if(iter.getNext() == null) {
                break;
            }
            iter = iter.getNext();
        }
        Node<Item> finder = first;
        while(true) {
            if(finder.getNext() == iter) {
                break;
            }
            finder = first.getNext();
        }
        Item tem = iter.getItem();
        finder.setNext(null);
        return tem;
    }


    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private Node<Item> currnet = first;

        @Override
        public boolean hasNext() {
            return currnet != null;
        }

        @Override
        public Item next() {
            Item item = currnet.getItem();
            currnet = currnet.getNext();
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    // unit testing (required)
    public static void main(String[] args) {
        Dequeue<Integer> app = new Dequeue<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        builder.append("----DEQUEUE----\n")
                .append("(1) add        (2) print        (3) exit\n");
        while(true) {
            System.out.print(builder.toString());

            int menu = sc.nextInt();
            if(menu == 1) {
                app.addLast(sc.nextInt());
            }
            else if(menu == 2) {
                for(Integer i: app) {
                    System.out.print(i + "  ");
                }
                System.out.print("\n");
            }
            else {
                break;
            }

        }

    }

}