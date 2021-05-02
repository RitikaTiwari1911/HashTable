package com.hashmap;

public class MyLinkedList<K> {
    public INode head;
    public INode tail;

    public void MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    //method to add new node
    public void add(INode myNode) {
        if (this.tail == null) {
            this.tail = myNode;
        }
        if (this.head == null) {
            this.head = myNode;
        } else {
            INode tempNode = this.head;
            this.head = myNode;
            this.head.setNext(tempNode);
        }
    }

    // method to display
    public void printMyNodes() {
        StringBuffer myNodes = new StringBuffer("My Nodes : ");
        INode tempNode = head;
        while (tempNode.getNext() != null) {
            myNodes.append(tempNode.getKey());
            if (!tempNode.equals(tail))
                myNodes.append("->");
            tempNode = tempNode.getNext();
        }
        myNodes.append(tempNode.getKey());
        System.out.println(myNodes);
    }

    //method to append
    public void append(INode myNode) {
        if (this.head == null) {
            this.head = myNode;
        }
        if (this.tail != null) {
            this.tail.setNext(myNode);
        }
        this.tail = myNode;
    }

    //method to search node
    public INode search(K key) {
        INode tempNode = head;
        INode searchedNode = null;
        while (tempNode != null && tempNode.getNext() != null) {
            if (tempNode.getKey().equals(key))
                searchedNode = tempNode;
            tempNode = tempNode.getNext();
        }
        return searchedNode;
    }

    @Override
    public String toString() {
        return " MyLinkedListNodes{ " + head + "}";
    }
}
