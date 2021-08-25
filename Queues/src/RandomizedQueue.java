//import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Object;

public class RandomizedQueue<Item> implements Iterable<Item> {

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
    private int queueSize;

    //private ArrayList<Item> randomizedQueues = new ArrayList<>();
    private Item[] randomizeQueues;

    // construct an empty randomized queue
    public RandomizedQueue() {
        randomizeQueues = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        //return randomizedQueues.size() == 0;
        return queueSize == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        //return randomizedQueues.size();
        return queueSize;
    }

    // add the item
    public void enqueue(Item item) {
        if(item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        //randomizedQueues.add((int)(Math.random() * randomizedQueues.size()),item);
        if(queueSize == randomizeQueues.length) {
            Item[] tem = (Item[]) new Object[randomizeQueues.length * 2];
            for(int i = 0; i < queueSize; i++) {
                tem[i] = randomizeQueues[i];
            }
            randomizeQueues = tem;
        }
        randomizeQueues[queueSize] = item;
        queueSize++;
        return;
    }

    // remove and return a random item
    public Item dequeue() {
        /*
        if(randomizedQueues.size() == 0) {
            throw new java.util.NoSuchElementException();
        }
        int index = (int)(Math.random() * randomizedQueues.size());
        Item tem = randomizedQueues.get(index);
        randomizedQueues.remove(index);
        return tem;
        */
        if(queueSize == 0) {
            throw new java.util.NoSuchElementException();
        }

        int index = (int)(Math.random() * queueSize);

        Item answer = randomizeQueues[index];

        for(int i = index; i < queueSize - 1; i++) {
            randomizeQueues[i] = randomizeQueues[i+1];
        }
        randomizeQueues[queueSize - 1] = null;
        queueSize--;

        if(queueSize*2 == randomizeQueues.length) {
            Item[] tem = (Item[]) new Object[randomizeQueues.length / 2];
            for(int i = 0; i < queueSize; i++) {
                tem[i] = randomizeQueues[i];
            }
            randomizeQueues = tem;
        }
        return answer;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if(queueSize == 0) {
            throw new java.util.NoSuchElementException();
        }

        return randomizeQueues[(int)(Math.random() * queueSize)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int i;
        @Override
        public boolean hasNext() {
            return randomizeQueues[i] != null;
        }

        @Override
        public Item next() {
            if(hasNext() == false) {
                throw  new java.util.NoSuchElementException();
            }
            Item answer =  randomizeQueues[i];
            i++;
            return answer;
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