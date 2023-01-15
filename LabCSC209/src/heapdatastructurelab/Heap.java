package heapdatastructurelab;

public class Heap {
    int[] heap;
    int size;

    public Heap() {
        this(100);
    }

    public Heap(int maxSize) {
        heap = new int[maxSize];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == this.heap.length;
    }

    public void printAll() {
        for(int i = 0; i < this.size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public void enqueue(int newValue) {
        if (!isFull()) {
            heap[size] = newValue;
            int newValueIndex = size;
            int parentIndex = (newValueIndex - 1) / 2;

            while (heap[newValueIndex] > heap[parentIndex]) {
                //swap child with its parent
                int temp = heap[parentIndex];
                heap[parentIndex] = heap[newValueIndex];
                heap[newValueIndex] = temp;

                newValueIndex = parentIndex;
                parentIndex = (newValueIndex - 1) / 2; //เช็กถัดขึ้นไปเรื่อยๆ
            }
            size++;
        }
        else {
            System.out.println("The heap is full. No more space :(");
        }
    }

    public int dequeue() {
        int maxValue = this.heap[0];
        int lastElement = heap[this.size-1];

        //replace and remove last element
        heap[0] = lastElement;
        this.size--;

        int lastElementIndex = 0; //root
        int leftChildIndex = (lastElementIndex * 2) + 1;
        int rightChildIndex = (lastElementIndex * 2) + 2;
        int swapIndex;

        while((leftChildIndex < this.size && this.heap[lastElementIndex] < this.heap[leftChildIndex]) ||
                (rightChildIndex < this.size && this.heap[lastElementIndex] < this.heap[rightChildIndex])) {
            //move down
            if (leftChildIndex == this.size - 1) {
                //there is only left child (no right child)
                swapIndex = leftChildIndex;
            }
            else {
                //there are both left child and right child.
                if (this.heap[leftChildIndex] > this.heap[rightChildIndex]) {
                    swapIndex = leftChildIndex;
                }
                else {
                    swapIndex = rightChildIndex;
                }
            }

            int temp = this.heap[lastElementIndex];
            this.heap[lastElementIndex] = this.heap[swapIndex];
            this.heap[swapIndex] = temp;

            lastElementIndex = swapIndex; //เช็กถัดลงมาเรื่อยๆ
            leftChildIndex = (lastElementIndex * 2) + 1;
            rightChildIndex = (lastElementIndex * 2) + 2;
        }

        return maxValue;
    }
}
