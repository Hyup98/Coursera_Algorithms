import java.util.ArrayList;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

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

    private ArrayList<Item> randomizedQueues = new ArrayList<>();

    // construct an empty randomized queue
    public RandomizedQueue() {
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return randomizedQueues.size() == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return randomizedQueues.size();
    }

    // add the item
    public void enqueue(Item item) {
        if(item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        randomizedQueues.add((int)(Math.random() * randomizedQueues.size()),item);
    }

    // remove and return a random item
    public Item dequeue() {
        if(randomizedQueues.size() == 0) {
            throw new java.util.NoSuchElementException();
        }
        int index = (int)(Math.random() * randomizedQueues.size());
        Item tem = randomizedQueues.get(index);
        randomizedQueues.remove(index);
        return tem;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if(randomizedQueues.size() == 0) {
            throw new java.util.NoSuchElementException();
        }
        return randomizedQueues.get((int)(Math.random() * randomizedQueues.size()));
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        @Override
        public boolean hasNext() {
            return randomizedQueues.size() != 0;
        }

        @Override
        public Item next() {
            return randomizedQueues.get((int)(Math.random() * randomizedQueues.size()));
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