package heapdatastructurelab;

public class HeapDataStructureLab {
    public static void main(String[] args) {
        Heap h = new Heap(50);
        h.enqueue(30);
        h.enqueue(55);
        h.enqueue(320);
        h.enqueue(20);
        h.enqueue(400);
        //                    400
        //              320           55
        //          20      30

        // 400, 320, 55 , 20, 30
        h.printAll();

        h.enqueue(100);
        h.enqueue(600);
        //                     600
        //              320           400
        //          20      30     55     100

        //600, 320, 400, 20, 30, 55, 100
        h.printAll();

        int topValue = h.dequeue();
        //                     400
        //              320           100
        //          20      30     55

        //400, 320, 100, 20, 30, 55
        System.out.println(topValue);
        h.printAll();

        topValue = h.dequeue();
        //                     320
        //              55           100
        //          20      30

        //320, 55, 100, 20, 30
        System.out.println(topValue);
        h.printAll();
    }
}
