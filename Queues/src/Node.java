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
