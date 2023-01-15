package LinkedList;

public class SinglyLinkedListLab {
    public static void main(String[] args) {
        SLLnode n1 = new SLLnode(20);
        SLLnode n2 = new SLLnode(40);
        n1.next = n2;   // (n1 is 20) => (n2 is 40)
        SLLnode n3 = new SLLnode(35);
        n2.next = n3;   // (n1 is 20) => (n2 is 40) => (n3 is 35)

        System.out.println(n1.value);
        System.out.println(n2.value);
        System.out.println(n1.next.value);
        System.out.println(n1.next.next.value);
        System.out.println(n1.next);   //  show address of n2

        SLLnode n4 = new SLLnode(22);    // (n1 is 20) => (n2 is 40) => (n3 is 35)

        n2.next = n4;
        n4.next = n3;
        // (n1 is 20) => (n2 is 40) => (n4 is 22) => (n3 is 35)

        System.out.println(n1.next.next.value);
        System.out.println(n1.next.next.next.value);

        n2 = null;
        n4 = null;
        // (n1 is 20) => ( 40) => ( 22) => (n3 is 35)

        System.out.println("No more n2 but I still be able" + " to link to " + n1.next.value);
        System.out.println("No more n4 but I still be able" + " to link to " + n1.next.next.value);
        System.out.println(n1.next.next.next.value);

        n1.next.next = new SLLnode(81, n1.next.next);

        // new SLLnode(81, n1.next.next):
        // (n1 is 20) => ( 40) => ( 22) => (n3 is 35)
        //                    (81) -^

        //n1.next.next = new SLLnode(81, n1.next.next);
        // (n1 is 20) => ( 40) => (81) => ( 22) => (n3 is 35)

//        System.out.println(n1.next.next.value);

        SinglyLinkedList list = new SinglyLinkedList();
        list.addToTail(10);
        list.addToTail(39);
        list.addToTail(76);
        // 10 => 39 => 76

        list.addToTail(48);
        // 10 => 39 => 76 => 48

        System.out.println("Head is " + list.head.value);
        System.out.println("Tail is " + list.tail.value);
        System.out.println(list.head.next.next.value);

        list.addToHead(9);
        System.out.println(list.head.value);
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.addToHead(40);
        System.out.println(list2.head.value + " " + list2.tail.value);

        //list 9 => 10 => 39 => 76 => 46
        list.printAllNode();
    }
}
