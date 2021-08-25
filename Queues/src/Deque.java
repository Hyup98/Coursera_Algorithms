import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private class Node {
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

    private Node first;
    private int size;

    // construct an empty deque
    public Deque() {
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
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if(item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        Node tem = new Node(item);
        if(first == null) {
            first = tem;
            size++;
            return;
        }
        tem.setNext(first);
        first = tem;
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if(item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        Node tem = new Node(item);
        if(first == null) {
            first = tem;
            size++;
            return;
        }
        Node iter = first;
        while(true) {
            if(iter.getNext() == null) {
                break;
            }
            iter = iter.getNext();
        }
        iter.setNext(tem);
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if(first == null) {
            throw new java.util.NoSuchElementException();
        }
        Item tem = first.getItem();
        first = first.getNext();
        size--;
        return tem;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if(first == null) {
            throw new java.util.NoSuchElementException();
        }
        Node iter = first;
        Node finder = first.getNext();
        if(finder == null) {
            Item tem = iter.getItem();
            first = null;
            size--;
            return tem;
        }
        while(true) {
            if(finder.getNext() == null) {
                break;
            }
            iter = iter.getNext();
            finder = finder.getNext();
        }

        Item tem = finder.getItem();
        iter.setNext(null);
        size--;
        return tem;
    }


    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if(hasNext() == false) {
                throw  new java.util.NoSuchElementException();
            }
            Item item = current.getItem();
            current = current.getNext();
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    // unit testing (required)
    public static void main(String[] args) {

    }

}