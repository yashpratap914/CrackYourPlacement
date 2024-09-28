class Node{
    int value;
    Node next;
    Node prev;
    Node(int value){
        this.value=value;
    }
}
class DLL{
    Node head;
    Node tail;
    DLL(){
        head=new Node(-1);
        tail=new Node(-1);
        head.next=tail;
        tail.prev=head;
    }
    void insertFront(Node node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }
    void insertLast(Node node){
        node.next=tail;
        node.prev=tail.prev;
        tail.prev.next=node;
        tail.prev=node;
    }
    void delete(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }
    void deleteFront(){
        delete(head.next);
    }
    void deleteLast(){
        delete(tail.prev);
    }
    boolean isEmpty(){
        return head.next==tail;
    }
    int getFront(){
        return head.next.value;
    }
    int getRear(){
        return tail.prev.value;
    }
}
class MyCircularDeque {
    int size;
    DLL dll;
    public MyCircularDeque(int k) {
        size=k;
        dll=new DLL();
    }
    
    public boolean insertFront(int value) {
        if(size>0){
            dll.insertFront(new Node(value));
            size--;
            return true;
        }
        return false;
    }
    
    public boolean insertLast(int value) {
        if(size>0){
            dll.insertLast(new Node(value));
            size--;
            return true;
        }
        return false;
    }
    
    public boolean deleteFront() {
        if(dll.isEmpty())
            return false;
        dll.deleteFront();
        size++;
        return true;
    }
    
    public boolean deleteLast() {
        if(dll.isEmpty())
            return false;
        dll.deleteLast();
        size++;
        return true;
    }
    
    public int getFront() {
        if(dll.isEmpty())
            return -1;
        return dll.getFront();
    }
    
    public int getRear() {
        if(dll.isEmpty())
            return -1;
        return dll.getRear();
    }
    
    public boolean isEmpty() {
        return dll.isEmpty();
    }
    
    public boolean isFull() {
        return size==0;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */