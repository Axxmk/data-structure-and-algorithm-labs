package LinkedList;

public class SinglyLinkedList {
    SLLnode head;
    SLLnode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // addToTail()
    // addToHead()
    // size()  sort()
    // deleteFromTail()  deleteFromHead()  deleteithNode(i)
    // deleteByValue(int v)  swapNode(i, j)  reverse()

    public void addToTail(int v) {
        if (this.head == null) {
            this.tail=  this.head = new SLLnode(v, null);
        }
        else {
            this.tail.next = new SLLnode(v, null);
            this.tail = this.tail.next;
        }
    }

    public void addToHead(int v) {
        this.head = new SLLnode(v, this.head);
        if (tail == null) {
            this.tail = this.head;
        }
    }

    public void printAllNode() {
        for (SLLnode i = this.head; i != null; i = i.next) {
            if (i == this.tail) {
                System.out.print(i.value);
            }
            else {
                System.out.print(i.value + " => ");
            }
        }
    }
}
