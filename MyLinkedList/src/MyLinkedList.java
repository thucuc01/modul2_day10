public class MyLinkedList {
    private Node head;
    private int numNodes=0;
    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;
    }
    public class Node {
        private Object data;
        private Node next;
        public Node(Object data) {
            this.data = data;
        }
        public Object getData() {
            return data;
        }
    }
    public void printList() {
        int i=0;
        Node temp = head;
        while (i<numNodes) {
            System.out.println(temp.data);
            temp = temp.next;
            i++;
        }
    }
    public void addFirst(Object o) {
        Node temp = head;
        head = new Node(o);
        head.next = temp;
        numNodes++;
    }
    public void addLast(Object o) {
        Node temp = head;
        for(int i = 0; i< numNodes-1; i++) {
            temp = temp.next;
        }
        temp.next = new Node(o);
        numNodes++;
    }
    public void add(int index, Object o) {
        Node temp = head;
        Node middle;
        for(int i = 0; i< index-1 && temp.next!=null; i++) {
            temp = temp.next;
        }
        middle = temp.next;
        temp.next = new Node(o);
        temp.next.next = middle;
        numNodes++;
    }
    public Object remove(int index) {
        if (index>=numNodes) {
            throw new IndexOutOfBoundsException("Index" + index + ",numNodes" +index);
        } else {
            Node temp = head;
            for(int i = 0; i<index-1; i++) {
                temp = temp.next;
            }
            Object removedItem = temp.next.data;
            temp.next =temp.next.next;
            numNodes--;
            return removedItem;
        }
    }
    public void removeObj(Object o) {
        Node temp = head;
        while (temp.next!=null) {
            if (temp.next.data.equals(o)) {
                if(temp.next.next!=null) {
                    temp.next=temp.next.next;
                    temp = temp.next;
                } else {
                    temp.next =null;
                }
                numNodes--;
            }
        }
    }
    public Node get(int index) {
        Node temp = head;
        for(int i = 0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public int size() {
        return numNodes;
    }
    public boolean contains (Object o) {
        Node temp = head;
        for (int i=0; i<numNodes; i++) {
            if (temp.data.equals(o)) {
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public int indexOf (Object o) {
        Node temp = head;
        for (int i=0; i<numNodes; i++) {
            if (temp.data.equals(o)) {
                return i;
            }
            temp=temp.next;
        }
        return -1;
    }
    public MyLinkedList clone() {
        MyLinkedList myLinkedListClone = new MyLinkedList(head.data);
        Node temp = head;
        while (temp.next!=null) {
            myLinkedListClone.addLast(temp.next.data);
            temp = temp.next;
        }
        return myLinkedListClone;
    }
}