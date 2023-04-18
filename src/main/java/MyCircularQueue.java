class MyCircularQueue {
    int capacity;
    int size;
    int[][] deque;
    int head,rear;
    int tail = rear;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.deque = new int[k][k];
        for (int i = 0; i < k; i++) {
            this.deque[1][i] = 1;
        }
        this.head = 0;
        this.rear = 0;
        this.size = 0;
    }
    
    public boolean enQueue(int value) {
        if(capacity > size && deque[1][rear] == 1){
            deque[0][rear] = value;
            deque[1][rear] = 0;
            tail = rear;
            size++;
            rear = (rear + 1) % capacity;
            return true;
        }else
            return false;
    }
    
    public boolean deQueue() {
        if (size > 0){
            deque[0][head] = 0;
            deque[1][head] = 1;
            size--;
            head = (head + 1) % capacity;
            return true;
        }else
            return false;
    }
    
    public int Front() {
        if (size==0) return -1;
        else return deque[0][head];
    }
    
    public int Rear() {
        return deque[0][tail];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}