package Algorithms.LinkedLists;

public class SinglyLinkedList<T> {
    //Node inner class of SLL
    public class Node {
        public T data;
        public Node nextNode;
    }

    public Node headNode; //head node of linked list
    public int size; //size of the linked list

    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    //Helper function that checks if list is empty or not
    public boolean isEmpty() {
        if (headNode == null) return true;
        return false;
    }

    //Insert at start of the linked list
    public void insertAtHead(T data) {
        Node newNode = new Node();
        newNode.data = data;
        //Link existing headNode as next of new node
        newNode.nextNode = headNode;
        //Change newNode as headNode
        headNode = newNode;
        size++;
    }

    //Insert at the end of the linked list
    public void insertAtEnd(T data) {
        //If list was empty
        if (this.isEmpty()) {
            insertAtHead(data);
            return;
        }
        //Initialize the new node with data
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;
        //Assign headNode to temp
        Node node = headNode;
        //Loop to end of the list
        while(node.nextNode != null) {
            node = node.nextNode;
        }
        //point last element next node to new node
        node.nextNode = newNode;
        size++;
    }

    //Insert after the given element in the linked list
    public void insertAfter(T data, T previous) {
        //Create new node
        Node newNode = new Node();
        newNode.data = data;
        //Check for the node with value previous
        Node node = headNode;
        while(node != null && node.data != previous) {
            node = node.nextNode;
        }
        if (node != null) {
            newNode.nextNode = node.nextNode;
            node.nextNode = newNode;
            size++;
        } else {
            System.out.println(previous.toString() + " not found in the list");
        }
    }

    //Search for given element
    public boolean searchNode(T data) {
        if (isEmpty()) return false;
        Node node = headNode;
        while (node != null && node.data != data) {
            node = node.nextNode;
        }
        if (node == null) return false;
        return true;
    }

    //Delete the head element
    public void deleteAtHead() {
        if (isEmpty()) return;
        headNode = headNode.nextNode;
        size--;
    }

    //Delete the given element
    public void deleteNode(T data) {
        if (isEmpty()) return;
        if (this.headNode.data == data) {
            deleteAtHead();
        }
        Node node = headNode;
        while (node != null && node.nextNode != null) {
            if (node.nextNode.data == data) {
                break;
            }
            node = node.nextNode;
        }
        if (node != null && node.nextNode != null) {
            node.nextNode = node.nextNode.nextNode;
            size--;
        }
    }

    //Form a loop
    public void formLoop() {
        if (isEmpty()) {
            return;
        }
        Node node = this.headNode;
        Node prev = null;
        while(node !=  null) {
            prev = node;
            node =  node.nextNode;
        }
        prev.nextNode = this.headNode;
    }

    public void printList() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node node =  this.headNode;
        while(node != null) {
            System.out.print(node.data.toString() + " --> ");
            node = node.nextNode;
        }
        System.out.println("NULL");
    }
}
