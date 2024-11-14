class ChainLink {
    public String color;

    ChainLink(String color) {
        this.color = color;
    }
}

class LinkedList<T> {
    private class Node {
        T data;
        Node next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
        
        int remainingSize() {
            int count = 0;
            Node current = this.next;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }
    }
    
    private Node head;
    private Node tail; 
    private int size;
    
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void append(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode; 
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    public void prepend(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        LinkedList<ChainLink> list = new LinkedList<>();
        
        list.append(new ChainLink("red"));
        list.append(new ChainLink("blue"));
        list.append(new ChainLink("green"));
        
        list.prepend(new ChainLink("yellow"));
        
        System.out.println("Remaining size after first node: " + list.head.remainingSize());
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).color);
        }
    }
}
